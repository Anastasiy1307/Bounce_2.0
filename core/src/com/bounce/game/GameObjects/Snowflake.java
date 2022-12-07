package com.bounce.game.GameObjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bounce.game.Levels.Loader;

import java.awt.Point;

public class Snowflake extends MainObject{

    private float speed;
    private Point point1;
    private Point point2;
    private int direction;

    public Snowflake(float x, float y, float width, float height, Point point1, Point point2) {
        super(x, y, width, height, 0);
        this.point1 = point1;
        this.point2 = point2;
        speed = 100;
        direction = 1;
    }

    public void update(float dt) {
        if (direction == 1) {
            if (rectangle.x < point2.x) rectangle.x += speed*dt;
            if (rectangle.y < point2.y) rectangle.y += speed*dt;
            if (rectangle.x >= point2.x && rectangle.y >= point2.y) direction = 2;
        } else {
            if (rectangle.x > point1.x) rectangle.x -= speed*dt;
            if (rectangle.y > point1.y) rectangle.y -= speed*dt;
            if (rectangle.x <= point2.x && rectangle.y <= point2.y) direction = 1;
        }
    }

    @Override
    public void draw(SpriteBatch sb) {
        sb.draw(Loader.textures[16], rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }
}
