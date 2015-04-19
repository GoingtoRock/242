package pieceMove;

import GameManaging.newChess;

/**
 * Created by My precious on 2015-02-08.
 */
public class Rook {
    /*
    possible_Rook(int piece_new_c, int piece_new_r, int piece_c, int piece_r, boolean isBlack)
    DESCRIPTION : determines if the corresponding Rook's move is possible
    INPUT : int piece_new_c, int piece_new_r : new column and row position of selected piece by player
            int piece_c, int piece_r : original column and row position of selected piece by player
            boolean isBlack : determines which player is on the play
    OUTPUT : True if the move is valid
             False otherwise
    SIDE EFFECT : NONE
     */
    public static Boolean possible_Rook(int piece_new_c, int piece_new_r, int piece_c, int piece_r, boolean isBlack) {


        int step = 1;
        //checking vertical line
        for (int j = -1; j <= 1; j += 2) {

            // two cases two consider : one goes horizontally, the other goes vertically

            if(piece_c != piece_new_c){
                int possible_c = piece_c + step * j;
                try {
                    while (" ".equals(newChess.Board[piece_r][possible_c]) && possible_c != piece_new_c) {
                        step++;
                        possible_c = piece_c + step * j;
                    }


                    if((Character.isLowerCase(newChess.Board[piece_r][possible_c].charAt(0)) && !isBlack) ||
                            (Character.isUpperCase(newChess.Board[piece_r][possible_c].charAt(0)) && isBlack)) {
                        if (piece_new_r == piece_r && piece_new_c == possible_c) {

                            if (KingSafe.isKingNotSafe(piece_new_c, piece_new_r, piece_c, piece_r, isBlack)) {
                                return true;
                            } else {
                                System.out.println("Your king is exposed!");
                                return false;
                            }
                        }
                    }

                } catch (Exception e) {
                }
            }

            else{
            int possible_r = piece_r + step * j;
            try {
                while (" ".equals(newChess.Board[possible_r][piece_c]) && possible_r != piece_new_r) {
                    step++;
                    possible_r = piece_r + step * j;
                }

                if(possible_r != piece_new_r){
                    System.out.println("There is something on the way.");
                    return false;
                }

                else if((Character.isLowerCase(newChess.Board[possible_r][piece_c].charAt(0)) && !isBlack) ||
                        (Character.isUpperCase(newChess.Board[possible_r][piece_c].charAt(0)) && isBlack)) {
                    if (piece_new_r == possible_r && piece_new_c == piece_c) {

                        if (KingSafe.isKingNotSafe(piece_new_c, piece_new_r, piece_c, piece_r, isBlack)) {
                            return true;
                        } else {
                            System.out.println("Your king is exposed!");
                            return false;
                        }
                    }
                }

            } catch (Exception e) {
            }
            step = 1;
            }
        }
        return false;
    }
}
