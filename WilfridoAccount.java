
package wilfridotestaccount;

/** Assignment #1 Task 9.7 */
/**author Wilfrido Toribio Espinosa */

import java.util.*;
public class WilfridoAccount {
    int id;
    String name;
    double balance;
    double annualInterestRate;
    Date dateCreated = new Date();
    double withDraw;
    double deposit;
    double currentBalance;
    double monthlyInterestRate;
 public WilfridoAccount() {
    id = 1122;
    name = "Checking Account";
    balance = 20000;
    annualInterestRate =  4.5;
    withDraw = 2500;
    deposit = 3000;
 }
public WilfridoAccount(int id, String name, double balance,double annualInterestRate, double deposit, double withDraw) {
    this.id = id;
    this.name = name;
    this.balance = balance;
    this.annualInterestRate = annualInterestRate;
    this.dateCreated = dateCreated;
    this.withDraw = withDraw;
    this.deposit = deposit;
} 
public void setID(int id) {
    this.id = id;
}
public void setName(String name) {
    this.name = name;
}
public void setBalance(double balance) {
    this.balance = balance;
}
public void setAnnualInterestRate(double annualInterestRate) {
    this.annualInterestRate = annualInterestRate;
}
public void setDateCreated (Date dateCreated) {
    this.dateCreated = dateCreated;
}
public Date gettDateCreated () {
    return this.dateCreated;
}
public void setWithDraw(double withDraw) {
    this.withDraw = withDraw;
}
public void setDeposit(double deposit) {
    this.deposit = deposit;
}
public double getMonthlyInterest() {
    monthlyInterestRate = annualInterestRate / 12;
    return Math.round(this.balance * this.monthlyInterestRate / 100);
}
public double getCurrentBalance(){
    return currentBalance = this.balance + this.deposit - this.withDraw;
 }
public double getNewMonthlyInterest() {
    monthlyInterestRate = this.annualInterestRate / 12;
    return Math.round(currentBalance * monthlyInterestRate / 100);
    }
}    

