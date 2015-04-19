package Test; /**
 * Created by My precious on 2015-02-09.
 */

import GameManaging.MoveCheck;
import GameManaging.MoveExecute;
import GameManaging.newChess;
import org.junit.Before;
import org.junit.Test;
import pieceMove.CheckCheck;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/*
    Apply test cases.
 */

public class TestCase {

    @Before
    public void setUp() {
        newChess the_Chess = new newChess();
        the_Chess.initBoard();
    }

    /*
     Testing for pawns.
     AssertTrue means it will be right.
     AssertFalse means it will be wrong.
     */

    @Test
    public void PawnMoveCheck1_1() throws Exception {
        assertTrue(MoveCheck.validMove(5, 5, 5, 6));
    }

    @Test
    public void PawnMoveCheck1_2() throws Exception {
        assertTrue(MoveCheck.validMove(1, 5, 1, 6));
    }

    // when the end is not reached
    @Test
    public void PawnMoveCheck1_3() throws Exception {
        assertFalse(MoveCheck.validMove(5, 3, 2, 6));
    }

    // out of bound case
    @Test
    public void PawnMoveCheck1_4() throws Exception {
        assertFalse(MoveCheck.validMove(2, 8, 7, 6));
    }

    // when there is no move
    @Test
    public void PawnMoveCheck1_5() throws Exception {
        assertFalse(MoveCheck.validMove(1, 6, 1, 6));
    }

    // When moving two
    @Test
    public void invalidPawnMove2_1() throws Exception {
        assertTrue(MoveCheck.validMove(6, 4, 6, 6));
    }

    // capturing
    @Test
    public void validPawnMove2() throws Exception {

        for(int i = 0; i < newChess.size_board; i++){
            newChess.Board[i / newChess.r][i % newChess.c] =
                    SampleBoard.Board_for_Pawn[i / newChess.r][i % newChess.c];
        }
        assertTrue(MoveCheck.validMove(2, 3, 3, 4));
    }

    // going two is not allowed after first time
    @Test
    public void invalidPawnMove3() throws Exception {

        for(int i = 0; i < newChess.size_board; i++){
            newChess.Board[i / newChess.r][i % newChess.c] =
                    SampleBoard.Board_for_Pawn[i / newChess.r][i % newChess.c];
        }
        assertFalse(MoveCheck.validMove(1, 4, 3, 4));
    }

    /*
     Knight movements
     */
    @Test
    public void validKnightMove1() throws Exception {
        assertTrue(MoveCheck.validMove(2, 5, 1, 7));
    }

    // capturing enemy piece
    @Test
    public void validKnightMove2() throws Exception {
        MoveCheck.validMove(7, 3, 3, 7);
        assertTrue(MoveCheck.validMove(2, 2, 1, 0));
    }

    @Test
    public void invalidKnightMove1() throws Exception {
        assertFalse(MoveCheck.validMove(4, 5, 6, 7));
    }

    @Test
    public void invalidKnightMove2() throws Exception {
        assertFalse(MoveCheck.validMove(8, 5, 6, 7));
    }
    /*
    Rook movements
     */
    @Test
    public void invalidRookMove1() throws Exception {

        for(int i = 0; i < newChess.size_board; i++){
            newChess.Board[i / newChess.r][i % newChess.c] =
                    SampleBoard.Board_for_Rook[i / newChess.r][i % newChess.c];
        }
        assertFalse(MoveCheck.validMove(0, 3, 7, 3));
    }

    @Test
    public void validRookMove1() throws Exception {

        for(int i = 0; i < newChess.size_board; i++){
            newChess.Board[i / newChess.r][i % newChess.c] =
                    SampleBoard.Board_for_Rook[i / newChess.r][i % newChess.c];
        }
        assertTrue(MoveCheck.validMove(7, 1, 7, 3));
    }

    // when something is on the way
    @Test
    public void invalidRookMove2() throws Exception {

        for(int i = 0; i < newChess.size_board; i++){
            newChess.Board[i / newChess.r][i % newChess.c] =
                    SampleBoard.Board_for_Rook[i / newChess.r][i % newChess.c];
        }
        assertFalse(MoveCheck.validMove(7, 0, 7, 3));
    }


    /*
    Bishop movements
     */
   @Test
    public void invalidBishopMove1() throws Exception {} {
        try {
        assertFalse(MoveCheck.validMove(7, 2, 2, 7));
        } catch (Exception e) {}
    }

