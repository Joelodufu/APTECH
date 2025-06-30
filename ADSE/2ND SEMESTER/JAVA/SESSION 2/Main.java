class Main{
    public static void main(String[] args){
        // EXPLORING ESCAPE SEQUENCES
        // New Line
        printSessionTitle("NEW LINE");
        printThis("Hello, World!\nWelcome to Java Programming!");

        //T A B S
        printSessionTitle("TABS");
        printThis("Name:\tJohn Doe\nAge:\t25\nLocation:\tUSA");


        //DOUBLE QUOTES
        printSessionTitle("DOUBLE QUOTES");
        printThis("She said, \"Hello, World!\"😂😂 with a smile.");


        //BACK SLASH
        printSessionTitle("BACK SLASH");
        printThis("To escape a backslash, use two: \\\\");

        //Backspace
        printSessionTitle("BACKSPACE");
        printThis("Hello, World!\b\b\b\b\b\bJava!"); // Removes "World" and replaces it with "Java!"

        //formart Printing
        printSessionTitle("FORMATTED PRINTING");
        String name = "Alice";
        int age = 30;
        double height = 5.5;
        // Using printf
        System.out.printf("Name: %s\nAge: %d\nHeight: %.1f feet\n", name, age, height);

        
    }

     static void printThis(String message){
        System.out.println(message);
    }

    static void printSessionTitle(String title){
        System.out.println( title + "\n________________________");

    }
}