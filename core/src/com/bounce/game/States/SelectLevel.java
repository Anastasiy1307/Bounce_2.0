package com.bounce.game.States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bounce.game.Controls.Button;
import com.bounce.game.Controls.Texture;
import com.bounce.game.Levels.Loader;

public class SelectLevel extends State {

    private final Button[] levels;
    private final Texture background;

    public SelectLevel(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, 1080, 540);
        background = new Texture(0, 0, 1080, 540, "Background_menu.png");
        levels = new Button[11];
        for (int i = 0; i < levels.length; i++) {
            levels[i] = new Button(275 + 150 * (i % 4), 330 - 125 * (i / 4), 76, 76, "level_" + (i + 1) + ".png");
        }
    }

    @Override
    protected void handleInput() {
        for (int i = 0; i < levels.length; i++) {
            if (levels[i].isClick(tempDown, tempUp)) {
                Loader.levelNumber = i + 1;
                Loader.loadLevel();
                gsm.set(new GameState(gsm));
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        for (Button level : levels) {
            level.update(camera);
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        camera.update();
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        background.draw(sb);
        for (Button level : levels) {
            level.draw(sb);
        }
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        for (int i = 0; i < levels.length; i++) {
            levels[1].dispose();
        }
    }
}
