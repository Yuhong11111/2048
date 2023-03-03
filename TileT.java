//name: Yuhong Nie
//macID: niey12

/**
 * @file: TileT.java
 * @Author: Yuhong Nie
 * @Date: April.6th, 2021
 * @Description: tile type
 */

package src;

public class TileT{

	protected int value;

    /** 
     * @brief constructor of tile
     * @details initialize tile with 0 value
     */
	public TileT() {
		value = 0;
	}

    /** 
     * @brief get the value
     * @return the value of the tile
     */
	public int getValue() {
		return value;
	}

    /** 
     * @brief set the value of the tile
     * @param i the new value
     * @throws IllegalArgumentException the value is not divisble by two, which is invalid
     */
	public void setValue(int newValue) {
		if ( newValue % 2 != 0 || newValue > 16384) {
			throw new IllegalArgumentException("value is invalid");
		} else {
			value = newValue;
		}
	}

}