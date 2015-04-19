package GameManaging;

import pieceMove.*;

/**
 * Created by My precious on 2015-02-08.
 */
public class MoveCheck {

    /*
     import values from newChess
     this is to keep such variable name short and make the whole code neat
    */
    static int r = newChess.r;
    static int c = newChess.c;
    static int size_board = newChess.size_board;

    /*
    validMove(int piece_new_c, int piece_new_r, int piece_c, int piece_r)
    DESCRIPTION : check if the move player is trying to make is valid.
    INPUT : int piece_new_c, int piece_new_r : new column and row position of selected piece by player
            int piece_c, int piece_r : original column and row position of selected piece by player
    OUTPUT : True if move is valid
             False if invalid
    SIDE EFFECT :
     */
    public static boolean validMove(int piece_new_c, int piece_new_r, int piece_c, int piece_r) {

        // import values

        // when it goes out of board
        if (piece_new_c >= r || piece_new_r >= c) {
            System.out.println("Out of bound!");
            return false; // out of the edge
        }
        // when there is no movement
        if (piece_new_c == piece_c && piece_new_r == piece_r) {
            System.out.println("You need to move.");
            return false;
        }

        // check the color of player
        boolean isBlack = false;
        if (newChess.currentPlayer == newChess.Black) {
            isBlack = true;
        }

        // check the validity of piece depending on its type
        if (newChess.Board[piece_r][piece_c].equals("P") || newChess.Board[piece_r][piece_c].equals("p")) {
            return Pawn.possible_Pawn(piece_new_c, piece_new_r, piece_c, piece_r, isBlack);

        } else if (newChess.Board[piece_r][piece_c].equals("K") || newChess.Board[piece_r][piece_c].equals("k")) {
            return Knight.possible_Knight(piece_new_c, piece_new_r, piece_c, piece_r, isBlack);

        } else if (newChess.Board[piece_r][piece_c].equals("R") || newChess.Board[piece_c][piece_r].equals("r")) {
            return Rook.possible_Rook(piece_new_c, piece_new_r, piece_c, piece_r, isBlack);

        } else if (newChess.Board[piece_r][piece_c].equals("B") || newChess.Board[piece_r][piece_c].equals("b")) {
            return Bishop.possible_Bishop(piece_new_c, piece_new_r, piece_c, piece_r, isBlack);

        } else if (newChess.Board[piece_r][piece_c].equals("Q") || newChess.Board[piece_r][piece_c].equals("q")) {
            return Queen.possible_Queen(piece_new_c, piece_new_r, piece_c, piece_r, isBlack);

        } else if (newChess.Board[piece_r][piece_c].equals("A") || newChess.Board[piece_r][piece_c].equals("a")) {
            return King.possible_King(piece_new_c, piece_new_r, piece_c, piece_r, isBlack);
        }

        return false;
    }

