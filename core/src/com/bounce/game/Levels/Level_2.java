package com.bounce.game.Levels;

import java.util.Arrays;

public class Level_2 extends Level {
    public Level_2() {
        map = new int[112][22];
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], 0);
        }
        set(0,0,111,0,1);

    }
}
