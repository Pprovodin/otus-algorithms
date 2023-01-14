package ru.otus.barn.impl;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.otus.barn.BarnSolution;

public class BarnBestSolutionTest {

    BarnSolution barnSolution;

    @Test
    public void solveCustomTest() {
        boolean[][] map = new boolean[][] {{false, false, false, false, false, false, false, false, true, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, true, false, false, false, false},
                {false, true, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, true, false, false, false},
                {false, false, true, false, false, false, false, false, false, false},
                {false, false, false, false, true, false, true, false, false, false},
                {false, false, false, false, false, false, false, false, false, false},
        };
        barnSolution = new BarnBestSolution(map);
        Assert.assertEquals(27, barnSolution.solve());
    }

    @Test
    @Ignore
    public void solveEmptyAreaTest() {
        boolean[][] map = BarnSolution.generateMap(5, 10000, 12345);
        barnSolution = new BarnBestSolution(map);
        Assert.assertEquals(25, barnSolution.solve());
    }

    @Test
    public void solveFullAreaTest() {
        boolean[][] map = BarnSolution.generateMap(5, 1, 12345);
        barnSolution = new BarnBestSolution(map);
        Assert.assertEquals(0, barnSolution.solve());
    }
}
