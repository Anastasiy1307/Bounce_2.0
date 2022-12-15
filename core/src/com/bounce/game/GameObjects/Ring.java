package com.bounce.game.GameObjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bounce.game.Levels.Loader;

/*
    1 - не задействован обычный вертикальный
    2 - задействован обычный вертикальный
    3 - не задействован обычный горизонтальный
    4 - задействован обычный горизонтальный
*/
public class Ring /*Кольца*/ extends MainObject{

    public Ring(float x, float y, float width, float height, int type) {
        super(x, y, width, height, type);
    }

    @Override
    public void draw(SpriteBatch sb) {
        switch (type) {
            case 1: sb.draw(Loader.textures[31], rectangle.x, rectangle.y, rectangle.width, rectangle.height); break;
            case 2: sb.draw(Loader.textures[32], rectangle.x, rectangle.y, rectangle.width, rectangle.height); break;
            case 3: sb.draw(Loader.textures[36], rectangle.x, rectangle.y, rectangle.width, rectangle.height); break;
            case 4: sb.draw(Loader.textures[37], rectangle.x, rectangle.y, rectangle.width, rectangle.height); break;
        }
    }

    public void changeState() {
        type++;
    }
}
