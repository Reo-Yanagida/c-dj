package sample;

import java.awt.*;

public interface Drawable {
    public int getX();
    public int getY();

    public void setX(int X);
    public void setY(int Y);

    public static int PIECESIZE=20;

    public Image getImage();
    public void setImage();

    public void draw(Graphics2D g2d);

}
