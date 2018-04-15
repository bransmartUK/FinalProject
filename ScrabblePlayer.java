/*

  Authors (group members):
  Email addresses of group members:
  Group name:

  Course:
  Section:

  Description of the overall algorithm and key data structures:


*/

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;


public class ScrabblePlayer
{
    
    
    // initialize ScrabblePlayer with a file of English words
    public ScrabblePlayer(String wordFile)
    {
        
        
        
    }

    // based on the board and available letters, 
    //    return a valid word with its location and orientation
    //    See ScrabbleWord.java for details of the ScrabbleWord class 
    //
    // board: 15x15 board, each element is an UPPERCASE letter or space;
    //    a letter could be an underscore representing a blank (wildcard);
    //    first dimension is row, second dimension is column
    //    ie, board[row][col]
    //    row 0 is the top row; col 0 is the leftmost column
    // 
    // availableLetters: a char array that has seven letters available
    //    to form a word
    //    a blank (wildcard) is represented using an underscore '_'
    //
    
    public static final int BOARD_SIZE = 15;
    public static final int MAX_WORD = 7;
    public char[] findInitialWord (char[][] board) {
        char[] initialWord;
        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board[0].length; k++) {
                if (board[i][k] != ' ') {
                    initialWord = storeInitialWord(board, i, k);
                    return initialWord;
                }
            }
        }
        return null;
    }
    
    public char[] storeInitialWord (char[][] board, int row, int column) {
        char[] word = new char[MAX_WORD];
        int i = 0;
        if (row < BOARD_SIZE && board[row + 1][column] != ' ') {
            while (board[row][column] != ' ') {
                word[i] = board[row][column];
                row++;
                i++;
            }
        } else {
            while (board[row][column] != ' ') {
                word[i] = board[row][column];
                column++;
                i++;
            }
        }
        System.out.print(word);
        return word;
    }
    

    public ScrabbleWord getScrabbleWord(char[][] board, char[] availableLetters)
    {
        char[] initialWord = findInitialWord(board);
        



        return  new ScrabbleWord("MYWORD", 0, 0, 'h');
    }

}