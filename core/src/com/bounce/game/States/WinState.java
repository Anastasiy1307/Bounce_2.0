package com.bounce.game.States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bounce.game.Controls.Button;
import com.bounce.game.Controls.Texture;
import com.bounce.game.Levels.Loader;

public class WinState extends State {

    private final Button next;
    private final Texture background;

    public WinState(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, 1080, 540);
        background = new Texture(0, 0, 1080, 540, "finish.png");
        next = new Button(422, 110, 237, 77, "Button_Finish_Dalee.png");
    }

    @Override
    protected void handleInput() {
        if (next.isClick(tempDown, tempUp)) {
            if (Loader.levelNumber < 11) {
                Loader.levelNumber++;
                Loader.loadLevel();
                gsm.set(new GameState(gsm));
            } else gsm.set(new SelectLevel(gsm));
        }
        /*if (Gdx.input.isTouched() && !next.isDown(tempDown, tempUp)) {
            gsm.set(new SelectLevel(gsm));
        }*/
    }

    @Override
    public void update(float dt) {
        handleInput();
        next.update(camera);
    }

    @Override
    public void render(SpriteBatch sb) {
        camera.update();
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        background.draw(sb);
        next.draw(sb);
        sb.end();
    }

    @Override
    public void dispose() {
        next.dispose();
        background.dispose();
    }
}
