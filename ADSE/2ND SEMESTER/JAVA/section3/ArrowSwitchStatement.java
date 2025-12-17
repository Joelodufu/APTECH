public class ArrowSwitchStatement {
    public static void main(String[] args) {
        int dayOfTheWeek = 2;
        String result = switch (dayOfTheWeek){
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Invalid day";
        };

        String route = "HomePage";

        String navigation = switch (route) {
            case "HomePage" -> "Navigating to Home Page";
            case "LoginPage" -> "Navigating to Login Page";
            case "ProfilePage" -> "Navigating to Profile Page";
            default -> "Unknown route";
        };
        System.out.println(navigation);
    }
}
