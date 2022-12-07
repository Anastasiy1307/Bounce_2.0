package com.bounce.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bounce.game.GameObjects.Ball;
import com.bounce.game.GameObjects.Snowflake;
import com.bounce.game.Levels.Loader;

public class GameState extends State {

    Ball ball;

    public GameState(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, 1080, 540);
        camera.position.set(Loader.ballPosition.x, Loader.ballPosition.y, 0);
        ball = new Ball("ball.png", Loader.ballPosition.x, Loader.ballPosition.y, 27);
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
        camera.translate(ball.getCircle().x - camera.position.x, ball.getCircle().y - camera.position.y);
    }

    @Override
    public void dispose() {
        ball.dispose();
    }
}
