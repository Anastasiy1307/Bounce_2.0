package com.bounce.game.GameObjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class MainObject {

    protected Rectangle rectangle;

    public MainObject(float x, float y, float width, float height){
        rectangle = new Rectangle(x, y, width, height);
    }

    public abstract void draw(SpriteBatch sb);

}
