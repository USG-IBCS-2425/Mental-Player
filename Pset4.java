import java.util.*;

class Student {
    // two instance variables for a student
    // 1. their raffle number
    // 2. their name
    int rafNum; 
    String name; 

// constructor method for student creates
    // each student with a random raffle number
    public Student(String n) {
        name = n;
        rafNum = (int)(Math.random() * 10000);
    }

    // getters for the instance variables
    public int getNum() {
        return rafNum;
    }

    public String getName() {
        return name;
    }
}

class Raffle {
        // we need an array for students and an array of raffle nums

    Student[] sArr;
    int[] rafNums;
    String winners;

    // constructor for raffle requires giving it
    // a student array as input

    
    public Raffle(Student[] s) {
        // the student array should just be whatever
        // was passed in as the parameter
        winners = "";
        sArr = s;
        // need to create a empty array of integers first
        rafNums = new int[s.length];

        // loop through the array to set values
        // equal to each student's number
        for (int i = 0; i < sArr.length; i++) {
                        // sArr[i] is a student

            rafNums[i] = sArr[i].getNum();
        }
    }

    // use a loop to print each number in the array

    public void printRafNums() {
        for (int n : rafNums) {
            System.out.println(n);
        }
    }

    public Student getWinner() {
                // choose an integer between 0-4


        int choice = (int)(Math.random() * 10);
        //other way to get new winner
        // Student tempWinner = sArr[choice];
        //String tempName = tempWinner.getName();

        if (winners.contains (sArr[choice].getName())){
            //get a new winner
             choice = (int)(Math.random()*sArr.length);
        }

        winners = winners + sArr[choice].getName();
                //print the winning number

        System.out.println("The winning number is: " + rafNums[choice]);

        return sArr[choice];
    }
}

class Pset4 {
    public static void main(String[] args) {
    
        Student s1 = new Student("Vera");
        Student s2 = new Student("Lisa");
        Student s3 = new Student("Amy");
        Student s4 = new Student("Abby");
        Student s5 = new Student("Trinity");
        Student s6 = new Student("Lyzane");
        Student s7 = new Student("Doris");
        Student s8 = new Student("Jaein");
        Student s9 = new Student("Femke");
        Student s10 = new Student("Di");

        Student[] s = {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10};

        Raffle r = new Raffle(s);
        r.printRafNums();
        
        for(int i=0; i<3;i++){

               Student win = r.getWinner();
        System.out.println(win.getName() + " is the winner!");

        }

    }
}




