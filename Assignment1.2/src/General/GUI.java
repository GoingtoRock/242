package General; /**
 * Created by My precious on 2015-02-06.
 */

import pieceMove.isCheck;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


public class GUI {

    /*
        constants
     */
    static int x = 0, y = 0;
    static int Square = 70;
    static int size_board = 64;
    static int r = 8, c = 8;


    public static Color oldColor;
    public static boolean validChoose;
    public static boolean validMove;
    public static int moveRow;
    public static int moveCol;
    public static int enteredRow;
    public static int enteredCol;
    public static int draggedIndex;
    public static int currentRow;
    public static int currentCol;
    public static ImageIcon chosenImage;
    public static JButton oldLocation;

    public static boolean undoable = false;

    public static int white_prev_r;
    public static int white_prev_c;
    public static String white_prev_piece;
    public static int white_next_r;
    public static int white_next_c;
    public static String white_next_piece;
    public static JButton white_prev_button;
    public static JButton white_next_button;
    public static ImageIcon white_prev_icon;
    public static ImageIcon white_next_icon;

    public static int black_prev_r;
    public static int black_prev_c;
    public static String black_prev_piece;
    public static int black_next_r;
    public static int black_next_c;
    public static String black_next_piece;
    public static JButton black_prev_button;
    public static JButton black_next_button;
    public static ImageIcon black_prev_icon;
    public static ImageIcon black_next_icon;

    public static int prev_r;
    public static int prev_c;
    public static String prev_piece;
    public static int next_r;
    public static int next_c;
    public static String next_piece;
    public static JButton prev_button;
    public static JButton next_button;
    public static ImageIcon prev_icon;
    public static ImageIcon next_icon;


    private static chessBoardPanel chessBoard;
    private static settingPanel settingBoard;
    private static playerPanel playerBoard;

    public static JLabel whiteScoreLabel;
    public static JLabel blackScoreLabel;
    public static JLabel player1Label;
    public static JLabel player2Label;
    public static String player1Name;
    public static String player2Name;
    private static JFrame f;

    public GUI() {

        // graphics
        f = new JFrame("Chess");
//        squares = new JPanel[r][c];
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chessBoard = new chessBoardPanel();
        settingBoard = new settingPanel();
        playerBoard = new playerPanel();
        f.add(chessBoard, BorderLayout.WEST);
        f.add(settingBoard, BorderLayout.SOUTH);
        f.add(playerBoard, BorderLayout.EAST);
        f.pack();
        f.setVisible(true);

    }

    private static class playerPanel extends JPanel {

        public playerPanel(){

            super(new GridLayout(2,1));

            JButton player1 = new JButton();
            JButton player2 = new JButton();

            player1Label = new JLabel();
            player2Label = new JLabel();
            player1Label.setText("Player 1 : White");
            player2Label.setText("Player 2 : Black");
            player1.add(player1Label);
            player2.add(player2Label);
            this.add(player1);
            this.add(player2);
        }

    }


    private static class settingPanel extends JPanel {


        public settingPanel() {
            super(new GridLayout(1, 6));

            JButton matchButton = new JButton("New Match");
            JButton rematchButton = new JButton("Rematch");
            JButton surrenderButton = new JButton("Surrender");
            JButton undoButton = new JButton("Undo");
            JButton whiteButton = new JButton();
            JButton blackButton = new JButton();

            matchButton.addActionListener(new matchAction());
            rematchButton.addActionListener(new rematchAction());
            surrenderButton.addActionListener(new surrenderAction());
            undoButton.addActionListener(new undoAction());

            this.add(matchButton);
            this.add(rematchButton);
            this.add(surrenderButton);
            this.add(undoButton);

            whiteScoreLabel = new JLabel();
            blackScoreLabel = new JLabel();
            whiteScoreLabel.setText("White Score: " + newChess.whiteScore);
            blackScoreLabel.setText("Black Score: " + newChess.blackScore);
            whiteButton.add(whiteScoreLabel);
            blackButton.add(blackScoreLabel);
            this.add(blackButton);
            this.add(whiteButton);

        }

    }

