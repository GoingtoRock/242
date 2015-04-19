package pieceMove;

import GameManaging.newChess;

/**
 * Created by My precious on 2015-02-08.
 */
public class Knight {

    /*
    possible_Knight(int piece_new_c, int piece_new_r, int piece_c, int piece_r, boolean isBlack)
    DESCRIPTION : determines if the corresponding Knight's move is possible
    INPUT : int piece_new_c, int piece_new_r : new column and row position of selected piece by player
            int piece_c, int piece_r : original column and row position of selected piece by player
            boolean isBlack : determines which player is on the play
    OUTPUT : True if the move is valid
             False otherwise
    SIDE EFFECT : NONE
     */
    public static Boolean possible_Knight(int piece_new_c, int piece_new_r, int piece_c, int piece_r, boolean isBlack) {



        for (int j = -1; j <= 1; j += 2) {
            for (int k = -1; k <= 1; k += 2) {

                    int possible_r = piece_r + j;
                    int possible_c = piece_c + k * 2;

                    // 1 in one direction, 2 in other direction
                    if ((piece_new_r == possible_r && piece_new_c == possible_c) && (
                            " ".equals(newChess.Board[possible_r][possible_c]) ||
                                    (Character.isLowerCase(newChess.Board[possible_r][possible_c].charAt(0)) && !isBlack) ||
                                    (Character.isUpperCase(newChess.Board[possible_r][possible_c].charAt(0)) && isBlack))) {


                        if(KingSafe.isKingNotSafe(piece_new_c, piece_new_r, piece_c, piece_r, isBlack)) {
                            return true;
                        }
                        else {
                            System.out.println("Your king is exposed!");
                            return false;
                        }
                    }

                    possible_r = piece_r + j * 2;
                    possible_c = piece_c + k;

                    if ((piece_new_r == possible_r && piece_new_c == possible_c) && (
                            " ".equals(newChess.Board[possible_r][possible_c]) ||
                            (Character.isLowerCase(newChess.Board[possible_r][possible_c].charAt(0)) && !isBlack) ||
                            (Character.isUpperCase(newChess.Board[possible_r][possible_c].charAt(0)) && isBlack))) {

                        if(KingSafe.isKingNotSafe(piece_new_c, piece_new_r, piece_c, piece_r, isBlack)) {
                            return true;
                        }
                        else {
                            System.out.println("Your king is exposed!");
                            return false;
                        }

                    }

            }
        }

        return false;
    }
}

