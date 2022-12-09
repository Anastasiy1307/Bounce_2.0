package com.bounce.game.Levels;

import com.bounce.game.GameObjects.Exit;
import com.bounce.game.GameObjects.Snowflake;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

public class Level_2 extends Level {

    public Level_2() {
        map = new int[138][23];
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], 0);
        }

        set(0,0,137,0,1);
        set(0,0,1,7,1);
        set(0,7,133,7,1);
        set(13,1,13,1,25);
        set(15,1,16,4,1);
        set(16,1,17,4,1);
        set(17,4,23,4,1);
        set(22,3,23,3,1);
        set(26,3,27,6,1);
        set(30,1,31,4,1);
        set(32,1,32,1,17);
        set(34,5,36,6,1);
        set(41,1,45,4,1);
        set(66,3,67,6,1);
        set(73,1,73,1,4);
        set(74,2,74,2,4);
        set(75,3,75,3,4);
        set(76,4,76,4,4);
        //set(76,6,76,6,29);
        set(77,4,77,4,5);
        set(78,3,78,3,5);
        set(79,2,79,2,5);
        set(80,1,80,1,5);
        set(74,1,79,1,1);
        set(74,1,79,1,1);
        set(75,2,78,2,1);
        set(76,3,77,3,1);
        set(92,3,93,6,1);
        set(103,1,104,2,1);
        set(103,5,104,6,1);
        set(105,0,113,0,21);
        set(114,1,115,4,1);
        set(118,3,119,6,1);
        set(122,3,123,3,1);
        set(124,1,125,4,1);
        set(129,4,130,6,1);
        set(134,1,134,1,25);
        set(133,4,135,4,1);
        set(136,0,137,21,1);
        set(131,8,132,8,1);
        set(130,9,131,9,1);
        set(129,10,130,10,1);
        set(128,11,129,11,1);
        set(126,8,126,8,25);
        set(124,11,125,11,1);
        set(123,10,124,10,1);
        set(122,9,123,9,1);
        set(121,8,122,8,1);
        set(116,10,116,10,29);
        set(126,8,126,8,25);
        set(114,8,115,21,1);
        set(116,11,117,11,1);
        set(119,14,137,14,1);
        set(116,17,127,17,1);
        set(116,20,116,20,29);
        set(114,21,137,21,1);
        //...
        snowflakes = new ArrayList<>();
        snowflakes.add(new Snowflake(2*55,55,110,110,new Point(110,55),new Point(110,275)));
        snowflakes.add(new Snowflake(4*55,55,110,110,new Point(220,55),new Point(220,275)));
        //...
        exit = new Exit(7480, 825, 110, 110);
        ballPosition = new Point(500,260);
        numberOfLives = 3;
        numberOfRings = 8;
    }
}
