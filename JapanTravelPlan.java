import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class JapanTravelPlan{
	private int budget;
	private String selectedArea;
	private String selectedHotel;
	private int hotelPrice;
	//https://howtodoinjava.com/java/collections/hashmap/java-nested-map/
	private Map<String, Map<String,String[][]>> hotelDatabase;

	public JapanTravelPlan(){
		initializeHotelDatabase();
		showWelcomePage();
	}

private void showWelcomePage(){
	//https://www.geeksforgeeks.org/java-jframe/
	JFrame frame = new JFrame("Welcome to Japan Travel Plan!");
	//https://www.geeksforgeeks.org/java-jframe/
	frame.setSize(600,400);
//https://www.geeksforgeeks.org/jlabel-java-swing/
	JLabel label = new JLabel("Welcome to Japan Travel Plan",SwingConstants.CENTER);
	JButton startButton = new JButton ("Start your plan");

//https://stackoverflow.com/questions/13475255/dispose-a-frame-inside-a-listener-after-3-secs
	startButton.addActionListener( e -> {
		frame.dispose();
		showBudgetPage();
	});
//https://stackoverflow.com/questions/72237283/how-can-i-create-a-frame-with-a-borderlayout-and-assign-each-space-a-component
	frame.setLayout(new BorderLayout());
	frame.add(label,BorderLayout.CENTER);
	frame.add(startButton,BorderLayout.SOUTH);
	frame.setVisible(true);
}

private void showBudgetPage(){
	JFrame frame = new JFrame ("Budget");
	frame.setSize(600,400);

	JLabel label = new JLabel("Enter your budget in Yen:");
	//https://stackoverflow.com/questions/6350797/how-to-set-new-text-in-jtextfield-after-creation
	JTextField enterBudget = new JTextField();
	JButton nextButton = new JButton("Next");

	nextButton.addActionListener(e -> {
		//https://www.w3schools.com/java/java_try_catch.asp
    try {
        budget = Integer.parseInt(enterBudget.getText());
        if (budget <= 0) {
            // If the budget is less than or equal to 0, show an error message
            //https://mkyong.com/swing/java-swing-how-to-make-a-simple-dialog/
            JOptionPane.showMessageDialog(frame, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // If the budget is valid (greater than 0), dispose of the frame and show the next screen
            frame.dispose();
            showAreaSelection();
        }
        //https://www.geeksforgeeks.org/numberformatexception-in-java-with-examples/
    } catch (NumberFormatException ex) {
        // If the input is not a valid number, show an error message
        JOptionPane.showMessageDialog(frame, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
    }
});
	frame.setLayout(new GridLayout(3,1));
	frame.add(label);
	frame.add(enterBudget);
	frame.add(nextButton);
	frame.setVisible(true);

}

private void showAreaSelection(){
	JFrame frame= new JFrame("Area Selection");
	frame.setSize(600,400);

	JLabel label = new JLabel("Choose your area:");
	JButton tokyoButton = new JButton("Tokyo");
	JButton osakaButton = new JButton("Osaka");
	

	tokyoButton.addActionListener(e -> selectArea(frame,"Tokyo"));
	osakaButton.addActionListener(e -> selectArea(frame,"Osaka"));


	frame.setLayout(new GridLayout(4,1));
	frame.add(label);
	frame.add(tokyoButton);
	frame.add(osakaButton);
	frame.setVisible(true);
}

private void selectArea (JFrame frame,String area){
	selectedArea = area;
	//https://stackoverflow.com/questions/13360430/jframe-dispose-vs-system-exit
	frame.dispose();
	showHotelSelection();
}

private void showHotelSelection(){
	JFrame frame = new JFrame("Hotel Selection");
	frame.setSize(600,400);
	frame.setLayout(new GridLayout(4,1));

	JLabel label = new JLabel("Select a hotel preference:", SwingConstants.CENTER);

	JButton affordableButton = new JButton ("Affordable Price");
	JButton convenientButton = new JButton ("Near Transportation");
	JButton goodButton = new JButton ("Good Hotel");

	affordableButton.addActionListener(e -> showHotels(frame,"Affordable Price"));
	convenientButton.addActionListener(e -> showHotels(frame,"Near Transportation"));
	goodButton.addActionListener(e -> showHotels(frame,"Good Hotel"));

	frame.add(label);
	frame.add(affordableButton);
	frame.add(convenientButton);
	frame.add(goodButton);
	frame.setVisible(true);

}

private void showHotels(JFrame frame, String category){
	//https://stackoverflow.com/questions/9347076/how-to-remove-all-components-from-a-jframe-in-java/32253547
	frame.getContentPane().removeAll();
	frame.repaint();
//https://www.geeksforgeeks.org/list-get-method-in-java-with-examples/
	Map<String,String[][]> areaHotels = hotelDatabase.get(selectedArea);
	String[][] hotels = areaHotels.get(category);

	for(int i = 0; i<hotels.length;i++){
		String [] hotel = hotels[i];
		JButton hotelButton = new JButton(hotel[0]);
		hotelButton.addActionListener(e -> showHotelDetails(hotel, frame));
		frame.add(hotelButton);

	}

JButton backButton = new JButton("Back");
backButton.addActionListener(e -> {
	frame.dispose();
	showHotelSelection();
});

frame.add(backButton,BorderLayout.SOUTH);
//adding 2 extra rows
frame.setLayout(new GridLayout(hotels.length+2, 1));
frame.setVisible(true);

}

private void showHotelDetails(String[]hotel, JFrame preFrame){
	
	preFrame.dispose();

	JFrame frame = new JFrame("Hotel Receipts");
	frame.setSize(600,400);

	JLabel nameLabel = new JLabel("Hotel:" + hotel[0],SwingConstants.CENTER);
	JLabel descriptionLabel = new JLabel("Hotel Detail:" + hotel[1],SwingConstants.CENTER);
	JLabel hotelpriceLabel = new JLabel("Price:" + hotel[2],SwingConstants.CENTER);
//https://www.geeksforgeeks.org/integer-valueof-vs-integer-parseint-with-examples/
	   hotelPrice = Integer.parseInt(hotel[2]);


//https://stackoverflow.com/questions/46874163/how-can-i-create-the-following-layout-in-swing
	frame.setLayout(new GridLayout(4,1));
	frame.add(nameLabel);
	frame.add(descriptionLabel);
	frame.add(hotelpriceLabel);

	createHotelButtons(frame,hotel);

	frame.setVisible(true);


}

private void createHotelButtons(JFrame frame, String[]hotel){
	JButton backButton2 = new JButton("Back");
	backButton2.addActionListener(e -> {
		hotelPrice = Integer.parseInt(hotel[2]);
		frame.dispose();
		showHotelSelection();
	});

	JButton confirmButton = new JButton("Confirm");
	confirmButton.addActionListener(e -> {
		selectedHotel = hotel[0];
		frame.dispose();
		showFinalPage();
	});
	//https://www.geeksforgeeks.org/java-swing-jpanel-with-examples/
	JPanel buttonPanel = new JPanel();
	buttonPanel.add(backButton2);
	buttonPanel.add(confirmButton);
	
	frame.add(buttonPanel, BorderLayout.SOUTH);
	
}

private void initializeHotelDatabase(){
	//https://www.w3schools.com/java/java_hashmap.asp
	hotelDatabase = new HashMap<>();

	Map<String,String[][]>osakaHotels = new HashMap<>();
	osakaHotels.put("Affordable Price",new String[][]{
		{"Hotel Sovial Osaka Dome-mae",
		"convenient for access to entertainment areas, with Kyocera Dome just an 8-minute walk away and USJ just 4 stations away","8000~"},
		{"Nisshin Namba Inn","All rooms feature a simple and modern design, equipped with a mini kitchen. A complimentary light breakfast is also provided.","7700~"},
		{"Hotel Amaterrace En -Yosuga","2 minutes walk from Emisucho Subway Station. 5 minutes walk to Tsutenkaku Tower.","7400~"}
	});
	
	osakaHotels.put("Near Transportation",new String[][]{
		{"Hotel Monterey Grasmere Osaka",
		"directly connected to Namba Station and just a 1-minute walk away.","13600"},
		{"OMO7 Osaka by Hoshino Resort","The hotel is close to Osaka's major tourist attractions. One minute walk from Shin-Imamiya Station.","22000"},
		{"Osaka Excel Hotel Tokyu","2 minutes walk from Hommachi Station (Midosuji Line and Chuo Line) Exit 13. Bathrooms with a washbasin. Convenient to INTEX Osaka, Kyocera Dome, and Shinsaibashi.","15600"}
	});
	
	osakaHotels.put("Good Hotel",new String[][]{
		{"The Ritz-Carlton, Osaka",
		"The Ritz-Carlton, Osaka brings modern elegance to a city with over 1500 years of history. Located in Umeda, in the heart of Osaka City, this five-star hotel embodies Japanese aesthetic sensibilities with a touch of British style.","100000"},
		{"Osaka Marriott Miyako Hotel"," The Osaka Marriott Miyako Hotel is located in Abeno Harukas, the tallest skyscraper in Japan. The 360 guest rooms are located on the 38th to 55th floors and boast unobstructed views of the city. Each room offers a different view of the dynamic nightscape of Osaka, Osaka Bay, and the Akashi Straits.","43000"},
		{"Intercontinental Hotel Osaka","The InterContinental Hotel Osaka is located in Grand Front Osaka, directly connected to R Osaka Station. The guest rooms have a modern and stylish interior with a Japanese atmosphere that creates a sense of serenity.","70000"}
	});

	Map<String,String[][]>tokyoHotels = new HashMap<>();
	tokyoHotels.put("Affordable Price",new String[][]{
		{"APA Hotel & Resort <Roppongi Station East>",
		"It's a low-cost hotel in the Roppongi area, where you can stay from around 25000 yen for two people","25000~"},
		{"Tokyo Guesthouse HIVE","Tokyo Guesthouse HIVE is only a 5-minute drive from the Imperial Palace and Sensoji Temple. The rooms are mainly in the form of bunk beds.","13000"},
		{"Sotetsu Grand Fresa Tokyo Bay Ariake","5 minute walk to Tokyo Big Sight. Next to Odaiba, free shuttle bus to TDR and limousine bus to Haneda and Narita airports","8800"}
	});
	
	tokyoHotels.put("Near Transportation",new String[][]{
		{"New Otani Inn Tokyo",
		"Directly connected from the north ticket gate of Osaki Station on the JR Yamanote Line! Close to the station and within walking distance of restaurants. Easy access to Haneda Airport","10000"},
		{"Via Inn Shinagawa Oimachi","One stop from Shinagawa. Conveniently located just a 2-minute walk from Oimachi Station. 30 minutes by bus from Haneda Airport to Oimachi Station. Convenience store inside the building.","8600"},
		{"Super Hotel Ikebukuro Nishiguchi Natural Hot Spring","Renewal opening on December 26, 2024.Only 1 second walk from exit C1b of JR Ikebukuro Station.","12300"}
	});
	
	tokyoHotels.put("Good Hotel",new String[][]{
		{"Aman Tokyo",
		"Located on the top floor of Otemachi Tower, Aman Tokyo offers a refined space that blends the city's energy with traditional Japanese culture. Featuring ikebana and a veranda, which creates a transition between the outside and the inside. The hotel's interior reflects a traditional Japanese home, and it also houses Tokyo’s largest Aman Spa.","340000"},
		{"The Ritz-Carlton, Tokyo"," a 5-star hotel in Roppongi, Tokyo. Directly connected to the Roppongi subway station, this luxurious location occupies the upper nine floors of the Midtown Tower, the symbolic tower of Tokyo Midtown, a 4-hectare complex of green spaces, museums, and stores.","180000"},
		{"HOSHINOYA Tokyo","5 minute walk to Tokyo Big Sight. Next to Odaiba, free shuttle bus to TDR and limousine bus to Haneda and Narita airports","200000"}
	});
		
	hotelDatabase.put("Tokyo",tokyoHotels);
	hotelDatabase.put("Osaka",osakaHotels);


}  // I wil do the same thing for activity
    

   private void showFinalPage() {
        JFrame frame = new JFrame("Trip Summary");
        frame.setSize(600, 400);
        
        int totalCost = hotelPrice ;
	int finalCost = budget - totalCost;

        JLabel label = new JLabel("Your travel plan summary:", SwingConstants.CENTER);
        JTextArea summary = new JTextArea(
            "Budget: ¥" + budget + "\n" +
            "Area: " + selectedArea+ "\n" +
            "Hotel: " + selectedHotel + " - ¥" + hotelPrice + "\n" +
            "Remaining Cost: ¥" + finalCost
        );

        //https://stackoverflow.com/questions/21695175/jtextfield-setenabled-vs-seteditable
        summary.setEditable(false);
       
    if (finalCost < 0) {
    JOptionPane.showMessageDialog(frame, "Your total cost exceeds your budget. Please start again.", "Budget Exceeded", JOptionPane.ERROR_MESSAGE);
    frame.dispose();
    showWelcomePage();
}

	  frame.setLayout(new BorderLayout());
        frame.add(label, BorderLayout.NORTH);
        //https://www.geeksforgeeks.org/java-jscrollpane/
        //scroll through text
        frame.add(new JScrollPane(summary), BorderLayout.CENTER);
        frame.setVisible(true);

        }
        


public static void main(String[] args) {
new JapanTravelPlan();

	
}

}

