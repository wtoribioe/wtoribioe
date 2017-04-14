package wilfridostock;
/** Assignment #1 Task 9.1 */
/**author Wilfrido Toribio Espinosa */

public class WilfridoStock {
    public static void main(String[] args) {
        /** Define stock class */
        Stock stock1 = new Stock();
        System.out.println("Symbol : " + stock1.symbol);
        System.out.println("Name : " + stock1.name);
        System.out.println("-------------------------");
        System.out.println("Current Time : " + stock1.toString());
        System.out.println(" ");
        System.out.println("The Previous stock-1 closing Price was " + stock1.previousChangePrice );
        System.out.println("The Current Price stock-1 Price is " + stock1.currentPrice);
        System.out.println("The Percentage change is " + stock1.getPercentageChange());
        System.out.println(" ");
        
        /** Define stock class */
        Stock stock2 = new Stock(43.2, 50.4);
        System.out.println("Current Time : " + stock2.toString());
        System.out.println(" ");
        System.out.println("The Previous stock-2 closing Price was " + stock2.previousChangePrice );
        System.out.println("The Current Price stock-2 Price is " + stock2.currentPrice);
        System.out.println("The Percentage change is " + stock2.getPercentageChange());
        System.out.println(" ");
        
        /** Changing the Current Price */
        System.out.println("Current Time : " + stock2.toString());
        System.out.println(" ");
        System.out.println("**Changed Current Price**");
        System.out.println(" ");
        
        //stock2.currentPrice = 60.5;
        stock2.setCurrentPrice(60.5);
        System.out.println("The Previous stock-2 closing Price was " + stock2.previousChangePrice );
        System.out.println("The Current Price stock-2 Price is " + stock2.currentPrice);
        System.out.println("The Percentage change is " + stock2.getPercentageChange());
    }
}
class Stock {
    String symbol = "ORCL";
    String name = "Oracle Corporation";
    double previousChangePrice;
    double currentPrice;
    java.util.Date dateCreated;
    
Stock(){
    previousChangePrice = 35.5;
    currentPrice = 35.9; 
    dateCreated = new java.util.Date();
}
Stock(double newPreviousChangePrice, double newCurrentPrice){
    previousChangePrice = newPreviousChangePrice;
    currentPrice = newCurrentPrice;
    dateCreated = new java.util.Date();
}
double getPercentageChange(){
    return currentPrice - previousChangePrice;
}
void setClosingPrice(double newClosingPrice){
        previousChangePrice = newClosingPrice;
}
void setCurrentPrice(double newCurrentPrice){
       currentPrice = newCurrentPrice; 
    }
@Override
public String toString() {
    return "Created on " + dateCreated;
   }
}