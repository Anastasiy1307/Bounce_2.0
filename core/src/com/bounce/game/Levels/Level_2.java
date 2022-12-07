package com.bounce.game.Levels;

import com.bounce.game.GameObjects.Exit;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

public class Level_2 extends Level {

    public Level_2() {
        map = new int[112][22];
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], 0);
        }
        set(0,0,111,0,1);
        //...
        snowflakes = new ArrayList<>();
        //...
        exit = new Exit(55, 110, 110, 110);
        ballPosition = new Point(60,60);
    }
}
