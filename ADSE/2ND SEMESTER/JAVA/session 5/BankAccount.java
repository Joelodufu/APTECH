public class BankAccount {
    private int accountBallance = 1000;

    public void withdraw(int ammount) {
        if (ammount <= accountBallance) {
            accountBallance -= ammount;
            System.out.println("Withdrawal: " + ammount + "\n" + "Ballance: " + accountBallance);
        } else {
            System.out.println("Insufficient Ballance: " + accountBallance);
        }
    }

    public int getAccountBallance() {
        System.out.println(this.accountBallance);
        return accountBallance;
    }
}
