public interface Payment {
    void makePayment(double amount);    
}

//impliment using cash payment
class CashPayment implements Payment {

    @Override
    public void makePayment(double amount) {
        System.out.println("Payment of " + amount + " made using Cash.");
    }
}

//impliment using card payment
class CardPayment implements Payment {

    @Override
    public void makePayment(double amount) {
        System.out.println("Payment of " + amount + " made using Card.");
    }
}   

//impliment using online payment
class OnlinePayment implements Payment {

    @Override
    public void makePayment(double amount) {
        System.out.println("Payment of " + amount + " made using Online Payment.");
    }
}

//impliment using bank transfer payment

class BankTransferPayment implements Payment {
    String recieversName;
    String bankName;
    String accountNumber;

    //constructor
    public BankTransferPayment(String recieversName, String bankName, String accountNumber) {
        this.recieversName = recieversName;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
    }

    @Override
    public void makePayment(double amount) {
        System.out.println("Payment of " + amount + " made using Bank Transfer.");
    }
}

public class SomethingElse {

    public void makePayment(double amount) {
        System.out.println("Payment of " + amount + " made using Bank Transfer.");
    }
}

public class InnerPayment {

    public static void main(String[] args) {

        };
       
    }
}