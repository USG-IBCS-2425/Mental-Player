import java.util.*;

class LoopArrayPractice{

	public static void main(String[] args) {

		int[]arr1 = {1,2,3,4,5,6};
		int[]arr2 = {1,2,3,4,5,6,7};
		
		System.out.println("Middle value of array1: " + middleValue(arr1));

		  String[] numString = {"Lisa", "Amy", "Abby", "Trinity", "Lisa"};
        String x = "Lisa"; 
        System.out.println("Number of matches for '" + x + "': " + numMatches(numString, x));

         int[] ascendingArray = {2, 3, 8, 8, 9};
        System.out.println("inOrder (ascending): " + inOrder(ascendingArray)); 

    
        int[] descendingArray = {9, 8, 8, 3, 2};
        System.out.println("inOrder (descending): " + inOrder(descendingArray));


        String[] words1 = {"Considine", "Phillips", "Vankatesh", "Elliott", "Droubay", "Woolley"};
        
        boolean[] results = doubleLetter(words1);

        for (boolean result : results) {
            System.out.println(result); 
        }


         String[] words2 = {"bob", "jim", "sally", "anna", "joe", "elle", "zbhskdjez"};
        
       

	}

	public static int middleValue(int[]arr){
		int middle;

		if (arr.length % 2 == 0){

			middle = (arr.length / 2) -1;

		}else{


			middle = (arr.length/2);
		}

		return arr[middle];

	}

  public static int numMatches(String[] numString, String x) { 
        int count = 0;

        for (String str : numString) { 
            if (str.equals(x)) {
                count++;
            }
        }

        return count; 
    }

  public static boolean inOrder(int[]isOrder){

  	boolean ascending = true;
       

  		     for (int i = 0; i < 4; i++) {  
            if (isOrder[i] > isOrder[i + 1]) {
                ascending = false;
            }
        }

        return ascending;
       
  }

    public static boolean[] doubleLetter(String[] str) {
        
        boolean[] arr = new boolean[str.length];

        for (int i = 0; i < str.length; i++) {
            String currentWord = str[i];
            arr[i] = false; 

            for (int a = 0; a < currentWord.length() - 1; a++) {
              
                if (currentWord.charAt(a) == currentWord.charAt(a + 1)) {
                    arr[i] = true; 
                }
            }
        }

        return arr;
    }

    //public static String[] bookEnds(String[] originalArr) {
   
       // int validChar = 0;
       // for (String currentWord : originalArr) {
           // if (currentWord.charAt(0) == currentWord.charAt(currentWord.length() - 1)) {
              //  validChar++;
            //}
       // }

    }

