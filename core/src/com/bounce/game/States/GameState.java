package com.bounce.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bounce.game.Controls.Button;
import com.bounce.game.Controls.Collisions;
import com.bounce.game.GameObjects.Ball;
import com.bounce.game.GameObjects.Ring;
import com.bounce.game.GameObjects.Snowflake;
import com.bounce.game.Levels.Loader;

import java.util.ArrayList;

public class GameState extends State {

    Ball ball;
    Collisions collisions;
    Button left, right, up;
    Texture life, X, ring;
    ArrayList<Texture> numbers;

    public GameState(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, 1080, 540);
        camera.zoom = 0.815f;
        camera.position.set(Math.min(Math.max(Loader.ballPosition.x, camera.viewportWidth/2*camera.zoom), Loader.map.length*Loader.size - camera.viewportWidth/2*camera.zoom),
                Math.min(Math.max(Loader.ballPosition.y, camera.viewportHeight/2*camera.zoom), Loader.map[0].length*Loader.size - camera.viewportHeight/2*camera.zoom), 0);
        ball = new Ball("ball_54x54.png", "ball_81x81.png", Loader.ballPosition.x, Loader.ballPosition.y, 27);
        collisions = new Collisions();
        left = new Button(40/camera.zoom,30/camera.zoom,82,82,"Left.png");
        right = new Button(135/camera.zoom,30/camera.zoom,82,82,"Right.png");
        up = new Button(925*camera.zoom,30/camera.zoom,82,82,"Up.png");
        life = new Texture("ball.png");
        life.setFilter(com.badlogic.gdx.graphics.Texture.TextureFilter.Linear, com.badlogic.gdx.graphics.Texture.TextureFilter.Linear);
        X = new Texture("X.png");
        X.setFilter(com.badlogic.gdx.graphics.Texture.TextureFilter.Linear, com.badlogic.gdx.graphics.Texture.TextureFilter.Linear);
        numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(new Texture("num_" + i + ".png"));
            numbers.get(i).setFilter(com.badlogic.gdx.graphics.Texture.TextureFilter.Linear, com.badlogic.gdx.graphics.Texture.TextureFilter.Linear);
        }
        ring = new Texture("ring_for_count.png");
        ring.setFilter(com.badlogic.gdx.graphics.Texture.TextureFilter.Linear, com.badlogic.gdx.graphics.Texture.TextureFilter.Linear);
    }

    @Override
    protected void handleInput() {
        if (left.isDown(tempDown, tempUp)) ball.moveLeft();
        if (right.isDown(tempDown, tempUp)) ball.moveRight();
        if (up.isDown(tempDown, tempUp)) ball.jump();
    }

    @Override
    public void update(float dt) {
        handleInput();
        for (Snowflake snowflake: Loader.snowflakes) {
            snowflake.update(dt);
        }
        ball.update(dt);
        collisions.checkingCollision(ball,dt);
        float offsetX = Math.max(Math.min((camera.viewportWidth/3) / Math.abs(ball.getCircle().x - camera.position.x), 3), 1.5f) * (ball.getCircle().x - camera.position.x) * dt;
        float offsetY = Math.max(Math.min((camera.viewportHeight/3) / Math.abs(ball.getCircle().y - camera.position.y), 3), 1.5f) * (ball.getCircle().y - camera.position.y) * dt;
        camera.translate(offsetX, offsetY);
        camera.position.set(Math.min(Math.max(camera.position.x, camera.viewportWidth/2*camera.zoom), Loader.map.length*Loader.size - camera.viewportWidth/2*camera.zoom),
                Math.min(Math.max(camera.position.y, camera.viewportHeight/2*camera.zoom), Loader.map[0].length*Loader.size - camera.viewportHeight/2*camera.zoom), 0);
        left.update(camera);
        right.update(camera);
        up.update(camera);
    }

    @Override
    public void render(SpriteBatch sb) {
        camera.update();
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        int begin_i = Math.min(Math.max((int)(camera.position.x - camera.viewportWidth/2) / 55, 0), Loader.map.length - 1);
        int end_i = Math.max(Math.min((int)(camera.position.x + camera.viewportWidth/2) / 55, Loader.map.length - 1), 0);
        int begin_j = Math.min(Math.max((int)(camera.position.y - camera.viewportHeight/2) / 55, 0), Loader.map[0].length - 1);
        int end_j = Math.max(Math.min((int)(camera.position.y + camera.viewportHeight/2) / 55, Loader.map[0].length - 1), 0);
        for (int i = begin_i; i <= end_i; i++) {
            for (int j = begin_j; j <= end_j; j++) {
                if (Loader.map[i][j] != null) Loader.map[i][j].draw(sb);
            }
        }
        for (Snowflake snowflake: Loader.snowflakes) {
            snowflake.draw(sb);
        }
        for (Ring ring: Loader.rings) {
            ring.draw(sb);
        }
        Loader.exit.draw(sb);
        ball.draw(sb);
        left.draw(sb);
        right.draw(sb);
        up.draw(sb);
        sb.draw(life, camera.position.x - camera.viewportWidth/2 + 115, camera.position.y - camera.viewportHeight/2 + 445, 30,30);
        sb.draw(X, camera.position.x - camera.viewportWidth/2 + 150, camera.position.y - camera.viewportHeight/2 + 440, 30,35);
        sb.draw(numbers.get(Loader.numberOfLives), camera.position.x - camera.viewportWidth/2 + 182, camera.position.y - camera.viewportHeight/2 + 440, 30,35);
        for (int i = 0; i < Loader.numberOfRings; i++) {
            sb.draw(ring, camera.position.x - camera.viewportWidth/2 + 220 + i*18, camera.position.y - camera.viewportHeight/2 + 445, 15,30);
        }
        sb.end();
    }

    @Override
    public void dispose() {
        ball.dispose();
        left.dispose();
        right.dispose();
        up.dispose();
    }
}
