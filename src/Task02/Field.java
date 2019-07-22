package task02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Field extends JFrame implements ActionListener {
    private final int field[] = {8, 60};
    private int a;
    private int b;

    JButton button[][]; //buttonを二次元配列で用意
    Stone stone[][];
    Turn turn=new Turn("W");
    JPanel panel = new JPanel();

    Field(String title){
        this.a = field[0];
        this.b = field[1];
        button=new JButton[a][a];
        stone=new Stone[a][a];
        setTitle(title);
        setLocationRelativeTo(null);
        setSize(a * b, a * b + 22);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLAF();
        setField();
        setStone();
        displayField();

        getContentPane().add(panel, BorderLayout.CENTER);
    }

    void setLAF() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            UIManager.put("swing.boldMetal", Boolean.FALSE);
            UIManager.put("Button.select",new Color(46,138,87));

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    void setField(){
        panel.setLayout(null);
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                button[i][j] = new JButton();
                button[i][j].setFont(new Font("Arial", Font.PLAIN, 43));
                stone[i][j]=new Stone("N");
                //button[i][j].setFont();
                button[i][j].setBackground(new Color(46,138,87));
                //button[i][j].setForeground(Color.GREEN);
                button[i][j].addActionListener(this);
                button[i][j].setActionCommand("i"+i+"j"+j);
                button[i][j].setBounds(i * b, j * b, b, b);
                panel.add(button[i][j]);
            }
        }
    }

    void setStone(){
        stone[0][0].setStoneColor("W");
        stone[3][4].setStoneColor("B");
        stone[4][3].setStoneColor("B");
        stone[4][4].setStoneColor("W");
    }

    void displayField(){
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                //button[i][j].setText("");
                if (!stone[i][j].getStoneColor().equals("N")) {
                    button[i][j].setText("●");
                    if (stone[i][j].getStoneColor().equals("B")) {
                        button[i][j].setForeground(Color.BLACK);
                    }else if (stone[i][j].getStoneColor().equals("W")) {
                        button[i][j].setForeground(Color.WHITE);
                    }
                }
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent e){ //buttonを押した時に実行される行動についてのメソッド
        Object cmd=e.getActionCommand(); //Object cmdにActionCommandを代入？
        ba:{
            for(int i=0;i<a;i++){ //マスの数だけ繰り返す
                for(int j=0;j<a;j++){ //マスの数だけ繰り返す
                    if(cmd.equals("i"+i+"j"+j)) {  //もし何かと何かが等しい時に実行
                        if(!stone[i][j].getStoneColor().equals("N")){
                            break ba;
                        }
                        stone[i][j].setStoneColor(turn.getTurn());
                        turn.turnChange(turn.getTurn());
                        displayField();
                    }
                }
            }
        }
    }
}
