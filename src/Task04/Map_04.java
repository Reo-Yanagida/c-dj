package Task04;

import Test.Map;
import Test.MapCell;
import Test.Picture;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Map_04 extends JFrame{
    Image img1;//キャラクター
    Image img2;
    Image[][] back1=new Image[8][8];
    Image[][] back2=new Image[8][8];
    Image[][] back3=new Image[8][8];//マップ要は背景
    Image[][] back=new Image[8][8];
    int x=96;//初期位置
    int y=64;//初期位置
    int dir=0;//画像の種類
    int num=0;//画像の種類から何番目か
    private final int mapsize[] = {8, 32};
    private int a;
    private int b;
    int fl=1;

    int n=7;
    int cx=8;
    int cy=8;
    int sx=b*cx;
    int sy=b*cy+22;

    private int[][] field1={
            {2,2,2,2,2,2,2,2},
            {2,4,3,3,3,3,3,2},
            {2,3,3,3,3,3,3,2},
            {2,3,3,3,3,3,3,2},
            {2,3,3,3,3,3,3,2},
            {2,3,3,3,3,3,3,2},
            {2,3,3,3,3,3,3,2},
            {2,2,2,2,2,2,2,2},
//            {2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
//            {2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
//            {2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
//            {2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
//            {2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
//            {2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
//            {2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
//            {2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
//            {2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
//            {2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
//            {2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,2},
//            {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
    };
    private int[][]field2= {
            {2,2,2,2,2,2,2,2},
            {2,4,5,5,5,5,4,2},
            {2,5,5,5,5,5,5,2},
            {2,5,5,5,5,5,5,2},
            {2,5,5,5,5,5,5,2},
            {2,5,5,5,5,5,5,2},
            {2,5,5,5,5,5,5,2},
            {2,2,2,2,2,2,2,2},
    };
    private int[][] field3= {
            {2,2,2,2,2,2,2,2},
            {2,6,6,6,6,6,4,2},
            {2,6,6,6,6,6,6,2},
            {2,6,6,6,6,6,6,2},
            {2,6,6,6,6,6,6,2},
            {2,6,6,6,6,6,6,2},
            {2,7,6,8,8,6,9,2},
            {2,2,2,2,2,2,2,2},
    };
    Map map[][];
    Image mapImage;

    Picture_04 picture=new Picture_04();
    //Image =picture.getImage(1);

    Map_04(){
        super("Test");
        this.a = mapsize[0];
        this.b = mapsize[1];
        map=new Map[a][a];
        img1 = getToolkit().getImage("src/sample/chr47.gif");
        img2 = getToolkit().getImage("src/sample/5754179_p0_master1200.jpg");
//        back=back1;
//        for (int i = 0; i < a; i++) {
//            for (int j = 0; j < a; j++) {
//                //this.map[i][j]
//                back[i][j]=picture.getImage(field1[i][j]);
//                // System.out.println(field[i][j]);
//            }
//            //System.out.println("\n");
//        }
//        for (int i = 0; i < a; i++) {
//            for (int j = 0; j < a; j++) {
//                //this.map[i][j]
//                back2[i][j]=picture.getImage(field2[i][j]);
//                // System.out.println(field[i][j]);
//            }
//            //System.out.println("\n");
//        }
//        for (int i = 0; i < a; i++) {
//            for (int j = 0; j < a; j++) {
//                //this.map[i][j]
//                back3[i][j]=picture.getImage(field3[i][j]);
//                // System.out.println(field[i][j]);
//            }
//            //System.out.println("\n");
//        }
        //addKeyListener(this);
        setBackground(Color.gray);
        setSize(a*b, a*b+22);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //System.out.println(new File(".").getAbsoluteFile().getParent());
        setVisible(true);

    }

    public int getDir(){
        return dir;
    }
    public void setDir(int Dir){
        this.dir=dir;
    }

    public int getNum(){
        return num;
    }
    public void setNum(int Num){
        this.num=num;
    }

    public int getA(){
        return a;
    }
    public void setA(int A){
        this.a=a;
    }
    public int getB(){
        return b;
    }
    public void setB(int B){
        this.a=b;
    }
    public int getX(){
        return x;
    }
    public void setX(int X){
        this.x=x;
    }

    public int getY(){
        return y;
    }
    public void setY(int Y){
        this.y=y;
    }
    public int[][] getField1(){
        return field1;
    }
    public void setField1(int Field1){
        this.field1=field1;
    }
    public int[][] getField2(){
        return field2;
    }
    public void setField2(int Field2){
        this.field2=field2;
    }
    public int[][] getField3(){
        return field3;
    }
    public void setField3(int Field3){
        this.field3=field3;
    }

//    @Override
//    public void paint(Graphics g)
//    {
//        int yoff;
//        //g.drawImage(back,0,40,this);
//
//        if (img1!=null){
//            yoff= (dir*2+num)*b;
//
//             if(b*1==y && b*1==x && fl==1){
//                 for (int i = 0; i < a; i++) {
//                     for (int j = 0; j < a; j++) {
//                         back[j][i]=back2[j][i];
//                     }
//                 }
//                 fl++;
//             }else if(b*1==y && b*6==x && fl==2){
//                for (int i = 0; i < a; i++) {
//                    for (int j = 0; j < a; j++) {
//                        back[j][i]=back3[j][i];
//                    }
//                }
//                fl++;
//            }else if(b*1==y && b*1==x && fl==2){
//                 for (int i = 0; i < a; i++) {
//                     for (int j = 0; j < a; j++) {
//                         back[j][i]=picture.getImage(field1[i][j]);
//                     }
//                 }
//                 fl--;
//             }else if(b*1==y && b*6==x && fl==3){
//                for (int i = 0; i < a; i++) {
//                    for (int j = 0; j < a; j++) {
//                        back[j][i]=back2[j][i];
//                    }
//                }
//                fl--;
//            }
//
//            for (int i = 0; i < a; i++) {
//                for (int j = 0; j < a; j++){
//                    g.drawImage(back[j][i],b*i,22+b*j,this);
//
//                }
//            }
//
//            if(32==y&&x==32) {
//                //System.out.println("aaa");
//                for (int i = 0; i < a; i++) {
//                    for (int j = 0; j < a; j++) {
//                        g.drawImage(back2[j][i], b * i, 22 + b * j, this);
//                    }
//                }
//            }
//
//            if(b*1==y&&x==b*6) {
//                //System.out.println("aaa");
//                for (int i = 0; i < a; i++) {
//                    for (int j = 0; j < a; j++) {
//                        g.drawImage(back[j][i]=back3[j][i], b * i, 22 + b * j, this);
//                    }
//                }
//            }

//
//            Random random=new Random();
//            int v=random.nextInt(4);
//            if (v == 0) {
//                if(isTure(sy-16,sx)){
//                    sy -= 16;
//                }
//            } else if (v == 1) {
//                if(isTure(sy,sx+16)){
//                    sx += 16;
//                }
//            } else if (v == 2) {
//                if(isTure(sy+16,sx)){
//                    sy += 16;
//                }
//            } else if (v == 3) {
//                if(isTure(sy,sx-16)){
//                    sx -= 16;
//                }
//            }
//            //g.drawImage(img,b*cx,b*cy,b*(cx+1),b*(cy+1),0,b*n,b,b*(n+1),this);
//            //g.drawImage(img1,sx,sy,sx+b,sy+b,0,b*n,b,b*(n+1),this);
//           // g.drawImage(img1,sx,sy,sx+b,sy+b,0,b*n,b,b*(n+1),this);
//            g.drawImage(img1,x,y,x+b,y+b,0,yoff,b,yoff+b,this);
//
//
//        }


//    @Override
//    public void keyPressed(KeyEvent e){
//        switch(e.getKeyCode( )){
//            case KeyEvent.VK_UP : if(isTure(y-16,x)){y=y-16; dir=0; break;}break;
//            case KeyEvent.VK_RIGHT : if(isTure(y,x+16)){x=x+16; dir=1; break;}break;
//            case KeyEvent.VK_DOWN :
//                if(y+16<=(a*b)-40){
//                    y = y + 16;
//                    dir = 2;
//                }break;
//            case KeyEvent.VK_LEFT : if(isTure(y,x-16)){
//                x=x-16; dir=3; break;
//            }break;
//        }
//        num ^= 1;
//        repaint();
//        if(y==32&&x==32){
//            System.out.println("aaa");
//
//
//        }
//    }
//    public void keyReleased(KeyEvent e) { }
//    public void keyTyped(KeyEvent e) { }
    public boolean isTure(int i,int j){
        if(b<=i&&b*a-b>=i&&b<=j&&(b*a-b)-b>=j){
            return true;
        }
        return false;
    }

}
