//name: Yuhong Nie
//macID: niey12

/**
 * @file: GridT.java
 * @Author: Yuhong Nie
 * @Date: April.6th, 2021
 * @Description: grid type
 */

package src;

import java.util.ArrayList;
import java.util.Random;

public class GridT{

	protected TileT[][] grid = new TileT[4][4];
	protected int score;

    /** 
     * @brief constructor of grid
     * @details the initialized grid is empty and with 0 score
     */
	public GridT() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				grid[i][j] = new TileT();
			}
		}
		this.score = 0;
	}

    /** 
     * @brief get the tile with specific position
     * @param i the row
     * @param j the column
     * @throws IndexOutOfBoundsException the position that is beyond the grid
     */
	public TileT getTile(int i, int j) {
		if (i>=4 || i<0 || j>=4 || j<0) {
			throw new IndexOutOfBoundsException("Tile does not exist");
		}
		return grid[i][j];
	}

    /**
     * @brief get the empty tiles in the grid
     * @return the empty tiles
     */ 
	public ArrayList<TileT> getEmptyTiles() {
		ArrayList<TileT> emptyTiles = new ArrayList<TileT>();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (grid[i][j].getValue() == 0) {
					emptyTiles.add(grid[i][j]);
				}
			}
		}
		return emptyTiles;
	}

    /**
     * @brief create a tile which value is random 2 or 4 in random empty position
     */ 
	public void createRandom() {
		if (getEmptyTiles().size() == 0) {
			grid = grid;
		} else {
			ArrayList<TileT> list = getEmptyTiles();
			Random random = new Random();
        	int index = random.nextInt(list.size());
        	TileT tile = list.get(index);
        	tile.setValue(random.nextInt(100) > 90 ? 4:2);

		}
	}

    /**
     * @brief get the score of the grid
     * @return the score
     */ 
	public int getScore(){
		return score;
	}

    /**
     * @brief update the score
     * @param addedScore the score that will be added
     */ 
	public void updateScore(int addedScore) {
		this.score = this.score + addedScore;
	}

	//partial of the movement codes are from the Internet
	//the main idea of the movement implementation is that if the tile is not on the margin of the movement direction,
	//and it is not empty, then we need to see whether this tile can merge with others or replace others or do nothing.

    /**
     * @brief move the grid up
     * @return the boolean that if the grid move up or not
     */ 
	public boolean moveUp() {
		boolean movement = false;
		for (int i = 0; i < 4; i++) {
			//we use index to keep track of which tile we want to compare with
			for (int j = 1, index = 0; j < 4; j++) {
				if (grid[j][i].getValue() > 0) {
					if (grid[j][i].getValue() == grid[index][i].getValue()) {
						grid[index][i].setValue(2*grid[index][i].getValue());
						updateScore(grid[index++][i].getValue());
						grid[j][i].setValue(0);
						movement = true;
					} else if (grid[index][i].getValue() == 0) {
						grid[index][i].setValue(grid[j][i].getValue());
						grid[j][i].setValue(0);
						movement = true;
						//if the tile we want to compare with can neither merge or replace, we move to the next one
					}else if (grid[++index][i].getValue() == 0) {
						grid[index][i].setValue(grid[j][i].getValue());
						grid[j][i].setValue(0);
						movement = true;
					}
				}
			}
		}
		return movement;
	}
    /**
     * @brief move the grid down
     * @return the boolean that if the grid move down or not
     */ 
	public boolean moveDown() {
		boolean movement = false;
		for (int i = 0; i < 4; i++) {
			for (int j = 2, index = 3; j >= 0; j--) {
				if (grid[j][i].getValue() > 0) {
					if (grid[j][i].getValue() == grid[index][i].getValue()) {
						grid[index][i].setValue(2*grid[index][i].getValue());
						updateScore(grid[index--][i].getValue());
						grid[j][i].setValue(0);
						movement = true;
					} else if (grid[index][i].getValue() == 0) {
						grid[index][i].setValue(grid[j][i].getValue());
						grid[j][i].setValue(0);
						movement = true;
					}else if (grid[--index][i].getValue() == 0) {
						grid[index][i].setValue(grid[j][i].getValue());
						grid[j][i].setValue(0);
						movement = true;
					}
				}
			}
		}
		return movement;
	}

    /**
     * @brief move the grid left
     * @return the boolean that if the grid move left or not
     */ 
	public boolean moveLeft() {
		boolean movement = false;
		for (int i = 0; i < 4; i++) {
			for (int j = 1, index = 0; j < 4; j++) {
				if (grid[i][j].getValue() > 0) {
					if (grid[i][j].getValue() == grid[i][index].getValue()) {
						grid[i][index].setValue(2*grid[i][index].getValue());
						updateScore(grid[i][index++].getValue());
						grid[i][j].setValue(0);
						movement = true;
					} else if (grid[i][index].getValue() == 0) {
						grid[i][index].setValue(grid[i][j].getValue());
						grid[i][j].setValue(0);
						movement = true;
					}else if (grid[i][++index].getValue() == 0) {
						grid[i][index].setValue(grid[i][j].getValue());
						grid[i][j].setValue(0);
						movement = true;
					}
				}
			}
		}
		return movement;
	}

    /**
     * @brief move the grid right
     * @return the boolean that if the grid move right or not
     */ 
	public boolean moveRight() {
		boolean movement = false;
		for (int i = 0; i < 4; i++) {
			for (int j = 2, index = 3; j >= 0; j--) {
				if (grid[i][j].getValue() > 0) {
					if (grid[i][j].getValue() == grid[i][index].getValue()) {
						grid[i][index].setValue(2*grid[i][index].getValue());
						updateScore(grid[i][index--].getValue());
						grid[i][j].setValue(0);
						movement = true;
					} else if (grid[i][index].getValue() == 0) {
						grid[i][index].setValue(grid[i][j].getValue());
						grid[i][j].setValue(0);
						movement = true;
					}else if (grid[i][--index].getValue() == 0) {
						grid[i][index].setValue(grid[i][j].getValue());
						grid[i][j].setValue(0);
						movement = true;
					}
				}
			}
		}
		return movement;
	}

    /**
     * @brief check whether the game is over or not
     * @return the result of the game
     */ 
    public boolean isGameOver() {
        //check whether there are any empty tiles
        if (getEmptyTiles().size() != 0) {
            return false;
        }
        //check whehter there are any two tiles can merge
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j].getValue() == grid[i][j+1].getValue()) {
                    return false;
                }
            }
        }
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 3; i++) {
                if (grid[i][j].getValue() == grid[i+1][j].getValue()) {
                    return false;
                }
            }
        }
        return true;
    }
}