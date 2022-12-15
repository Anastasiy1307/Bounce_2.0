package com.bounce.game.GameObjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class MainObject {

    protected Rectangle rectangle;
    protected int type;

    public MainObject(float x, float y, float width, float height, int type) {
        rectangle = new Rectangle(x, y, width, height);
        this.type = type;
    }

    public abstract void draw(SpriteBatch sb);

    public Rectangle getRectangle() {
        return rectangle;
    }

    public int getType() {
        return type;
    }
}
