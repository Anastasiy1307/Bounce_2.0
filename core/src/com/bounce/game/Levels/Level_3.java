package com.bounce.game.Levels;

import com.badlogic.gdx.math.Vector2;
import com.bounce.game.GameObjects.Exit;
import com.bounce.game.GameObjects.Snowflake;

import java.util.ArrayList;
import java.util.Arrays;

public class Level_3 extends Level{
    public Level_3() {
        map = new int[139][36];
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], 0);
        }

        set(0,35,138,35,1);
        set(0,21,32,21,1);
        set(0,21,1,35,1);
        set(6,24,27);
        set(6,25,7,25,1);
        set(0,28,4,28,1);
        set(2,34,27);
        set(4,34,27);
        set(8,34,35);
        set(10,21,11,24,1);
        set(10,28,11,34,1);
        set(12,21,12,23,1);
        set(13,21,13,22,1);
        set(12,24,5);
        set(13,23,5);
        set(14,22,5);
        set(19,22,4);
        set(20,23,4);
        set(21,24,4);
        set(20,22,25,22,1);
        set(21,23,25,23,1);
        set(22,24,25,24,1);
        set(15,22,18,24,2);
        set(14,23,14,24,2);
        set(13,24,13,24,2);
        set(19,23,19,24,2);
        set(20,24,2);
        set(31,22,32,23,1);
        set(31,26,32,27,1);
        set(12,28,12,31,1);
        set(13,28,13,30,1);
        set(14,28,14,29,1);
        set(15,28,1);
        set(12,32,5);
        set(13,31,5);
        set(14,30,5);
        set(15,29,5);
        set(12,34,29);
        set(18,29,4);
        set(18,28,1);
        set(19,30,4);
        set(20,31,4);
        set(21,32,4);
        set(19,28,19,29,1);
        set(20,28,20,30,1);
        set(21,28,21,31,1);
        set(22,28,23,32,1);
        set(23,28,69,28,1);
        //...
        snowflakes = new ArrayList<>();
        //...
        rings = new ArrayList<>();
        exit = new Exit(3190, 1595, 110, 110);
        ballPosition = new Vector2(3190,1850);
        numberOfLives = 3;
        numberOfRings = 8;
    }

}
