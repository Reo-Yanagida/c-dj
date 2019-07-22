package task;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Field field = new Field();
        List<JButton>buttons=new ArrayList<>();
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(5,3));
        JFrame frame = new JFrame("Minesweeper");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();


        JButton button1 = new JButton("ボタン1");
        JButton button2 = new JButton("ボタン2");
        buttons.add(button1);
        buttons.add(button2);
        /*for(JButton button:buttons){
            contentPane.add(button,BorderLayout.SOUTH);
        }*/
        buttons.stream().forEach(e->contentPane.add(e,BorderLayout.SOUTH));
       // contentPane.add(button1,BorderLayout.SOUTH);
        //contentPane.add(button2,BorderLayout.NORTH);



    }
}
