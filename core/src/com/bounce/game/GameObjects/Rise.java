package com.bounce.game.GameObjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bounce.game.Levels.Loader;

/*
    1 - вверх
    2 - вправо
    3 - вниз
    4 - влево
*/
public class Rise /*Увеличение*/ extends MainObject {

    public Rise(float x, float y, float width, float height, int type) {
        super(x, y, width, height, type);
    }

    @Override
    public void draw(SpriteBatch sb) {
        switch (type) {
            case 1: sb.draw(Loader.textures[17], rectangle.x, rectangle.y, rectangle.width, rectangle.height); break;
            case 2: sb.draw(Loader.textures[18], rectangle.x, rectangle.y, rectangle.width, rectangle.height); break;
            case 3: sb.draw(Loader.textures[19], rectangle.x, rectangle.y, rectangle.width, rectangle.height); break;
            case 4: sb.draw(Loader.textures[20], rectangle.x, rectangle.y, rectangle.width, rectangle.height); break;
        }
    }
}
