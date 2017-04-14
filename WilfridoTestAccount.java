
package wilfridotestaccount;

import static java.lang.System.exit;
import static java.time.Clock.system;
import java.util.Date;
import java.util.Scanner;

/** This is an extract work from the Assignment #1 Task 9.7 Account class Design*/
/**author Wilfrido Toribio Espinosa */

public class WilfridoTestAccount {
       
    public static void main(String[] args) {
        // Instantiating the object for the account 1
      
        WilfridoAccount oc1;
        oc1 = new WilfridoAccount(); 
        object1(oc1);
        
        // Instantiating the object for the account 2
        WilfridoAccount oc2;
        oc2 = new WilfridoAccount(); 
        object2(oc2);
        
        // Making the call to update the object for the account 2
        updateObject2(oc2);
    }
    public static void object1 (WilfridoAccount oc1){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer number for the Account ID :");
        int id = input.nextInt();
        if (id <= 0) System.exit(0);
        oc1.setID(id);
        System.out.print("Enter the Account Name :");
        String name = input.nextLine();
        oc1.setName(name);
        System.out.print("Enter the Inital Balance :");
        double balance = input.nextDouble();
        if (balance < 0) System.exit(0);
        oc1.setBalance(balance);
        System.out.print("Enter the Annual Interest Rate :");
        double annualInterestRate = input.nextDouble();
        if (annualInterestRate <= 0) System.exit(0);
        oc1.setAnnualInterestRate(annualInterestRate);
        System.out.print("Enter a Deposit if there is any :");
        double deposit = input.nextDouble();
        oc1.setDeposit(deposit);
        System.out.print("Enter a Withdraw if there is any :");
        double withDraw = input.nextDouble();
        oc1.setWithDraw(withDraw);
        
        System.out.println(" ");
        System.out.println(" ");
        
        System.out.println("Scotiabank ");
        System.out.println("Account Date/Time Created: " +  oc1.dateCreated);
        System.out.println("--------------------------------------------");
        System.out.println("Account ID : " + oc1.id);
        System.out.println("Account Name : " + oc1.name);
        System.out.printf("Account Inital Balance : $%10.2f\n", oc1.balance);
        System.out.printf("Account Annual Interest Rate : %2.2f\nl ", oc1.annualInterestRate);
        System.out.println(" ");
        System.out.printf("Account Monthly (Amount)Interest Rate : $%4.2f\n", oc1.getMonthlyInterest());
        System.out.printf("Account Deposit : $%4.2f\n", oc1.deposit);
        System.out.printf("Account WithDraw : $%4.2f\n", oc1.withDraw);
        System.out.println(" ");
        System.out.printf("Account Current Balance : $%4.2f\n", oc1.getCurrentBalance() );
        System.out.printf("Account Monthly (Amount)Interest Rate : $%4.2f\n", oc1.getNewMonthlyInterest());
        System.out.println("********************************************************* ");
        System.out.println(" "); 
    }
    public static void object2 (WilfridoAccount oc2){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer number for the Account ID :");
        int id = input.nextInt();
        oc2.setID(id);
        System.out.print("Enter the Account Name :");
        String name = input.next();
        oc2.setName(name);
        System.out.print("Enter the Inital Balance :");
        double balance = input.nextDouble();
        oc2.setBalance(balance);
        System.out.print("Enter the Annual Interest Rate :");
        double annualInterestRate = input.nextDouble();
        oc2.setAnnualInterestRate(annualInterestRate);
        System.out.print("Enter a Deposit if there is any :");
        double deposit = input.nextDouble();
        oc2.setDeposit(deposit);
        System.out.print("Enter a Withdraw if there is any :");
        double withDraw = input.nextDouble();
        oc2.setWithDraw(withDraw);
        
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("Second Account Object");
        System.out.println("CIBC ");
        System.out.println("Account Date/Time Created: " +  oc2.dateCreated);
        System.out.println("--------------------------------------------");
        System.out.println("Account ID : " + oc2.id);
        System.out.println("Account Name : " + oc2.name);
        System.out.printf("Account Inital Balance : $%4.2f\n", oc2.balance);
        System.out.printf("Account Annual Interest Rate : %2.2f\n", oc2.annualInterestRate);
        System.out.println(" ");
        System.out.printf("Account Monthly (Amount)Interest Rate : $%4.2f\n", oc2.getMonthlyInterest());
        System.out.printf("Account Deposit : $%4.2f\n", oc2.deposit);
        System.out.printf("Account WithDraw : $%4.2f\n", oc2.withDraw);
        System.out.println(" ");
        System.out.printf("Account Current Balance : $%4.2f\n", oc2.getCurrentBalance() );
        System.out.printf("Account Monthly (Amount)Interest Rate : $%4.2f\n", oc2.getNewMonthlyInterest());
        System.out.println("******************************************************************* ");
        System.out.println(" ");  
    }
    public static void updateObject2 (WilfridoAccount oc2){
        Scanner input = new Scanner(System.in);
        System.out.println("The current account ID is :" + oc2.id);
        System.out.print("Enter a new Account ID or Press enter :");
        int id = input.nextInt();
        oc2.setID(id);
        String response = input.nextLine();
        System.out.println("The curremt Account Name is :" + oc2.name);
        System.out.print("Enter a new Account Name or Press Enter :");
        String name = input.nextLine();
        oc2.setName(name);
        oc2.name = input.nextLine();
        System.out.println("The current Inital Balance is :" + oc2.balance);
        System.out.print("Enter a new Inital Balance or Press Enter :");
        double balance = input.nextDouble();
        oc2.setBalance(balance);
        oc2.balance = input.nextDouble();
        System.out.println("The current Annual Interest Rate is :" +oc2.annualInterestRate);
        System.out.print("Enter a new Annual Interest Rate or Press Enter :" +oc2.annualInterestRate);
        double annualInterestRate = input.nextDouble();
        oc2.setAnnualInterestRate(annualInterestRate);
        oc2.annualInterestRate = input.nextDouble();
        System.out.println("The current Deposit Import is :" + oc2.deposit);
        System.out.print("Enter a new Deposit Amount or Press Enter :" + oc2.deposit);
        double deposit = input.nextDouble();
        oc2.setDeposit(deposit);
        System.out.println("The current Withdraw Amount is :" +oc2.withDraw);
        System.out.print("Enter a new Withdraw Amount or Press Enter :" +oc2.withDraw);
        double withDraw = input.nextDouble();
        oc2.setWithDraw(withDraw);
        
        System.out.println("Modifiyng some attributes on the Second account objectt");
        System.out.println("CIBC ");
        System.out.println("Account Date/Time Created: " +  oc2.dateCreated);
        System.out.println("--------------------------------------------");
        System.out.println("Account ID : " + oc2.id);
        System.out.println("Account Name : " + oc2.name);
        System.out.printf("Account Inital Balance : $%4.2f\n", oc2.balance);
        System.out.printf("Account Annual Interest Rate : %2.2f\n",  oc2.annualInterestRate);
        System.out.println(" ");
        System.out.printf("Account Monthly (Amount)Interest Rate : $%4.2f\n", oc2.getMonthlyInterest());
        System.out.printf("Account Deposit : $%4.2f\n", oc2.deposit);
        System.out.printf("Account WithDraw :$%4.2f\n", oc2.withDraw);
        System.out.println(" ");
        System.out.printf("Account Current Balance : $%4.2f\n", oc2.getCurrentBalance() );
        System.out.printf("Account Monthly New Amount Interest Rate : $%4.2f\n", oc2.getNewMonthlyInterest());
        System.out.println("************************************************************ ");  
    }
}