    private static class chessBoardPanel extends JPanel {

        public chessBoardPanel() {
            super(new GridLayout(r, c));
            this.setPreferredSize(new Dimension(r * Square, c * Square));

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {

                    final JButton square = new JButton();
                    square.setIcon(imageIcon(i, j));
                    square.setVisible(true);


                    // draw the chessBoard
                    if ((i + j) % 2 == 0) {
                        square.setBackground(Color.white);
                        this.add(square);
                    } else {
                        square.setBackground(Color.orange);
                        this.add(square);
                    }

                    square.putClientProperty("row", i);
                    square.putClientProperty("col", j);

                    Action mouseHandler = new Action();
                    square.addMouseListener(mouseHandler);
                    square.addMouseMotionListener(mouseHandler);
                }
            }
        }
    }

    private static class matchAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if (newChess.currentState == newChess.noGame) {
                player1Name = JOptionPane.showInputDialog("Enter player 1's name!");
                player2Name = JOptionPane.showInputDialog("Enter player 2's name!");

                if(player1Name != null) player1Label.setText(player1Name + " : White");
                else player1Name = "Player 1";
                if(player2Name != null) player2Label.setText(player2Name + " : Black");
                else player2Name = "Player 2";
            }
            newChess.currentState = newChess.inGame;
            newChess.currentPlayer = newChess.White;
            undoable = false;
            whiteScoreLabel.setText("White Score: " + newChess.whiteScore);
            blackScoreLabel.setText("Black Score: " + newChess.blackScore);


        }
    }


    private static class rematchAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (newChess.currentState != newChess.noGame) {

                int n = JOptionPane.showConfirmDialog(null,
                        player1Name + ", Continue to rematch?", null, JOptionPane.YES_NO_OPTION);

                int m = JOptionPane.showConfirmDialog(null,
                        player2Name + ", Continue to rematch?", null, JOptionPane.YES_NO_OPTION);

                if (n == 0 && m == 0) {
                    newChess.initBoard();
                    newChess.currentState = newChess.inGame;
                    newChess.currentPlayer = newChess.White;

                    undoable = false;
                    chessBoard.removeAll();
                    f.remove(chessBoard);

                    chessBoard = new chessBoardPanel();
                    f.add(chessBoard, BorderLayout.WEST);

                    whiteScoreLabel.setText("White Score: " + newChess.whiteScore);
                    blackScoreLabel.setText("Black Score: " + newChess.blackScore);

                    f.revalidate();
                    f.repaint();

                }
                else {
                    JOptionPane.showMessageDialog(null,"Failed restart.", null,JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "Please Start a Game first.", null,JOptionPane.WARNING_MESSAGE);
            }
        }
    }


    private static class surrenderAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (newChess.currentState == newChess.inGame) {

                if (newChess.currentPlayer == newChess.White) {
                    int n = JOptionPane.showConfirmDialog(null,
                            player1Name + ", Surrender the game?", null, JOptionPane.YES_NO_OPTION);

                    if (n == 0) {

                            JOptionPane.showMessageDialog(null,
                                    player2Name + " win!", null, JOptionPane.WARNING_MESSAGE);
                            newChess.blackScore++;
                            newChess.currentState = newChess.blackWin;

                    }
                }else {
                        int n = JOptionPane.showConfirmDialog(null,
                                player2Name + ", Surrender the game?", null, JOptionPane.YES_NO_OPTION);
                        if (n == 0) {

                                JOptionPane.showMessageDialog(null,
                                        player1Name + " win!", null, JOptionPane.WARNING_MESSAGE);
                                newChess.whiteScore++;
                                newChess.currentState = newChess.whiteWin;

                        }

                    }

                whiteScoreLabel.setText("White Score: " + newChess.whiteScore);
                blackScoreLabel.setText("Black Score: " + newChess.blackScore);
                }


            else {
                JOptionPane.showMessageDialog(null,"Please Start a Game first.", null, JOptionPane.WARNING_MESSAGE);
            }
        }
    }


    private static class undoAction implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if(undoable) {
                newChess.chessBoard[prev_r][prev_c] = prev_piece;
                newChess.chessBoard[next_r][next_c] = next_piece;
                next_button.setIcon(next_icon);
                prev_button.setIcon(prev_icon);

                newChess.switchPlayer();
                undoable = false;
            }

        }
    }




    private static ImageIcon imageIcon(int r, int c) {

        ImageIcon icon = null;
        if (newChess.chessBoard[r][c].equals(Pieces.wPawn)) {
            icon = new ImageIcon(GUI.class.getResource("/wpawn.gif"));
        } else if (newChess.chessBoard[r][c].equals(Pieces.bPawn)) {
            icon = new ImageIcon(GUI.class.getResource("/bpawn.gif"));
        } else if (newChess.chessBoard[r][c].equals(Pieces.wKnight)) {
            icon = new ImageIcon(GUI.class.getResource("/wknight.gif"));
        } else if (newChess.chessBoard[r][c].equals(Pieces.bKnight)) {
            icon = new ImageIcon(GUI.class.getResource("/bknight.gif"));
        } else if (newChess.chessBoard[r][c].equals(Pieces.wBishop)) {
            icon = new ImageIcon(GUI.class.getResource("/wbishop.gif"));
        } else if (newChess.chessBoard[r][c].equals(Pieces.bBishop)) {
            icon = new ImageIcon(GUI.class.getResource("/bbishop.gif"));
        } else if (newChess.chessBoard[r][c].equals(Pieces.wRook)) {
            icon = new ImageIcon(GUI.class.getResource("/wrook.gif"));
        } else if (newChess.chessBoard[r][c].equals(Pieces.bRook)) {
            icon = new ImageIcon(GUI.class.getResource("/brook.gif"));
        } else if (newChess.chessBoard[r][c].equals(Pieces.wQueen)) {
            icon = new ImageIcon(GUI.class.getResource("/wqueen.gif"));
        } else if (newChess.chessBoard[r][c].equals(Pieces.bQueen)) {
            icon = new ImageIcon(GUI.class.getResource("/bqueen.gif"));
        } else if (newChess.chessBoard[r][c].equals(Pieces.wKing)) {
            icon = new ImageIcon(GUI.class.getResource("/wking.gif"));
        } else if (newChess.chessBoard[r][c].equals(Pieces.bKing)) {
            icon = new ImageIcon(GUI.class.getResource("/bking.gif"));
        } else if (newChess.chessBoard[r][c].equals(Pieces.wGreaterKnight)) {
            icon = new ImageIcon(GUI.class.getResource("/wgreaterknight.png"));
        } else if (newChess.chessBoard[r][c].equals(Pieces.bGreaterKnight)) {
            icon = new ImageIcon(GUI.class.getResource("/bgreaterknight.png"));
        } else if (newChess.chessBoard[r][c].equals(Pieces.wKamikaze)) {
            icon = new ImageIcon(GUI.class.getResource("/wkamikaze.png"));
        } else if (newChess.chessBoard[r][c].equals(Pieces.bKamikaze)) {
            icon = new ImageIcon(GUI.class.getResource("/bkamikaze.png"));
        }
        return icon;
    }


    private static class Action implements MouseInputListener, MouseMotionListener {
        public void mouseMoved(MouseEvent e) {}
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
        public void mouseClicked(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                JButton left_click = (JButton) e.getSource();
                currentRow = ((Integer) left_click.getClientProperty("row")).intValue();
                currentCol = ((Integer) left_click.getClientProperty("col")).intValue();

                //System.out.println("current Row: " + currentRow + ", current Col: " + currentCol);

                if (newChess.currentState == newChess.inGame) {

                    if ((Character.isLowerCase(newChess.Board[currentRow][currentCol].charAt(0)) &&
                            newChess.currentPlayer == newChess.Black) ||
                            (Character.isUpperCase(newChess.Board[currentRow][currentCol].charAt(0)) &&
                                    newChess.currentPlayer == newChess.White)) {

                        left_click.setBackground(Color.green);
                        chosenImage = (ImageIcon) left_click.getIcon();
                        oldLocation = left_click;
                        validChoose = true;
                    } else {
                        left_click.setBackground(Color.red);
                        validChoose = false;
                    }
                } else if (newChess.currentState != newChess.inGame) {

                    JOptionPane.showMessageDialog(null, "Please start a game!", null, JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Please restart!", null, JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JButton right_click = (JButton) e.getSource();
                moveRow = ((Integer) right_click.getClientProperty("row")).intValue();
                moveCol = ((Integer) right_click.getClientProperty("col")).intValue();

                //System.out.println("moving to Row: " + currentRow + ", moving to Col: " + currentCol);
                if (validChoose) {
                    if (MoveCheck.validMove(moveCol, moveRow, currentCol, currentRow)) {

                        undoHelper(right_click);
                        MoveExecute.moveNow(moveCol, moveRow, currentCol, currentRow);

                        if(MoveCheck.isGame()){
                            if (newChess.currentState == newChess.whiteWin) {
                                JOptionPane.showMessageDialog(null, player2Name + ", CheckMate!", null, JOptionPane.WARNING_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, player1Name + ", CheckMate!", null, JOptionPane.WARNING_MESSAGE);
                            }
                        }
                        if (newChess.currentState != newChess.inGame) {
                            if (newChess.currentState == newChess.whiteWin) {
                                JOptionPane.showMessageDialog(null, player1Name + " win!", null, JOptionPane.WARNING_MESSAGE);
                                undoable = false;
                                newChess.whiteScore++;
                            } else {
                                JOptionPane.showMessageDialog(null, player2Name + " win!", null, JOptionPane.WARNING_MESSAGE);
                                undoable = false;
                                newChess.blackScore++;
                            }
                            whiteScoreLabel.setText("White Score: " + newChess.whiteScore);
                            blackScoreLabel.setText("Black Score: " + newChess.blackScore);
                        }

                        right_click.setIcon(chosenImage);

                        oldLocation.setIcon(null);
                        newChess.switchPlayer();
                        validChoose = false;
                        undoable = true;

                        if (newChess.currentState == newChess.inGame) {
                            if (newChess.currentPlayer == newChess.White &&
                                    isCheck.isCheck(newChess.Board, false, false)) {
                                JOptionPane.showMessageDialog(null, player1Name + ", Check!!", null, JOptionPane.WARNING_MESSAGE);
                            } else if (newChess.currentPlayer == newChess.Black &&
                                    isCheck.isCheck(newChess.Board, true, false)) {
                                JOptionPane.showMessageDialog(null, player2Name + ", Check!!", null, JOptionPane.WARNING_MESSAGE);
                            }
                        }


                    }
                }
            }
        }

        public void mouseDragged(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
            JButton currentLabel = (JButton) e.getSource();
            oldColor = currentLabel.getBackground();
            if (validChoose) {
                enteredRow = ((Integer) currentLabel.getClientProperty("row")).intValue();
                enteredCol = ((Integer) currentLabel.getClientProperty("col")).intValue();

                if (MoveCheck.validMove(enteredCol, enteredRow, currentCol, currentRow)) {
                    currentLabel.setBackground(Color.green);
                } else {
                    currentLabel.setBackground(Color.red);
                }
            }
        }

        public void mouseExited(MouseEvent e) {
            JButton exit = (JButton) e.getSource();
            exit.setBackground(oldColor);
        }

        private void undoHelper(JButton right_click) {


            prev_r = currentRow;
            prev_c = currentCol;
            prev_piece = newChess.Board[prev_r][prev_c];
            prev_button = oldLocation;
            prev_icon = chosenImage;

            next_r = moveRow;
            next_c = moveCol;
            next_piece = newChess.Board[next_r][next_c];
            next_button = right_click;
            next_icon = (ImageIcon) right_click.getIcon();

        }
    }

}