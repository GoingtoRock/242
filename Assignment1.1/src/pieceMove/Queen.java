package pieceMove;

/**
 * Created by My precious on 2015-02-08.
 */
public class Queen {

    public static int r1 = 0;
    public static int c1 = 3;

    public static int R1 = 7;
    public static int C1 = 3;
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
    public static Boolean possible_Queen(int piece_new_c, int piece_new_r, int piece_c,
                                         int piece_r, boolean isBlack, String[][] Board, boolean mateCheck) {
    int step = 1;
    //checking vertical line
        // invalid piece
        if(piece_c == 0 && piece_r == 0) return false;

        for (int j = -1; j <= 1; j += 1) {
            for (int k = -1; k <= 1; k += 1) {

                if(j!=0 || k!=0) {
                    int possible_r = piece_r + step * j;
                    int possible_c = piece_c + step * k;

                    try {
                        while (" ".equals(Board[possible_r][possible_c]) &&
                                (possible_r != piece_new_r || possible_c != piece_new_c)) {
                            step++;
                            possible_r = piece_r + step * j;
                            possible_c = piece_c + step * k;
                        }


                        if ((piece_new_r == possible_r && piece_new_c == possible_c) && (
                                " ".equals(Board[possible_r][possible_c]) ||
                                        (Character.isLowerCase(Board[possible_r][possible_c].charAt(0)) && !isBlack) ||
                                        (Character.isUpperCase(Board[possible_r][possible_c].charAt(0)) && isBlack))) {

                            if (isKingSafe.isKingSafe(piece_new_c, piece_new_r, piece_c, piece_r, isBlack, false)) {
                                return true;
                            }else if(mateCheck) {
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
