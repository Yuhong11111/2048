//name: Yuhong Nie
//macID: niey12
//some ideas are from 2020-A4 solution

/**
 * @file: GameController.java
 * @Author: Yuhong Nie
 * @Date: April.12th, 2021
 * @Description: the game module that handles the beginning and end and the inputs of the game 
 */

package src;

import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class GameController{

	private static GridT theGrid;
	private UserInterface view;
    private static GameController controller = null;
    private Scanner keyboard = new Scanner(System.in);


    /**
     * @brief the constructor of game module
     * @param theGrid the grid that will be used
     * @param view the view that will be used
     */
    private GameController(GridT theGrid, UserInterface view){
        this.theGrid = theGrid;
        this.view = view;
    }

    /**
     * @brief get the abstract object of the game(avoiding more than one instance)
     * @return the single game module object
     */   
    public static GameController getInstance(GridT theGrid, UserInterface view) 
    { 
        if (controller == null) 
            controller = new GameController(theGrid, view); 
  
        return controller; 
    }  

    /**
     * @brief initialize the game
     */ 
	public static void initGame() {
		theGrid = new GridT();
		theGrid.createRandom();
		theGrid.createRandom();
	}

    /**
     * @brief take the input from users to see whethter they want to start
     * @return the input
     */
	public String readGameInput() {
		String gameMode = " ";
		gameMode = keyboard.nextLine();
		gameMode = gameMode.toLowerCase();
		try {
			if(!gameMode.equals("s") && !gameMode.equals("e"))
				throw new IllegalArgumentException();
		}
		catch (IllegalArgumentException e) {
			System.out.println("invalid input");
		}
		return gameMode;
	}

    /**
     * @brief take the input from users to see the movement of the grid
     * @return the movement
     */ 
	public String readMovement() {
		String input = "";
		input = keyboard.nextLine();
		try {
			if(!input.equals("u") && !input.equals("d") &&!input.equals("l") && !input.equals("r") &&  !input.equals("q"))
				throw new IllegalArgumentException();
		}
		catch (IllegalArgumentException e) {
			System.out.println("invalid input");
		}
		return input;
	}

    /**
     * @brief display welcome message
     */
    public void displayWelcomeMessage(){
        view.printWelcomeMessage();
    }

    /**
     * @brief display the grid
     */
    public void displayGrid(){
        view.printGrid(theGrid);
    }

    /**
     * @brief display the score
     */
    public void displayScore() {
    	view.printScore(theGrid);
    }

    /**
     * @brief display the the start message
     */
    public void displayGameStart() {
    	view.printGameStart();
    }

    /**
     * @brief display the instrcution
     */
    public void displayGameInstruction() {
    	view.printGameInstruction();
    }

    /**
     * @brief display the ending message
     */
    public void displayEnding() {
    	view.printEndingMessage();
    }

    /**
     * @brief run the game
     */
    public void runGame(){
        String input = "";
        String gameMode = "";
        displayWelcomeMessage();
        do {
            //start the game
        	initGame();
        	displayGameStart();
        	do{
        		gameMode = readGameInput();
        	}while(!gameMode.equals("s") && !gameMode.equals("e"));
        	input = " ";
        	while(!theGrid.isGameOver() && !(input.equals("q")) && !(gameMode.equals("e"))) {
        		displayGameInstruction();
        		displayGrid();
        		displayScore();
                System.out.println("");
        		try {
                    //user wants to quit
        			input = readMovement();
        			if(input.equals("q"))
        				break;

        			if (input.equals("u")) {
        				boolean isMove = theGrid.moveUp();
                        //create one more random tile only when the grid is moved
                        if (isMove) {
                            theGrid.createRandom();
                        }
                        continue;
        			}

                    if (input.equals("d")) {
                        boolean isMove = theGrid.moveDown();
                        if (isMove) {
                            theGrid.createRandom();
                        }
                        continue;
                    }

                    if (input.equals("l")) {
                        boolean isMove = theGrid.moveLeft();
                        if (isMove) {
                            theGrid.createRandom();
                        }
                        continue;
                    }

                    if (input.equals("r")) {
                        boolean isMove = theGrid.moveRight();
                        if (isMove) {
                            theGrid.createRandom();
                        }
                        continue;
                    }
        		}
        	    catch (IllegalArgumentException e) {
        			System.out.println("invalid input");
        		}
        	}
        	if (theGrid.isGameOver()) {
                displayGrid();
        		System.out.println("game is over, please restart");
        	}
        }while(!gameMode.equals("e"));
        displayEnding();
    }
}