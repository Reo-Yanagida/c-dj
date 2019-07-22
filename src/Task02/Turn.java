package task02;

public class Turn {
    private String turn;
    Turn(String turn){
        this.turn=turn;
    }

    public void turnChange(String turn){
        if(turn.equals("B")){
            this.turn="W";
        }else {
            this.turn="B";
        }
    }

    public String getTurn() {
        return turn;
    }

    public void setTurn(String turn) {
        this.turn = turn;
    }

}
