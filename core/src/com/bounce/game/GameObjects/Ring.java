package com.bounce.game.GameObjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bounce.game.Levels.Loader;

/*
    1 - не задействован
    2 - задействован
*/
public class Ring /*Кольца*/ extends MainObject{

    public Ring(float x, float y, float width, float height) {
        super(x, y, width, height, 1);
    }

    @Override
    public void draw(SpriteBatch sb) {
        switch (type) {
            case 1: sb.draw(Loader.textures[31], rectangle.x, rectangle.y, rectangle.width, rectangle.height); break;
            case 2: sb.draw(Loader.textures[32], rectangle.x, rectangle.y, rectangle.width, rectangle.height); break;
        }
    }

    public void changeState() {
        type = 2;
    }
}
