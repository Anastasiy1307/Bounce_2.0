package com.bounce.game.Levels;

import com.badlogic.gdx.math.Vector2;
import com.bounce.game.GameObjects.Exit;
import com.bounce.game.GameObjects.Ring;

import java.util.ArrayList;
import java.util.Arrays;

public class Level_1 extends Level {

    public Level_1() {
        map = new int[112][8];
        for (int[] ints : map) {
            Arrays.fill(ints, 0);
        }
        set(0, 0, 111, 0, 1);
        set(1, 1, 2);
        set(0, 0, 1, 7, 1);
        set(0, 7, 111, 7, 1);
        set(5, 3, 10, 7, 1);
        set(14, 0, 15, 4, 1);
        set(17, 1, 17, 1, 25);
        set(21, 3, 23, 7, 1);
        set(26, 0, 27, 3, 1);
        set(28, 3, 29, 3, 1);
        set(30, 1, 30, 1, 25);
        set(32, 3, 35, 3, 1);
        set(33, 2, 34, 2, 1);
        set(33, 6, 34, 6, 1);
        set(36, 1, 36, 1, 25);
        set(38, 3, 41, 3, 1);
        set(40, 1, 41, 2, 1);
        set(44, 3, 45, 7, 1);
        set(46, 6, 46, 7, 1);
        set(47, 7, 64, 7, 1);
        set(51, 1, 51, 1, 25);
        set(54, 1, 54, 1, 25);
        set(56, 4, 56, 4, 29);
        set(58, 1, 58, 1, 25);
        set(62, 1, 62, 1, 25);
        set(65, 6, 67, 6, 1);
        set(66, 3, 67, 5, 1);
        set(70, 0, 71, 4, 1);
        set(74, 3, 75, 7, 1);
        set(78, 0, 79, 4, 1);
        set(78, 6, 35); //доп.жизнь
        set(82, 3, 83, 6, 1);
        set(86, 0, 87, 4, 1);
        set(92, 1, 96, 1, 1);
        set(92, 2, 93, 2, 1);
        set(94, 2, 94, 2, 25);
        set(95, 1, 96, 3, 1);
        set(99, 3, 100, 6, 1);
        set(99, 2, 99, 2, 29);
        set(103, 1, 104, 3, 1);
        set(105, 1, 105, 1, 1);
        set(105, 2, 105, 2, 25);
        set(106, 1, 107, 2, 1);
        set(110, 3, 111, 6, 1);
        //...
        snowflakes = new ArrayList<>();
        //...
        rings = new ArrayList<>();
        rings.add(new Ring(9 * 55 + 12, 55 + 15, 30, 80, 1));
        rings.add(new Ring(33 * 55 + 12, 4 * 55 + 15, 30, 80, 1));
        rings.add(new Ring(74 * 55 + 12, 55 + 15, 30, 80, 1));
        rings.add(new Ring(82 * 55 + 12, 55 + 15, 30, 80, 1));
        rings.add(new Ring(97 * 55 + 15, 3 * 55 + 12, 80, 30, 3));
        rings.add(new Ring(101 * 55 + 15, 3 * 55 + 12, 80, 30, 3));
        //...
        exit = new Exit(6050, 55, 110, 110);
        ballPosition = new Vector2(110, 330);
        numberOfLives = 3;
        numberOfRings = 6;
    }
}
