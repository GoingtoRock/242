package GameManaging;

import GameManaging.newChess;

import java.util.Arrays;

/**
 * Created by My precious on 2015-02-08.
 */
public class MoveExecute {

    /*
    validMove(int piece_new_c, int piece_new_r, int piece_c, int piece_r)
    DESCRIPTION : make the move of the player
    INPUT : int piece_new_c, int piece_new_r : new column and row position of selected piece by player
            int piece_c, int piece_r : original column and row position of selected piece by player
    OUTPUT : NONE
    SIDE EFFECT : calls executePiece function to handle the rest
     */
    public static void moveNow(int piece_new_c, int piece_new_r, int piece_c, int piece_r) {

        // string to save opponents color as string
        String other;
        // check if the player can win by making the move
        int mayWin;
        int mayNotWin = 0;

        // figure out which player is playing right now, and check if enemy piece is at the desired destination
        if (newChess.currentPlayer == newChess.White){
            if(Character.isLowerCase(newChess.Board[piece_new_r][piece_new_c].charAt(0))) {
                other  = "black";
                mayWin = newChess.whiteWin;
                executePiece(piece_new_c, piece_new_r, piece_c, piece_r, other, mayWin);
            }
            else {
                executePiece(piece_new_c, piece_new_r, piece_c, piece_r, "none", mayNotWin);
            }
        }
        else if (newChess.currentPlayer == newChess.Black) {

            if(Character.isUpperCase(newChess.Board[piece_new_r][piece_new_c].charAt(0))) {

                other = "white";
                mayWin = newChess.blackWin;
                executePiece(piece_new_c, piece_new_r, piece_c, piece_r, other, mayWin);
            }
            else {
                executePiece(piece_new_c, piece_new_r, piece_c, piece_r, "none", mayNotWin);
            }

        }
        return;
        }

    /*
    executePiece(int piece_new_c, int piece_new_r, int piece_c, int piece_r, String other, int mayWin)
    DESCRIPTION : helper function for moveNow by executing the move
    INPUT : int piece_new_c, int piece_new_r : new column and row position of selected piece by player
            int piece_c, int piece_r : original column and row position of selected piece by player
            String other : contains the opponent color name
            int mayWin : will be used when the player is won after this move
    OUTPUT : None
    SIDE EFFECT : Strings inside Board[][] will be changed
     */
    private static void executePiece(int piece_new_c, int piece_new_r, int piece_c, int piece_r, String other, int mayWin){


        String old_pos = newChess.Board[piece_r][piece_c];
        String new_pos = newChess.Board[piece_new_r][piece_new_c];
        String notice;

        // if there is an enemy at destination, figure out which one and tell that it has been slain.
        if (new_pos.equals("P") || new_pos.equals("p")) {
            notice = other + " Player's pawn has fallen!";
            System.out.println(notice);
        } else if (new_pos.equals("K")|| new_pos.equals("k")) {
            notice = other + " Player's knight has fallen!";
            System.out.println(notice);
        } else if (new_pos.equals("R")|| new_pos.equals("r")) {
            notice = other + " Player's rook has fallen!";
            System.out.println(notice);
        } else if (new_pos.equals("B")|| new_pos.equals("b")) {
            notice = other + " Player's bishop has fallen!";
            System.out.println(notice);
        } else if (new_pos.equals("Q")|| new_pos.equals("q")) {
            notice = other + " Player's queen has fallen!";
            System.out.println(notice);
        } else if (new_pos.equals("A")|| new_pos.equals("a")) {
            notice = other + " Player's king has fallen!";
            System.out.println(notice);
            newChess.currentState = mayWin;
        }

        // now update the change
        newChess.Board[piece_new_r][piece_new_c] = old_pos;
        newChess.Board[piece_r][piece_c] = " ";

    }

}
