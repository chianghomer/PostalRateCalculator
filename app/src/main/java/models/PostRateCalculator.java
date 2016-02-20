package models;

/**
 * Created by Baizhong Zhang on 2016/2/20.
 */
public class PostRateCalculator {
    public double width, depth, height, weight;
    public double postRate;

    public PostRateCalculator() {
    }

    public double calculatePostRateFromDest(String destination){
        if(destination.equalsIgnoreCase("canada")){
            postRate = calculatePostRateCanada(width,depth, height, weight);
        }
        else if((destination.equalsIgnoreCase("usa"))||(destination.equalsIgnoreCase("United State"))){
            postRate = calculatePostRateUSA();
        }
        else if(destination.equalsIgnoreCase("international")){
            postRate = calculatePostRateWorld();
        }
        else{// if destination is empty
            invalidInput();
        }
        return postRate;
    }
    public String invalidInput(){
        return "Please select your destination";
    }
    public double calculatePostRateCanada(double width, double depth, double height, double weight){

        return 0;
    }
    public double calculatePostRateUSA(){
        return 0;
    }
    public double calculatePostRateWorld(){
        return 0;
    }

}
