//package sample;
//
//import java.awt.*;
//import java.awt.event.*;
//import java.applet.*;
//import java.io.*;
//import java.net.URL;
//
//public class test extends Applet implements Runnable,KeyListener {
//    Image buffer;//イメージバッファ
//    Graphics bufferg;//バックバッファ
//
//    final int CHIP_SIZE=32;//チップサイズ
//
//    float FrameTime;//１フレームあたりの時間（秒）
//    long waitTime;//現在時刻保存用
//
//    Image ball_image;//ボールイメージ
//    float ball_px,ball_py;//ボール座標
//    float bl_speed;//ボールの速度
//
//    //キーの状態（離している=0、押し続けている=1、押した瞬間=2）
//    int key_states[] = new int[5];//４方向（上=0,下=1,左=2,右=3）＋Ｚキー=4
//
//    //マップデータ
//    int map_data[][] = new int[64][64];//64×64
//    int map_width,map_height;//マップの横幅、高さ（チップ数）
//    Image map_image;//マップチップ画像
//
//    //セルテーブル
//    Mapcell celltbl[] = {
//            new Mapcell(0,0,false),//草原
//            new Mapcell(1,0,true),//芝生Ａ
//            new Mapcell(2,0,true),//芝生Ｂ
//            new Mapcell(3,0,false),//家
//            new Mapcell(4,0,false),//木Ａ
//
//            new Mapcell(5,0,true),//木Ｂ
//            new Mapcell(6,1,true),//城
//            new Mapcell(7,2,true),//海
//            new Mapcell(8,3,true),//塔の上
//            new Mapcell(9,4,true),//塔の下
//
//            new Mapcell(10,0,true),//洞窟
//            new Mapcell(11,0,true),//岩山
//            new Mapcell(12,5,true),//宇宙Ａ
//            new Mapcell(13,5,true),//宇宙Ｂ
//            new Mapcell(14,5,true),//クリスタル
//    };
//
//    //初期化
//    public void init(){
//        Thread t;
//        Dimension d = getSize();
//        MediaTracker mediaT = new MediaTracker(this);
//
//        //ボール画像ロード
//        ball_image = getImage(getDocumentBase(),"chara13.gif");
//        mediaT.addImage(ball_image,0);
//
//        //マップチップ画像ロード
//        map_image = getImage(getDocumentBase(),"map_chip.gif");
//        mediaT.addImage(map_image,0);
//
//        //ロード待ち
//        try{
//            mediaT.waitForAll();
//        }catch(InterruptedException e){}
//
//        //マップデータロード(20×15サイズ)
//        readData("map00.dat",20,15);
//
//        //ball_speed = 128;//ボールの速度。1秒で128ドット。
//
//        //ボールの初期座標(マップ上で4,6の位置)
//        ball_px = 4*32;
//        ball_py = 6*32;
//
//        //現在時刻保存
//        waitTime=System.currentTimeMillis();
//
//        addKeyListener(this);//キー入力リスナー
//        requestFocus();//フォーカス取得
//
//        //スレッドを開始する
//        t = new Thread(this);
//        t.start();
//
//        //バッファを作成する
//        buffer = createImage(d.width,d.height);
//    }
//
//
//    //マップデータを読み込む
//    private void readData(String filename,int max_x,int max_y){
//        int i,x,y;
//        InputStream is = null;
//
//        map_width = max_x;
//        map_height = max_y;
//
//        try{
//            is = new URL(getDocumentBase(),filename).openStream();
//
//            x=y=0;
//            while((i=is.read()) != -1){
//                map_data[x][y]=i;
//                if(++x == map_width){
//                    ++y;
//                    x=0;
//
//                    if(y==map_width)break; //終了条件
//                }
//            }
//            is.close();
//        }catch(IOException e){}
//    }
//
//    //実行
//    public void run(){
//        try{
//            //ここがゲームループ
//            while(true){
//                //１フレーム時間計算（秒）
//                FrameTime = ( System.currentTimeMillis()-waitTime ) /1000.0f;
//                waitTime = System.currentTimeMillis();
//
//                //action();//処理
//                repaint();//描画
//
//                //ちょっと休憩（0.01秒）
//                Thread.sleep(10);
//            }
//        }
//        catch(Exception e){
//        }
//    }
//
//    //描画更新
//    public void update(Graphics g){
//        paint(g);
//    }
//
//    //描画
//    public void paint(Graphics g){
//        int i,j,x,y;
//        int cell_data,gra;
//
//        //バッファのグラフィックコンテキストを取得する
//        if(bufferg == null){
//            bufferg = buffer.getGraphics();
//        }
//
//        //バッファを描画する
//        Dimension d = getSize();
//        bufferg.setColor(Color.white);
//        bufferg.fillRect(0,0,d.width,d.height);
//
//        //マップ描画
//        for(i=0;i<map_height;i++){
//            for(j=0;j<map_width;j++){
//                //セルデータ取得
//                cell_data = map_data[j][i];
//
//                //セルデータからマップグラフィックスを取得
//                gra = celltbl[ cell_data ].gra;
//
//                //マップチップからグラフィックスの位置を取得
//                x = (gra%16)*32;
//                y = (gra/16)*32;
//
//                bufferg.drawImage(map_image,j*32,i*32,(j+1)*32,(i+1)*32,x,y,x+32,y+32,this);
//            }
//        }
//
//        //ボール表示
//        bufferg.drawImage(ball_image,(int)ball_px,(int)ball_py,this);
//
//        //フォント
//        bufferg.setColor(Color.black);
//        bufferg.drawString("マップサイズ("+map_width+","+map_height+")。",10,20);
//        bufferg.drawString("現在の座標は(" +(int)ball_px+ "," +(int)ball_py+ ")。",10,40);
//        bufferg.drawString("現在のマップ上での位置は(" +(int)ball_px/32+ "," +(int)ball_py/32+ ")。",10,60);
//
//        //ウインドウを更新する
//        g.drawImage(buffer,0,0,this);
//    }
//
//
//    //処理
//    /*public void action(){
//
//        Dimension d = getSize();
//
//        //移動処理
//
//        //上
//        if(key_states[0] == 1){
//            ball_py -= FrameTime * ball_speed;
//            //上端
//            if(ball_py < 0){
//                ball_py = 0;
//            }
//        }
//
//        //下
//        if(key_states[1] == 1){
//            ball_py += FrameTime * ball_speed;
//            //下端
//            if(ball_py > d.height-CHIP_SIZE){
//                ball_py = d.height-CHIP_SIZE;
//            }
//        }
//
//        //左
//        if(key_states[2] == 1){
//            ball_px -= FrameTime * ball_speed;
//            //左端
//            if(ball_px < 0){
//                ball_px = 0;
//            }
//        }
//
//        //右
//        if(key_states[3] == 1){
//            ball_px += FrameTime * ball_speed;
//            //右端
//            if(ball_px > d.width-CHIP_SIZE){
//                ball_px = d.width-CHIP_SIZE;
//            }
//        }
//
//        //Zキーを押した時
//        if(key_states[4] == 2){
//            //キーの状態を押し続けに変更。
//            key_states[4] = 1;
//        }
//    }
//
//    //キーが押された瞬間(使わない)
//    public void keyTyped(KeyEvent e){
//    }
//
//    //キーを押している時
//    public void keyPressed(KeyEvent e){
//        int key;
//
//        key=e.getKeyCode();
//
//        switch(key){
//            //上キー
//            case KeyEvent.VK_UP:
//                key_states[0] = 1;
//                break;
//            //下キー
//            case KeyEvent.VK_DOWN:
//                key_states[1] = 1;
//                break;
//            //左キー
//            case KeyEvent.VK_LEFT:
//                key_states[2] = 1;
//                break;
//            //右キー
//            case KeyEvent.VK_RIGHT:
//                key_states[3] = 1;
//                break;
//            //Zキー
//            case KeyEvent.VK_Z:
//                //最初に押した時に2を入れる
//                if(key_states[4] == 0){
//                    key_states[4] = 2;
//                }
//                break;
//        }
//    }*/
//
//    @Override
//    public void keyTyped(KeyEvent e) {
//
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//
//    }
//
//    //キーが放された瞬間
//    public void keyReleased(KeyEvent e){
//        int key;
//
//        key=e.getKeyCode();
//
//        switch(key){
//            //上キー
//            case KeyEvent.VK_UP:
//                key_states[0] = 0;
//                break;
//            //下キー
//            case KeyEvent.VK_DOWN:
//                key_states[1] = 0;
//                break;
//            //左キー
//            case KeyEvent.VK_LEFT:
//                key_states[2] = 0;
//                break;
//            //右キー
//            case KeyEvent.VK_RIGHT:
//                key_states[3] = 0;
//                break;
//            //Zキー
//            case KeyEvent.VK_Z:
//                key_states[4] = 0;
//                break;
//        }
//
//    }
//}
