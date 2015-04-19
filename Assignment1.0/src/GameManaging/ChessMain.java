package GameManaging;
/**
 * Created by My precious on 2015-02-06.
 */
import GameManaging.newChess;
import java.util.*;

public class ChessMain {

    /*
    main function
     */

    public static void main(String[] args) {

        newChess the_Chess = new newChess();
        the_Chess.initBoard();

        // graphics - TODO later
        /*
        JFrame f = new JFrame("Chess");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GameManaging.UserInterface ui = new GameManaging.UserInterface();
        f.add(ui);
        f.setSize(500, 500);
        f.setVisible(true);
        */


        // draw the board
        for (int i=0;i<8;i++) {
            System.out.println(Arrays.toString(newChess.Board[i]));
        }

        //Begin the game
        while( newChess.currentState == newChess.inGame ) {
            //Make the move!
            newChess.playerMove(newChess.currentPlayer);

            // Show the change of the board after move
            for (int i=0;i<8;i++) {
                System.out.println(Arrays.toString(newChess.Board[i]));
            }
            // End of the turn.
            newChess.switchPlayer();
        }
    }
}




