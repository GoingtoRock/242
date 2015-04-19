package pieceMove;

import GameManaging.newChess;
/**
 * Created by My precious on 2015-02-08.
 */

public class King {
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


                        if(KingSafe.isKingNotSafe(piece_new_c, piece_new_r, piece_c, piece_r, isBlack)) {
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