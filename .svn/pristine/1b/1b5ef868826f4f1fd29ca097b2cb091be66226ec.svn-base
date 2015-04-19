package pieceMove;

import GameManaging.newChess;

/**
 * Created by My precious on 2015-02-08.
 */
public class Queen {
    /*
    possible_Queen(int piece_new_c, int piece_new_r, int piece_c, int piece_r, boolean isBlack)
    DESCRIPTION : determines if the corresponding Queen's move is possible
    INPUT : int piece_new_c, int piece_new_r : new column and row position of selected piece by player
            int piece_c, int piece_r : original column and row position of selected piece by player
            boolean isBlack : determines which player is on the play
    OUTPUT : True if the move is valid
             False otherwise
    SIDE EFFECT : NONE
     */
    public static Boolean possible_Queen(int piece_new_c, int piece_new_r, int piece_c, int piece_r, boolean isBlack) {
    int step = 1;
    //checking vertical line

        for (int j = -1; j <= 1; j += 1) {
            for (int k = -1; k <= 1; k += 1) {

                if(j!=0 || k!=0) {
                    int possible_r = piece_r + step * j;
                    int possible_c = piece_c + step * k;

                    try {
                        while (" ".equals(newChess.Board[possible_r][possible_c]) &&
                                (possible_r != piece_new_r || possible_c != piece_new_c)) {
                            step++;
                            possible_r = piece_r + step * j;
                            possible_c = piece_c + step * k;
                        }
                        System.out.println("posr: " + possible_r + " posc: " + possible_c);
                        System.out.println("newr: " + piece_new_r + " newc: " + piece_new_c);


                        if ((piece_new_r == possible_r && piece_new_c == possible_c) && (
                                " ".equals(newChess.Board[possible_r][possible_c]) ||
                                        (Character.isLowerCase(newChess.Board[possible_r][possible_c].charAt(0)) && !isBlack) ||
                                        (Character.isUpperCase(newChess.Board[possible_r][possible_c].charAt(0)) && isBlack))) {

                            if (KingSafe.isKingNotSafe(piece_new_c, piece_new_r, piece_c, piece_r, isBlack)) {
                                return true;
                            } else {
                                System.out.println("Your king is exposed!");
                                return false;
                            }
                        }


                    } catch (Exception e) {
                    }
                    step = 1;
                }
            }
        }
    return false;
    }
}
