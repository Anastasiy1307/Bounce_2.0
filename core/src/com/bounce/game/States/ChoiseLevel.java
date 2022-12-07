package com.bounce.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bounce.game.GameObjects.Ball;
import com.bounce.game.GameObjects.Button;
import com.bounce.game.GameObjects.Texture;
import com.bounce.game.Levels.Loader;

public class ChoiseLevel extends State {

    Button ball;

    public ChoiseLevel(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, 1080, 540);
        Loader.create();
        ball = new Button(512, 242, 55, 55, "ball.png");
    }

    @Override
    protected void handleInput() {
        if (ball.isClick(tempDown, tempUp)) {
            Loader.loadLevel();
            gsm.set(new GameState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        ball.update(camera);
    }

    @Override
    public void render(SpriteBatch sb) {
        camera.update();
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        ball.draw(sb);
        sb.end();
    }

    @Override
    public void dispose() {
        ball.dispose();
    }
}
