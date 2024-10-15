import java.util.*;

class TwentyQuestions{


//array for storing possible answers
 String[]possibleAnswers;
 //keep track of the remaining possible answers
 ArrayList<String> currentPossibleAnswers;
 //store and count the number of questions asked
 int questionsAsked;
 //stores the last question asked
 String lastQuestion;


 public TwentyQuestions(String[]inputPossibleAnswers){
    // store the possible answer in the array
  possibleAnswers = inputPossibleAnswers;
  // initialize the array for keep track of remaining possible answers
  currentPossibleAnswers = new ArrayList<String>();
  for(int i=0; i<possibleAnswers.length;i++){
   currentPossibleAnswers.add(inputPossibleAnswers[i]);
  }

  //initialized the questions asked and last question
  questionsAsked = 0;
  lastQuestion = "";

 }Tg

 public String askQuestion(){
    // increment the question asked as game progrecess
  questionsAsked++;
  //System.out.println(currentPossibleAnswers);
  //base on how many question it has been asked the qustion will change
  if(questionsAsked == 1){
   lastQuestion = "Is it mammal?";

  }else if(questionsAsked == 2){
    //depend on if "deer" is still in the list it will ask question "Is it commonly kept as pet"
   if(currentPossibleAnswers.contains("Deer")){
    lastQuestion = "Is it commonly kept as pet?";
   }else{
    //if it's not "Does it live in water"
    lastQuestion = "Does it live in water?";
   }
//based on current answer the question it will be aske will change
  }else if(questionsAsked == 3){
   if(currentPossibleAnswers.contains("Rabbit")){
    lastQuestion = "Is it a dog?";
   }else if(currentPossibleAnswers.contains("Deer")){
    lastQuestion = "Is it carnivore?";
   }else if(currentPossibleAnswers.contains("Sea Snake")){
    lastQuestion = "Is it reptile?";
   }else{
    lastQuestion = "Does it fly?";
   }

//same logic
  }else if(questionsAsked == 4){

   if(currentPossibleAnswers.contains("Golden Retriever")){
    lastQuestion = "Is it big?";
   }else if(currentPossibleAnswers.contains("Rabbit")){
    lastQuestion = "Is it a cat?";
   }else{
    lastQuestion = "Is it large?";
   }

  }else if(questionsAsked == 5){
   if(currentPossibleAnswers.contains("Ragdoll")){
    lastQuestion = "Does it has long hair?";
   }else{
    lastQuestion = "Does it has long ears?";
   }
  }else{
   lastQuestion = "No more questions.";
  }
  return lastQuestion;
 }

