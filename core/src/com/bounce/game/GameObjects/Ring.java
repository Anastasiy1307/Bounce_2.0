package com.bounce.game.GameObjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.bounce.game.Levels.Loader;

/*
    1 - не задействован обычный вертикальный
    2 - задействован обычный вертикальный
    3 - не задействован большой вертикальный
    4 - задействован большой вертикальный
    5 - не задействован обычный горизонтальный
    6 - задействован обычный горизонтальный
    7 - не задействован большой горизонтальный
    8 - задействован большой горизонтальный
*/
public class Ring /*Кольца*/ extends MainObject{

    //Rectangle rectangle1, rectangle2;

    public Ring(float x, float y, float width, float height, int type) {
        super(x, y, width, height, type);
        /*switch (type) {
            case 1: rectangle1 = new Rectangle();
        }*/
    }

    @Override
    public void draw(SpriteBatch sb) {
        switch (type) {
            case 1: sb.draw(Loader.textures[31], rectangle.x, rectangle.y, rectangle.width, rectangle.height); break;
            case 2: sb.draw(Loader.textures[32], rectangle.x, rectangle.y, rectangle.width, rectangle.height); break;
        }
    }

    public void changeState() {
        type++;
    }
}
