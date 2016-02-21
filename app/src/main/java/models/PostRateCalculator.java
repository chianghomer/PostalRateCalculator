package models;

/**
 * Created by Baizhong Zhang on 2016/2/20.
 */
public class PostRateCalculator {
    public double width, depth, height, weight;
    public double postRate;

    public PostRateCalculator(double width, double depth, double height, double weight) {
        this.width = width;
        this.depth = depth;
        this.height = height;
        this.weight = weight;
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

        double rate = 0.0;
        if((width < 140.0)||(depth < 90.0)||(height < 0.18)||(width > 380.0)||(depth > 270.0)||(height > 20)||(weight > 500)){
            rate = -1;
        }
        else{
            if(((width <= 245.0)&&(depth <= 156.0)&&(height <= 5.0)) && (weight <= 50)){
                if(weight<= 30){
                   rate = 1.00;
                }
                else {
                    rate = 1.20;
                }
            }
            else{
                if(weight <= 100.00){
                    rate = 1.80;
                }
                else if((weight>100.00)&&(weight<=200.00)){
                    rate = 2.95;
                }
                else if((weight>200.00)&&(weight<=300.00)){
                    rate = 4.10;
                }
                else if((weight>300.00)&&(weight<=400.00)){
                    rate = 4.70;
                }
                else if((weight>400.00)&&(weight<=500.00)){
                    rate = 5.05;
                }
            }
        }
        return rate;

    }
    public double calculatePostRateUSA(){
        double rate = 0.0;
        if((width < 140.0)||(depth < 90.0)||(height < 0.18)||(width > 380.0)||(depth > 270.0)||(height > 20)||(weight > 500)){
            rate = -1;
        }
        else{
            if(((width <= 245.0)&&(depth <= 156.0)&&(height <= 5.0)) && (weight <= 50)){
                if(weight<= 30){
                    rate = 1.20;
                }
                else {
                    rate = 1.80;
                }
            }
            else{
                if(weight <= 100.00){
                    rate = 2.95;
                }
                else if((weight>100.00)&&(weight<=200.00)){
                    rate = 5.15;
                }
                else if((weight>200.00)&&(weight<=500.00)){
                    rate = 10.30;
                }
            }
        }
        return rate;
    }
    public double calculatePostRateWorld(){
        double rate = 0.0;
        if((width < 140.0)||(depth < 90.0)||(height < 0.18)||(width > 380.0)||(depth > 270.0)||(height > 20)||(weight > 500)){
            rate = -1;
        }
        else {
            if(((width <= 245.0)&&(depth <= 156.0)&&(height <= 5.0)) && (weight <= 50)){
                if(weight<= 30){
                    rate = 2.50;
                }
                else {
                    rate = 3.60;
                }
            }
            else{
                if(weight <= 100.00){
                    rate = 5.90;
                }
                else if((weight>100.00)&&(weight<=200.00)){
                    rate = 10.30;
                }
                else if((weight>200.00)&&(weight<=500.00)){
                    rate = 20.60;
                }
            }
        }
        return rate;
    }

}
