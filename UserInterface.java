//name: Yuhong Nie
//macID: niey12
//some ideas are from 2020-A4 solution

/**
 * @file: UserInterface.java
 * @Author: Yuhong Nie
 * @Date: April.12th, 2021
 * @Description: the view module
 */

package src;

public class UserInterface{

    private static UserInterface visual = null;

    /** 
     * @brief constructor of view moduel
     */
    private UserInterface(){}

    /**
     * @brief public static method for obtaining a single instance
     * @return an UserInterface object
     */
    public static UserInterface getInstance(){
        if (visual == null)
            return visual = new UserInterface();
        return visual;
    }

    /**
     * @brief display a welcome message
     */
    public void printWelcomeMessage(){
        System.out.println("-------------------------------------------------");
        System.out.println("                 Welcome to 2048                 ");
        System.out.println("-------------------------------------------------");
    }

    /**
     * @brief display the score
     */
    public void printScore(GridT grid){
        System.out.println("score:" + grid.getScore());
    }

    /**
     * @brief display the information for how to start
     */
    public void printGameStart(){
        System.out.println("");
        System.out.println("Enter s to start, e to exit");
    }
    /**
     * @brief display the instruction for how to move
     */
    public void printGameInstruction(){
        System.out.println("");
        System.out.println("Enter u: move upward, d: move downward, l: move leftward, r: move rightward, q: quit");
    }

    /**
     * @brief Display the grid on the screen
     * @param GridT the grid
     */
    public void printGrid(GridT grid){
        for (int x = 0; x < 4; x++){
            for (int y = 0; y < 4; y++){
               System.out.print(grid.getTile(x, y).getValue() + "   ");
            } 
            System.out.println();
        }
        System.out.println();
    }

    /**
     * @brief display an ending message
     */
    public void printEndingMessage(){
        System.out.println("-------------------------------------------------");
        System.out.println("             Thank You For Playing !!!           ");
        System.out.println("-------------------------------------------------");
    }
}