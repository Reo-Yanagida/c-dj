package Task04;

import Test.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Character_04 extends JFrame implements KeyListener {

    private final int mapsize[] = {8, 32};
    private int a;
    private int b;
    private int x;
    private int y;
    private int dir;
    private int num;
    private int fl=1;
    private int[][] field1;
    private int[][] field2;
    private int[][] field3;
    private Image image1;
    Image[][] back1=new Image[8][8];
    Image[][] back2=new Image[8][8];
    Image[][] back3=new Image[8][8];//マップ要は背景
    Image[][] back=new Image[8][8];
    Map_04 map_04 = new Map_04();
    Picture_04 picture_04=new Picture_04();

    Character_04() {
        this.a = map_04.getA();
        this.b = map_04.getB();
        this.dir = map_04.getDir();
        this.num = map_04.getNum();
        this.x = map_04.getX();
        this.y = map_04.getY();
        this.image1=picture_04.getImage1();
        this.field1=map_04.getField1();
        this.field2=map_04.getField2();
        this.field3=map_04.getField3();


        back=back1;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                //this.map[i][j]
                back[i][j]=picture_04.getImage(field1[i][j]);
                // System.out.println(field[i][j]);
            }
            //System.out.println("\n");
        }
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                //this.map[i][j]
                back2[i][j]=picture_04.getImage(field2[i][j]);
                // System.out.println(field[i][j]);
            }
            //System.out.println("\n");
        }
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                //this.map[i][j]
                back3[i][j]=picture_04.getImage(field3[i][j]);
                // System.out.println(field[i][j]);
            }
            //System.out.println("\n");
        }

        addKeyListener(this);
    }


    @Override
    public void paint(Graphics g) {
        int yoff= (dir * 2 + num) * b;
        //g.drawImage(back,0,40,this);

        if (image1 != null) {
            yoff = (dir * 2 + num) * b;

            if (b * 1 == y && b * 1 == x && fl == 1) {
                for (int i = 0; i < a; i++) {
                    for (int j = 0; j < a; j++) {
                        back[j][i] = back2[j][i];
                    }
                }
                fl++;
            } else if (b * 1 == y && b * 6 == x && fl == 2) {
                for (int i = 0; i < a; i++) {
                    for (int j = 0; j < a; j++) {
                        back[j][i] = back3[j][i];
                    }
                }
                fl++;
            } else if (b * 1 == y && b * 1 == x && fl == 2) {
                for (int i = 0; i < a; i++) {
                    for (int j = 0; j < a; j++) {
                        back[j][i] = picture_04.getImage(field1[i][j]);
                    }
                }
                fl--;
            } else if (b * 1 == y && b * 6 == x && fl == 3) {
                for (int i = 0; i < a; i++) {
                    for (int j = 0; j < a; j++) {
                        back[j][i] = back2[j][i];
                    }
                }
                fl--;
            }

            for (int i = 0; i < a; i++) {
                for (int j = 0; j < a; j++) {
                    g.drawImage(back[j][i], b * i, 22 + b * j, this);

                }
            }
        }
        int n=7;
        int cx=8;
        int cy=8;
        int sx=b*cx;
        int sy=b*cy+22;

        Random random=new Random();
        int v=random.nextInt(4);
        if (v == 0) {
            if(isTure(sy-16,sx)){
                sy -= 16;
            }
        } else if (v == 1) {
            if(isTure(sy,sx+16)){
                sx += 16;
            }
        } else if (v == 2) {
            if(isTure(sy+16,sx)){
                sy += 16;
            }
        } else if (v == 3) {
            if(isTure(sy,sx-16)){
                sx -= 16;
            }
        }
        g.drawImage(image1,x,y,x+b,y+b,0,yoff,b,yoff+b,this);
    }

            @Override
            public void keyPressed (KeyEvent e){
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        if (isTure(y - 16, x)) {
                            y = y - 16;
                            dir = 0;
                            break;
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (isTure(y, x + 16)) {
                            x = x + 16;
                            dir = 1;
                            break;
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        if (y + 16 <= (a * b) - 40) {
                            y = y + 16;
                            dir = 2;
                        }
                        break;
                    case KeyEvent.VK_LEFT:
                        if (isTure(y, x - 16)) {
                            x = x - 16;
                            dir = 3;
                            break;
                        }
                        break;
                }
                num ^= 1;
                repaint();
            }
            public void keyReleased (KeyEvent e){
            }
            public void keyTyped (KeyEvent e){
            }

            public boolean isTure ( int i, int j){
                if (b <= i && b * a - b >= i && b <= j && (b * a - b) - b >= j) {
                    return true;
                }
                return false;
            }

}
