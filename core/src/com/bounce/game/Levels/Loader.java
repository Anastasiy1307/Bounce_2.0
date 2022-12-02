package com.bounce.game.Levels;

import com.badlogic.gdx.graphics.Texture;
import com.bounce.game.GameObjects.Block;
import com.bounce.game.GameObjects.MainObject;

public class Loader {
    public static int levelNumber;
    public static MainObject[][] map;
    public static Texture[] textures;
    private static final int size = 55;

    public static void create() {
        levelNumber = 1;
        textures = new Texture[33];
        textures[0] = null;
        textures[1] = new Texture("1.png");
        //...
        for (int i = 1; i < textures.length; i++) {
            textures[i].setFilter(com.badlogic.gdx.graphics.Texture.TextureFilter.Linear, com.badlogic.gdx.graphics.Texture.TextureFilter.Linear);
        }
    }

    public static void loadLevel() {
        Level level = null;
        switch (levelNumber) {
            case 1: level = new Level_1(); break;
            /*case 2: level = new Level_2(); break;
            case 3: level = new Level_3(); break;
            case 4: level = new Level_4(); break;
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
                    case 1: map[i][j] = new Block(i*size, j*size, size, size); break;
                    //...
                }
            }
        }
    }
}
