package com.bounce.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bounce.game.Controls.Button;
import com.bounce.game.Controls.Texture;
import com.bounce.game.Levels.Loader;

public class GameOver extends State {

    Button Restart;
    Texture background;
    public GameOver(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, 1080, 540);
        Loader.create();
        background = new Texture(0,0,1080, 540, "Game_over.png");
        Restart = new Button(512, 242, 55, 55, "Button_Game_over.png");
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.isTouched()) {
            gsm.set(new ChoiseLevel(gsm));
        }
        if (Restart.isClick(tempDown, tempUp)) {
            Loader.loadLevel();
            gsm.set(new GameState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        Restart.update(camera);
    }

    @Override
    public void render(SpriteBatch sb) {
        camera.update();
        sb.setProjectionMatrix(camera.combined);
        sb.begin();

        background.draw(sb);
        sb.end();
        Restart.draw(sb);
        sb.end();
    }

    @Override
    public void dispose() {
        Restart.dispose();
        background.dispose();
    }
}
