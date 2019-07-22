package task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class Minesweeper extends JFrame implements ActionListener {

    private static int easy[] = {8, 50, 10};
    private static int normal[] = {16, 30, 40};
    private static int hard[] = {24, 20, 100};
    private static int x = easy[0];
    private static int b = easy[1];
    private static int boms = easy[2];
    private static int ex = x * x;
    private static int bom[] = new int[boms];
    private static int num[] = new int[ex];
    private static int btn;
    private static String cmd;
    private static String numb;
    JButton button[] = new JButton[ex];
    JPanel panel = new JPanel();


    Minesweeper(String title) {
        setTitle(title);
        setLocationRelativeTo(null);
        setSize(x * b, x * b + 22);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLAF();
        DrawBotton();
        DrawBoms();
        setNumber();

        getContentPane().add(panel, BorderLayout.CENTER);

    }


    void DrawBotton() {
        int btn;

        panel.setLayout(null);

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                btn = i * x + j;
                button[btn] = new JButton();
                button[btn].setBackground(Color.LIGHT_GRAY);
                button[btn].setBounds(i * b, j * b, b, b);
                button[btn].addActionListener(this);
                button[btn].setActionCommand("a" + btn);
                panel.add(button[btn]);
            }
        }

    }

    void DrawBoms() {

        Random random = new Random();

        for (int i = 0; i < boms; i++) {
            bom[i] = random.nextInt(ex);
        }
        for (int i = 0; i < boms; i++) {
            bm:
            {
                //button[bom[i]].setText("●");

                //button[bom[i]].setActionCommand("a"+bom[i]);

                for (int j = 0; j < boms; j++) {
                    if (i == j) {
                    } else if (bom[i] == bom[j]) {
                        bom[i] = random.nextInt(ex);
                        i = 0;
                        break bm;
                    }
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int key;
        cmd = e.getActionCommand();
        for (int i = 0; i < ex; i++) {
            if (cmd.equals("a" + i)) {

                key = e.getModifiers();

                if ((key & ActionEvent.SHIFT_MASK) == ActionEvent.SHIFT_MASK) {

                    button[i].setText("⚐");
                }

                if (num[i] < 10) {

                    numb = "" + num[i];

                    button[i].setEnabled(false);
                    button[i].setBackground(Color.WHITE);

                    if (num[i] != 0) {
                        button[i].setText(numb);
                    }
                }
            }
        }
    }

    void setNumber() {
        int l;
        out:
        for (int i = 0; i < boms; i++) {
            num[bom[i]] = 10;

            if (bom[i] == 0) {

                num[bom[i] + 1]++;
                num[bom[i] + x]++;
                num[bom[i] + x + 1]++;

            } else if (bom[i] == x - 1) {

                num[bom[i] - 1]++;
                num[bom[i] + x]++;
                num[bom[i] + x - 1]++;

            } else if (bom[i] == ex - x) {

                num[bom[i] - x]++;
                num[bom[i] - x + 1]++;
                num[bom[i] + 1]++;

            } else if (bom[i] == ex - 1) {

                num[bom[i] - x]++;
                num[bom[i] + x - 1]++;
                num[bom[i] - 1]++;

            } else if (bom[i] < x) {

                num[bom[i] - 1]++;
                num[bom[i] + 1]++;
                num[bom[i] + x - 1]++;
                num[bom[i] + x]++;
                num[bom[i] + x + 1]++;

            } else if (bom[i] < ex && bom[i] > ex - x) {

                num[bom[i] - 1 - x]++;
                num[bom[i] - x]++;
                num[bom[i] - x + 1]++;
                num[bom[i] - 1]++;
                num[bom[i] + 1]++;

            } else {
                for (int j = 0; j < x; j++) {
                    l = j * x;

                    if (bom[i] == 1) {

                        num[bom[i] - x]++;
                        num[bom[i] - x + 1]++;
                        num[bom[i] + 1]++;
                        num[bom[i] + x]++;
                        num[bom[i] + x + 1]++;

                        continue out;
                    }
                }
                for (int j = 0; j < x; j++) {
                    l = j * x - 1;

                    if (bom[i] == l) {

                        num[bom[i] - x - 1]++;
                        num[bom[i] - x]++;
                        num[bom[i] - 1]++;
                        num[bom[i] + x - 1]++;
                        num[bom[i] + x]++;

                        continue out;
                    }
                }
                num[bom[i] - x - 1]++;
                num[bom[i] - x]++;
                num[bom[i] - x + 1]++;
                num[bom[i] - 1]++;
                num[bom[i] + 1]++;
                num[bom[i] + x - 1]++;
                num[bom[i] + x]++;
                num[bom[i] + x + 1]++;

            }
        }
    }

    void setLAF() {
        try {

            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
