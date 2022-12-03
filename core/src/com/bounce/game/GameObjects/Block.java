package com.bounce.game.GameObjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bounce.game.Levels.Loader;

/*
    1 - обычный блок
    2 - блок воды
    3 - прыгучий блок
*/
public class Block extends MainObject{

    public Block(float x, float y, float width, float height, int type){
        super(x, y, width, height, type);
    }

    @Override
    public void draw(SpriteBatch sb) {
        switch (type) {
            case 1: sb.draw(Loader.textures[1], rectangle.x, rectangle.y, rectangle.width, rectangle.height); break;
            case 2: sb.draw(Loader.textures[2], rectangle.x, rectangle.y, rectangle.width, rectangle.height); break;
            case 3: sb.draw(Loader.textures[3], rectangle.x, rectangle.y, rectangle.width, rectangle.height); break;
        }
    }
}
