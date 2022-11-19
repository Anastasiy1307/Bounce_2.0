package com.bounce.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bounce.game.GameObjects.Ball;
import com.bounce.game.GameObjects.Button;
import com.bounce.game.GameObjects.Texture;

public class StartMenu extends State {

    Texture screensaver;
    Button ball;
    Ball ballP;

    public StartMenu(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, 1080, 540);
        screensaver = new Texture(0,0,1080, 540, "screensaver.png");
        ball = new Button(900, 200, 55, 55, "ball.png");
        ballP = new Ball("ball.png", 100, 100, 27);
    }

    @Override
    protected void handleInput() {
        if (ball.isClick(tempDown, tempUp)) {

        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) ballP.moveLeft();
        if (Gdx.input.isKeyPressed(Input.Keys.D)) ballP.moveRight();
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) ballP.jump();
    }

    @Override
    public void update(float dt) {
        handleInput();
        ball.update(camera);
        ballP.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        camera.update();
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        screensaver.draw(sb);
        ball.draw(sb);
        ballP.draw(sb);
        sb.end();
    }

    @Override
    public void dispose() {
        screensaver.dispose();
        ball.dispose();
        ballP.dispose();
    }
}
