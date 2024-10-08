class ChompBistro{
	String[] employees;  
    String[] menuItems;  
    int dayOfWeek; 

      public ChompBistro(String[] emp, String[] menu) {
        employees = emp;
        menuItems = menu;
        dayOfWeek = 1; 
    }

    public String getEmployees(){
    	String employeeList = "";
        for (int i = 0; i < employees.length; i++) {
            employeeList =　employeeList + employees[i];
            if (i < employees.length - 1) {
                employeeList = employeeList + ", "; 
            }
        }
        return employeeList;

    }

    public String getMenuItems(){
    	String menuList = "";
        for (int i = 0; i < menuItems.length; i++) {
            menuList =　menuList + menuItems[i];
            if (i < menuItems.length - 1) {
                menuList = menuList + ", "; 
           }
        }
        return menuList;

    }

       
  
    public void setDay(int day) {
        if (day >= 1 && day <= 5) {
            dayOfWeek = day;
        }


      public String generateMenu() {
        String menuOfTheDay = "";
        for (int i = 0; i < 3; i++) {
            int randomIndex = (int) (Math.random() * menuItems.length); // Math.random() returns a value between 0.0 and 1.0
            menuOfTheDay = menuOfTheDay + menuItems[randomIndex];
            if (i < 2) {
                menuOfTheDay = menuOfTheDay + ", "; 
            }
       }
        return menuOfTheDay;
    }

   public String whoWorking() {
   
    }


} 

    public static void main(String[] args) {
     	  Scanner scanner = new Scanner(System.in);

    ChompBistro bistro = new ChompBistro(employees, menuItems);

    Scanner scanner = new Scanner(System.in);

        String[] employees = new String[5];
        employees[0] = "Lisa";
        employees[1] = "Amy";
        employees[2] = "Vera";
        employees[3] = "Abby";
        employees[4] = "Trinity";

        String[] menuItems = {"Pasta", "Salad", "Burger", "Pizza", "Soup"};

        System.out.println("Please choose an option:");
        System.out.println("1. See the Menu of the Day");
        System.out.println("2. See who is working today");
        System.out.println("3. Change day");
        System.out.println("4. Exit");

        int choice = scanner.nextInt();

        
      
        if (choice == 1) {
           
            System.out.println("Menu of the Day: " + bistro.generateMenu());
        } else if (choice == 2) {
         
            System.out.println("Who is working today: " + bistro.whoWorking());
        } else if (choice == 3) {
            
            System.out.println("Enter a day (1-5): ");
            int newDay = scanner.nextInt();
            bistro.setDay(newDay);
            System.out.println("Day has been set to: " + bistro.getDay());
        } else if (choice = 4) {
            System.out.println("Please try again.");
        }


}