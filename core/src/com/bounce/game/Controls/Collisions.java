package com.bounce.game.Controls;

import com.bounce.game.GameObjects.Ball;
import com.bounce.game.Levels.Loader;

public class Collisions {

    // В процессе...
    public void checkingCollision(Ball ball, float dt) {
        int begin_i = Math.min(Math.max((int)(ball.getCircle().x) / 55 - 1, 0), Loader.map.length - 1);
        int end_i = Math.max(Math.min((int)(ball.getCircle().x) / 55 + 1, Loader.map.length - 1), 0);
        int begin_j = Math.min(Math.max((int)(ball.getCircle().y) / 55 - 1, 0), Loader.map[0].length - 1);
        int end_j = Math.max(Math.min((int)(ball.getCircle().x) / 55 + 1, Loader.map[0].length - 1), 0);
        for (int i = begin_i; i <= end_i; i++) {
            for (int j = begin_j; j <= end_j; j++) {
                    if (Loader.map[i][j] != null) {
                        /*if (Loader.map[i][j].getRectangle().overlaps(ball.getCircle())) {
                            if (player.rectangle.x + player.rectangle.width - Loader.map[i][j].getRectangle().x < Math.abs(player.velocity.x * dt) + 0.01) {
                                player.rectangle.x = Loader.map[i][j].getRectangle().x - player.rectangle.width;
                                player.velocity.x = 0;
                            } else if (Loader.map[i][j].getRectangle().x + Loader.map[i][j].getRectangle().width - player.rectangle.x < Math.abs(player.velocity.x * dt) + 0.01) {
                                player.rectangle.x = Loader.map[i][j].getRectangle().x + Loader.map[i][j].getRectangle().width;
                                player.velocity.x = 0;
                            } else if (Loader.map[i][j].getRectangle().y + Loader.map[i][j].getRectangle().height - player.rectangle.y < Math.abs(player.velocity.y * dt) + 0.01) {
                                player.rectangle.y = Loader.map[i][j].getRectangle().y + Loader.map[i][j].getRectangle().height;
                                player.isStand = true;
                                player.velocity.y = 0;
                            } else if (player.rectangle.y + player.rectangle.height - Loader.map[i][j].getRectangle().y < Math.abs(player.velocity.y * dt) + 0.01) {
                                player.rectangle.y = Loader.map[i][j].getRectangle().y - player.rectangle.height;
                                player.velocity.y = 0;
                            }
                        }*/
                    }
            }
        }
    }
}
