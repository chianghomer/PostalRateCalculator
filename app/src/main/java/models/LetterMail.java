package models;

/**
 * Created by Baizhong Zhang on 2016/2/20.
 */
public class LetterMail {
    public int width,depth,height,weight;
    public String destination;

    public LetterMail(){

    }

    public int getWidth(){
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDepth() {
        return depth;
    }

    public int getWeight() {
        return weight;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void setDestination(String destination) {

        this.destination = destination;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getDestination() {
        return destination;
    }

}
