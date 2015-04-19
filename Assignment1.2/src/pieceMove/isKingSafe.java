package pieceMove;

import General.newChess;

/**
 * Created by My precious on 2015-02-08.
 */


public class isKingSafe {

    /*
     import values from newChess
     this is to keep such variable name short and make the whole code neat
    */
    static int r = newChess.r;
    static int c = newChess.c;
    static int size_board = newChess.size_board;
    /*
    isKingSafe(int piece_new_c, int piece_new_r, int piece_c, int piece_r, boolean isBlack)
    DESCRIPTION : based on the possible moves from each piece, check whether the king of current
                    player would be safe after the move
    INPUT : int piece_new_c, int piece_new_r : new column and row position of selected piece by player
            int piece_c, int piece_r : original column and row position of selected piece by player
            boolean isBlack : determines which player is on the play
    OUTPUT : True if King is safe
             False otherwise
    SIDE EFFECT : NONE
     */
    public static boolean isKingSafe(int piece_new_c, int piece_new_r, int piece_c, int piece_r,
                                     boolean isBlack, boolean mateCheck) {

        // make a temporary board
        String[][] tempBoard = new String [r][c];
        for(int i = 0; i < size_board; i++) {
            tempBoard[i/r][i%c] = newChess.Board[i/r][i%c];
        }

        // put the value
        String old_pos = tempBoard[piece_r][piece_c];
        tempBoard[piece_new_r][piece_new_c] = old_pos;
        tempBoard[piece_r][piece_c] = " ";

        // return the result
    return !isCheck.isCheck(tempBoard, isBlack, mateCheck);
    }

}
