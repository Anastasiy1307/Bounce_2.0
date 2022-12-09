package com.bounce.game.GameObjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bounce.game.Levels.Loader;

public class ExtraLife extends MainObject{

    public ExtraLife(float x, float y, float width, float height) {
        super(x, y, width, height, 0);
    }

    @Override
    public void draw(SpriteBatch sb) {
        sb.draw(Loader.textures[35], rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }
}
