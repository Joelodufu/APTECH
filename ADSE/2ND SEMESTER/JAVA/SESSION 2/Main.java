class Main {
    public static void main(String[] args) {
        int age = 5;
        System.out.println(age);
        int nextYearAge = ++age;
        System.out.printf("Initial Age: %d \n", age);
        System.out.printf("Initial Age: %d \n", nextYearAge);
        int lastYearAgeThisYear = age++;
        System.out.printf("Initial Age: %d \n", age);
        System.out.printf("Initial Age: %d \n", nextYearAge);

        System.out.println(nextYearAge);
        System.out.println(lastYearAgeThisYear);
    }

    public static void sayHello() {
        System.out.println("Hello to the World");
    }
}