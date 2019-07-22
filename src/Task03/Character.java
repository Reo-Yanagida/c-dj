package task03;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/*public class Character extends JFrame {
    Image img1;
    private int x=96;//初期位置
    private int y=64;//初期位置
    private int dir=0;
    private int num=0;
    private int n=7;
    private int a;
    private int b;
    private int cx=8;
    private int cy=8;
    private int sx=b*cx;
    private int sy=b*cy+22;
    Mapdata mapdata=new Mapdata();

    Character(int cx,int cy){
        img1 = getToolkit().getImage("src/sample/chr47.gif");
        this.b=mapdata.getB();
        this.a=mapdata.getA();
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

    @Override
    public void paint(Graphics g)
    {
        int yoff;

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
                if(isTrue(sy-16,sx)){
                    sy -= 16;
                }
            } else if (v == 1) {
                if(isTrue(sy,sx+16)){
                    sx += 16;
                }
            } else if (v == 2) {
                if(isTrue(sy+16,sx)){
                    sy += 16;
                }
            } else if (v == 3) {
                if(isTrue(sy,sx-16)){
                    sx -= 16;
                }
            }
            g.drawImage(img1,sx,sy,sx+b,sy+b,0,b*n,b,b*(n+1),this);
            g.drawImage(img1,sx,sy,sx+b,sy+b,0,b*n,b,b*(n+1),this);
            g.drawImage(img1,x,y,x+b,y+b,0,yoff,b,yoff+b,this);
        }
    }

    public boolean isTrue(int i,int j){
        if(b<=i&&b*a-b>=i&&b<=j&&(b*a-b)-b>=j){
            return true;
        }
        return false;
    }
}
*/