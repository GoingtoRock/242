package pieceMove;

import General.newChess;

/**
 * Created by My precious on 2015-02-15.
 */

// to check if complete checkmate is possible
public class CheckMateHelper {

    /*
    import values from newChess
    this is to keep such variable name short and make the whole code neat
    */
    static int r = newChess.r;
    static int c = newChess.c;
    static int size_board = newChess.size_board;

    public static boolean checkProtection(int king_r, int king_c, int i, int j, int max_step,
                                          boolean isBlack, String[][] Board){

        // track the current position of corresponding player's non-king pieces

        boolean mateCheck = true;
        // check if one of the our piece can interfere with the enemy's way to the king
        // if it is, it is not checkmate yet
        int step = 1;
        while (step < max_step) {

            int possible_r = step * i;
            int possible_c = step * j;

            // possible_Queen(int piece_new_c, int piece_new_r, int piece_c, int piece_r, boolean isBlack)

            if(Queen.possible_Queen(king_c + possible_c, king_r + possible_r, Queen.C1, Queen.R1,
                    !isBlack, Board, mateCheck)
                    || (Queen.possible_Queen(king_c + possible_c, king_r + possible_r, Queen.c1, Queen.r1, isBlack,
                    Board, mateCheck))){

                return true;
            } else if(Rook.possible_Rook(king_c + possible_c, king_r + possible_r, Rook.C1, Rook.R1,
                    !isBlack, Board, mateCheck)
                    || (Rook.possible_Rook(king_c + possible_c, king_r + possible_r, Rook.c1, Rook.r1,
                    isBlack, Board, mateCheck))){

                return true;
            } else if(Rook.possible_Rook(king_c + possible_c, king_r + possible_r, Rook.C2, Rook.R2,
                    !isBlack, Board, mateCheck)
                || (Rook.possible_Rook(king_c + possible_c, king_r + possible_r, Rook.c2, Rook.r2,
                    isBlack, Board, mateCheck))){

            return true;
            }
            else if(Bishop.possible_Bishop(king_c + possible_c, king_r + possible_r, Bishop.C1, Bishop.R1,
                    !isBlack, Board, mateCheck)
                    || (Bishop.possible_Bishop(king_c + possible_c, king_r + possible_r, Bishop.c1, Bishop.r1,
                    isBlack, Board, mateCheck))){

                return true;
            } else if(Knight.possible_Knight(king_c + possible_c, king_r + possible_r, Knight.C1, Knight.R1,
                    !isBlack, Board, mateCheck)
                    || (Knight.possible_Knight(king_c + possible_c, king_r + possible_r, Knight.c1, Knight.r1,
                    isBlack, Board, mateCheck))){

                return true;
            } else if(Pawn.possible_Pawn(king_c + possible_c, king_r + possible_r, Pawn.C1, Pawn.R1,
                    !isBlack, Board, mateCheck)
                    || (Pawn.possible_Pawn(king_c + possible_c, king_r + possible_r, Pawn.c1, Pawn.r1,
                    isBlack, Board, mateCheck))){

                return true;
            } else if(Pawn.possible_Pawn(king_c + possible_c, king_r + possible_r, Pawn.C2, Pawn.R2,
                    !isBlack, Board, mateCheck)
                    && (Pawn.possible_Pawn(king_c + possible_c, king_r + possible_r, Pawn.c2, Pawn.r2,
                    isBlack, Board, mateCheck))){

                return true;
            } else if(Pawn.possible_Pawn(king_c + possible_c, king_r + possible_r, Pawn.C3, Pawn.R3,
                    !isBlack, Board, mateCheck)
                    && (Pawn.possible_Pawn(king_c + possible_c, king_r + possible_r, Pawn.c3, Pawn.r3,
                    isBlack, Board, mateCheck))){

                return true;
            } else if(Pawn.possible_Pawn(king_c + possible_c, king_r + possible_r, Pawn.C4, Pawn.R4,
                    !isBlack, Board, mateCheck)
                    && (Pawn.possible_Pawn(king_c + possible_c, king_r + possible_r, Pawn.c4, Pawn.r4,
                    isBlack, Board, mateCheck))){

                return true;
            } else if(Pawn.possible_Pawn(king_c + possible_c, king_r + possible_r, Pawn.C5, Pawn.R5,
                    !isBlack, Board, mateCheck)
                    && (Pawn.possible_Pawn(king_c + possible_c, king_r + possible_r, Pawn.c5, Pawn.r5,
                    isBlack, Board, mateCheck))){

                return true;
            } else if(Pawn.possible_Pawn(king_c + possible_c, king_r + possible_r, Pawn.C6, Pawn.R6,
                    !isBlack, Board, mateCheck)
                    && (Pawn.possible_Pawn(king_c + possible_c, king_r + possible_r, Pawn.c6, Pawn.r6,
                    isBlack, Board, mateCheck))){

                return true;
            } else if(Queen.possible_Queen(king_c + possible_c, king_r + possible_r, Kamikaze.C1, Kamikaze.R1,
                    !isBlack, Board, mateCheck)
                    && (Queen.possible_Queen(king_c + possible_c, king_r + possible_r, Kamikaze.c1, Kamikaze.r1,
                    isBlack, Board, mateCheck))){

                return true;
            } else if(GreaterKnight.possible_GKnight(king_c + possible_c, king_r + possible_r,
                    GreaterKnight.C1, GreaterKnight.R1, !isBlack, Board, mateCheck)
                    && (GreaterKnight.possible_GKnight(king_c + possible_c, king_r + possible_r,
                    GreaterKnight.c1, GreaterKnight.r1, isBlack, Board, mateCheck))){
                return true;
            }


            step++;
        }

    return false;
    }
}
