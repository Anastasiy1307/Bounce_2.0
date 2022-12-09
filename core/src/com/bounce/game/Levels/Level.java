package com.bounce.game.Levels;

import com.bounce.game.GameObjects.Exit;
import com.bounce.game.GameObjects.Snowflake;

import java.awt.Point;
import java.util.ArrayList;

public abstract class Level {
    protected int[][] map;
    protected ArrayList<Snowflake> snowflakes;
    protected Exit exit;
    protected Point ballPosition;
    protected int numberOfLives;
    protected int numberOfRings;

    protected void set(int x, int y, int value) {
        map[x][y] = value;
    }

    protected void set(int x1, int y1, int x2, int y2, int value) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                map[i][j] = value;
            }
        }
    }
}
