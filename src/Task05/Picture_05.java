package Task05;

import javax.swing.*;
import java.awt.*;

public class Picture_05 extends JFrame {
    Image image1=getToolkit().getImage("src/sample/chr47.gif");//猫ちゃん
    Image image2=getToolkit().getImage("src/sample/wall.gif");//壁
    Image image3=getToolkit().getImage("src/sample/floor.gif");//床
    Image image4=getToolkit().getImage("src/sample/kaidanG1のコピー.png");
    Image image5=getToolkit().getImage("src/sample/yuka11のコピー.png");
    Image image6=getToolkit().getImage("src/sample/yuka9のコピー.png");
    Image image7=getToolkit().getImage("src/sample/Tboxnのコピー.png");
    Image image8=getToolkit().getImage("src/sample/Tboxrのコピー.png");
    Image image9=getToolkit().getImage("src/sample/Tboxbのコピー.png");

    public Image getImage1(){
        return image1;
    }
    public void setA(int A){
        this.image1=image1;
    }

    public Image getImage(int num){

        switch (num){
            case 1:
                return this.image1;
            case 2:
                return this.image2;
            case 3:
                return this.image3;
            case 4:
                return this.image4;
            case 5:
                return this.image5;
            case 6:
                return this.image6;
            case 7:
                return this.image7;
            case 8:
                return this.image8;
            case 9:
                return this.image9;
            default:
                return null;
        }
        //return null;
    }
}
