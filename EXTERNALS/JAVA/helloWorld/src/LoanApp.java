import java.util.Scanner;

public class LoanApp {

    public static void main(String[] args) {
        double principal;
        int period;
        float rate;
        double mortgage;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter Principal: ");
        principal = input.nextDouble();
        System.out.print("Enter Rate: ");
        rate = input.nextFloat() / 12;
        System.out.print("Enter Period in years: ");
        period = input.nextInt();
        mortgage = principal
                * ((rate * (Math.pow((1 + rate), period))) / ((rate * (Math.pow((1 + rate), period))) - 1));
        System.out.println(mortgage);
        input.close();

        System.out.print("Your Mortgage is: +" + mortgage);

    }
}