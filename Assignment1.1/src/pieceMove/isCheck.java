package pieceMove;

import General.newChess;

/**
 * Created by My precious on 2015-02-08.
 */
public class isCheck {

    /*
     import values from newChess
     this is to keep such variable name short and make the whole code neat
    */
    static int r = newChess.r;
    static int c = newChess.c;
    static int size_board = newChess.size_board;

    /*
    isCheck(String[][] Board, boolean isBlack)
    DESCRIPTION : determines if the player's king is safe right now
    INPUT : String[][] Board : the Board to Testcases the fate of king
            boolean isBlack : determines which player is on the play
    OUTPUT : True if the king is currently safe
             False otherwise
    SIDE EFFECT : NONE
     */
    public static boolean isCheck(String[][] Board, boolean isBlack, boolean mateCheck) {

        int kingPos, temp = 0;

        boolean kingProtected = true;

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

                try {
                    int possible_r = step * i;
                    int possible_c = step * j;

                    // going in diagonal path


                    while (" ".equals(Board[kingPos / r + possible_r][kingPos % c + possible_c])) {
                        step++;
                        possible_r = step * i;
                        possible_c = step * j;
                    }

                    // enemy bishop or queen in the line, DANGER!
                    if (!isBlack && ("b".equals(Board[kingPos / r + possible_r][kingPos % c + possible_c]) ||
                            "q".equals(Board[kingPos / r + possible_r][kingPos % c + possible_c]))) {

                        // returns true if checkmate, false otherwise
                        // get the information of opponent
                        if(mateCheck){
                            kingProtected = CheckMateHelper.checkProtection(kingPos / r, kingPos % c, i, j, step, isBlack, Board);
                            if(!kingProtected)
                                return true;
                        }
                        else{ // not checkmate, but check
                            return true;
                        }
                   } else if (isBlack && ("B".equals(Board[kingPos / r + possible_r][kingPos % c + possible_c]) ||
                            "Q".equals(Board[kingPos / r + possible_r][kingPos % c + possible_c]))) {

                        if(mateCheck){
                            kingProtected = CheckMateHelper.checkProtection(kingPos / r, kingPos % c, i, j, step, !isBlack, Board);
                            if(!kingProtected)
                                return true;
                        }
                        else{ // not checkmate, but check
                            return true;
                        }
                    }


                } catch(Exception e){
                }
                step = 1;
            }
        }


        step = 1;
        // check horizontal & vertical (rook & queen)
        for (int i = -1; i <= 1; i += 2) {

            // horizontal case (column check)
            try {
                int possible_c = step * i;
                while(" ".equals(Board[kingPos / r][kingPos % c + possible_c])) {
                    step++;
                    possible_c = step * i;

                }
                   // enemy rook or queen in the line, DANGER!
                    if (!isBlack && ("r".equals(Board[kingPos / r][kingPos % c + possible_c]) ||
                            "q".equals(Board[kingPos / r][kingPos % c + possible_c]))) {

                        if(mateCheck){
                            kingProtected = CheckMateHelper.checkProtection(kingPos / r, kingPos % c, 0, i, step, isBlack, Board);
                            if(!kingProtected)
                                return true;
                        }
                        else{ // not checkmate, but check
                            return true;
                        }
                    }

                    else if (isBlack && ("R".equals(Board[kingPos / r][kingPos % c + possible_c]) ||
                            "Q".equals(Board[kingPos / r][kingPos % c + possible_c]))) {

                        if(mateCheck){
                            kingProtected = CheckMateHelper.checkProtection(kingPos / r, kingPos % c, 0, i, step, isBlack, Board);
                            if(!kingProtected)
                                return true;
                        }
                        else{ // not checkmate, but check
                            return true;
                        }
                    }

            } catch (Exception e) {}

            step = 1;
            try { // vertical (row) check
                int possible_r = step * i;

                while(" ".equals(Board[kingPos / r + possible_r][kingPos % c])) {
                    step++;
                    possible_r = step * i;

                }



                if (!isBlack && ("r".equals(Board[kingPos / r + possible_r][kingPos % c]) ||
                        "q".equals(Board[kingPos / r + possible_r][kingPos % c]))) {

                    if(mateCheck){
                        kingProtected = CheckMateHelper.checkProtection(kingPos / r, kingPos % c, i, 0, step, isBlack, Board);
                        if(!kingProtected)
                            return true;
                    }
                    else{ // not checkmate, but check
                        return true;
                    }
                }
                // enemy rook or queen in the line, DANGER!
                else if (isBlack && ("R".equals(Board[kingPos / r + possible_r][kingPos % c]) ||
                        "Q".equals(Board[kingPos / r + possible_r][kingPos % c]))) {
                    if(mateCheck){
                        kingProtected = CheckMateHelper.checkProtection(kingPos / r, kingPos % c, i, 0, step, isBlack, Board);
                        if(!kingProtected)
                            return true;
                    }

                    else{ // not checkmate, but check
                        return true;
                    }
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

                            kingProtected = false;
                            return true;

                    }
                    else if (isBlack && ("K".equals(Board[kingPos / r + i][kingPos % c + j * 2]) ||
                            "K".equals(Board[kingPos / r + i * 2][kingPos % c + j]))) {

                            kingProtected = false;
                            return true;

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

                        kingProtected = false;
                        return true;

                }
            }
            else if (isBlack && kingPos <= noWhitePawn) {
                if ("P".equals(Board[kingPos / r + 1][kingPos % c - 1]) ||
                        "P".equals(Board[kingPos / r + 1][kingPos % c + 1])) {
// not checkmate, but check
                    kingProtected = false;
                    return true;

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
                            return true;
                        }
                        else if (isBlack && "A".equals(Board[kingPos / r + i][kingPos % c + j])) {
                            return true;
                        }

                    } catch (Exception e) {
                    }
                }
            }
        }

        if(!kingProtected && mateCheck){
            return true;
        }

        return false;
    }

}
