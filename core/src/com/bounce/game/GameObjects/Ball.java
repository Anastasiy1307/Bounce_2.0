package com.bounce.game.GameObjects;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Ball {
    private Sprite texture;
    private Circle circle;
    private Vector2 speed;
    private final float gravity;
    private final float friction;

    public Ball (String texture, float x, float y, float radius) {
        this.texture = new Sprite(new Texture(texture));
        this.texture.getTexture().setFilter(com.badlogic.gdx.graphics.Texture.TextureFilter.Linear, com.badlogic.gdx.graphics.Texture.TextureFilter.Linear);
        circle = new Circle(x, y, radius);
        speed = new Vector2(0,0);
        gravity = 10;
        friction = 20;
    }

    public void update(float dt) {
        circle.x += speed.x * dt;
        circle.y += speed.y * dt;
       /* texture.setOrigin(27,27);
        texture.setRotation(90);*/
        if (speed.x > 0) speed.x -= friction;
        if (speed.x < 0) speed.x += friction;
        if (circle.y > 0) speed.y -= gravity;
        else {
            circle.y = 0;
            speed.y = 0;
        }
    }

    public void moveLeft() {
        speed.x = -300;
    }

    public void moveRight() {
        speed.x = 300;
    }

    public void jump() {
        if (circle.y == 0) speed.y = 600;
    }

    public void draw(SpriteBatch sb) {
        sb.draw(texture, circle.x, circle.y, circle.radius*2, circle.radius*2);
    }

    public void dispose() {
        texture.getTexture().dispose();
    }

}
