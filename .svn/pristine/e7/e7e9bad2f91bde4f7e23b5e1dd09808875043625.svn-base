package General;

import pieceMove.isCheck;

import java.util.Scanner;

/**
 * Created by My precious on 2015-02-08.
 */

public class newChess {
    /* the 8 x 8 size chessboard
    Capital letters represent white pieces
    Non-capital letters represent black pieces
    P stands for Pawn
    K stands for Knight
    B stands for Bishop
    R stands for Rook
    Q stands for Queen
    A stands for King
    */
    static String chessBoard[][] = {

            {"r", "k", "b", "q", "a", "z", "g", "r"},
            {"p", "p", "p", "p", "p", "p", "p", "p"},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {"P", "P", "P", "P", "P", "P", "P", "P"},
            {"R", "K", "B", "Q", "A", "Z", "G", "R"}};

    /* a new chessboard which will keep track of every move */
    public static String[][] Board = new String[8][8];

    /* basic constants */
    public static int White = 1;
    public static int Black = 2;
    public static final int inGame = 0;
    public static final int whiteWin = 1;
    public static final int blackWin = 2;
    public static final int draw = 3;
    public static int currentState;
    public static int currentPlayer;

    public static final int r = 8;
    public static final int c = 8;
    public static final int size_board = 64;

    /* for receiving user input values */
    public static Scanner input = new Scanner(System.in);

    /*
    initBoard()
    DESCRIPTION : initialize the board before every game.
    INPUT : None
    OUTPUT : None
    SIDE EFFECT : copy the Board[][] from pre-defined chessBoard[][]
     */
    public void initBoard() {
        for (int i = 0; i < size_board; i++) {
            Board[i/r][i%c] = chessBoard[i/r][i%c];
        }
        currentState = inGame;
        currentPlayer = White;
    }

    /*
    switchPlayer()
    DESCRIPTION : changes the player after each turn
    INPUT : None
    OUTPUT : None
    SIDE EFFECT : the value of currentPlayer will be changed
     */
    public static void switchPlayer(){
        if( currentPlayer == White)
            currentPlayer = Black;
        else
            currentPlayer = White;
    }


    /*
    playerMove(int playerColor)
    DESCRIPTION : make the move of each piece
    INPUT : playerColor = decides which player is making move
    OUTPUT : None
    SIDE EFFECT : String inside Board[][] will be changed, representing the move of corresponding piece
     */

    public static void playerMove(int playerColor) {

        boolean valid = false;
        //isCheck if player choose right color
         while (!valid)
         {

            boolean isBlack = false;
            if(playerColor == Black){
                isBlack = true;
            }
            if (playerColor == White) {
                //isCheck if king is safe first
                if (isCheck.isCheck(newChess.Board, isBlack, false)) {
                    System.out
                            .println("that's a check, white");
                }
                //Then player choose piece
                System.out
                        .println("Your turn, white! ");
            } else {
                if (isCheck.isCheck(newChess.Board, isBlack, false)) {
                    System.out
                            .println("that's a check, black");
                }
                System.out
                        .println("Your turn, black!");
            }


            //read the user input
             System.out.println("Enter the row and column of the piece to move: ex) 3-enter-3 for " +
                     "position at [3,3]");
            int piece_r = input.nextInt();
            int piece_c = input.nextInt();


            //isCheck if player chooses the right position
             try {
                 if ((currentPlayer == White && !newChess.Board[piece_r][piece_c].equals(" ") &&
                         newChess.Board[piece_r][piece_c] == newChess.Board[piece_r][piece_c].toUpperCase()) ||
                         (currentPlayer == Black && !newChess.Board[piece_r][piece_c].equals(" ") &&
                                 newChess.Board[piece_r][piece_c] == newChess.Board[piece_r][piece_c].toLowerCase())) {

                     System.out.println("Enter the row and column of new position to move: ex) 3-enter-3 for " +
                             "position at [3,3]");
                     int piece_new_r = input.nextInt();
                     int piece_new_c = input.nextInt();


                     if (!MoveCheck.validMove(piece_new_c, piece_new_r, piece_c, piece_r)) {
                         System.out.println("Cannot move to " + piece_new_r + "," + piece_new_c + ".");
                         valid = false;
                     }
                     else {

                         valid = true;
                         MoveExecute.moveNow(piece_new_c, piece_new_r, piece_c, piece_r);
                         System.out.println("Successfully moved to " + piece_new_r + "," + piece_new_c  + ".");


                         if(MoveCheck.isGame()){
                             break;
                         }

                     }
                 }
                 else { // when there is no piece or the selected piece is not able to move
                     System.out.println("You have picked an invalid piece.");
                 }
             } catch (Exception e) { // when the user wrongly put the number of original piece to move
                 System.out.println("You have picked the wrong position to start!");}
        }
    }


}

