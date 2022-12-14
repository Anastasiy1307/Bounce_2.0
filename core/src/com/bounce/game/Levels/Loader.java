package com.bounce.game.Levels;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.bounce.game.GameObjects.Block;
import com.bounce.game.GameObjects.Checkpoint;
import com.bounce.game.GameObjects.Cutting;
import com.bounce.game.GameObjects.Exit;
import com.bounce.game.GameObjects.ExtraLife;
import com.bounce.game.GameObjects.MainObject;
import com.bounce.game.GameObjects.Ring;
import com.bounce.game.GameObjects.Rise;
import com.bounce.game.GameObjects.Snowflake;
import com.bounce.game.GameObjects.Spike;
import com.bounce.game.GameObjects.Triangle;

import java.awt.Point;
import java.util.ArrayList;

public class Loader {
    public static int levelNumber;
    public static MainObject[][] map;
    public static ArrayList<Snowflake> snowflakes;
    public static Exit exit;
    public static Vector2 ballPosition;
    public static int numberOfLives;
    public static int numberOfRings;
    public static int numberOfPoints;
    public static Texture[] textures;
    public static final int size = 55;
    public static Ring[] rings;

    public static void create() {
        levelNumber = 3;
        numberOfPoints = 0;
        textures = new Texture[36];
        textures[0] = null;
        for (int i = 1; i < textures.length; i++) {
            textures[i] = new Texture(i + ".png");
            textures[i].setFilter(com.badlogic.gdx.graphics.Texture.TextureFilter.Linear, com.badlogic.gdx.graphics.Texture.TextureFilter.Linear);
        }
    }

    public static void loadLevel() {
        Level level = null;
        switch (levelNumber) {
            case 1: level = new Level_1(); break;
            case 2: level = new Level_2(); break;
            case 3: level = new Level_3(); break;
            /*case 4: level = new Level_4(); break;
            case 5: level = new Level_5(); break;
            case 6: level = new Level_6(); break;
            case 7: level = new Level_7(); break;
            case 8: level = new Level_8(); break;
            case 9: level = new Level_9(); break;
            case 10: level = new Level_10(); break;
            case 11: level = new Level_11(); break;*/
        }

        map = new MainObject[level.map.length][level.map[0].length];
        for (int i = 0; i < level.map.length; i++) {
            for (int j = 0; j < level.map[i].length; j++) {
                switch (level.map[i][j]) {
                    case 1: map[i][j] = new Block(i*size, j*size, size, size, 1); break;
                    case 2: map[i][j] = new Block(i*size, j*size, size, size, 2); break;
                    case 3: map[i][j] = new Block(i*size, j*size, size, size, 3); break;
                    case 4: map[i][j] = new Triangle(i*size, j*size, size, size, 1); break;
                    case 5: map[i][j] = new Triangle(i*size, j*size, size, size, 2); break;
                    case 6: map[i][j] = new Triangle(i*size, j*size, size, size, 3); break;
                    case 7: map[i][j] = new Triangle(i*size, j*size, size, size, 4); break;
                    case 8: map[i][j] = new Triangle(i*size, j*size, size, size, 5); break;
                    case 9: map[i][j] = new Triangle(i*size, j*size, size, size, 6); break;
                    case 10: map[i][j] = new Triangle(i*size, j*size, size, size, 7); break;
                    case 11: map[i][j] = new Triangle(i*size, j*size, size, size, 8); break;
                    case 12: map[i][j] = new Triangle(i*size, j*size, size, size, 9); break;
                    case 13: map[i][j] = new Triangle(i*size, j*size, size, size, 10); break;
                    case 14: map[i][j] = new Triangle(i*size, j*size, size, size, 11); break;
                    case 15: map[i][j] = new Triangle(i*size, j*size, size, size, 12); break;
                    case 17: map[i][j] = new Rise(i*size+15, j*size, 26, size, 1); break;
                    case 18: map[i][j] = new Rise(i*size, j*size+15, size, 26, 2); break;
                    case 19: map[i][j] = new Rise(i*size+15, j*size, 26, size, 3); break;
                    case 20: map[i][j] = new Rise(i*size, j*size+15, size, 26, 4); break;
                    case 21: map[i][j] = new Cutting(i*size+12, j*size, 31, size, 1); break;
                    case 22: map[i][j] = new Cutting(i*size, j*size+12, size, 31, 2); break;
                    case 23: map[i][j] = new Cutting(i*size+12, j*size, 31, size, 3); break;
                    case 24: map[i][j] = new Cutting(i*size, j*size+12, size, 31, 4); break;
                    case 25: map[i][j] = new Spike(i*size+11, j*size, 33, size, 1); break;
                    case 26: map[i][j] = new Spike(i*size, j*size+11, size, 33, 2); break;
                    case 27: map[i][j] = new Spike(i*size+11, j*size, 33, size, 3); break;
                    case 28: map[i][j] = new Spike(i*size, j*size+11, size, 33, 4); break;
                    case 29: map[i][j] = new Checkpoint(i*size, j*size, size, size); break;
                    case 35: map[i][j] = new ExtraLife(i*size+5, j*size+5, 45, 45); break;
                }
            }
        }
        snowflakes = level.snowflakes;
        exit = level.exit;
        ballPosition = level.ballPosition;
        numberOfLives = level.numberOfLives;
        numberOfRings = level.numberOfRings;
    }
}
