package com.bounce.game.Controls;

import com.bounce.game.GameObjects.Ball;
import com.bounce.game.Levels.Loader;

public class Collisions {

    // В процессе...
    public void checkingCollision(Ball ball, float dt) {
        int begin_i = Math.min(Math.max((int)(ball.getRectangle().x) / 55 - 1, 0), Loader.map.length - 1);
        int end_i = Math.max(Math.min((int)(ball.getRectangle().x) / 55 + 1, Loader.map.length - 1), 0);
        int begin_j = Math.min(Math.max((int)(ball.getRectangle().y) / 55 - 1, 0), Loader.map[0].length - 1);
        int end_j = Math.max(Math.min((int)(ball.getRectangle().x) / 55 + 1, Loader.map[0].length - 1), 0);
        for (int i = begin_i; i <= end_i; i++) {
            for (int j = begin_j; j <= end_j; j++) {
                if (Loader.map[i][j] != null) {
                    if (Loader.map[i][j].getRectangle().overlaps(ball.getRectangle())) {
                        if (ball.getRectangle().x + ball.getRectangle().width - Loader.map[i][j].getRectangle().x < Math.abs(ball.getSpeed().x * dt) + 0.01) {
                            ball.getRectangle().x = Loader.map[i][j].getRectangle().x - ball.getRectangle().width;
                            ball.getCircle().x = Loader.map[i][j].getRectangle().x - ball.getRectangle().width;
                            ball.getSpeed().x = 0;
                        } else if (Loader.map[i][j].getRectangle().x + Loader.map[i][j].getRectangle().width - ball.getRectangle().x < Math.abs(ball.getSpeed().x * dt) + 0.01) {
                            ball.getRectangle().x = Loader.map[i][j].getRectangle().x + Loader.map[i][j].getRectangle().width;
                            ball.getCircle().x = Loader.map[i][j].getRectangle().x + Loader.map[i][j].getRectangle().width;
                            ball.getSpeed().x = 0;
                        } else if (Loader.map[i][j].getRectangle().y + Loader.map[i][j].getRectangle().height - ball.getRectangle().y < Math.abs(ball.getSpeed().y * dt) + 0.01) {
                            ball.getRectangle().y = Loader.map[i][j].getRectangle().y + Loader.map[i][j].getRectangle().height;
                            ball.getCircle().y = Loader.map[i][j].getRectangle().y + Loader.map[i][j].getRectangle().height;
                            ball.stand();
                            ball.getSpeed().y = Math.abs(ball.getSpeed().y) > 300? Math.abs(ball.getSpeed().y) / 2.5f: 0;
                        } else if (ball.getRectangle().y + ball.getRectangle().height - Loader.map[i][j].getRectangle().y < Math.abs(ball.getSpeed().y * dt) + 0.01) {
                            ball.getRectangle().y = Loader.map[i][j].getRectangle().y - ball.getRectangle().height;
                            ball.getCircle().y = Loader.map[i][j].getRectangle().y - ball.getRectangle().height;
                            ball.getSpeed().y = 0;
                        }
                    }
                }
            }
        }
    }
}
