package com.bounce.game.GameObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Ball {
    private Sprite texture;
    private Sprite textureBig;
    private Circle circle;
    private Vector2 speed;
    private final float gravity;
    private final float friction;
    private boolean isStand;
    private int type;
    private int degrees;

    public Ball (String texture, String textureBig, float x, float y, float radius) {
        this.texture = new Sprite(new Texture(texture), (int)radius*2, (int)radius*2);
        this.textureBig = new Sprite(new Texture(textureBig), (int)radius*3, (int)radius*3);
        this.texture.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        this.textureBig.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        circle = new Circle(x, y, radius);
        speed = new Vector2(0,0);
        gravity = 10;
        friction = 20;
        isStand = false;
        type = 1;
    }

    public void update(float dt) {
        if (speed.x > 0) speed.x -= friction;
        if (speed.x < 0) speed.x += friction;
        if (!isStand) speed.y -= gravity;
        isStand = false;
        circle.x += speed.x * dt;
        circle.y += speed.y * dt;
        degrees = (degrees - (int)((speed.x * dt) * (360/(2*Math.PI*circle.radius)))) % 360;
        texture.setPosition(circle.x, circle.y);
        textureBig.setPosition(circle.x, circle.y);
        texture.setOriginCenter();
        textureBig.setOriginCenter();
        texture.setRotation(degrees);
        textureBig.setRotation(degrees);
    }

    public void moveLeft() {
        speed.x -= 40;
        if (speed.x < -400) speed.x = -400;
    }

    public void moveRight() {
        speed.x += 40;
        if (speed.x > 400) speed.x = 400;
    }

    public void jump() {
        if (isStand) speed.y = 550;
    }

    public boolean overlaps(Rectangle rectangle) {
        return (circle.x + circle.radius > rectangle.x && circle.x + circle.radius < rectangle.x + rectangle.width &&
                circle.y + circle.radius*2 > rectangle.y && circle.y < rectangle.y + rectangle.height) ||
               (circle.y + circle.radius > rectangle.y && circle.y + circle.radius < rectangle.y + rectangle.height &&
                circle.x + circle.radius*2 > rectangle.x && circle.x < rectangle.x + rectangle.width) ||
               (circle.x + circle.radius < rectangle.x && circle.y + circle.radius < rectangle.y &&
                Math.sqrt(Math.pow(circle.x + circle.radius - rectangle.x, 2) + Math.pow(circle.y + circle.radius - rectangle.y, 2)) < circle.radius) ||
               (circle.x + circle.radius > rectangle.x + rectangle.width && circle.y + circle.radius < rectangle.y &&
                Math.sqrt(Math.pow(circle.x + circle.radius - rectangle.x - rectangle.width, 2) + Math.pow(circle.y + circle.radius - rectangle.y, 2)) < circle.radius) ||
               (circle.x + circle.radius > rectangle.x + rectangle.width && circle.y + circle.radius > rectangle.y + rectangle.height &&
                Math.sqrt(Math.pow(circle.x + circle.radius - rectangle.x - rectangle.width, 2) + Math.pow(circle.y + circle.radius - rectangle.y - rectangle.height, 2)) < circle.radius) ||
               (circle.x + circle.radius < rectangle.x && circle.y + circle.radius > rectangle.y + rectangle.height &&
                Math.sqrt(Math.pow(circle.x + circle.radius - rectangle.x, 2) + Math.pow(circle.y + circle.radius - rectangle.y - rectangle.height, 2)) < circle.radius);
    }

    public boolean overlapsLoverLeftCorner(Rectangle rectangle) {
        return circle.x + circle.radius < rectangle.x && circle.y + circle.radius < rectangle.y &&
                Math.sqrt(Math.pow(circle.x + circle.radius - rectangle.x, 2) + Math.pow(circle.y + circle.radius - rectangle.y, 2)) < circle.radius;
    }

    public boolean overlapsLoverRightCorner(Rectangle rectangle) {
        return circle.x + circle.radius > rectangle.x + rectangle.width && circle.y + circle.radius < rectangle.y &&
                Math.sqrt(Math.pow(circle.x + circle.radius - rectangle.x - rectangle.width, 2) + Math.pow(circle.y + circle.radius - rectangle.y, 2)) < circle.radius;
    }

    public boolean overlapsUpperRightCorner(Rectangle rectangle) {
        return circle.x + circle.radius > rectangle.x + rectangle.width && circle.y + circle.radius > rectangle.y + rectangle.height &&
                Math.sqrt(Math.pow(circle.x + circle.radius - rectangle.x - rectangle.width, 2) + Math.pow(circle.y + circle.radius - rectangle.y - rectangle.height, 2)) < circle.radius;
    }

    public boolean overlapsUpperLeftCorner(Rectangle rectangle) {
        return circle.x + circle.radius < rectangle.x && circle.y + circle.radius > rectangle.y + rectangle.height &&
                Math.sqrt(Math.pow(circle.x + circle.radius - rectangle.x, 2) + Math.pow(circle.y + circle.radius - rectangle.y - rectangle.height, 2)) < circle.radius;
    }

    public void draw(SpriteBatch sb) {
        if (type == 1) texture.draw(sb);
        else textureBig.draw(sb);
    }

    public void dispose() {
        texture.getTexture().dispose();
    }

    public Circle getCircle() {
        return circle;
    }

    public Vector2 getSpeed() {
        return speed;
    }

    public void stand() {
        isStand = true;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Sprite getTexture() {
        return texture;
    }

    public Sprite getTextureBig() {
        return textureBig;
    }
}
