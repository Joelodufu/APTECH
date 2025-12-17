public class NestedIfStatement {
    public static void main(String[] args) {
        int score = 59;
        if (score >= 60) {
            if (score >= 70) {
                if (score >= 90) {
                    System.out.println("Grade A");
                } else {
                    System.out.println("Grade B");

                }
            } else {
                System.out.println("Average");
            }
        } else {
            System.out.println("Failed");
        }
    }
}
