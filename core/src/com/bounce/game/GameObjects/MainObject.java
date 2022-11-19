package com.bounce.game.GameObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class MainObject {
    Texture texture;
    Rectangle rectangle;
    public void draw(SpriteBatch sb) {
        sb.draw(texture, rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }
    public void dispose() {
        texture.dispose();
    }
}
