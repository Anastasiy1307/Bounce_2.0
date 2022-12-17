package com.bounce.game.Levels;

import com.badlogic.gdx.math.Vector2;
import com.bounce.game.GameObjects.Exit;
import com.bounce.game.GameObjects.Ring;
import java.util.ArrayList;
import java.util.Arrays;

public class Level_3 extends Level {
    public Level_3() {
        map = new int[97][9];
        for (int[] ints : map) {
            Arrays.fill(ints, 0);
        }

        /*set(0, 35, 138, 35, 1);
        set(0, 21, 32, 21, 1);
        set(0, 21, 1, 35, 1);
        set(6, 24, 27);
        set(6, 25, 7, 25, 1);
        set(0, 28, 4, 28, 1);
        set(2, 34, 27);
        set(4, 34, 27);
        set(8, 34, 35);
        set(10, 21, 11, 24, 1);
        set(10, 28, 11, 34, 1);
        set(12, 21, 12, 23, 1);
        set(13, 21, 13, 22, 1);
        set(12, 24, 5);
        set(13, 23, 5);
        set(14, 22, 5);
        set(19, 22, 4);
        set(20, 23, 4);
        set(21, 24, 4);
        set(20, 22, 25, 22, 1);
        set(21, 23, 25, 23, 1);
        set(22, 24, 25, 24, 1);
        set(15, 22, 18, 24, 2);
        set(14, 23, 14, 24, 2);
        set(13, 24, 13, 24, 2);
        set(19, 23, 19, 24, 2);
        set(20, 24, 2);
        set(31, 22, 32, 23, 1);
        set(31, 26, 32, 27, 1);
        set(12, 28, 12, 31, 1);
        set(13, 28, 13, 30, 1);
        set(14, 28, 14, 29, 1);
        set(15, 28, 1);
        set(12, 32, 5);
        set(13, 31, 5);
        set(14, 30, 5);
        set(15, 29, 5);
        set(12, 34, 29);
        set(18, 29, 4);
        set(18, 28, 1);
        set(19, 30, 4);
        set(20, 31, 4);
        set(21, 32, 4);
        set(19, 28, 19, 29, 1);
        set(20, 28, 20, 30, 1);
        set(21, 28, 21, 31, 1);
        set(22, 28, 23, 32, 1);
        set(23, 28, 69, 28, 1);
        set(43, 29, 45, 29, 1);
        set(44, 30, 45, 30, 1);*/
        set(0, 0, 96, 0, 1);
        set (0,0,0,8,1);
        set (0,8,95,8,1);
        set (2,2,2,6,1);
        set (3,6,1);
        set (4,2,4,6,1);
        set (6,2,6,6,1);
        set (6,4,8,4,1);
        set (6,6,8,6,1);
        set (8,5,1);
        set (10,2,10,6,1);
        set (11,2,1);
        set (11,6,1);
        set (12,2,12,6,1);
        set (14,2,18,2,1);
        set (15,2,15,6,1);
        set (16,6,1);
        set (17,2,17,6,1);
        set (20,2,20,6,1);
        set (21,2,1);
        set (21,6,1);
        set (22,2,22,6,1);
        set (24,2,25,2,1);
        set (25,2,25,6,1);
        set (26,6,1);
        set (27,2,27,6,1);
        set (29,2,29,6,1);
        set (30,4,1);
        set (31,2,31,6,1);
        set (32,4,1);
        set (33,2,33,6,1);
        set (35,2,35,6,1);
        set (36,2,37,2,1);
        set (36,4,37,4,1);
        set (36,6,37,6,1);
        set (39,2,39,6,1);
        set (40,4,1);
        set (41,2,41,6,1);
        set (43,2,43,6,1);
        set (44,3,1);
        set (45,4,1);
        set (46,2,46,6,1);
        set (48,2,48,6,1);
        set (48,2,50,2,1);
        set (48,4,50,4,1);
        set (48,6,50,6,1);
        set (56,2,56,6,1);
        set (56,2,58,2,1);
        set (56,6,58,6,1);
        set (60,2,61,2,1);
        set (61,2,61,6,1);
        set (62,6,1);
        set (63,2,63,6,1);
        set (65,2,65,6,1);
        set (65,2,67,2,1);
        set (65,4,67,4,1);
        set (65,6,67,6,1);
        set (69,2,73,2,1);
        set (70,2,70,6,1);
        set (71,6,1);
        set (72,2,72,6,1);
        set (75,2,77,2,1);
        set (75,4,75,6,1);
        set (76,4,1);
        set (77,2,77,6,1);
        set (79,2,79,6,1);
        set (79,2,81,2,1);
        set (79,4,81,4,1);
        set (79,6,81,6,1);
        set (83,6,87,6,1);
        set (85,2,85,6,1);
        set (89,2,1);
        set (91,2,1);
        set (93,2,1);
        set (95,3,96,8,1);
        //...
        snowflakes = new ArrayList<>();
        //...
        rings = new ArrayList<>();

        rings.add(new Ring(5 * 55 + 12, 55 + 15, 30, 80, 1));
        rings.add(new Ring(7 * 55 + 15, 3 * 55 + 12, 80, 30, 3));
        rings.add(new Ring(13 * 55 + 12, 55 + 15, 30, 80, 1));
        rings.add(new Ring(19 * 55 + 12, 55 + 15, 30, 80, 1));
        rings.add(new Ring(23 * 55 + 12, 55 + 15, 30, 80, 1));
        rings.add(new Ring(28 * 55 + 12, 55 + 15, 30, 80, 1));
        rings.add(new Ring(52 * 55 + 15, 4 * 55 + 12, 80, 30, 3));
        rings.add(new Ring(68 * 55 + 12, 55 + 15, 30, 80, 1));
        rings.add(new Ring(78 * 55 + 12, 55 + 15, 30, 80, 1));
        exit = new Exit(95*55, 55, 110, 110);
        ballPosition = new Vector2(55, 110);
        numberOfLives = 1;
        numberOfRings = 9;
    }

}
