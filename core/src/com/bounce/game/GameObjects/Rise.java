package com.bounce.game.GameObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Rise /*Увеличение*/ extends MainObject {

    public Rise(float x, float y, float width, float height, String texture) {
        this.texture = new com.badlogic.gdx.graphics.Texture(texture);
        this.texture.setFilter(com.badlogic.gdx.graphics.Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        rectangle = new Rectangle(x, y, width, height);
    }
}