 public void updateAnswers(String userInput){
  if(questionsAsked == 1){
    //if user says "yes" to the first question it will remove
    //all of the non-mammals from the list
   if(userInput.contains("yes")){
    currentPossibleAnswers.remove("Butterfly");
    currentPossibleAnswers.remove("Sea Snake");
    currentPossibleAnswers.remove("Duck");
    currentPossibleAnswers.remove("Shark");
   }else{
    //remove mammals from the list if the user didn't say "yes"
    currentPossibleAnswers.remove("Deer");
    currentPossibleAnswers.remove("Golden Retriever");
    currentPossibleAnswers.remove("Maltese Dog");
    currentPossibleAnswers.remove("Rabbit");
    currentPossibleAnswers.remove("Hamster");
    currentPossibleAnswers.remove("Fox");
    currentPossibleAnswers.remove("Puma");
    currentPossibleAnswers.remove("Ragdoll");
    currentPossibleAnswers.remove("American Shorthair");
   }
  }
  //System.out.println(currentPossibleAnswers);

//same logic 
  if(questionsAsked == 2){
   if(lastQuestion.contains("Is it commonly kept as pet?")){
    if(userInput.contains("yes")){
     currentPossibleAnswers.remove("Deer");
     currentPossibleAnswers.remove("Fox");
     currentPossibleAnswers.remove("Puma");
    }else{
     currentPossibleAnswers.remove("Rabbit");
     currentPossibleAnswers.remove("Golden Retriever");
     currentPossibleAnswers.remove("Maltese Dog");
     currentPossibleAnswers.remove("Hamster");
     currentPossibleAnswers.remove("Ragdoll");
     currentPossibleAnswers.remove("American Shorthair");
    }
   }else{
    if(userInput.contains("yes")){
     currentPossibleAnswers.remove("Butterfly");
     currentPossibleAnswers.remove("Duck");
    }else{
     currentPossibleAnswers.remove("Sea Snake");
     currentPossibleAnswers.remove("Shark");
    }
   }
  }

  //same logic
  if(questionsAsked == 3){

   if(lastQuestion.contains("Is it a dog?")){
    if(userInput.contains("yes")){
     currentPossibleAnswers.remove("Rabbit");
     currentPossibleAnswers.remove("Hamster");
     currentPossibleAnswers.remove("Ragdoll");
     currentPossibleAnswers.remove("American Shorthair");
    }else{
     currentPossibleAnswers.remove("Golden Retriever");
     currentPossibleAnswers.remove("Maltese Dog");
    }

   }else if(lastQuestion.contains("Is it carnivore?")){
    if(userInput.contains("yes")){
     currentPossibleAnswers.remove("Deer");
    }else{
     currentPossibleAnswers.remove("Fox");
     currentPossibleAnswers.remove("Puma");
    }

   }else if(lastQuestion.contains("Is it reptile?")){
    if(userInput.contains("yes")){
     currentPossibleAnswers.remove("Sea Snake");
    }else{
     currentPossibleAnswers.remove("Shark");
    }

   }else{
    if(userInput.contains("yes")){
     currentPossibleAnswers.remove("Duck");
    }else{
     currentPossibleAnswers.remove("Butterfly");
    }
   }
  }
  if(questionsAsked == 4){

   if(lastQuestion.contains("Is it big?")){
    if(userInput.contains("yes")){
     currentPossibleAnswers.remove("Maltese Dog");
    }else{
     currentPossibleAnswers.remove("Golden Retriever");
    }
   }else if(lastQuestion.contains("Is it a cat?")){
    if(userInput.contains("yes")){
     currentPossibleAnswers.remove("Hamster");
     currentPossibleAnswers.remove("Rabbit");
    }else{
     currentPossibleAnswers.remove("Ragdoll");
     currentPossibleAnswers.remove("American Shorthair");
    }

   }else{
    if(userInput.contains("yes")){
     currentPossibleAnswers.remove("Fox");
    }else{
     currentPossibleAnswers.remove("Puma");
    }
   }
  }


  if(questionsAsked == 5){

   if(lastQuestion.contains("Does it has long hair?")){
    if(userInput.contains("yes")){
     currentPossibleAnswers.remove("American Shorthair");
    }else{
     currentPossibleAnswers.remove("Ragdoll");
    }
   }else{
    if(userInput.contains("yes")){
     currentPossibleAnswers.remove("Hamster");
    }else{
     currentPossibleAnswers.remove("Rabbit");
    }
   }
  }
 }


 public String guess(){
    // initialize the string
  String answer = "";
  //if only one possible answer is remaining
  //then answer will be the last remaining answer
  if(currentPossibleAnswers.size() == 1){
   answer = currentPossibleAnswers.get(0);
  }
  return answer;
 }



 public static void main(String[] args) {
    //initialize the 20questios with a list of possible answers
  String[] inputPossibleAnswers = {"Deer","Golden Retriever","Maltese Dog","Rabbit","Hamster","Fox","Puma","Ragdoll","American Shorthair","Butterfly","Sea Snake","Duck","Shark"};
  // new instance of the TwentyQuestions class
  TwentyQuestions t = new TwentyQuestions(inputPossibleAnswers);

  //scanner for user input
  Scanner s = new Scanner(System.in);

  //array list to store answers
  ArrayList<String> answers = new ArrayList<String>();

  while(true){
    //ask the next question base on the current status
   String question = t.askQuestion();
   System.out.println(question);
   //update the currentPossibleAnswers based on user's input (yes/no)
   String userInput = s.nextLine();
   t.updateAnswers(userInput);
   //if only one answer is left, break the loop
   if (t.currentPossibleAnswers.size() == 1) {
    break;
   }
  }
  // the final guess
  String guess = t.guess();
  System.out.println("My guess is: " + guess);
 }

}
