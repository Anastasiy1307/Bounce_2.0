package com.bounce.game.Levels;

public abstract class Level {
    protected int[][] map;

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
