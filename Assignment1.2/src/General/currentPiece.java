package General;

import pieceMove.*;

/**
 * Created by My precious on 2015-02-15.
 */
public class currentPiece {

    public static void setCurrentPiece(int piece_new_c, int piece_new_r, int piece_c, int piece_r) {

        int black = 0;
        int white = 1;
        int piece_num = 0;

        int[] arr = new int[4];
        if (piece_r == Pawn.r1 && piece_c == Pawn.c1) {
            Pawn.r1 = piece_new_r;
            Pawn.c1 = piece_new_c;


        } else if (piece_r == Pawn.r2 && piece_c == Pawn.c2) {
            Pawn.r2 = piece_new_r;
            Pawn.c2 = piece_new_c;

        } else if (piece_r == Pawn.r3 && piece_c == Pawn.c3) {
            Pawn.r3 = piece_new_r;
            Pawn.c3 = piece_new_c;


        } else if (piece_r == Pawn.r4 && piece_c == Pawn.c4) {
            Pawn.r4 = piece_new_r;
            Pawn.c4 = piece_new_c;

        } else if (piece_r == Pawn.r5 && piece_c == Pawn.c5) {
            Pawn.r5 = piece_new_r;
            Pawn.c5 = piece_new_c;

        } else if (piece_r == Pawn.r6 && piece_c == Pawn.c6) {
            Pawn.r6 = piece_new_r;
            Pawn.c6 = piece_new_c;

        } else if (piece_r == Pawn.R1 && piece_c == Pawn.C1) {
            Pawn.R1 = piece_new_r;
            Pawn.C1 = piece_new_c;


        } else if (piece_r == Pawn.R2 && piece_c == Pawn.C2) {
            Pawn.R2 = piece_new_r;
            Pawn.C2 = piece_new_c;

        } else if (piece_r == Pawn.R3 && piece_c == Pawn.C3) {
            Pawn.R3 = piece_new_r;
            Pawn.C3 = piece_new_c;

        } else if (piece_r == Pawn.R4 && piece_c == Pawn.C4) {
            Pawn.R4 = piece_new_r;
            Pawn.C4 = piece_new_c;

        } else if (piece_r == Pawn.R5 && piece_c == Pawn.C5) {
            Pawn.R5 = piece_new_r;
            Pawn.C5 = piece_new_c;

        } else if (piece_r == Pawn.R6 && piece_c == Pawn.C6) {
            Pawn.R6 = piece_new_r;
            Pawn.C6 = piece_new_c;

        }

        // knight
        else if (piece_r == Knight.r1 && piece_c == Knight.c1) {
            Knight.r1 = piece_new_r;
            Knight.c1 = piece_new_c;

        } else if (piece_r == Knight.R1 && piece_c == Pawn.C1) {
            Knight.R1 = piece_new_r;
            Knight.C1 = piece_new_c;

        }

        else if (piece_r == Bishop.r1 && piece_c == Bishop.c1) {
            Bishop.r1 = piece_new_r;
            Bishop.c1 = piece_new_c;

        } else if (piece_r == Bishop.R1 && piece_c == Bishop.C1) {
            Bishop.R1 = piece_new_r;
            Bishop.C1 = piece_new_c;

        }

        else if (piece_r == Rook.r1 && piece_c == Rook.c1) {
            Rook.r1 = piece_new_r;
            Rook.c1 = piece_new_c;

        } else if (piece_r == Rook.R1 && piece_c == Rook.C1) {
            Rook.R1 = piece_new_r;
            Rook.C1 = piece_new_c;

        }

        else if (piece_r == Queen.r1 && piece_c == Queen.c1) {
            Queen.r1 = piece_new_r;
            Queen.c1 = piece_new_c;

        } else if (piece_r == Queen.R1 && piece_c == Queen.C1) {
            Queen.R1 = piece_new_r;
            Queen.C1 = piece_new_c;

        }

        else if (piece_r == King.r1 && piece_c == King.c1) {
            King.r1 = piece_new_r;
            King.c1 = piece_new_c;

        } else if (piece_r == King.R1 && piece_c == King.C1) {
            King.R1 = piece_new_r;
            King.C1 = piece_new_c;

        }




    }
}
