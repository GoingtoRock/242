package Testcases; /**
 * Created by My precious on 2015-02-09.
 */

import General.MoveCheck;
import General.MoveExecute;
import General.newChess;
import org.junit.Before;
import org.junit.Test;
import pieceMove.isCheck;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/*
    Apply Testcases cases.
 */

public class TestCase {


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
                    Board_for_Pawn[i / newChess.r][i % newChess.c];
        }
        assertTrue(MoveCheck.validMove(2, 3, 3, 4));
    }

    // going two is not allowed after first time
    @Test
    public void invalidPawnMove3() throws Exception {

        for(int i = 0; i < newChess.size_board; i++){
            newChess.Board[i / newChess.r][i % newChess.c] =
                    Board_for_Pawn[i / newChess.r][i % newChess.c];
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
        assertFalse(MoveCheck.validMove(4, 5, 1, 7));
    }

    @Test
    public void invalidKnightMove2() throws Exception {
        assertFalse(MoveCheck.validMove(8, 5, 1, 7));
    }
    /*
    Rook movements
     */
    @Test
    public void validRookMove1() throws Exception {

        for(int i = 0; i < newChess.size_board; i++){
            newChess.Board[i / newChess.r][i % newChess.c] =
                    Board_for_Rook[i / newChess.r][i % newChess.c];
        }
        assertTrue(MoveCheck.validMove(0, 3, 7, 3));
    }



    // when something is on the way
    @Test
    public void invalidRookMove1() throws Exception {

        for(int i = 0; i < newChess.size_board; i++){
            newChess.Board[i / newChess.r][i % newChess.c] =
                    Board_for_Rook[i / newChess.r][i % newChess.c];
        }
        assertFalse(MoveCheck.validMove(7, 0, 7, 3));
    }

    @Test
    public void validRookMove3() throws Exception {

        for(int i = 0; i < newChess.size_board; i++){
            newChess.Board[i / newChess.r][i % newChess.c] =
                    Board_for_Rook[i / newChess.r][i % newChess.c];
        }
        assertTrue(MoveCheck.validMove(7, 1, 7, 3));
    }

    // when something is on the way
    @Test
    public void invalidRookMove2() throws Exception {

        for(int i = 0; i < newChess.size_board; i++){
            newChess.Board[i / newChess.r][i % newChess.c] =
                    Board_for_Rook[i / newChess.r][i % newChess.c];
        }
        assertFalse(MoveCheck.validMove(7, 6, 7, 3));
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
                    Board_for_Bishop[i / newChess.r][i % newChess.c];
        }
        try {
            assertFalse(MoveCheck.validMove(0, 0, 2, 2));
        } catch (Exception e) {}
    }

    @Test
    public void invalidBishopMove3() throws Exception {} {
        for(int i = 0; i < newChess.size_board; i++){
            newChess.Board[i / newChess.r][i % newChess.c] =
                    Board_for_Bishop[i / newChess.r][i % newChess.c];
        }
        try {
            assertFalse(MoveCheck.validMove(0, 8, 2, 2));
        } catch (Exception e) {}
    }

    @Test
    public void validBishopMove1() throws Exception {} {
        for(int i = 0; i < newChess.size_board; i++){
            newChess.Board[i / newChess.r][i % newChess.c] =
                    Board_for_Bishop[i / newChess.r][i % newChess.c];
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
                    Board_for_Queen[i / newChess.r][i % newChess.c];
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
                    Board_for_King[i / newChess.r][i % newChess.c];
        }
        assertTrue(MoveCheck.validMove(3, 4, 4, 4));
    }

    @Test
    public void validKingMove2() throws Exception {

        for(int i = 0; i < newChess.size_board; i++){
            newChess.Board[i / newChess.r][i % newChess.c] =
                    Board_for_King[i / newChess.r][i % newChess.c];
        }
        assertTrue(MoveCheck.validMove(5, 4, 4, 4));
    }

    @Test
         public void invalidKingMove2() throws Exception {

        for(int i = 0; i < newChess.size_board; i++){
            newChess.Board[i / newChess.r][i % newChess.c] =
                    Board_for_King[i / newChess.r][i % newChess.c];
        }
        assertFalse(MoveCheck.validMove(5, 6, 4, 4));
    }

    @Test
    public void check() throws Exception {

        for(int i = 0; i < newChess.size_board; i++){
            newChess.Board[i / newChess.r][i % newChess.c] =
                    Board_for_Check[i / newChess.r][i % newChess.c];
        }
        assertFalse(isCheck.isCheck(Board_for_Check, true, false));
    }

    @Test
    public void check2() throws Exception {

        for(int i = 0; i < newChess.size_board; i++){
            newChess.Board[i / newChess.r][i % newChess.c] =
                    Board_for_Check[i / newChess.r][i % newChess.c];
        }
        assertTrue(isCheck.isCheck(Board_for_Check, false, false));
    }

    @Test
    public void noStaleMate() throws Exception {


        assertFalse(MoveCheck.isGame());
    }


    @Test
    public void StaleMate() throws Exception {

        boolean isBlack = true;
        for(int i = 0; i < newChess.size_board; i++){
            newChess.Board[i / newChess.r][i % newChess.c] =
                    Board_for_Stalemate[i / newChess.r][i % newChess.c];
        }

        assertFalse(MoveCheck.isGame());
    }


    @Test
    public void noCheckMate() throws Exception {


        assertFalse(MoveCheck.isGame());
    }

    // Test checkmate
    @Test
    public void checkMate() throws Exception {} {

        boolean isBlack = true;
        for(int i = 0; i < newChess.size_board; i++){
        newChess.Board[i / newChess.r][i % newChess.c] =
                Board_for_Checkmate[i / newChess.r][i % newChess.c];
        }

        assertTrue(MoveCheck.isGame());

    }


    @Test
    public void invalidKamikaze1() throws Exception {

        assertFalse(MoveCheck.validMove(7, 7, 7, 6));
    }

    @Test
    public void validKamikaze1() throws Exception {
        MoveExecute.moveNow(4, 4, 4, 6);
        MoveExecute.moveNow(5, 3, 5, 1);
        assertTrue(MoveCheck.validMove(0, 2, 5, 7));
    }

    @Test
    public void validGreaterKnight1() throws Exception {
        assertTrue(MoveCheck.validMove(4, 4, 6, 7));
    }

    @Test
    public void invalidGreaterKnight1() throws Exception {
        assertFalse(MoveCheck.validMove(4, 5, 6, 7));
    }



    @Before
    public void setUp() throws Exception {
        newChess the_Chess = new newChess();
        the_Chess.initBoard();

    }


        /*
    contains the various board for miscellaneous testing case
     */

    public static String Board_for_Pawn[][] = {
            {"r", "k", "b", "q", "a", "b", "k", "r"},
            {"p", "p", " ", "p", " ", "p", "p", "p"},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", "p", " ", "p", " ", " ", " "},
            {" ", " ", " ", "P", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {"P", "P", "P", "P", "P", "P", "P", "P"},
            {"R", "K", "B", "Q", "A", "B", "K", "R"}};

    public static String Board_for_Rook[][] = {
            {"r", "k", "b", "q", "a", "b", "k", "r"},
            {"p", "p", "p", "p", "p", "p", "p", "p"},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", "R"},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {"P", "P", "P", "P", "P", "P", "P", "P"},
            {"R", "K", "B", "Q", "A", "B", "K", " "}};

    public static String Board_for_Bishop[][] = {
            {"r", "k", "b", "q", "a", "b", "k", "r"},
            {"p", "p", "p", "p", "p", "p", "p", "p"},
            {" ", " ", "B", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {"P", "P", "P", "P", "P", "P", "P", "P"},
            {"R", "K", " ", "Q", "A", "B", "K", "R"}};

    public static String Board_for_Queen[][] = {
            {"r", "k", "b", "q", "a", "b", "k", "r"},
            {"p", "p", "p", "p", "p", "p", "p", "p"},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", "Q", " ", " "},
            {"P", "P", "P", "P", "P", "P", "P", "P"},
            {"R", "K", "B", " ", "A", "B", "K", "R"}};

    public static String Board_for_King[][] = {
            {"r", "k", "b", "q", "a", "b", "k", "r"},
            {"p", "p", "p", "p", "p", "p", "p", "p"},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", "A", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {"P", "P", "P", "P", "P", "P", "P", "P"},
            {"R", "K", "B", "Q", " ", "B", "K", "R"}};

    public static String Board_for_Check[][] = {
            {"r", "k", "b", "q", "a", "b", "k", "r"},
            {"p", "p", "p", "p", "p", "p", "p", "p"},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", "p", " ", " "},
            {" ", " ", " ", " ", "A", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {"P", "P", "P", "P", "P", "P", "P", "P"},
            {"R", "K", "B", "Q", " ", "B", "K", "R"}};

    public static String Board_for_Stalemate[][] = {
            {"a", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", "A", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "}};

    public static String Board_for_Checkmate[][] = {
            {"R", " ", "a", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", "Q", " ", " ", "Q", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", "A", " ", " "}};


}
