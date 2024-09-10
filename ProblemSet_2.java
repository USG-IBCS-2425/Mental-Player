class ProblemSet_2 {
    public static void main(String[] args) {
        String name = "Lisa";
        String date = "2024/9/06";

        System.out.println(name);
        System.out.println(date);
        System.out.println();
        System.out.println();

        int x = 5;
        System.out.println(x + " students are in our class.");

        System.out.println("A new student is enrolled in the class!");

        x += 1;
        System.out.println(x + " students are in our class.");

        if (x < 3) {
            System.out.println("Class is canceled.");
        } else {
            System.out.println("Class will continue.");
        }

        int nameLength = name.length();
        x -= nameLength;


        if (x < 3) {
            System.out.println("Class is canceled.");
        } else {
            System.out.println("Class will continue.");
        }

		boolean isDivisible = true;

        if (x % 3 == 0) {
        	isDivisible = true;
        	System.out.print(isDivisible);
            System.out.print("The number of groups is " + (x / 3));
        } else {
        	isDivisible = false;
            int remainder = x % 3;
            int need = 3 - remainder;
            System.out.println("We need " + need + " more people to make it work.");
        }
    }
}
