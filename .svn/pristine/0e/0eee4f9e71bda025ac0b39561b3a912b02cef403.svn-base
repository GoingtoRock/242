package pieceMove;

import GameManaging.newChess;

import java.util.Arrays;

/**
 * Created by My precious on 2015-02-08.
 */
public class CheckCheck {

    /*
     import values from newChess
     this is to keep such variable name short and make the whole code neat
    */
    static int r = newChess.r;
    static int c = newChess.c;
    static int size_board = newChess.size_board;

    /*
    isNotCheck(String[][] Board, boolean isBlack)
    DESCRIPTION : determines if the player's king is safe right now
    INPUT : String[][] Board : the Board to test the fate of king
            boolean isBlack : determines which player is on the play
    OUTPUT : True if the king is currently  not safe
             False otherwise
    SIDE EFFECT : NONE
     */
    public static boolean isNotCheck(String[][] Board, boolean isBlack) {

        int kingPos, temp = 0;


        // get the current position of king
        for (int i = 0; i < size_board; i++) {
            
            if ((Board[i / r][i % c].equals("A") && !isBlack) ||
                    (Board[i / r][i % c].equals("a") && isBlack)) {
                temp = i;
                break;
            }
        }
        // this is to avoid "uninitialized value" error
        kingPos = temp;


        int step = 1;
        // check diagonals (bishop & queen)
        for (int i = -1; i <= 1; i += 2) {
            for (int j = -1; j <= 1; j += 2) {

                int possible_r = step * i;
                int possible_c = step * j;

                // going in diagonal path

                try {
                    while(" ".equals(Board[kingPos / r + possible_r][kingPos % c + possible_c])) {
                        step++;
                        possible_r = step * i;
                        possible_c = step * j;
                    }

                        // enemy bishop or queen in the line, DANGER!
                        if (!isBlack && ("b".equals(Board[kingPos / r + possible_r][kingPos % c + possible_c]) ||
                                "q".equals(Board[kingPos / r + possible_r][kingPos % c + possible_c]))) {
                            return false;
                        }

                        else if (isBlack && ("B".equals(Board[kingPos / r + possible_r][kingPos % c + possible_c]) ||
                                "Q".equals(Board[kingPos / r + possible_r][kingPos % c + possible_c]))) {
                            return false;
                        }

                } catch (Exception e) {
                }
                step = 1;
            }
        }


        step = 1;
        // check horizontal & vertical (rook & queen)
        for (int i = -1; i <= 1; i += 2) {

            int possible_c = step * i;

            // horizontal case (column check)
            try {
                while(" ".equals(Board[kingPos / r][kingPos % c + possible_c])) {
                    step++;
                    possible_c = step * i;

                }
                   // enemy rook or queen in the line, DANGER!
                    if (!isBlack && ("r".equals(Board[kingPos / r][kingPos % c + possible_c]) ||
                            "q".equals(Board[kingPos / r][kingPos % c + possible_c]))) {
                        return false;
                    }

                    else if (isBlack && ("R".equals(Board[kingPos / r][kingPos % c + possible_c]) ||
                            "Q".equals(Board[kingPos / r][kingPos % c + possible_c]))) {

                        return false;
                    }

            } catch (Exception e) {}

            step = 1;
            int possible_r = step * i;
            try {
                while(" ".equals(Board[kingPos / r + possible_r][kingPos % c])) {
                    step++;
                    possible_r = step * i;

                }



                if (!isBlack && ("r".equals(Board[kingPos / r + possible_r][kingPos % c]) ||
                        "q".equals(Board[kingPos / r + possible_r][kingPos % c]))) {
                    return false;
                }
                // enemy rook or queen in the line, DANGER!
                else if (isBlack && ("R".equals(Board[kingPos / r + possible_r][kingPos % c]) ||
                        "Q".equals(Board[kingPos / r + possible_r][kingPos % c]))) {
                    return false;
                }
            }catch (Exception e) {
            }
            step = 1;
        }


        // knight
        for (int i = -1; i <= 1; i += 2) {
            for (int j = -1; j <= 1; j += 2) {

                // check various combinations of knights which can possibly approach to king
                try {
                    if (!isBlack && ("k".equals(Board[kingPos / r + i][kingPos % c + j * 2]) ||
                            "k".equals(Board[kingPos / r + i * 2][kingPos % c + j]))) {
                        return false;
                    }
                    else if (isBlack && ("K".equals(Board[kingPos / r + i][kingPos % c + j * 2]) ||
                            "K".equals(Board[kingPos / r + i * 2][kingPos % c + j]))) {
                        return false;
                    }
                } catch (Exception e) {
                }

            }
        }

        // pawn
        // in white side, if the king is in first two row, it is impossible for black pawn to reach.
        // so excluding such case.
        int noBlackPawn = 16;
        int noWhitePawn = 46;

        try {
            if (!isBlack && kingPos >= noBlackPawn) {
                if ("p".equals(Board[kingPos / r - 1][kingPos % c - 1]) ||
                        "p".equals(Board[kingPos / r - 1][kingPos % c + 1])) {
                    return false;
                }
            }
            else if (isBlack && kingPos <= noWhitePawn) {
                if ("P".equals(Board[kingPos / r + 1][kingPos % c - 1]) ||
                        "P".equals(Board[kingPos / r + 1][kingPos % c + 1])) {
                    return false;
                }
            }

        }catch (Exception e) { }


        // king
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                // avoid checking its own position
                if (i != 0 || j != 0) {
                    try {
                        if (!isBlack && "a".equals(Board[kingPos / r + i][kingPos % c + j])) {
                            return false;
                        }
                        else if (isBlack && "A".equals(Board[kingPos / r + i][kingPos % c + j])) {
                            return false;
                        }

                    } catch (Exception e) {
                    }
                }
            }
        }

        return true;
    }

}
