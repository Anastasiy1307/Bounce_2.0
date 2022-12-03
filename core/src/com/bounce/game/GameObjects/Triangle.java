package com.bounce.game.GameObjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bounce.game.Levels.Loader;

/*
    1 - обычный треугольник 1
    2 - обычный треугольник 2
    3 - обычный треугольник 3
    4 - обычный треугольник 4
    5 - водяной треугольник 1
    6 - водяной треугольник 2
    7 - водяной треугольник 3
    8 - водяной треугольник 4
    9 - прыгучий треугольник 1
    10 - прыгучий треугольник 2
    11 - прыгучий треугольник 3
    12 - прыгучий треугольник 4
*/
public class Triangle extends MainObject{

    public Triangle(float x, float y, float width, float height, int type) {
        super(x, y, width, height, type);
    }

    @Override
    public void draw(SpriteBatch sb) {
        switch (type) {
            case 1: sb.draw(Loader.textures[4], rectangle.x, rectangle.y, rectangle.width, rectangle.height); break;
            case 2: sb.draw(Loader.textures[5], rectangle.x, rectangle.y, rectangle.width, rectangle.height); break;
            case 3: sb.draw(Loader.textures[6], rectangle.x, rectangle.y, rectangle.width, rectangle.height); break;
            case 4: sb.draw(Loader.textures[7], rectangle.x, rectangle.y, rectangle.width, rectangle.height); break;
            case 5: sb.draw(Loader.textures[8], rectangle.x, rectangle.y, rectangle.width, rectangle.height); break;
            case 6: sb.draw(Loader.textures[9], rectangle.x, rectangle.y, rectangle.width, rectangle.height); break;
            case 7: sb.draw(Loader.textures[10], rectangle.x, rectangle.y, rectangle.width, rectangle.height); break;
            case 8: sb.draw(Loader.textures[11], rectangle.x, rectangle.y, rectangle.width, rectangle.height); break;
            case 9: sb.draw(Loader.textures[12], rectangle.x, rectangle.y, rectangle.width, rectangle.height); break;
            case 10: sb.draw(Loader.textures[13], rectangle.x, rectangle.y, rectangle.width, rectangle.height); break;
            case 11: sb.draw(Loader.textures[14], rectangle.x, rectangle.y, rectangle.width, rectangle.height); break;
            case 12: sb.draw(Loader.textures[15], rectangle.x, rectangle.y, rectangle.width, rectangle.height); break;
        }
    }
}
