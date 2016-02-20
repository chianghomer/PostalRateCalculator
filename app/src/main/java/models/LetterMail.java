package models;

/**
 * Created by Baizhong Zhang on 2016/2/20.
 */
public class LetterMail {
    public double width,depth,height,weight;
    public String destination;

    public LetterMail(){

    }

    public double getWidth(){
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getDepth() {
        return depth;
    }

    public double getWeight() {
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
        if(destination.isEmpty()){
            return "Please select your destination";
        }
        else {
            return destination;
        }
    }


}
