package com.bounce.game.Controls;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Texture {

    private final com.badlogic.gdx.graphics.Texture texture;
    private final float x, y, width, height;

    public Texture(float x, float y, float width, float height, String texture) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.texture = new com.badlogic.gdx.graphics.Texture(texture);
        this.texture.setFilter(com.badlogic.gdx.graphics.Texture.TextureFilter.Linear, com.badlogic.gdx.graphics.Texture.TextureFilter.Linear);
    }

    public void draw(SpriteBatch sb) {
        sb.draw(texture, x, y, width, height);
    }

    public void draw(SpriteBatch sb, OrthographicCamera camera) {
        sb.draw(texture, x + camera.position.x - camera.viewportWidth / 2, y + camera.position.y - camera.viewportHeight / 2, width, height);
    }

    public void dispose() {
        texture.dispose();
    }
}
