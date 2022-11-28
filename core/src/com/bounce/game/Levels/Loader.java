package com.bounce.game.Levels;

import com.bounce.game.GameObjects.Block;
import com.bounce.game.GameObjects.MainObject;

public class Loader {
    public static int levelNumber;
    public static MainObject[][] map;
    private static final int size = 55;

    public static void load() {
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
        for (int i = 0; i < level.map.length; i++) {
            for (int j = 0; j < level.map[i].length; j++) {
                switch (level.map[i][j]) {
                    case 1: map[i][j] = new Block(i*size, j*size, size, size); break;
                }
            }
        }
    }
}
