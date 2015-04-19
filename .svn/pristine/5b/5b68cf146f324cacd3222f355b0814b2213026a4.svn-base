package General;

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
        if (newChess.Board[piece_r][piece_c].equals(Pieces.bPawn) ||
                newChess.Board[piece_r][piece_c].equals(Pieces.wPawn)) {
            return Pawn.possible_Pawn(piece_new_c, piece_new_r, piece_c, piece_r, isBlack, newChess.Board, false);

        } else if (newChess.Board[piece_r][piece_c].equals(Pieces.bKnight) ||
                newChess.Board[piece_r][piece_c].equals(Pieces.wKnight)) {
            return Knight.possible_Knight(piece_new_c, piece_new_r, piece_c, piece_r, isBlack, newChess.Board, false);

        } else if (newChess.Board[piece_r][piece_c].equals(Pieces.bRook) ||
                newChess.Board[piece_r][piece_c].equals(Pieces.wRook)) {
            System.out.println("Rook step:");
            return Rook.possible_Rook(piece_new_c, piece_new_r, piece_c, piece_r, isBlack, newChess.Board, false);

        } else if (newChess.Board[piece_r][piece_c].equals(Pieces.bBishop) ||
                newChess.Board[piece_r][piece_c].equals(Pieces.wBishop)) {
            return Bishop.possible_Bishop(piece_new_c, piece_new_r, piece_c, piece_r, isBlack, newChess.Board, false);

        } else if (newChess.Board[piece_r][piece_c].equals(Pieces.bQueen) ||
                newChess.Board[piece_r][piece_c].equals(Pieces.wQueen)) {
            return Queen.possible_Queen(piece_new_c, piece_new_r, piece_c, piece_r, isBlack, newChess.Board, false);

        } // for kamikaze, the condition is same as queen
        else if (newChess.Board[piece_r][piece_c].equals(Pieces.bKamikaze) ||
                newChess.Board[piece_r][piece_c].equals(Pieces.wKamikaze)) {
            return Queen.possible_Queen(piece_new_c, piece_new_r, piece_c, piece_r, isBlack, newChess.Board, false);

        }  else if (newChess.Board[piece_r][piece_c].equals(Pieces.bGreaterKnight) ||
                newChess.Board[piece_r][piece_c].equals(Pieces.wGreaterKnight)) {
            return GreaterKnight.possible_GKnight
                    (piece_new_c, piece_new_r, piece_c, piece_r, isBlack, newChess.Board, false);

        } else if (newChess.Board[piece_r][piece_c].equals(Pieces.bKing) ||
                newChess.Board[piece_r][piece_c].equals(Pieces.wKing)) {
            return King.possible_King(piece_new_c, piece_new_r, piece_c, piece_r, isBlack);
        }

        return false;
    }



    /*
    isGame
    DESCRIPTION : check if the game is on stalemate or checkmate
    INPUT : isBlack : to determine which player
    OUTPUT : True if the game is on checkmate or stalemate
             False if not
    SIDE EFFECT : ends the game by changing the current state
     */
    public static boolean isGame() {
        // get the current position of king

        // the total possible number of places for a king to live
        int kingPos_total = 9;
        int kingCurrent = 4;

        // player color
        boolean isBlack = (newChess.currentPlayer == newChess.Black);

        // which is 3x3 size around the king, including the current area
        int kingPos_r = 3;
        int kingPos_c = 3;
        int whiteMayWin = 0;
        int blackMayWin = 0;

        // king position variable
        int kingA_r, kingA_c, kinga_r, kinga_c;
        int temp = 0;
        int temp2 = 0;

        for (int i = 0; i < size_board; i++) {
            if (newChess.Board[i / r][i % c].equals("A")) {
                temp = i;
            } else if (newChess.Board[i / r][i % c].equals("a")) {
                temp2 = i;
            }
        }

        kingA_r = temp / r;
        kingA_c = temp % c;
        kinga_r = temp2 / r;
        kinga_c = temp2 % c;


        int staleMate = 0;

        // check if king is safe on his every possible move, including his current move
        for (int j = 0; j < kingPos_total; j++) {

            try {
                int possible_r = ((kingA_r) - 1 + j / kingPos_r);
                int possible_c = ((kingA_c) - 1 + j % kingPos_c);

                // if king is safe in one of area, then it is fine
                if (!isKingSafe.isKingSafe(possible_c, possible_r,
                        (kingA_c), (kingA_r), !isBlack, true)) {

                    if(j == kingCurrent){
                        staleMate++;
                    }
                    else {
                        staleMate = 0;
                        whiteMayWin = 1;
                        break;
                    }
                }

            } catch (Exception e) {
            }

        }

        for (int j = 0; j < kingPos_total; j++) {

            try {
                int possible_r = ((kinga_r) - 1 + j / kingPos_r);
                int possible_c = ((kinga_c) - 1 + j % kingPos_c);


                if (!isKingSafe.isKingSafe(possible_c, possible_r,
                        (kinga_c), (kinga_r), isBlack, true)) {

                    if(j == kingCurrent){
                        staleMate++;
                    } else if(whiteMayWin == 0) {
                        staleMate = 0;
                        newChess.currentState = newChess.blackWin;
                        System.out.println("Checkmate!");
                        System.out.println("You have won the game, Player Black!");
                        return true;
                    } else {
                        staleMate = 0;
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

        else if(staleMate > 0) {
            newChess.currentState = newChess.draw;
            System.out.println("Stalemate!");
            return true;
        }

        return false;
    }
}