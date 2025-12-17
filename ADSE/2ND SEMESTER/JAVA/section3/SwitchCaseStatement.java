public class SwitchCaseStatement {
    public static void main(String[] args) {
        int score = 85;
        switch (score) {
            case 100:
            case 90:
                System.out.println("Grade A");
                break;
            case 80:
                System.out.println("Grade B");
                break;
            case 70:
                System.out.println("Grade C");
                break;
            case 60:
                System.out.println("Grade D");
                break;
            default:
                System.out.println("Grade F");
        }
    }
}
