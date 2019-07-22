package task03;

public class Mapdata {
    private final int mapsize[] = {20, 32};
    private int a;
    private int b;

    Mapdata(){
        this.a = mapsize[0];
        this.b = mapsize[1];
    }

    public int getA(){
        return a;
    }
    public void setA(int A){
        this.a=a;
    }
    public int getB(){
        return b;
    }
    public void setB(int B){
        this.a=b;
    }

}
