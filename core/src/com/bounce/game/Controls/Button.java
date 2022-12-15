package com.bounce.game.Controls;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Button {

    private final com.badlogic.gdx.graphics.Texture texture;
    private final Rectangle rectangle;
    private final int deltaSize;
    private boolean isClick;
    private float x, y;

    public Rectangle getRectangle() {
        return rectangle;
    }

    public Button(float x, float y, float width, float height, String texture) {
        this.texture = new com.badlogic.gdx.graphics.Texture(texture);
        this.texture.setFilter(com.badlogic.gdx.graphics.Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        rectangle = new Rectangle(x, y, width, height);
        deltaSize = (int) Math.ceil(Math.min(width, height) / 15) / 2;
        isClick = false;
        this.x = x;
        this.y = y;
    }

    public boolean isClick(Vector3 touchDown, Vector3 touchUp) {
        if (rectangle.contains(touchDown.x, touchDown.y) && !isClick) {
            resize(-1);
            touchUp.x = 0;
            touchUp.y = 0;
        }
        if (rectangle.contains(touchUp.x, touchUp.y) && isClick) {
            resize(1);
            touchDown.x = 0;
            touchDown.y = 0;
            touchUp.x = 0;
            touchUp.y = 0;
            return true;
        }
        if (!rectangle.contains(touchUp.x, touchUp.y) && isClick && touchUp.x != 0 && touchUp.y != 0) {
            resize(1);
            touchDown.x = 0;
            touchDown.y = 0;
            return false;
        }
        return false;
    }

    private void resize(int sign) {
        x -= sign * deltaSize;
        y -= sign * deltaSize;
        rectangle.width += sign * deltaSize * 2;
        rectangle.height += sign * deltaSize * 2;
        isClick = sign < 0;
    }

    public void update(OrthographicCamera camera) {
        rectangle.x = camera.position.x - 540 * camera.zoom + x;
        rectangle.y = camera.position.y - 270 * camera.zoom + y;
    }

    public void draw(SpriteBatch sb) {
        sb.draw(texture, rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    public void dispose() {
        texture.dispose();
    }
}
