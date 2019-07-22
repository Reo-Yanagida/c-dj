package Task05;

import java.awt.*;

public class Map_05 {
    private int[][] field1={
            {2,2,2,2,2,2,2,2},
            {2,4,3,3,3,3,3,2},
            {2,3,3,3,3,3,3,2},
            {2,3,3,3,3,3,3,2},
            {2,3,3,3,3,3,3,2},
            {2,3,3,3,3,3,3,2},
            {2,3,3,3,3,3,3,2},
            {2,2,2,2,2,2,2,2},
    };
    private int[][] field2={
            {2,2,2,2,2,2,2,2},
            {2,4,5,5,5,5,4,2},
            {2,5,5,5,5,5,5,2},
            {2,5,5,5,5,5,5,2},
            {2,5,5,5,5,5,5,2},
            {2,5,5,5,5,5,5,2},
            {2,5,5,5,5,5,5,2},
            {2,2,2,2,2,2,2,2},
    };
    private int[][] field3={
            {2,2,2,2,2,2,2,2},
            {2,6,6,6,6,6,4,2},
            {2,6,6,6,6,6,6,2},
            {2,6,6,6,6,6,6,2},
            {2,6,6,6,6,6,6,2},
            {2,6,6,6,6,6,6,2},
            {2,7,6,8,8,6,9,2},
            {2,2,2,2,2,2,2,2},
    };

    Image[][] back1=new Image[8][8];
    Image[][] back2=new Image[8][8];
    Image[][] back3=new Image[8][8];//マップ要は背景
    Image[][] back=new Image[8][8];

    Map_05(){
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
    }
}