    @Test
    public void invalidBishopMove2() throws Exception {} {
        for(int i = 0; i < newChess.size_board; i++){
            newChess.Board[i / newChess.r][i % newChess.c] =
                    SampleBoard.Board_for_Bishop[i / newChess.r][i % newChess.c];
        }
        try {
            assertFalse(MoveCheck.validMove(0, 0, 2, 2));
        } catch (Exception e) {}
    }

    @Test
    public void invalidBishopMove3() throws Exception {} {
        for(int i = 0; i < newChess.size_board; i++){
            newChess.Board[i / newChess.r][i % newChess.c] =
                    SampleBoard.Board_for_Bishop[i / newChess.r][i % newChess.c];
        }
        try {
            assertFalse(MoveCheck.validMove(0, 8, 2, 2));
        } catch (Exception e) {}
    }

    @Test
    public void validBishopMove1() throws Exception {} {
        for(int i = 0; i < newChess.size_board; i++){
            newChess.Board[i / newChess.r][i % newChess.c] =
                    SampleBoard.Board_for_Bishop[i / newChess.r][i % newChess.c];
        }
        try {
            assertTrue(MoveCheck.validMove(1, 1, 2, 2));
        } catch (Exception e) {}
    }
    /*
    Queen movements
     */
    @Test
    public void invalidQueenMove1() throws Exception {} {
        try {
            assertFalse(MoveCheck.validMove(7, 3, 3, 7));
        } catch (Exception e) {}
    }

    @Test
    public void validQueenMove1() throws Exception {} {
        for(int i = 0; i < newChess.size_board; i++){
            newChess.Board[i / newChess.r][i % newChess.c] =
                    SampleBoard.Board_for_Queen[i / newChess.r][i % newChess.c];
        }
        try {
            assertTrue(MoveCheck.validMove(1, 1, 5, 5));
        } catch (Exception e) {}
    }


    /*
    King movements
     */

    @Test
    public void validKingMove1() throws Exception {

        for(int i = 0; i < newChess.size_board; i++){
            newChess.Board[i / newChess.r][i % newChess.c] =
                    SampleBoard.Board_for_King[i / newChess.r][i % newChess.c];
        }
        assertTrue(MoveCheck.validMove(3, 4, 4, 4));
    }

    @Test
    public void validKingMove2() throws Exception {

        for(int i = 0; i < newChess.size_board; i++){
            newChess.Board[i / newChess.r][i % newChess.c] =
                    SampleBoard.Board_for_King[i / newChess.r][i % newChess.c];
        }
        assertTrue(MoveCheck.validMove(5, 4, 4, 4));
    }

    @Test
         public void invalidKingMove2() throws Exception {

        for(int i = 0; i < newChess.size_board; i++){
            newChess.Board[i / newChess.r][i % newChess.c] =
                    SampleBoard.Board_for_King[i / newChess.r][i % newChess.c];
        }
        assertFalse(MoveCheck.validMove(5, 6, 4, 4));
    }

    @Test
    public void check() throws Exception {

        for(int i = 0; i < newChess.size_board; i++){
            newChess.Board[i / newChess.r][i % newChess.c] =
                    SampleBoard.Board_for_Check[i / newChess.r][i % newChess.c];
        }
        assertFalse(CheckCheck.isNotCheck(SampleBoard.Board_for_Check, false));
    }

    @Test
    public void check2() throws Exception {

        for(int i = 0; i < newChess.size_board; i++){
            newChess.Board[i / newChess.r][i % newChess.c] =
                    SampleBoard.Board_for_Check[i / newChess.r][i % newChess.c];
        }
        assertTrue(CheckCheck.isNotCheck(SampleBoard.Board_for_Check, true));
    }



    @Test
    public void noStaleMate() throws Exception {

        boolean isBlack = true;
        for(int i = 0; i < newChess.size_board; i++){
            newChess.Board[i / newChess.r][i % newChess.c] =
                    SampleBoard.Board_for_Stalemate[i / newChess.r][i % newChess.c];
        }
        MoveExecute.moveNow(0, 1, 0, 2);
        assertFalse(MoveCheck.isStaleMate());
    }



    // Test checkmate
    @Test
    public void checkMate() throws Exception {} {

        boolean isBlack = true;
        for(int i = 0; i < newChess.size_board; i++){
        newChess.Board[i / newChess.r][i % newChess.c] =
                SampleBoard.Board_for_Checkmate[i / newChess.r][i % newChess.c];
        }
        MoveExecute.moveNow(1, 1, 1, 2);
        assertTrue(MoveCheck.isCheckMate());

    }


}
