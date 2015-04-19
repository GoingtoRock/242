package pieceMove;

/**
 * Created by My precious on 2015-02-16.
 */
/*
    GreaterKnight
    The horse icon piece
    instead of moving 1 by 2 or vice versa, it moves 1 by 3 (or vice versa)
    If you are an asian, you should know what I'm talking about (elephant in xiangqi)
 */
public class GreaterKnight {

    public static int r1 = 0;
    public static int c1 = 6;

    public static int R1 = 7;
    public static int C1 = 6;
    /*
    possible_GKnight(int piece_new_c, int piece_new_r, int piece_c, int piece_r, boolean isBlack)
    DESCRIPTION : determines if the corresponding Knight's move is possible
    INPUT : int piece_new_c, int piece_new_r : new column and row position of selected piece by player
            int piece_c, int piece_r : original column and row position of selected piece by player
            boolean isBlack : determines which player is on the play
    OUTPUT : True if the move is valid
             False otherwise
    SIDE EFFECT : NONE
     */
    public static Boolean possible_GKnight(int piece_new_c, int piece_new_r, int piece_c,
                                          int piece_r, boolean isBlack, String[][] Board, boolean mateCheck) {

        if(piece_c == 0 && piece_r == 0) return false;

        for (int j = -1; j <= 1; j += 2) {
            for (int k = -1; k <= 1; k += 2) {

                int possible_r = piece_r + j * 2;
                int possible_c = piece_c + k * 3;

                // 1 in one direction, 3 in other direction
                if ((piece_new_r == possible_r && piece_new_c == possible_c) && (
                        " ".equals(Board[possible_r][possible_c]) ||
                                (Character.isLowerCase(Board[possible_r][possible_c].charAt(0)) && !isBlack) ||
                                (Character.isUpperCase(Board[possible_r][possible_c].charAt(0)) && isBlack))) {


                    if(isKingSafe.isKingSafe(piece_new_c, piece_new_r, piece_c, piece_r, isBlack, false)) {
                        return true;
                    } else if(mateCheck) {
                        return true;
                    }
                    else {
                        System.out.println("Your king is exposed!");
                        return false;
                    }
                }

                possible_r = piece_r + j * 3;
                possible_c = piece_c + k * 2;

                if ((piece_new_r == possible_r && piece_new_c == possible_c) && (
                        " ".equals(Board[possible_r][possible_c]) ||
                                (Character.isLowerCase(Board[possible_r][possible_c].charAt(0)) && !isBlack) ||
                                (Character.isUpperCase(Board[possible_r][possible_c].charAt(0)) && isBlack))) {

                    if(isKingSafe.isKingSafe(piece_new_c, piece_new_r, piece_c, piece_r, isBlack, false)) {
                        return true;
                    } else if(mateCheck) {
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
