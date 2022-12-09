package com.bounce.game.GameObjects;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Ball {
    private Sprite texture;
    private Circle circle;
    private Rectangle rectangle;
    private Vector2 speed;
    private final float gravity;
    private final float friction;
    private boolean isStand;

    public Ball (String texture, float x, float y, float radius) {
        this.texture = new Sprite(new Texture(texture));
        this.texture.getTexture().setFilter(com.badlogic.gdx.graphics.Texture.TextureFilter.Linear, com.badlogic.gdx.graphics.Texture.TextureFilter.Linear);
        circle = new Circle(x, y, radius);
        rectangle = new Rectangle(x,y,radius*2, radius*2);
        speed = new Vector2(0,0);
        gravity = 10;
        friction = 20;
        isStand = false;
    }

    public void update(float dt) {
        if (speed.x > 0) speed.x -= friction;
        if (speed.x < 0) speed.x += friction;
        if (!isStand) speed.y -= gravity;
        isStand = false;
        rectangle.x += speed.x * dt;
        rectangle.y += speed.y * dt;
        circle.x = rectangle.x;
        circle.y = rectangle.y;
       /* texture.setOrigin(27,27);
        texture.setRotation(90);*/
    }

    public void moveLeft() {
        speed.x = -300;
    }

    public void moveRight() {
        speed.x = 300;
    }

    public void jump() {
        if (isStand) speed.y = 600;
    }

    public void draw(SpriteBatch sb) {
        sb.draw(texture, circle.x, circle.y, circle.radius*2, circle.radius*2);
    }

    public void dispose() {
        texture.getTexture().dispose();
    }

    public Circle getCircle() {
        return circle;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public Vector2 getSpeed() {
        return speed;
    }

    public void stand() {
        isStand = true;
    }
}
