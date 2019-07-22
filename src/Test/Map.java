package Test;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;


public class Map extends JFrame implements KeyListener{
    Image img1;//キャラクター
    Image img2;
    Image[][] back=new Image[20][20];//マップ要は背景
    int x=96;//初期位置
    int y=64;//初期位置
    int dir=0;//画像の種類
    int num=0;//画像の種類から何番目か
    private final int mapsize[] = {20, 32};
    private int a;
    private int b=32;

    int n=7;
    int cx=8;
    int cy=8;
    int sx=b*cx;
    int sy=b*cy+22;

    int field[][]={
            {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
            {2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
            {2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
            {2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
            {2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
            {2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
            {2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
            {2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
            {2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
            {2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
            {2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
            {2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
            {2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
            {2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
            {2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
            {2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
            {2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
            {2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
            {2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
            {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
        };
    Map map[][];
    Image mapImage;
    MapCell celltbl[]={
            new MapCell(0,false),
            new MapCell(1,false),
    };
    Picture picture=new Picture();
    //Image =picture.getImage(1);

    Map(){
        super("Test");
        this.a = mapsize[0];
        this.b = mapsize[1];
        map=new Map[a][a];
        img1 = getToolkit().getImage("src/sample/chr47.gif");
        img2 = getToolkit().getImage("src/sample/5754179_p0_master1200.jpg");
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                //this.map[i][j]
                back[i][j]=picture.getImage(field[i][j]);
               // System.out.println(field[i][j]);
            }
            //System.out.println("\n");
        }
        addKeyListener(this);
        setBackground(Color.gray);
        setSize(a*b, a*b+22);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //System.out.println(new File(".").getAbsoluteFile().getParent());
        setVisible(true);

    }

//    public void drawMap(Graphics g) {
//        img = getToolkit().getImage("src/sample/chr47.gif");
//       for(int i=0;i<a;i++){
//            for(int j=0;j<a;j++){
//                        back = map[i][j].getToolkit().getImage("src/sample/chr47.gif");
//
//                }
//            }
//        }

    /*public void drawMap(Graphics g) {
        img = getToolkit().getImage("src/sample/chr47.gif");
        for(int i=0;i<a;i++){
            for(int j=0;j<a;j++){
                switch (map[i][j]){
                    case 0:
                        back=getToolkit().getImage("src/sample/floor.gif");
                        break;
                    case 1:
                        back = getToolkit().getImage("src/sample/wall.gif");
                        break;
                }
            }
        }
    }*/

    @Override
    public void paint(Graphics g)
    {
        int yoff;
        //g.drawImage(back,0,40,this);

        if (img1!=null){
            yoff= (dir*2+num)*b;

            for (int i = 0; i < a; i++) {
                for (int j = 0; j < a; j++) {
                    //this.map[i][j]
                    g.drawImage(back[j][i],b*i,22+b*j,this);
                }
            }
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
            //g.drawImage(img,b*cx,b*cy,b*(cx+1),b*(cy+1),0,b*n,b,b*(n+1),this);
            g.drawImage(img1,sx,sy,sx+b,sy+b,0,b*n,b,b*(n+1),this);
            g.drawImage(img1,sx,sy,sx+b,sy+b,0,b*n,b,b*(n+1),this);
            //g.drawImage(img,32*6,32*8,224,288,0,96,32,128,this);
            g.drawImage(img1,x,y,x+b,y+b,0,yoff,b,yoff+b,this);


        }
    }

    @Override
    public void keyPressed(KeyEvent e){
        switch(e.getKeyCode( )){
        case KeyEvent.VK_UP : if(isTure(y-16,x)){y=y-16; dir=0; break;}break;
        case KeyEvent.VK_RIGHT : if(isTure(y,x+16)){x=x+16; dir=1; break;}break;
        case KeyEvent.VK_DOWN :
            if(y+16<=(a*b)-40){
                y = y + 16;
                dir = 2;
            }break;
        case KeyEvent.VK_LEFT : if(isTure(y,x-16)){
            x=x-16; dir=3; break;
        }break;
    }
        num ^= 1;
        repaint();
    }

    public boolean isTure(int i,int j){
        if(b<=i&&b*a-b>=i&&b<=j&&(b*a-b)-b>=j){
            return true;
        }
        return false;
    }
    public void keyReleased(KeyEvent e) { }
    public void keyTyped(KeyEvent e) { }
}

