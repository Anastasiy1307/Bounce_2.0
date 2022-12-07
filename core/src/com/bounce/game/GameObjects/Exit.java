package com.bounce.game.GameObjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bounce.game.Levels.Loader;

/*
    1 - закрыт
    2 - открыт
*/
public class Exit extends MainObject{

    public Exit(float x, float y, float width, float height) {
        super(x, y, width, height, 1);
    }

    @Override
    public void draw(SpriteBatch sb) {
        switch (type) {
            case 1: sb.draw(Loader.textures[33], rectangle.x, rectangle.y, rectangle.width, rectangle.height); break;
            case 2: sb.draw(Loader.textures[34], rectangle.x, rectangle.y, rectangle.width, rectangle.height); break;
        }
    }

    public void changeState() {
        type = 2;
    }
}
