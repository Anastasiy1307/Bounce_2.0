package com.bounce.game.States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bounce.game.Controls.Button;
import com.bounce.game.Controls.Texture;
import com.bounce.game.Levels.Loader;

public class GameOver extends State {

    private final Button restart;
    private final Texture background;

    public GameOver(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, 1080, 540);
        background = new Texture(0, 0, 1080, 540, "Game_over.png");
        restart = new Button(422, 110, 237, 77, "Button_Game_over.png");
    }

    @Override
    protected void handleInput() {
        if (restart.isClick(tempDown, tempUp)) {
            Loader.loadLevel();
            gsm.set(new GameState(gsm));
        }
        /*if (Gdx.input.isTouched() && !restart.isDown(tempDown, tempUp)) {
            gsm.set(new SelectLevel(gsm));
        }*/
    }

    @Override
    public void update(float dt) {
        handleInput();
        restart.update(camera);
    }

    @Override
    public void render(SpriteBatch sb) {
        camera.update();
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        background.draw(sb);
        restart.draw(sb);
        sb.end();
    }

    @Override
    public void dispose() {
        restart.dispose();
        background.dispose();
    }
}
