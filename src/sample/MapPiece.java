package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

/*public class MapPiece implements Drawable{
    private int pieceId;
    private boolean block;
    private int x;
    private int y;
    private Image image;
    private ImageObserver observer;
    private int [][] map={
            {1,1,1,1,1,1,1,1,1,1},
            {1,0,0,0,0,2,1,1,1,1},
            {1,0,0,0,0,2,0,1,1,1},
            {1,1,0,0,2,2,0,0,1,1},
            {1,1,0,0,2,0,0,0,0,1},
            {1,1,1,0,2,0,0,0,0,1},
            {1,1,0,2,2,0,0,0,0,1},
            {1,0,0,0,2,0,0,0,0,1},
            {1,1,0,2,0,0,0,0,1,1},
            {1,1,1,1,1,1,1,1,1,1}
    };

    public MapPiece(String pImageName,int x,int y,boolean pBlock,ImageObserver pobserver){
        this.x=x;
        this.y=y;
        observer=pobserver;
        try{
                image=new ImageIcon(getClass().getResource(pImageName)).getImage();
        }catch (Exception e){
            e.printStackTrace();
        }
        block=pBlock;
    }
    public int getX(){
        return x;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public void setX(int X) {

    }

    @Override
    public void setY(int Y) {

    }

    @Override
    public Image getImage() {
        return null;
    }

    @Override
    public void setImage() {

    }

    @Override
    public void draw(Graphics2D g2d) {
        Graphics2D g2d=(Graphics2D)g;
        for(int i=0;i<mapPiece.length;i++){
            for(int j=0;j<mapPiece[i];i++){
                mapPiece[i][j].draw(g2d);
    }

    public void MapPanel(){
        setPreferredsize(new Dimension(200,200));

        for(int i=0;i<map.length;i++){
            for(int j=0;i<map[i].length;i++){
                switch (map[i][j]){
                    case 0:
                        mapPiece[i][j]=new MapPiece("pipo-map001_at-mori.png",i,j,false,this);
                        break;
                    case 1:
                        mapPiece[i][j]=new MapPiece("image/map002.PNG",i,j,false,this);
                        break;
                    case 2:
                        mapPiece[i][j]=new MapPiece("image/map003.PNG",i,j,false,this);
                        break;
                }
            }
        }
    }

    public void paintComponent(Graphics g){
        System.out.println("a");
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        Graphics2D g2d=(Graphics2D)g;
        for(int i=0;i<mapPiece.length;i++){
            for(int j=0;j<mapPiece[i];i++){
                mapPiece[i][j].draw(g2d);
            }
        }
    }

}*/
