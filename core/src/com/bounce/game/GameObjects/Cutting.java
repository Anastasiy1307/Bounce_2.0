package com.bounce.game.GameObjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bounce.game.Levels.Loader;

// 5
public class Cutting /*Уменьшение*/ extends MainObject{

    private int type;
    public Cutting(float x, float y, float width, float height, int type) {
        super(x, y, width, height);
        this.type = type;
    }

    public void draw(SpriteBatch sb) {
        sb.draw(Loader.textures[5], rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }
}
