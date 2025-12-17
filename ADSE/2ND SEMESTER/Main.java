public class Main {

    public static void main(String[] args) {
        // numeric data and operations
        int a = 5;
        int b = 10;
        int sum = a + b;
        int difference = a - b;
        int product = a * b;
        int remainder = a % b;
        double quotient = (double) b / a;

        //Byte Operations
        byte byte1 = 5;
        byte byte2 = 10;
        byte byteSum = (byte) (byte1 + byte2);
        byte byteDifference = (byte) (byte1 - byte2);
        byte byteProduct = (byte) (byte1 * byte2);
        byte byteRemainder = (byte) (byte1 % byte2);
        float byteQuotient = (float) byte2 / byte1;

        

        // //Display Byte operation results
        // print(byteSum);
        // print(byteDifference);
        // print(byteProduct);
        // print(byteRemainder);
        // print(byteQuotient);
        
        // // displaying results
        // print(sum);
        // print(difference);
        // print(product);
        // print(remainder);
        // print(quotient);



    }

    public static void print(String message) {
        System.out.println(message);
    }
    public static void print(int message) {
        System.out.println(message);
    }
    public static void print(double message) {
        System.out.println(message);
    }
    public static void print(float message) {
        System.out.println(message);
    }

    public static void print(char message) {
        System.out.println(message);
    }
    
    // Overloading for printing bytes
    public static void print(byte message) {
        System.out.println(message);
    }
}