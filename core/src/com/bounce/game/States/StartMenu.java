package com.bounce.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bounce.game.Controls.Texture;

public class StartMenu extends State {

    Texture screensaver;

    public StartMenu(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, 1080, 540);
        screensaver = new Texture(0,0,1080, 540, "screensaver.png");
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.isTouched()) {
            gsm.set(new ChoiseLevel(gsm));
        }
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
        screensaver.draw(sb);
        sb.end();
    }

    @Override
    public void dispose() {
        screensaver.dispose();
    }
}
