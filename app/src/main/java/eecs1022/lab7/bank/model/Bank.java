package eecs1022.lab7.bank.model;

public class Bank {

    //Attributes
    String status;
    Client[] client;
    int noc;
    boolean lastError;


    //Constructor
    public Bank() {
        noc=0;
        client = new Client[6];
        status = "Accounts: {}";

    }

    //Assessor
    public String getStatus() {

        if(lastError==false) {
            status="Accounts: {";
            for(int i=0; i<noc; i++) {
                if(i<(noc-1)) {
                    status+= client[i].getStatus() + ", ";
                }
                else if(i==(noc-1)) {
                    status+= client[i].getStatus();
                }

            }

            status+="}";
        }
        return this.status;
    }

    public String[] getStatement(String name) {
        String[] stat=null;
        boolean exists =false;
        int length=0;


        for(int i=0; i<noc; i++) {
            if(client[i].getName().equals(name)) {
                exists =true;
                length= client[i].getStatement().length;
            }
        }

        if(length>0) {
            stat = new String[length];
            for(int i=0; i<noc; i++) {
                if(client[i].getName().equals(name)) {
                    stat=client[i].getStatement();
                }
            }
        }

        if(exists==false) {
            this.status = "Error: From-Account "+name+" does not exist";
            this.lastError=true;
        }
        return stat;
    }

    public String printStatement(String name){
        String pstat ="";
        int count=0;
        if(getStatement(name)!= null){
        for(int i = 0; i<getStatement(name).length; i++){
            if(i==(getStatement(name).length-1)){
                pstat+= getStatement(name)[i];
                count++;
            }

            else pstat+= getStatement(name)[i] + ", ";
            count++;
        }}

        if(count==0){pstat = "Error: From-Account "+name+ " does not exist";}
        return pstat;
    }


    //Mutator method
    public void deposit(String name, double value) {
        boolean error = true;
        for(int i=0; i<noc; i++) {
            if(client[i].getName().equals(name)) {
                error=false;
                if(value>0) {
                    client[i].deposit(value);

                    this.lastError=false;}
            }
        }

        if(error==true) {
            this.lastError=true;
            this.status = "Error: To-Account "+ name +" does not exist";
        }

        else if(value<=0) {
            this.lastError=true;
            this.status= "Error: Non-Positive Amount";
        }

    }


    public void withdraw(String name, double value) {
        double balance=0;
        boolean error = true;
        for(int i=0; i<noc; i++) {
            if(client[i].getName().equals(name)) {
                error=false;
                balance=client[i].getBalance();
                if(value>0 && value<=balance) {
                    client[i].withdraw(value);

                    this.lastError=false;}
            }
        }

        if(error==true) {
            this.lastError=true;
            this.status = "Error: From-Account "+ name +" does not exist";
        }
        else if(value<=0) {
            this.lastError=true;
            this.status= "Error: Non-Positive Amount";
        }

        else if(value>balance) {
            this.lastError=true;
            this.status= "Error: Amount too large to withdraw";
        }


    }

    public void transfer(String From, String to, double value) {
        boolean fromaccount = false;
        boolean toAccount=false;
        double balance=0;
        for(int i=0; i<noc; i++) {
            if(client[i].getName().equals(From)) {
                fromaccount=true;
                balance=client[i].getBalance();
                if(value>0 && value<=balance) {
                    withdraw(From, value);
                    this.lastError=false;}
            }
        }



        for(int i=0; i<noc; i++) {
            if(client[i].getName().equals(to)) {
                toAccount=true;
                if(value>0 && value<=balance) {
                    deposit(to, value);
                    this.lastError=false;}
            }
        }

        if(fromaccount==false) {
            this.lastError=true;
            this.status = "Error: From-Account "+ From +" does not exist";
        }

        else if(toAccount==false) {
            this.lastError=true;
            this.status = "Error: To-Account "+ to +" does not exist";
        }

        else if(value<=0) {
            this.lastError=true;
            this.status = "Error: Non-Positive Amount";
        }

        else if(value>balance) {
            this.lastError=true;
            this.status= "Error: Amount too large to transfer";
        }


    }


    public void addClient(String name, double value) {
        boolean error=false;



        if(value<=0) {
            error=true;
            this.lastError=true;
            this.status= "Error: Non-Positive Initial Balance";
        }

        if(error==false) {
            for(int i=0; i<noc; i++) {
                if(client[i].getName().equals(name)){
                    error=true;
                    this.lastError=true;
                    this.status= "Error: Client " +name+ " already exists";
                }
            }
        }

        if(error==false && (noc<6)) {
            this.status= "Accounts: {" + name+ ": $" +String.format("%.2f", value) +"}";
            client[noc] = new Client(name, value);
            this.lastError=false;
            noc++;
        }

        else if(noc==6) {
            this.lastError=true;
            this.status="Error: Maximum Number of Accounts Reached";
        }
    }
}
