/**
 * @file: TestTileT.java
 * @Author: Yuhong Nie - niey12
 * @Date: Apr.14th 2021
 * @Description: TileT testcases
 */

package src;

import org.junit.*;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.ArrayList;

public class TestTileT{

    private TileT tile1;

    @Before
    public void setUp(){
        tile1 = new TileT();
    }

    @After
    public void tearDown(){
        this.tile1 = null;
    }

    @Test 
    public void testGetValuel(){
        assertEquals(tile1.getValue(), 0);
    }

    @Test (expected=IllegalArgumentException.class)
    public void testSetValueException(){
        tile1.setValue(13);
    }

    @Test 
    public void testSetValue(){
        tile1.setValue(2);
        assertEquals(tile1.getValue(), 2);;
    }
}