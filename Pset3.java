class Pset3 {
    public static void main(String[] args) {
        Wallet wallet = new Wallet("0060402", 100.0);
        System.out.println("Initial Money: " + wallet.getMoney());
        wallet.payday(30.0);  
        System.out.println("After adding: " + wallet.getMoney());
        wallet.pay(20.0);  
        System.out.println("After subtracting: " + wallet.getMoney());

        Rectangle rect = new Rectangle(5.0, 3.0);
        Circle circ = new Circle(4.0);
        System.out.println("Rectangle Area: " + rect.area());
        System.out.println("Circle Area: " + circ.area());
    }
}

class Wallet {
    private String id;  
    private double money;

    public Wallet(String idNum, double initialMoney) {
        id = idNum;
        money = initialMoney;
    }


    public double getMoney() {
        return money;
    }

    public String getId() {
        return id;
    }

    public void payday(double amount) {
        money += amount;
    }

   
    public void pay(double amount) {
        money -= amount;
    }
}

class Shape{


    public double area(){
        return 2.0;


    }

    class Rectangle extends Shape{
        double length;
        double width;

        public Rectangle(double l, double w){

            length = l;
            width = w;
        }

        public double area(){

            return length * width;
        }

    }

    class Circle extends Shape{
        double radius;

        public Circle(double c){

            radius = c;
        }

        public double area(){

            return radius * radius * 3.142;
        }




    }
}

