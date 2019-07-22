package Test;

import javax.swing.*;
import java.awt.*;

public class Picture extends JFrame {
    Image image1=getToolkit().getImage("src/sample/chr47.gif");//猫ちゃん
    Image image2=getToolkit().getImage("src/sample/wall.gif");//壁
    Image image3=getToolkit().getImage("src/sample/floor.gif");//床

    Picture(){
    }

    public Image getImage(int num){

        switch (num){
            case 1:
                return this.image1;
            case 2:
                return this.image2;
            case 3:
                return this.image3;
            default:
                return null;
        }
        //return null;
    }

}
