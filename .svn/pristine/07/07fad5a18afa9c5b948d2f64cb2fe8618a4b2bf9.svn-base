package GameManaging; /**
 * Created by My precious on 2015-02-06.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class UserInterface extends JPanel implements MouseListener, MouseMotionListener {

    static int x = 0, y = 0;

    @Override
    public void paintComponent(Graphics g) {

        // enable changing of background
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);


        g.setColor(Color.BLUE);
        g.fillRect(x, y, 20, 20);
        g.setColor(Color.PINK);
        g.fillRect(40, 20, 20, 20);



        Image chessBoard = new ImageIcon("Image/Chess_Board.jpeg").getImage();

        Image blackPawn = new ImageIcon("Image/B_Pawn.jpeg").getImage();
        Image blackKnight = new ImageIcon("Image/B_Knight.jpeg").getImage();
        Image blackQueen = new ImageIcon("Image/B_Queen.jpeg").getImage();
        Image blackRook = new ImageIcon("Image/B_Rook.jpeg").getImage();
        Image blackBishop = new ImageIcon("Image/B_Bishop.jpeg").getImage();
        Image blackKing = new ImageIcon("Image/B_King.jpeg").getImage();

        Image whitePawn = new ImageIcon("Image/W_Pawn.jpeg").getImage();
        Image whiteKnight = new ImageIcon("Image/W_Knight.jpeg").getImage();
        Image whiteQueen = new ImageIcon("Image/W_Queen.jpeg").getImage();
        Image whiteRook = new ImageIcon("Image/W_Rook.jpeg").getImage();
        Image whiteBishop = new ImageIcon("Image/W_Bishop.jpeg").getImage();
        Image whiteKing = new ImageIcon("Image/W_King.jpeg").getImage();


        //g.drawImage(chessPieceImage, x, y, x + 210, y + 320, 0, 0, 400, 500, this);
        g.drawImage(chessBoard, x, y, 32*8, 32*8, this);
    }
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
        x=e.getX();
        y=e.getY();
        repaint();
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
