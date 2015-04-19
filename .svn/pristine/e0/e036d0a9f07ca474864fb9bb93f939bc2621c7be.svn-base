package General;
/**
 * Created by My precious on 2015-02-06.
 */

import javax.swing.*;
import java.util.Arrays;

public class ChessMain {

    /*
    main function
     */

    public static void main(String[] args) {

        newChess the_Chess = new newChess();
        the_Chess.initBoard();

        // draw the board
        for (int i=0;i<8;i++) {
            System.out.println(Arrays.toString(newChess.Board[i]));
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI();
            }
        });

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




