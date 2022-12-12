package com.bounce.game.Controls;

import com.bounce.game.GameObjects.Ball;
import com.bounce.game.GameObjects.Block;
import com.bounce.game.GameObjects.Checkpoint;
import com.bounce.game.GameObjects.Cutting;
import com.bounce.game.GameObjects.ExtraLife;
import com.bounce.game.GameObjects.MainObject;
import com.bounce.game.GameObjects.Rise;
import com.bounce.game.GameObjects.Snowflake;
import com.bounce.game.GameObjects.Spike;
import com.bounce.game.Levels.Loader;

public class Collisions {

    // В процессе...
    public void checkingCollision(Ball ball, float dt) {
        int begin_i = Math.min(Math.max((int)(ball.getCircle().x) / 55 - 2, 0), Loader.map.length - 1);
        int end_i = Math.max(Math.min((int)(ball.getCircle().x) / 55 + 2, Loader.map.length - 1), 0);
        int begin_j = Math.min(Math.max((int)(ball.getCircle().y) / 55 - 2, 0), Loader.map[0].length - 1);
        int end_j = Math.max(Math.min((int)(ball.getCircle().y) / 55 + 2, Loader.map[0].length - 1), 0);
        for (int i = begin_i; i <= end_i; i++) {
            for (int j = begin_j; j <= end_j; j++) {
                if (Loader.map[i][j] != null) {
                    if (Loader.map[i][j] instanceof Block) collisionRectangle(Loader.map[i][j], ball, dt);
                    if (Loader.map[i][j] instanceof Spike) collisionDeath(Loader.map[i][j], ball);
                    if (Loader.map[i][j] instanceof Checkpoint && Loader.map[i][j].getType() == 1) collisionCheckpoint(Loader.map[i][j], ball);
                    if (Loader.map[i][j] instanceof Rise) { collisionRise(Loader.map[i][j], ball); collisionRectangle(Loader.map[i][j], ball, dt);}
                    if (Loader.map[i][j] instanceof Cutting) { collisionCutting(Loader.map[i][j], ball); collisionRectangle(Loader.map[i][j], ball, dt);}
                    if (Loader.map[i][j] instanceof ExtraLife && ball.overlaps(Loader.map[i][j].getRectangle())) { Loader.numberOfLives++; Loader.map[i][j] = null;}
                }
            }
        }
        for (Snowflake snowflake: Loader.snowflakes) {
            collisionDeath(snowflake, ball);
        }
        if (Loader.exit.getType() == 1) collisionRectangle(Loader.exit, ball, dt);
    }

    private void collisionRectangle(MainObject object, Ball ball, float dt) {
        if (ball.overlaps(object.getRectangle())) {
            if (ball.getCircle().x + ball.getCircle().radius*2 - object.getRectangle().x < Math.abs(ball.getSpeed().x * dt) + 0.01) {
                ball.getCircle().x = object.getRectangle().x - ball.getCircle().radius*2;
                ball.getTexture().setX(object.getRectangle().x - ball.getCircle().radius*2);
                ball.getTextureBig().setX(object.getRectangle().x - ball.getCircle().radius*2);
                ball.getSpeed().x = 0;
            } else if (object.getRectangle().x + object.getRectangle().width - ball.getCircle().x < Math.abs(ball.getSpeed().x * dt) + 0.01) {
                ball.getCircle().x = object.getRectangle().x + object.getRectangle().width;
                ball.getTexture().setX(object.getRectangle().x + object.getRectangle().width);
                ball.getTextureBig().setX(object.getRectangle().x + object.getRectangle().width);
                ball.getSpeed().x = 0;
            } else if (object.getRectangle().y + object.getRectangle().height - ball.getCircle().y < Math.abs(ball.getSpeed().y * dt) + 0.01) {
                ball.getCircle().y = object.getRectangle().y + object.getRectangle().height;
                ball.getTexture().setY(object.getRectangle().y + object.getRectangle().height);
                ball.getTextureBig().setY(object.getRectangle().y + object.getRectangle().height);
                ball.stand();
                ball.getSpeed().y = Math.abs(ball.getSpeed().y) > 300? Math.abs(ball.getSpeed().y) / 2.5f: 0;
            } else if (ball.getCircle().y + ball.getCircle().radius*2 - object.getRectangle().y < Math.abs(ball.getSpeed().y * dt) + 0.01) {
                ball.getCircle().y = object.getRectangle().y - ball.getCircle().radius*2;
                ball.getTexture().setY(object.getRectangle().y - ball.getCircle().radius*2);
                ball.getTextureBig().setY(object.getRectangle().y - ball.getCircle().radius*2);
                ball.getSpeed().y = 0;
            }
        }
        if (ball.overlapsLoverLeftCorner(object.getRectangle()) || ball.overlapsUpperLeftCorner(object.getRectangle())) {
            ball.getCircle().x = ball.getCircle().x - (ball.getSpeed().x * dt + 0.25f);
            ball.getCircle().y = ball.getCircle().y - (ball.getSpeed().y * dt + 0.25f);
            ball.getSpeed().set(0,0);
        }
        if (ball.overlapsUpperRightCorner(object.getRectangle()) || ball.overlapsLoverRightCorner(object.getRectangle())) {
            ball.getCircle().x = ball.getCircle().x + (ball.getSpeed().x * dt + 0.25f);
            ball.getCircle().y = ball.getCircle().y + (ball.getSpeed().y * dt + 0.25f);
            ball.getSpeed().set(0,0);
        }
    }

    private void collisionDeath(MainObject object, Ball ball) {
        if (ball.overlaps(object.getRectangle())) {
            ball.getCircle().x = Loader.ballPosition.x;
            ball.getCircle().y = Loader.ballPosition.y;
            ball.getSpeed().set(0,0);
            Loader.numberOfLives--;
        }
    }

    private void collisionCheckpoint(MainObject object, Ball ball) {
        if (ball.overlaps(object.getRectangle())) {
            Loader.ballPosition.set(object.getRectangle().x, object.getRectangle().y);
            ((Checkpoint)object).changeState();
        }
    }

    private void collisionRise(MainObject object, Ball ball) {
        if (ball.overlaps(object.getRectangle()) && ball.getCircle().radius < 28) {
            ball.getCircle().radius = ball.getCircle().radius*1.5f;
            ball.setType(2);
        }
    }

    private void collisionCutting(MainObject object, Ball ball) {
        if (ball.overlaps(object.getRectangle()) && ball.getCircle().radius > 28) {
            ball.getCircle().radius = ball.getCircle().radius/1.5f;
            ball.setType(1);
        }
    }

}
