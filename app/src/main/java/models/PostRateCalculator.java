package models;

/**
 * Created by Baizhong Zhang on 2016/2/20.
 */
public class PostRateCalculator {
    public int width, depth, height, weight;
    public String destination;

    public PostRateCalculator(int width, int depth, int height, int weight, String destination) {
        this.width = width;
        this.depth = depth;
        this.height = height;
        this.weight = weight;
        this.destination = destination;
    }

    public void calculatePostRate(){
        if(destination.equalsIgnoreCase("canada")){
            calculatePostRateCanada();
        }
        else if((destination.equalsIgnoreCase("usa"))||(destination.equalsIgnoreCase("United State"))){
            calculatePostRateUSA();
        }
        else{
            calculatePostRateWorld();
        }
    }
    public int calculatePostRateCanada(){
        return 0;
    }
    public int calculatePostRateUSA(){
        return 0;
    }
    public int calculatePostRateWorld(){
        return 0;
    }
}
