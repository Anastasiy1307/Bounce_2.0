package com.bounce.game.GameObjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bounce.game.Levels.Loader;

/*
    1 - вверх
    2 - вправо
    3 - вниз
    4 - влево
*/
public class Spike/*Шип*/ extends MainObject{

    public Spike(float x, float y, float width, float height, int type){
        super(x, y, width, height, type);
    }

    @Override
    public void draw(SpriteBatch sb) {
        switch (type) {
            case 1: sb.draw(Loader.textures[25], rectangle.x, rectangle.y, rectangle.width, rectangle.height); break;
            case 2: sb.draw(Loader.textures[26], rectangle.x, rectangle.y, rectangle.width, rectangle.height); break;
            case 3: sb.draw(Loader.textures[27], rectangle.x, rectangle.y, rectangle.width, rectangle.height); break;
            case 4: sb.draw(Loader.textures[28], rectangle.x, rectangle.y, rectangle.width, rectangle.height); break;
        }
    }
}
