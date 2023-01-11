package eecs1022.lab7.bank.model;

public class Client {

    //Attributes
    private String name;
    private double Inibalance;
    private String status;
    String[] Statement;
    int nos;
    Transaction trans;


    //Constructor
    public Client(String name, double inibalance){
        this.name=name;
        this.Inibalance=inibalance;
        Statement = new String[10];
        nos=1;


    }

    //Assessor

    public String getName() {
        return this.name;
    }

    public double getBalance() {
        return this.Inibalance;
    }



    public String getStatus(){ //current account balance


        this.status = this.name + ": $" + String.format("%.2f", this.Inibalance);
        return this.status;


    }

    public String[] getStatement(){ //current balance + history transactions
        Statement[0]= this.name + ": $" + String.format("%.2f", this.Inibalance);
        String[] stat = new String[nos];
        for(int i=0; i<nos; i++){
            stat[i]=Statement[i];
        }
        return stat;
    }


    //Mutator methods

    public void deposit(double amount){
        if(nos<10 && amount>0) {
            this.Inibalance+= amount;
            String stat = "Transaction DEPOSIT: $" + String.format("%.2f", amount);
            Statement[nos] = stat;
            nos++;}

        if(amount<=0) {
            this.status= "Error: Non-Positive Amount";
        }
    }

    public void withdraw(double amount){
        if(nos<10) {
            this.Inibalance-=amount;
            String stat = "Transaction WITHDRAW: $" + String.format("%.2f", amount);
            Statement[nos]=stat;
            nos++;}

    }

}