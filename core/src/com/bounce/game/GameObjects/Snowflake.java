package com.bounce.game.GameObjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.bounce.game.Levels.Loader;

public class Snowflake extends MainObject{

    private float speed;
    private Vector2 point1;
    private Vector2 point2;

    public Snowflake(float x, float y, float width, float height, Vector2 point1, Vector2 point2) {
        super(x, y, width, height, 0);
        this.point1 = point1;
        this.point2 = point2;
        speed = 100;
    }

    @Override
    public void draw(SpriteBatch sb) {
        sb.draw(Loader.textures[16], rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }
}
