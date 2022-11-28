package com.bounce.game.Levels;

import java.util.Arrays;

public class Level_1 extends Level {

    public Level_1() {
        map = new int[112][8];
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], 0);
        }

    }
}
