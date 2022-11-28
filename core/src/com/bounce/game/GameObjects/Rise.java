package com.bounce.game.GameObjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bounce.game.Levels.Loader;

// 4
public class Rise /*Увеличение*/ extends MainObject {

    private int type;
    public Rise(float x, float y, float width, float height, int type) {
        super(x, y, width, height);
        this.type = type;
    }
    public void draw(SpriteBatch sb) {
        sb.draw(Loader.textures[4], rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }
}
