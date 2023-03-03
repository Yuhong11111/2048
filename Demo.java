//name: Yuhong Nie
//macID: niey12

/**
 * @file: Demo.java
 * @Author: Yuhong Nie
 * @Date: April.12th, 2021
 * @Description: running the game
 */
package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Demo
{
   public static void main(String[] args) {

      GridT grid = new GridT();
      UserInterface UI = UserInterface.getInstance();
      GameController game = GameController.getInstance(grid, UI);
      game.runGame();
  }
}
