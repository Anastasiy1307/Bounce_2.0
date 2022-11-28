package com.bounce.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bounce.game.GameObjects.Ball;
import com.bounce.game.GameObjects.Button;
import com.bounce.game.GameObjects.Texture;

public class ChoiseLevel extends State {

    public ChoiseLevel(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, 1080, 540);

    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        handleInput();

    }

    @Override
    public void render(SpriteBatch sb) {
        camera.update();
        sb.setProjectionMatrix(camera.combined);
        sb.begin();


        sb.end();
    }

    @Override
    public void dispose() {


    }
}
