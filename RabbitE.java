class RabbitE{
    String enclosureTitle = "Default"; 
    String rabbitList = "";
    int totalRabbits = 0; 

    void setEnclosureTitle(String title) {
        enclosureTitle = title; 
    }

    void addRabbit(Rabbit nameRabbit) {
        if (totalRabbits > 0) {
            rabbitList += ", "; 
        }
      rabbitList += nameRabbit.getName() + " (The breed of rabbit: " + nameRabbit.getBreed() + " )"; 
    totalRabbits++; 
    }

    String getRabbitNames() {
        return rabbitList; 
    }

    int getTotalRabbits() {
        return totalRabbits; 
    }

    
        

    public static void main(String[] args) {
        RabbitE enclosure = new RabbitE(); 
        enclosure.setEnclosureTitle("Bunny Bunny!!"); 

        Rabbit r1 = new Rabbit("woon", 3, "White", 1.0, "Angora rabbit");
        enclosure.addRabbit(r1); 
        
        Rabbit r2 = new Rabbit("rumi", 4, "Black", 1.4, "American Fuzzy Lop");
        enclosure.addRabbit(r2); 
        
        Rabbit r3 = new Rabbit("kura", 2, "Brown", 1.2, "Lionhead rabbit");
        enclosure.addRabbit(r3); 

        System.out.println("Total number of rabbits in the enclosure: " + enclosure.getTotalRabbits()); 
        System.out.println("Name of rabbits in the enclosure: " + enclosure.getRabbitNames()); 
    }
    }

