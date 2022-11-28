package com.bounce.game.GameObjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bounce.game.Levels.Loader;

// 3
public class Spike/*Шип*/ extends MainObject{

    private int type;
    public Spike(float x, float y, float width, float height, int type){
        super(x, y, width, height);
        this.type = type;
    }
    public void draw(SpriteBatch sb) {
        sb.draw(Loader.textures[3], rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }
}
