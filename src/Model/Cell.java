package Model;

/**
 * Created by mark on 10-3-2017.
 */
public class Cell {
    private int x;
    private int y;
    private char content;

    public Cell(int x, int y, char content){
        this.x= x;
        this.y= y;
        this.content= content;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getContent() {
        return content;
    }

    public void setContent(char content) {
        this.content = content;
    }
}