    /*
    isStaleMate()
    DESCRIPTION : check if the game is on stalemate.
    Specifically, if there are no legal moves for the moving player,
    or the moving player's King is not in check, that is a stalemate. (Piazza @52)
    INPUT : NONE
    OUTPUT : True if the game is on stalemate
             False if not
    SIDE EFFECT :
     */
    public static boolean isStaleMate() {


        // the total possible number of places for a king to live
        int kingPos_total = 9;
        int kingCurrent = 4;
        // which is 3x3 size around the king, including the current area
        int kingPos_r = 3;
        int kingPos_c = 3;

        // king position variable
        int kingPos_A;
        int kingPos_a;
        int kingA_r, kingA_c, kinga_r, kinga_c;
        int temp = 0;
        int temp2 = 0;

        // player color
        boolean isBlack = (newChess.currentPlayer == newChess.Black);
        for (int i = 0; i < size_board; i++) {
            if (newChess.Board[i / r][i % c].equals("A")) {
                temp = i;
            } else if (newChess.Board[i / r][i % c].equals("a")) {
                temp2 = i;
            }
        }
        kingPos_A = temp;
        kingA_r = temp / r;
        kingA_c = temp % c;
        kingPos_a = temp2;
        kinga_r = temp2 / r;
        kinga_c = temp2 % c;
        // check if king is safe on his every possible move, except his current move
        for (int j = 0; j < kingPos_total; j++) {

            if (j != kingCurrent) {
                try {
                    int possible_r = ((kingA_r) - 1 + j / kingPos_r);
                    int possible_c = ((kingA_c) - 1 + j % kingPos_c);

                    //System.out.println("white posr : " + (possible_r) + " posc: " + possible_c);
                    if (!KingSafe.isKingNotSafe(possible_c, possible_r, (kingA_c), (kingA_r), !isBlack)) {
                        break;
                    }


                } catch (Exception e) {
                }
            }
        }
        if (KingSafe.isKingNotSafe(kingA_c, kingA_r,
                (kingA_c), (kingA_r), !isBlack)) {

            return false;
        } else {


            // check other side of king as well
            for (int j = 0; j < kingPos_total; j++) {

                if (j != kingCurrent) {
                    try {
                        int possible_r = ((kinga_r) - 1 + j / kingPos_r);
                        int possible_c = ((kinga_c) - 1 + j % kingPos_c);

                        System.out.println("posr : " + (possible_r) + " posc: " + possible_c + "," + kinga_c);
                        if (!KingSafe.isKingNotSafe(possible_c, possible_r,
                                (kinga_c), (kinga_r), isBlack)) {

                            return false;
                        }


                    } catch (Exception e) {
                    }
                }
            }

        }

        if (!KingSafe.isKingNotSafe(kinga_c, kinga_r,
                (kinga_c), (kinga_r), isBlack)) {
            return true;
        }
        return false;
    }


    /*
    isCheckMate(isBlack)
    DESCRIPTION : check if the game is on checkmate
    INPUT : isBlack : to determine which player
    OUTPUT : True if the game is on checkmate
             False if not
    SIDE EFFECT :
     */
    public static boolean isCheckMate() {
        // get the current position of king

        // the total possible number of places for a king to live
        // the total possible number of places for a king to live
        int kingPos_total = 9;
        int kingCurrent = 4;
        // which is 3x3 size around the king, including the current area
        int kingPos_r = 3;
        int kingPos_c = 3;

        // king position variable
        int kingPos_A;
        int kingPos_a;
        int kingA_r, kingA_c, kinga_r, kinga_c;
        int temp = 0;
        int temp2 = 0;
        int whiteMayWin = 0;
        int blackMayWin = 0;

        boolean isBlack = (newChess.currentPlayer == newChess.Black);
        // player color

        for (int i = 0; i < size_board; i++) {
            if (newChess.Board[i / r][i % c].equals("A")) {
                temp = i;
            } else if (newChess.Board[i / r][i % c].equals("a")) {
                temp2 = i;
            }
        }
        kingPos_A = temp;
        kingA_r = temp / r;
        kingA_c = temp % c;
        kingPos_a = temp2;
        kinga_r = temp2 / r;
        kinga_c = temp2 % c;

        // check if king is safe on his every possible move, including his current move
        for (int j = 0; j < kingPos_total; j++) {

            try {
                int possible_r = ((kingA_r) - 1 + j / kingPos_r);
                int possible_c = ((kingA_c) - 1 + j % kingPos_c);


                if (!KingSafe.isKingNotSafe(possible_c, possible_r,
                        (kingA_c), (kingA_r), !isBlack)) {
                    whiteMayWin = 1;

                    break;
                }

            } catch (Exception e) {
            }

        }

        for (int j = 0; j < kingPos_total; j++) {

            try {
                int possible_r = ((kinga_r) - 1 + j / kingPos_r);
                int possible_c = ((kinga_c) - 1 + j % kingPos_c);

                if (!KingSafe.isKingNotSafe(possible_c, possible_r,
                        (kinga_c), (kinga_r), isBlack)) {
                    if(whiteMayWin == 0) {
                        newChess.currentState = newChess.blackWin;
                        System.out.println("Checkmate!");
                        System.out.println("You have won the game, Player Black!");
                        return true;
                    }
                    else {
                        break;
                    }
                }

            } catch (Exception e) {
            }

        }
        if(blackMayWin == 0 && whiteMayWin == 1){

                newChess.currentState = newChess.whiteWin;
                System.out.println("Checkmate!");
                System.out.println("You have won the game, Player White!");
                return true;
            }


        return false;
    }
}