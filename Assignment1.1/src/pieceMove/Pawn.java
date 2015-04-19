package pieceMove;


/**
 * Created by My precious on 2015-02-08.
 */
public class Pawn {

    public static int r1 = 1;
    public static int c1 = 0;
    public static int r2 = 1;
    public static int c2 = 1;
    public static int r3 = 1;
    public static int c3 = 2;
    public static int r4 = 1;
    public static int c4 = 3;
    public static int r5 = 1;
    public static int c5 = 4;
    public static int r6 = 1;
    public static int c6 = 5;

    public static int R1 = 6;
    public static int C1 = 0;
    public static int R2 = 6;
    public static int C2 = 1;
    public static int R3 = 6;
    public static int C3 = 2;
    public static int R4 = 6;
    public static int C4 = 3;
    public static int R5 = 6;
    public static int C5 = 4;
    public static int R6 = 6;
    public static int C6 = 5;

    /*
    possible_Pawn(int piece_new_c, int piece_new_r, int piece_c, int piece_r, boolean isBlack)
    DESCRIPTION : determines if the corresponding Pawn's move is possible
    INPUT : int piece_new_c, int piece_new_r : new column and row position of selected piece by player
            int piece_c, int piece_r : original column and row position of selected piece by player
            boolean isBlack : determines which player is on the play
    OUTPUT : True if the move is valid
             False otherwise
    SIDE EFFECT : NONE
     */
    public static Boolean possible_Pawn(int piece_new_c, int piece_new_r, int piece_c,
                                        int piece_r, boolean isBlack, String[][] Board, boolean mateCheck) {

         // Possible promote options
        String[] promoteList = {"Q", "R", "B", "K"};
        // since pawn cannot go backward, the black pawn cannot go up to the first row

        if(piece_c == 0 && piece_r == 0) return false;
        for (int j = -1; j <= 1; j += 2) {
            // Capturing case
            try {
                if (!isBlack) {
                    int possible_r = piece_r - 1;
                    int possible_c = piece_c + j;
                    if ((piece_new_r == possible_r && piece_new_c == possible_c) && (
                            Character.isLowerCase(Board[possible_r][possible_c].charAt(0)))) {

                        if(isKingSafe.isKingSafe(piece_new_c, piece_new_r, piece_c, piece_r, isBlack, false)) {
                            return true;
                        } else if(mateCheck) {
                            return true;
                        } else {
                                System.out.println("Your king is exposed!");
                                return false;
                        }

                    }
                } else {
                    int possible_r = piece_r + 1;
                    int possible_c = piece_c + j;
                    if ((piece_new_r == possible_r && piece_new_c == possible_c) && (
                            Character.isUpperCase(Board[possible_r][possible_c].charAt(0)))) {

                        if(isKingSafe.isKingSafe(piece_new_c, piece_new_r, piece_c, piece_r, isBlack, false)) {
                            return true;
                        }  else if(mateCheck) {
                            return true;
                        }
                        else {
                            System.out.println("Your king is exposed!");
                            return false;
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
           /* // TODO in later assignment : pawn promotion
            try {
                if (Character.isLowerCase(chessBoard[r - 1][c + j].charAt(0)) && i<16) {

                    // sweeping through promotion list string array
                    for (int k = 0; k < 4; k++) {
                        old_pos = chessBoard[r - 1][c + j];
                        chessBoard[r][c] = " ";
                        // Promotion part : this is mandatory
                        chessBoard[r - 1][c + j] = promoteList[k];
                        if (kingSafe()) {
                            //column1,column2,captured-piece,new-piece,P
                            list=list + c + (c + j) + old_pos + promoteList[k] + "P";
                        }
                        chessBoard[r][c] = "P";
                        chessBoard[r - 1][c + j] = old_pos;
                    }
                }
            } catch (Exception e) {}*/

       /* // Promotion without capturing
        try {
            if (" ".equals(chessBoard[r - 1][c]) && i < 16) {

                for (int k=0; k < 4; k++) {
                    old_pos=chessBoard[r - 1][c];
                    chessBoard[r][c]=" ";
                    chessBoard[r - 1][c]=promoteList[k];
                    if (kingSafe()) {
                        //column1,column2,captured-piece,new-piece,P
                        list=list + c + c + old_pos + promoteList[k]+"P";
                    }
                    chessBoard[r][c]="P";
                    chessBoard[r - 1][c]=old_pos;
                }
            }
        } catch (Exception e) {}*/

            // Moving up by one, no capturing
          try {

                if(!isBlack) {
                    int possible_r = piece_r - 1;
                    int possible_c = piece_c;
                        if ((piece_new_r == possible_r && piece_new_c == possible_c) && (
                            " ".equals(Board[possible_r][possible_c]))) {

                            if(isKingSafe.isKingSafe(piece_new_c, piece_new_r, piece_c, piece_r, !isBlack, false)) {
                                return true;
                            }  else if(mateCheck) {
                                return true;
                            } else {
                                System.out.println("Your king is exposed!");
                                return false;
                            }


                    }
                }
                else {
                    int possible_r = piece_r + 1;
                    int possible_c = piece_c;

                    if ((piece_new_r == possible_r && piece_new_c == possible_c) && (
                            " ".equals(Board[possible_r][possible_c]))) {

                        if(isKingSafe.isKingSafe(piece_new_c, piece_new_r, piece_c, piece_r, isBlack, false)) {
                            return true;
                        }  else if(mateCheck) {
                            return true;
                        }
                        else {
                            System.out.println("Your king is exposed!");
                            return false;
                        }

                    }
                }
            } catch (Exception e){}
            // moving up by two, no capturing

                // 4 is the only row that a pawn can make

            try {
                if (!isBlack) {
                    int possible_r = 4;
                    int possible_c = piece_c;
                    int possible_r2 = 5;
                    if ((piece_new_r == possible_r && piece_new_c == possible_c) && (
                            " ".equals(Board[possible_r][possible_c])) &&
                            " ".equals(Board[possible_r2][possible_c])) {

                        if(isKingSafe.isKingSafe(piece_new_c, piece_new_r, piece_c, piece_r, !isBlack, false)) {
                            return true;
                        } else if(mateCheck) {
                            return true;
                        }
                        else {
                            System.out.println("Your king is exposed!");
                            return false;
                        }

                    }
                } else { // 3 in this case
                    int possible_r = 3;
                    int possible_c = piece_c;
                    int possible_r2 = 2;
                    if ((piece_new_r == possible_r && piece_new_c == possible_c) && (
                            " ".equals(Board[possible_r][possible_c])) &&
                            " ".equals(Board[possible_r2][possible_c])) {

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
            }catch (Exception e){}

        return false;
    }


}




