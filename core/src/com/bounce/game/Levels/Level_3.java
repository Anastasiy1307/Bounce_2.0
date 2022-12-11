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
        set(6,24,27);
        set(6,25,7,25,1);
        set(0,28,4,28,1);
        set(3,34,27);
        set(3,34,27);
        set(8,34,35);
        set(10,21,11,24,1);
        set(10,28,11,34,1);
        set(12,21,12,23,1);
        set(13,21,13,22,1);
        set(12,24,5);
        set(13,23,5);
        set(12,24,5);
        //...

        //...
        exit = new Exit(150, 150, 110, 110);
        ballPosition = new Vector2(150,150);
        numberOfLives = 3;
        numberOfRings = 8;
    }

}
