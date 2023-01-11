package eecs1022.lab7.bank.model;


public class Transaction {
    //Attributes
    private String status;
    private double balance;
    private String action;


    //Constructor
    public Transaction(String action, double amount){
        this.action=action;
        this.balance=amount;
        this.status = "Transaction " + this.action + ": $" + String.format("%.2f", this.balance);

    }

    //Assessor method
    public String getStatus(){
        return this.status;
    }




}