package pieceMove;

import General.newChess;
/**
 * Created by My precious on 2015-02-08.
 */

public class King {

    public static int r1 = 0;
    public static int c1 = 5;

    public static int R1 = 7;
    public static int C1 = 5;
    /*
    possible_King(int piece_new_c, int piece_new_r, int piece_c, int piece_r, boolean isBlack)
    DESCRIPTION : determines if the corresponding King's move is possible
    INPUT : int piece_new_c, int piece_new_r : new column and row position of selected piece by player
            int piece_c, int piece_r : original column and row position of selected piece by player
            boolean isBlack : determines which player is on the play
    OUTPUT : True if the move is valid
             False otherwise
    SIDE EFFECT : NONE
     */
    public static Boolean possible_King(int piece_new_c, int piece_new_r, int piece_c, int piece_r, boolean isBlack) {

        if(piece_c == 0 && piece_r == 0) return false;
        /* check every possible places the king can go.
        there are 9 scenarios for king: he can either move to either one of eight possible directions,
        or he can stay in his current spot.
         */
        for (int j = 0; j < 9; j++) {
            // when the king moves
            if (j != 4) {
                // check if king goes "out of bound"
                try {
                    int possible_r = (piece_r - 1 + j / 3);
                    int possible_c = (piece_c - 1 + j % 3);
                    if ((piece_new_r == possible_r && piece_new_c == possible_c) && (
                            " ".equals(newChess.Board[possible_r][possible_c]) ||
                            (Character.isLowerCase(newChess.Board[possible_r][possible_c].charAt(0)) && !isBlack) ||
                            (Character.isUpperCase(newChess.Board[possible_r][possible_c].charAt(0)) && isBlack))){


                        if(isKingSafe.isKingSafe(piece_new_c, piece_new_r, piece_c, piece_r, isBlack, false)) {
                            return true;
                        }
                        else {
                            System.out.println("Your king is exposed!");

                            return false;
                        }

                    }
                } catch (Exception e) {}

            }
        }
        return false;
    }

}