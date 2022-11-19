package com.bounce.game.GameObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Snowflake extends MainObject{
    private float speed;
    private Vector2 point1;
    private Vector2 point2;
    public Snowflake(float x, float y, float width, float height, String texture, Vector2 point1, Vector2 point2) {
        this.texture = new com.badlogic.gdx.graphics.Texture(texture);
        this.texture.setFilter(com.badlogic.gdx.graphics.Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        rectangle = new Rectangle(x, y, width, height);
        this.point1 = point1;
        this.point2 = point2;
        speed = 100;
    }
}
