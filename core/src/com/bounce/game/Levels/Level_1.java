package com.bounce.game.Levels;

import java.util.Arrays;

public class Level_1 extends Level {

    public Level_1() {
        map = new int[112][8];
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], 0);
        }
        set(0,0,111,0,1);
        set(1,1,2);
        set(0,0,1,7,1);
        set(0,7,111,7,1);
        set(5,3,10,7,1);
        set(14,0,15,4,1);
        set(21,3,23,7,1);
        set(26,0,27,3,1);
        set(28,3,29,3,1);
        set(32,3,35,3,1);
        set(33,2,34,2,1);
        set(38,3,41,3,1);
        set(40,2,41,2,1);
        set(44,3,45,7,1);
        set(46,6,46,7,1);
        set(47,7,64,7,1);
        set(65,6,67,6,1);
        set(66,5,67,3,1);
        set(70,0,71,4,1);
        set(74,3,75,7,1);
        set(77,0,78,4,1);
        set(81,3,82,6,1);
        set(85,0,86,4,1);
        set(91,1,95,1,1);
        set(91,2,92,2,1);
        set(94,2,95,3,1);
        set(98,3,99,6,1);
        set(102,0,106,1,1);
        set(102,2,103,3,1);
        set(105,2,106,2,1);
        set(110,3,111,6,1);
        //...
    }
}
