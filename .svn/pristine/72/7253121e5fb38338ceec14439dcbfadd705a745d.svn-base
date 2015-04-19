package pieceMove;

/**
 * Created by My precious on 2015-02-08.
 */
public class Rook {

    public static int r1 = 0;
    public static int c1 = 1;
    public static int R1 = 7;
    public static int C1 = 1;
    public static int r2 = 0;
    public static int c2 = 6;
    public static int R2 = 7;
    public static int C2 = 6;
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
    public static Boolean possible_Rook(int piece_new_c, int piece_new_r, int piece_c,
                                        int piece_r, boolean isBlack, String[][] Board, boolean mateCheck) {

        if(piece_c == 0 && piece_r == 0)  return false;


        int step = 1;
        //checking vertical line
        for (int j = -1; j <= 1; j += 2) {

            // two cases two consider : one goes horizontally, the other goes vertically

            if(piece_c != piece_new_c){
                int possible_c = piece_c + step * j;
                try {
                    while (" ".equals(Board[piece_r][possible_c]) && possible_c != piece_new_c) {
                        step++;
                        possible_c = piece_c + step * j;
                    }


                    if(( " ".equals(Board[piece_r][possible_c]) ||
                            Character.isLowerCase(Board[piece_r][possible_c].charAt(0)) && !isBlack) ||
                            (Character.isUpperCase(Board[piece_r][possible_c].charAt(0)) && isBlack)) {
                        if (piece_new_r == piece_r && piece_new_c == possible_c) {

                            if (isKingSafe.isKingSafe(piece_new_c, piece_new_r, piece_c, piece_r, isBlack, false)) {
                                return true;
                            }else if(mateCheck) {
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
                while (" ".equals(Board[possible_r][piece_c]) && possible_r != piece_new_r) {
                    step++;
                    possible_r = piece_r + step * j;
                }


                 if(( " ".equals(Board[possible_r][piece_c]) ||
                         Character.isLowerCase(Board[possible_r][piece_c].charAt(0)) && !isBlack) ||
                        (Character.isUpperCase(Board[possible_r][piece_c].charAt(0)) && isBlack)) {
                    if (piece_new_r == possible_r && piece_new_c == piece_c) {


                        if (isKingSafe.isKingSafe(piece_new_c, piece_new_r, piece_c, piece_r, isBlack, false)) {
                            return true;
                        } else if(mateCheck) {
                            return true;
                        }else {
                            System.out.println("Your king is exposed!");
                            return false;
                        }
                    }
                }

            } catch (Exception e) {
            }

            }
            step = 1;
        }
        return false;
    }
}
