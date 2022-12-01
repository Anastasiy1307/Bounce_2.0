package com.bounce.game.GameObjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bounce.game.Levels.Loader;

// 1
public class Block extends MainObject{

    public Block(float x, float y, float width, float height){
        super(x, y, width, height);
    }

    public void draw(SpriteBatch sb) {
        sb.draw(Loader.textures[1], rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

}
