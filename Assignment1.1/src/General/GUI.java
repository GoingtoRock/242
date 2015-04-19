package General; /**
 * Created by My precious on 2015-02-06.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class GUI extends JPanel implements MouseListener, MouseMotionListener {

    static int x = 0, y = 0;
    static int Square = 70;
    static int size_board =64;
    static int r = 8, c = 8;


    JPanel squares[][];

    public GUI() {

        // graphics
        JFrame f = new JFrame("Chess");
        squares = new JPanel[r][c];
        f.setSize(Square * 8, Square * 8);
        f.setLayout(new GridLayout(r, c));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon blackPawn = new ImageIcon(getClass().getResource("/bpawn.gif"));

        ImageIcon blackKnight = new ImageIcon(getClass().getResource("/bknight.gif"));
        ImageIcon blackQueen = new ImageIcon(getClass().getResource("/bqueen.gif"));
        ImageIcon blackRook = new ImageIcon(getClass().getResource("/brook.gif"));
        ImageIcon blackBishop = new ImageIcon(getClass().getResource("/bbishop.gif"));
        ImageIcon blackKing = new ImageIcon(getClass().getResource("/bking.gif"));
        ImageIcon blackKamikaze = new ImageIcon(getClass().getResource("/bkamikaze.png"));
        ImageIcon blackGreaterKnight = new ImageIcon(getClass().getResource("/bgreaterknight.png"));

        ImageIcon whitePawn = new ImageIcon(getClass().getResource("/wpawn.gif"));
        ImageIcon whiteKnight = new ImageIcon(getClass().getResource("/wknight.gif"));
        ImageIcon whiteQueen = new ImageIcon(getClass().getResource("/wqueen.gif"));
        ImageIcon whiteRook = new ImageIcon(getClass().getResource("/wrook.gif"));
        ImageIcon whiteBishop = new ImageIcon(getClass().getResource("/wbishop.gif"));
        ImageIcon whiteKing = new ImageIcon(getClass().getResource("/wking.gif"));
        ImageIcon whiteKamikaze = new ImageIcon(getClass().getResource("/wkamikaze.png"));
        ImageIcon whiteGreaterKnight = new ImageIcon(getClass().getResource("/wgreaterknight.png"));

        // draw the chessBoard
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                squares[i][j] = new JPanel();

                if ((i + j) % 2 == 0) {
                    squares[i][j].setBackground(Color.white);
                } else {
                    squares[i][j].setBackground(Color.orange);
                }
                f.add(squares[i][j]);
            }
        }

        squares[0][0].add(new JLabel(whiteRook));
        squares[0][1].add(new JLabel(whiteKnight));
        squares[0][2].add(new JLabel(whiteBishop));
        squares[0][3].add(new JLabel(whiteQueen));
        squares[0][4].add(new JLabel(whiteKing));
        squares[0][5].add(new JLabel(whiteKamikaze));
        squares[0][6].add(new JLabel(whiteGreaterKnight));
        squares[0][7].add(new JLabel(whiteRook));

        squares[7][0].add(new JLabel(blackRook));
        squares[7][1].add(new JLabel(blackKnight));
        squares[7][2].add(new JLabel(blackBishop));
        squares[7][3].add(new JLabel(blackQueen));
        squares[7][4].add(new JLabel(blackKing));
        squares[7][5].add(new JLabel(blackKamikaze));
        squares[7][6].add(new JLabel(blackGreaterKnight));
        squares[7][7].add(new JLabel(blackRook));
        // disabled for Assignment 1.1
        //this.addMouseListener(this);
        //this.addMouseMotionListener(this);

        // pawn
        for (int i = 0; i < 8; i++)
        {
            squares[1][i].add(new JLabel(whitePawn));
            squares[6][i].add(new JLabel(blackPawn));
        }

        f.setVisible(true);
    }

    // TODO later assignment : mouse interaction
    @Override
    public void mouseMoved(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseClicked(MouseEvent e) {
/*        x=e.getX();
        y=e.getY();
        repaint();*/
    }
    @Override
    public void mouseDragged(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }

}
