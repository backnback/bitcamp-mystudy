package study.lang.operator;

import java.util.Random;

public class FindX {
  private static final int SIZE = 5;
  private static final int NUM_MINES = 5;
  private static final char MINE = '*';
  private static final char HIDDEN = '-';
  private static final char[][] board = new char[SIZE][SIZE];
  private static final Random random = new Random();

  public static void main(String[] args) {
    initializeBoard();
    placeMines();
    displayBoard();
  }

  private static void initializeBoard() {
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        board[i][j] = HIDDEN;
      }
    }
  }

  private static void placeMines() {
    int minesPlaced = 0;
    while (minesPlaced < NUM_MINES) {
      int x = random.nextInt(SIZE);
      int y = random.nextInt(SIZE);
      if (board[x][y] != MINE) {
        board[x][y] = MINE;
        minesPlaced++;
      }
    }
  }

  private static void displayBoard() {
    System.out.println("  0 1 2 3 4");
    for (int i = 0; i < SIZE; i++) {
      System.out.print(i + " ");
      for (int j = 0; j < SIZE; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }
}
