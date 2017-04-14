
package wilfridostopwatch;
/** Assignment #1 Task 9.1 */
/**author Wilfrido Toribio Espinosa */

import java.util.*;

public class WilfridoStopWatch {
    public static void main(String[] args) {
       
        StopWatch stopwatch = new StopWatch();
      //  System.out.println("Start Time is : " + new Date( ) + stopwatch.startTime + "\n");
        try {
         stopwatch.startTime = System.currentTimeMillis( );
         System.out.println("Start Time is : " + new Date( ) + stopwatch.startTime + "\n");
    
         Thread.sleep(15*60*20);
         
         stopwatch.endTime = System.currentTimeMillis( );
         System.out.println("End Time is : " + new Date( ) + stopwatch.endTime + "\n");
      }catch (Exception e) {
         System.out.println("Got an exception!");
      }
         System.out.println("Elapsed Time is : " + new Date( ) + stopwatch.getElapsedTime() + "\n"); 
    } 
}
class StopWatch {
    long startTime;
    long endTime;
    long elapsedTime;
    java.util.Date currentTime;
StopWatch(){
    startTime = System.currentTimeMillis( );
}
void setStartTime(long startTime) {
    new Date();
    this.startTime = System.currentTimeMillis( );  
}
void setEndTime(long endTime) {
    new Date();
    this.endTime = System.currentTimeMillis( );
}
long getElapsedTime(){
    return endTime - startTime;
    }
}