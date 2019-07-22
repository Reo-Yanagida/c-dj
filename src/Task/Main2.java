package task;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        List<JButton> buttons=new ArrayList<>();
        //フレーム表示
        JFrame frame = new JFrame("グリッドレイアウト");

        //コンテンツ区画の取得
        Container cont = frame.getContentPane();

        /*ボタンを作る
        JButton jb = new JButton("A");
        JButton jb1 = new JButton("B");
        JButton jb2 = new JButton("C");
        JButton jb3 = new JButton("D");
        JButton jb4 = new JButton("E");
        */
        JButton button1 = new JButton("ボタン1");
        JButton button2 = new JButton("ボタン2");
        JButton button3 = new JButton("ボタン3");
        JButton button4 = new JButton("ボタン4");
        JButton button5 = new JButton("ボタン5");
        JButton button6 = new JButton("ボタン6");
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(button4);
        buttons.add(button5);
        buttons.add(button6);
        for(JButton button:buttons){
            cont.add(button,BorderLayout.SOUTH);
        }


        GridLayout grid = new GridLayout(1,1);
        cont.setLayout(grid);



        //ボタンをコンテンツ区画に追加する
        /*cont.add(jb);
        cont.add(jb1);
        cont.add(jb2);
        cont.add(jb3);
        cont.add(jb4);
        */

        //フレームのサイズを指定
        frame.setSize(700, 700);
        //フレームの表示・非表示を指定
        frame.setVisible(true);
        //×を押した時の処理
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
