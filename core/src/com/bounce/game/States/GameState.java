package com.bounce.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bounce.game.Controls.Collisions;
import com.bounce.game.GameObjects.Ball;
import com.bounce.game.GameObjects.Snowflake;
import com.bounce.game.Levels.Loader;

public class GameState extends State {

    Ball ball;
    Collisions collisions;

    public GameState(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, 1080, 540);
        //camera.zoom = 0.815f;
        camera.position.set(Math.min(Math.max(Loader.ballPosition.x, camera.viewportWidth/2*camera.zoom), Loader.map.length*Loader.size - camera.viewportWidth/2*camera.zoom),
                Math.min(Math.max(Loader.ballPosition.y, camera.viewportHeight/2*camera.zoom), Loader.map[0].length*Loader.size - camera.viewportHeight/2*camera.zoom), 0);
        ball = new Ball("ball.png", Loader.ballPosition.x, Loader.ballPosition.y, 27);
        collisions = new Collisions();
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.A)) ball.moveLeft();
        if (Gdx.input.isKeyPressed(Input.Keys.D)) ball.moveRight();
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) ball.jump();
    }

    @Override
    public void update(float dt) {
        handleInput();
        for (Snowflake snowflake: Loader.snowflakes) {
            snowflake.update(dt);
        }
        ball.update(dt);
        collisions.checkingCollision(ball,dt);
        float offsetX = Math.min((camera.viewportWidth/2) / Math.abs(ball.getCircle().x - camera.position.x), 3) * (ball.getCircle().x - camera.position.x) * dt;
        float offsetY = Math.min((camera.viewportHeight/2) / Math.abs(ball.getCircle().y - camera.position.y), 3) * (ball.getCircle().y - camera.position.y) * dt;
        camera.translate(offsetX, offsetY);
        camera.position.set(Math.min(Math.max(camera.position.x, camera.viewportWidth/2*camera.zoom), Loader.map.length*Loader.size - camera.viewportWidth/2*camera.zoom),
                Math.min(Math.max(camera.position.y, camera.viewportHeight/2*camera.zoom), Loader.map[0].length*Loader.size - camera.viewportHeight/2*camera.zoom), 0);
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
        Loader.exit.draw(sb);
        ball.draw(sb);
        sb.end();
    }

    @Override
    public void dispose() {
        ball.dispose();
    }
}
