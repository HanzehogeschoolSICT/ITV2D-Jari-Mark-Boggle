package Model;

import java.util.LinkedList;

/**
 * Created by mark on 10-3-2017.
 */
public class Cell {
    private int x;
    private int y;
    private char content;
    private LinkedList<Cell> neighbors;
    private boolean visited;

    public Cell(int x, int y, char content, boolean visited){
        this.x= x;
        this.y= y;
        this.content= content;
        this.visited= visited;
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

    public LinkedList<Cell> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(LinkedList<Cell> neighbors) {
        this.neighbors = neighbors;
    }

    public boolean Visited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
