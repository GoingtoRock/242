package pieceMove;


import GameManaging.newChess;

/**
 * Created by My precious on 2015-02-08.
 */
public class Pawn {
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
    public static Boolean possible_Pawn(int piece_new_c, int piece_new_r, int piece_c, int piece_r, boolean isBlack) {

         // Possible promote options
        String[] promoteList = {"Q", "R", "B", "K"};
        // since pawn cannot go backward, the black pawn cannot go up to the first row

        for (int j = -1; j <= 1; j += 2) {
            // Capturing case
            try {
                if (!isBlack) {
                    int possible_r = piece_r - 1;
                    int possible_c = piece_c + j;
                    if ((piece_new_r == possible_r && piece_new_c == possible_c) && (
                            Character.isLowerCase(newChess.Board[possible_r][possible_c].charAt(0)))) {

                        if(KingSafe.isKingNotSafe(piece_new_c, piece_new_r, piece_c, piece_r, isBlack)) {
                            return true;
                        }
                        else {
                            System.out.println("Your king is exposed!");
                            return false;
                        }
                    }
                } else {
                    int possible_r = piece_r + 1;
                    int possible_c = piece_c + j;
                    if ((piece_new_r == possible_r && piece_new_c == possible_c) && (
                            Character.isUpperCase(newChess.Board[possible_r][possible_c].charAt(0)))) {

                        if(KingSafe.isKingNotSafe(piece_new_c, piece_new_r, piece_c, piece_r, isBlack)) {
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
                if (Character.isLowerCase(chessnewChess.Board[r - 1][c + j].charAt(0)) && i<16) {

                    // sweeping through promotion list string array
                    for (int k = 0; k < 4; k++) {
                        old_pos = chessnewChess.Board[r - 1][c + j];
                        chessnewChess.Board[r][c] = " ";
                        // Promotion part : this is mandatory
                        chessnewChess.Board[r - 1][c + j] = promoteList[k];
                        if (kingSafe()) {
                            //column1,column2,captured-piece,new-piece,P
                            list=list + c + (c + j) + old_pos + promoteList[k] + "P";
                        }
                        chessnewChess.Board[r][c] = "P";
                        chessnewChess.Board[r - 1][c + j] = old_pos;
                    }
                }
            } catch (Exception e) {}*/

       /* // Promotion without capturing
        try {
            if (" ".equals(chessnewChess.Board[r - 1][c]) && i < 16) {

                for (int k=0; k < 4; k++) {
                    old_pos=chessnewChess.Board[r - 1][c];
                    chessnewChess.Board[r][c]=" ";
                    chessnewChess.Board[r - 1][c]=promoteList[k];
                    if (kingSafe()) {
                        //column1,column2,captured-piece,new-piece,P
                        list=list + c + c + old_pos + promoteList[k]+"P";
                    }
                    chessnewChess.Board[r][c]="P";
                    chessnewChess.Board[r - 1][c]=old_pos;
                }
            }
        } catch (Exception e) {}*/

            // Moving up by one, no capturing
          try {

                if(!isBlack) {
                    int possible_r = piece_r - 1;
                    int possible_c = piece_c;
                        if ((piece_new_r == possible_r && piece_new_c == possible_c) && (
                            " ".equals(newChess.Board[possible_r][possible_c]))) {

                            if(KingSafe.isKingNotSafe(piece_new_c, piece_new_r, piece_c, piece_r, !isBlack)) {
                                return true;
                            }
                        return true;
                    }
                }
                else {
                    int possible_r = piece_r + 1;
                    int possible_c = piece_c;

                    if ((piece_new_r == possible_r && piece_new_c == possible_c) && (
                            " ".equals(newChess.Board[possible_r][possible_c]))) {

                        if(KingSafe.isKingNotSafe(piece_new_c, piece_new_r, piece_c, piece_r, isBlack)) {
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
                            " ".equals(newChess.Board[possible_r][possible_c])) &&
                            " ".equals(newChess.Board[possible_r2][possible_c])) {

                        if(KingSafe.isKingNotSafe(piece_new_c, piece_new_r, piece_c, piece_r, !isBlack)) {
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
                            " ".equals(newChess.Board[possible_r][possible_c])) &&
                            " ".equals(newChess.Board[possible_r2][possible_c])) {

                        if(KingSafe.isKingNotSafe(piece_new_c, piece_new_r, piece_c, piece_r, isBlack)) {
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




