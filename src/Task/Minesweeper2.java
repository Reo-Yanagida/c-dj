package task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

    public class Minesweeper2 extends JFrame implements ActionListener {

        private final int easy[] = {8, 42, 10}; //個数,マスの大きさ,爆弾の数«
        private final int normal[] = {16, 42, 40};
        private final int hard[] = {24, 42, 100};
        private int a; //縦と横のマスの数
        private int b; //マスの大きさ
        private int numOfBombs; //爆弾の数
        private int placeOfBombsY[]; //Y軸の爆弾の場所
        private int placeOfBombsX[]; //X軸の爆弾の場所
        int[][] numbers;
        int[][] flags;

        JButton button[][]; //buttonを二次元配列で用意
        JPanel panel = new JPanel(); //panelの用意インスタンス化？

        Minesweeper2(String title,String level) { //コンストラクタ？
            switch(level) { //switch文で場合分けをし、各難易度の値を設定
                case "easy":
                    this.a = easy[0]; //縦と横のマスの数を8に初期化
                    this.b = easy[1]; //マスの大きさを42に初期化
                    this.numOfBombs = easy[2]; //爆弾の数を10に初期化
                    break;
                case "normal":
                    this.a = normal[0];
                    this.b = normal[1];
                    this.numOfBombs = normal[2];
                    break;
                case "hard":
                    this.a = hard[0];
                    this.b = hard[1];
                    this.numOfBombs = hard[2];
                    break;
            }
            button=new JButton[a][a]; //buttonの数をa*aに設定
            placeOfBombsY=new int[numOfBombs]; //Y軸に爆弾を入れる
            placeOfBombsX=new int[numOfBombs]; //x軸に爆弾を入れる
            numbers=new int[a][a];
            flags=new int[a][a];
            setTitle(title); //タイトルのセット
            setLocationRelativeTo(null); //panelの位置の初期化？
            setSize(a * b, a * b + 22); //横のマスがa*b 縦のマスがa*b 横に22分スペースを追加
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //×でプログラム終了

            setLAF(); //setLAFメソッドの呼び出し
            setButton(); //setButtonメソッドの呼び出し
            setBombs(); //setBomsメソッドの呼び出し
            setNumber(); //setNumberメソッドの呼び出し

            getContentPane().add(panel, BorderLayout.CENTER); //panelの表示

        }

        void setLAF() { //LookAndFeelについてのメソッド
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                UIManager.put("swing.boldMetal", Boolean.FALSE);
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        void setButton(){ //buttonを置くメソッド
            panel.setLayout(null); //panelを配置？
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < a; j++) {
                    button[i][j] = new JButton();
                    //button[i][j].setFont();
                    button[i][j].setBackground(Color.LIGHT_GRAY);
                    button[i][j].setForeground(Color.LIGHT_GRAY);
                    button[i][j].addActionListener(this);
                    button[i][j].setActionCommand("i"+i+"j"+j);
                    button[i][j].setBounds(i * b, j * b, b, b);
                    panel.add(button[i][j]);
                }
            }
        }

        @Override
        public void actionPerformed(ActionEvent e){ //buttonを押した時に実行される行動についてのメソッド
            int key;
            Object cmd=e.getActionCommand(); //Object cmdにActionCommandを代入？
            for(int i=0;i<a;i++){ //マスの数だけ繰り返す
                for(int j=0;j<a;j++){ //マスの数だけ繰り返す
                    if(cmd.equals("i"+i+"j"+j)) {  //もし何かと何かが等しい時に実行
                        key=e.getModifiers();
                        if((key & ActionEvent.SHIFT_MASK) == ActionEvent.SHIFT_MASK){
                            if(flags[i][j]==1){
                                button[i][j].setForeground(Color.LIGHT_GRAY);
                                if(numbers[i][j]==0){
                                    button[i][j].setText("");
                                }else if(numbers[i][j]==10){
                                    button[i][j].setText("●");
                                }else{
                                    button[i][j].setText(String.valueOf(numbers[i][j]));
                                }
                                flags[i][j]=0;
                                break;
                            }
                            flags[i][j]=1;
                            button[i][j].setText("⚐");
                            button[i][j].setForeground(Color.BLACK);
                            break;
                        }
                        if(flags[i][j]==1){
                            button[i][j].setText(String.valueOf(numbers[i][j]));
                        }
                        button[i][j].setEnabled(false); //わからん
                        button[i][j].setBackground(Color.WHITE); //開けた時のボタンの色は白
                        for(int k=0;k<numOfBombs;k++){ //爆弾の数だけ繰り返す
                            if(placeOfBombsY[k]==i && placeOfBombsX[k]==j) { //爆弾を踏んだ時っていうことはわかる
                                JLabel label = new JLabel("GameOver!"); //GameOver!と表示させる
                                label.setForeground(Color.RED); //文字の色の設定
                                label.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 30)); //書体、大きさの設定
                                JOptionPane.showMessageDialog(this, label); //わからん
                            }
                        }
                    }
                }
            }
        }

        void setBombs(){ //爆弾を置くメソッド
            Random random = new Random(); //乱数の設置
            int i=0; //iは0

            start:
            while(i < numOfBombs) { //おしゃれwhile
                placeOfBombsY[i] = random.nextInt(a); //爆弾を設置
                placeOfBombsX[i] = random.nextInt(a); //爆弾を設置
                for(int j=0;j<i;j++){ //jがiより小さい時
                    if(placeOfBombsY[j] == placeOfBombsY[i] && placeOfBombsX[j] == placeOfBombsX[i]){ //爆弾の位置が同じ時
                        continue start; //上のstartに戻る
                    }
                }
                i++; //iにプラス1
            }
            for (i = 0; i < numOfBombs; i++) { //爆弾の数だけ繰り返す
                button[placeOfBombsY[i]][placeOfBombsX[i]].setText("●"); //爆弾の位置に●と表示
            }
        }

        void setNumber(){ //爆弾の周りの数字の設置
            int[] vectorY={-1,-1,0,1,1, 1, 0,-1}; //ベクトルY
            int[] vectorX={ 0, 1,1,1,0,-1,-1,-1}; //ベクトルX

            int[][] numbers=new int[a][a];

            for(int i=0;i<numOfBombs;i++){
                for(int v=0;v<8;v++){
                    try{
                        numbers[placeOfBombsY[i]+vectorY[v]][placeOfBombsX[i]+vectorX[v]]++;
                    }catch(ArrayIndexOutOfBoundsException e){

                    }
                }
            }
            for(int i=0;i<numOfBombs;i++){
                numbers[placeOfBombsY[i]][placeOfBombsX[i]]=0;
            }
            for(int i=0;i<a;i++){
                for(int j=0;j<a;j++){
                    if(numbers[i][j]!=0)button[i][j].setText(String.valueOf(numbers[i][j]));
                }
            }
        }
    }

