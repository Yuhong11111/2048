/**
 * @file: TestTileT.java
 * @Author: Yuhong Nie - niey12
 * @Date: Apr.14th 2021
 * @Description: GridT testcases
 */

package src;

import org.junit.*;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.ArrayList;

public class TestGridT{

    private GridT grid1;

    @Before
    public void setUp(){
        grid1 = new GridT();
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++) {
                grid1.getTile(i,j).setValue(2);
            } 
        }
    }

    @After
    public void tearDown(){
        this.grid1 = null;
    }

    @Test (expected=IndexOutOfBoundsException.class)
    public void testGetTileException(){
        grid1.getTile(4,0);
    }

    @Test 
    public void testGetTile(){
        assertEquals(grid1.getTile(1,1).getValue(), 2);
        assertFalse(grid1.getTile(1,1).getValue() == 0);
    }

    @Test 
    public void testCreateRandom(){
        grid1.getTile(0,0).setValue(0);
        assertEquals(grid1.getTile(0,0).getValue(), 0);
        grid1.createRandom();
        assertFalse(grid1.getTile(0,0).getValue() == 0);
    }

    @Test 
    public void testGetScore(){
        assertEquals(grid1.getScore(), 0);
    }

    @Test 
    public void testUpdateScore(){
        grid1.updateScore(8);
        assertEquals(grid1.getScore(), 8);
    }

    @Test 
    public void testGetEmptyTiles(){
        assertEquals(grid1.getEmptyTiles().size(), 0);
    }

    @Test 
    public void testMoveUp(){
        grid1.getTile(0,0).setValue(2);
        assertTrue(grid1.moveUp());
    }

    @Test 
    public void testMoveDown(){
        assertTrue(grid1.moveDown());
    }

    @Test 
    public void testMoveLeft(){
        assertTrue(grid1.moveLeft());
    }

    @Test 
    public void testMoveRight(){
        assertTrue(grid1.moveRight());
    }

    @Test 
    public void testIsGameOver(){
        assertFalse(grid1.isGameOver());

        grid1.getTile(0,0).setValue(2);
        grid1.getTile(1,0).setValue(8);
        grid1.getTile(2,0).setValue(2);
        grid1.getTile(3,0).setValue(8);

        grid1.getTile(0,1).setValue(8);
        grid1.getTile(1,1).setValue(2);
        grid1.getTile(2,1).setValue(8);
        grid1.getTile(3,1).setValue(2);

        grid1.getTile(0,2).setValue(2);
        grid1.getTile(1,2).setValue(8);
        grid1.getTile(2,2).setValue(2);
        grid1.getTile(3,2).setValue(8);

        grid1.getTile(0,3).setValue(8);
        grid1.getTile(1,3).setValue(2);
        grid1.getTile(2,3).setValue(8);
        grid1.getTile(3,3).setValue(2);

        assertTrue(grid1.isGameOver());
    }
}