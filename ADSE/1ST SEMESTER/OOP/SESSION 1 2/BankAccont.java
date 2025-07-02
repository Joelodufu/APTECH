public class BankAccont {
    private String accountName;
    private double balance;

    public BankAccont (String accountNumber, double initialBalance){
        this.accountName= accountNumber;
        this.balance= initialBalance;
    }

    //Getter 
    public double getBalance (){
        return balance;
    }

    //setter
    public void deposit(double ammount){
        if (ammount>0){
            balance+=ammount;
            System.out.println("Deposited $" + ammount + ". New Balance: $" + balance);
        } else{
            System.out.println("Invalid Deposit Ammount");
        }
    }
    public void withdraw(double ammount){
        if (ammount>0 && ammount<=balance){
            balance-=ammount;
            System.out.println("Withdrew $" + ammount + ". New balance : $" + balance);
        }
    }
    
    public static void main(String[] args){
        BankAccont chineduAccount= new BankAccont("12345", 300000.00);
        //get Chindu accont
        chineduAccount.getBalance();

        //deposit into chinedu account
        chineduAccount.deposit(45000.00);
        chineduAccount.getBalance();

        //Withdraw from chinedu account
        chineduAccount.withdraw(34000.00);
        chineduAccount.getBalance();
    }

}
