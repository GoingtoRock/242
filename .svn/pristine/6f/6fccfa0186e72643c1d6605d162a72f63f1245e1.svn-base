package General;

/**
 * Created by My precious on 2015-02-08.
 */
public class MoveExecute {

    /*
    validMove(int piece_new_c, int piece_new_r, int piece_c, int piece_r)
    DESCRIPTION : make the move of the player
    INPUT : int piece_new_c, int piece_new_r : new column and row position of selected piece by player
            int piece_c, int piece_r : original column and row position of selected piece by player
    OUTPUT : NONE
    SIDE EFFECT : calls executePiece function to handle the rest
     */
    public static void moveNow(int piece_new_c, int piece_new_r, int piece_c, int piece_r) {

        // string to save opponents color as string
        String other;
        // check if the player can win by making the move
        int mayWin;
        int mayNotWin = 0;


        // get the current piece information for update

        boolean isBlack = (newChess.currentPlayer == newChess.Black);


        // figure out which player is playing right now, and check if enemy piece is at the desired destination
        if (!isBlack){
            if(Character.isLowerCase(newChess.Board[piece_new_r][piece_new_c].charAt(0))) {

                mayWin = newChess.whiteWin;
                executePiece(piece_new_c, piece_new_r, piece_c, piece_r, mayWin, isBlack);
            }
            else {
                executePiece(piece_new_c, piece_new_r, piece_c, piece_r, mayNotWin, isBlack);
            }
        }
        else { // isBlack
            if(Character.isUpperCase(newChess.Board[piece_new_r][piece_new_c].charAt(0))) {

                other = "white";
                mayWin = newChess.blackWin;
                executePiece(piece_new_c, piece_new_r, piece_c, piece_r, mayWin, isBlack);
            }
            else {
                executePiece(piece_new_c, piece_new_r, piece_c, piece_r, mayNotWin, isBlack);
            }
        }
        return;
        }

    /*
    executePiece(int piece_new_c, int piece_new_r, int piece_c, int piece_r, String other, int mayWin)
    DESCRIPTION : helper function for moveNow by executing the move
    INPUT : int piece_new_c, int piece_new_r : new column and row position of selected piece by player
            int piece_c, int piece_r : original column and row position of selected piece by player
            String other : contains the opponent color name
            int mayWin : will be used when the player is won after this move
    OUTPUT : None
    SIDE EFFECT : Strings inside Board[][] will be changed
     */
    private static void executePiece(int piece_new_c, int piece_new_r, int piece_c, int piece_r, int mayWin,
                                     boolean isBlack){


        String old_pos = newChess.Board[piece_r][piece_c];
        String new_pos = newChess.Board[piece_new_r][piece_new_c];
        String notice;
        String other;
        if(isBlack){
            other = "White";
        }
        else {
            other = "Black";
        }

        //
        // if there is an enemy at destination, figure out which one and tell that it has been slain.
        if (new_pos.equals(Pieces.wPawn)|| new_pos.equals(Pieces.bPawn)) {
            notice = other + " Player's pawn has fallen!";
            System.out.println(notice);
        } else if (new_pos.equals(Pieces.wKnight)|| new_pos.equals(Pieces.bKnight)) {
            notice = other + " Player's knight has fallen!";
            System.out.println(notice);
        } else if (new_pos.equals(Pieces.wRook)|| new_pos.equals(Pieces.bRook)) {
            notice = other + " Player's rook has fallen!";
            System.out.println(notice);
        } else if (new_pos.equals(Pieces.wBishop)|| new_pos.equals(Pieces.bBishop)) {
            notice = other + " Player's bishop has fallen!";
            System.out.println(notice);
        } else if (new_pos.equals(Pieces.wQueen)|| new_pos.equals(Pieces.bQueen)) {
            notice = other + " Player's queen has fallen!";
            System.out.println(notice);
        } else if (new_pos.equals(Pieces.wKamikaze)|| new_pos.equals(Pieces.bKamikaze)) {
            notice = other + " Player's kamikaze has fallen!";
            System.out.println(notice);
        } else if (new_pos.equals(Pieces.wGreaterKnight)|| new_pos.equals(Pieces.bGreaterKnight)) {
            notice = other + " Player's greaterknight has fallen!";
            System.out.println(notice);
        } else if (new_pos.equals(Pieces.wKing)|| new_pos.equals(Pieces.bKing)) {
            notice = other + " Player's king has fallen!";
            System.out.println(notice);
            newChess.currentState = mayWin;
        }

        // remove the enemy piece if you take it
        if(!new_pos.equals(" ")) {
            currentPiece.setCurrentPiece(0, 0, piece_new_c, piece_new_r);
        }

        // special condition for kamikaze
        if(!new_pos.equals(" ") && (old_pos.equals(Pieces.wKamikaze) || old_pos.equals(Pieces.bKamikaze))){
            System.out.println("Kaboooooom!!!!");
            currentPiece.setCurrentPiece(0, 0, piece_c, piece_r);
            newChess.Board[piece_new_r][piece_new_c] = " ";
            newChess.Board[piece_r][piece_c] = " ";

        }

        else {
            // update current piece
            currentPiece.setCurrentPiece(piece_new_c, piece_new_r, piece_c, piece_r);

            newChess.Board[piece_new_r][piece_new_c] = old_pos;
            newChess.Board[piece_r][piece_c] = " ";
        }




    }

}
