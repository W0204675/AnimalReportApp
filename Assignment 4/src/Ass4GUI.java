//Import Utilities
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Ass4GUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ass4GUI frame = new Ass4GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Intitialize Arraylist to hold all saved entrys
	ArrayList<String> savedEntrys = new ArrayList<String>();
	
	/**
	 * Create the frame.
	 */
	public Ass4GUI() {
		
		//Panel Creation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, "name_82803013976550");
		panel.setLayout(null);
		
		//Label to Identify where blood pressure is entered. Is set to not visible until Penguin is selected
		JLabel lblBloodPressure = new JLabel("Blood Pressure:");
		lblBloodPressure.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBloodPressure.setBounds(10, 168, 199, 38);
		panel.add(lblBloodPressure);
		lblBloodPressure.setVisible(false);
		
		//Textfield for entering blood pressure
		JTextField enterBloodPressure = new JTextField();
		enterBloodPressure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Validation for entered blood pressure. Must be a number only
				//Shows pop up if an error occurs. Doesn't accept entry if its invalid
				String text = enterBloodPressure.getText();
			
				if (!text.matches("[0-9]+"))
				{
					JOptionPane.showMessageDialog(null, "Please enter a valid blood pressure!\nie: 123, 100, 50");
					enterBloodPressure.setText("");
				}
			}
		});
		enterBloodPressure.setFont(new Font("Monospaced", Font.PLAIN, 16));
		enterBloodPressure.setBounds(184, 176, 79, 22);
		panel.add(enterBloodPressure);
		enterBloodPressure.setVisible(false);
				
		//Label to Identify where number of spots is entered. Is set to not visible until Sea Lion is selected
		JLabel lblNumberOfSpots = new JLabel("Number Of Spots:");
		lblNumberOfSpots.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNumberOfSpots.setBounds(10, 168, 199, 38);
		panel.add(lblNumberOfSpots);
		lblNumberOfSpots.setVisible(false);
		
		//Textfield for entering number of spots
		JTextField enterNumOfSpots = new JTextField();
		enterNumOfSpots.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Validation for entered number of spots. Must be a number only
				//Shows pop up if an error occurs. Doesn't accept entry if its invalid
				String text = enterNumOfSpots.getText();
				
				if (!text.matches("[0-9]+"))
				{
					JOptionPane.showMessageDialog(null, "Please enter a valid number of spots!\nie: 3, 20, 101");
					enterNumOfSpots.setText("");
				}
			}
		});
		enterNumOfSpots.setFont(new Font("Monospaced", Font.PLAIN, 16));
		enterNumOfSpots.setBounds(184, 176, 79, 22);
		panel.add(enterNumOfSpots);
		enterNumOfSpots.setVisible(false);
		
		//Label to Identify where dental health is selected. Is set to not visible until Walrus is selected
		JLabel lblDentalHealth = new JLabel("Dental Health:");
		lblDentalHealth.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDentalHealth.setBounds(10, 168, 199, 38);
		panel.add(lblDentalHealth);
		lblDentalHealth.setVisible(false);
		
		//Combobox for selecting the dental health of the walrus
		JComboBox enterDentalHealth = new JComboBox();
		enterDentalHealth.setModel(new DefaultComboBoxModel(new String[] {"<Select>", "Good", "Average", "Poor"}));
		enterDentalHealth.setFont(new Font("Tahoma", Font.PLAIN, 16));
		enterDentalHealth.setBounds(184, 173, 99, 29);
		panel.add(enterDentalHealth);
		enterDentalHealth.setVisible(false);
		
		//Label to Identify where the animal is selected. Always Visible
		JLabel lblChooseAnimal = new JLabel("Choose Animal:");
		lblChooseAnimal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChooseAnimal.setBounds(10, 20, 182, 38);
		panel.add(lblChooseAnimal);
		
		//Combobox for selecting animal options
		JComboBox animalOptions = new JComboBox();
		animalOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//If statements that determines which labels and textfields to make visible for corresponding selected animals. Lines 152-191.
				if (animalOptions.getSelectedItem().toString().equals("Penguin"))
				{
					lblBloodPressure.setVisible(true);
					enterBloodPressure.setVisible(true);
					lblNumberOfSpots.setVisible(false);
					enterNumOfSpots.setVisible(false);
					lblDentalHealth.setVisible(false);
					enterDentalHealth.setVisible(false);
				}
				
				else if (animalOptions.getSelectedItem().toString().equals("Sea Lion"))
				{
					lblBloodPressure.setVisible(false);
					enterBloodPressure.setVisible(false);
					lblNumberOfSpots.setVisible(true);
					enterNumOfSpots.setVisible(true);
					lblDentalHealth.setVisible(false);
					enterDentalHealth.setVisible(false);
				}
				
				else if (animalOptions.getSelectedItem().toString().equals("Walrus"))
				{
					lblBloodPressure.setVisible(false);
					enterBloodPressure.setVisible(false);
					lblNumberOfSpots.setVisible(false);
					enterNumOfSpots.setVisible(false);
					lblDentalHealth.setVisible(true);
					enterDentalHealth.setVisible(true);
				}
				
				else if (animalOptions.getSelectedItem().toString().equals("<Select>"))
				{
					lblBloodPressure.setVisible(false);
					enterBloodPressure.setVisible(false);
					lblNumberOfSpots.setVisible(false);
					enterNumOfSpots.setVisible(false);
					lblDentalHealth.setVisible(false);
					enterDentalHealth.setVisible(false);
				}
			}
		});
		animalOptions.setFont(new Font("Tahoma", Font.PLAIN, 16));
		animalOptions.setModel(new DefaultComboBoxModel(new String[] {"<Select>", "Penguin", "Sea Lion", "Walrus"}));
		animalOptions.setBounds(164, 26, 99, 26);
		panel.add(animalOptions);
		
		//Sexual label
		JLabel lblSex = new JLabel("Sex:");
		lblSex.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSex.setBounds(10, 68, 49, 38);
		panel.add(lblSex);
		
		//Combobox for selecting the sex of the animal
		JComboBox sexOptions = new JComboBox();
		sexOptions.setModel(new DefaultComboBoxModel(new String[] {"<Select>", "Male", "Female"}));
		sexOptions.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sexOptions.setBounds(62, 74, 99, 27);
		panel.add(sexOptions);
		
		//Label to identify where the weight of the animal is entered
		JLabel lblWeightInPounds = new JLabel("Weight In Pounds:");
		lblWeightInPounds.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWeightInPounds.setBounds(10, 116, 199, 38);
		panel.add(lblWeightInPounds);
		
		//Textfield for entering in weight
		JTextField enterWeight = new JTextField();
		enterWeight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Validate user input to only allow numbers
				//Shows pop up if input is invalid
				String text = enterWeight.getText();
				
				if (!text.matches("[0-9]+"))
				{
					JOptionPane.showMessageDialog(null, "Please enter a valid weight!\nie: 45, 12 , 21");
					enterWeight.setText("");
				}
			}
		});
		enterWeight.setFont(new Font("Monospaced", Font.PLAIN, 16));
		enterWeight.setBounds(184, 124, 79, 22);
		panel.add(enterWeight);
		
		//Label to identify where the GPS Coordinates are entered
		JLabel lblGpsCoordinates = new JLabel("GPS Coordinates");
		lblGpsCoordinates.setFont(new Font("Arial", Font.PLAIN, 24));
		lblGpsCoordinates.setBounds(316, 17, 290, 38);
		panel.add(lblGpsCoordinates);
		
		//TextArea that stores all entered in GPS coordinates
		JTextArea displayGPSCoords = new JTextArea();
		displayGPSCoords.setFont(new Font("Monospaced", Font.PLAIN, 16));
		displayGPSCoords.setRows(10);
		displayGPSCoords.setLineWrap(true);
		displayGPSCoords.setEditable(false);
		displayGPSCoords.setBounds(316, 53, 290, 179);
		panel.add(displayGPSCoords);
		
		//TextField for entering in GPS coordinates
		JTextField enterCoordinates = new JTextField();
		enterCoordinates.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Validates user input to only allow coordinates of a length no greater than 9 digits and that can have a hyphen to signify negative coordinates
				//Shows pop up if the input is invalid
				String text = enterCoordinates.getText();
				
				if (!text.matches("^-?([1]?[1-7][1-9]|[1]?[1-8][0]|[1-9]?[0-9])\\.{1}\\d{1,7}"))
				{
					JOptionPane.showMessageDialog(null, "Please enter a valid coordinate!\nie: 12.3456789, -11.1111");
					enterCoordinates.setText("");					
				}
				
				else if (text.matches("^-?([1]?[1-7][1-9]|[1]?[1-8][0]|[1-9]?[0-9])\\.{1}\\d{1,7}")){				
				displayGPSCoords.append(enterCoordinates.getText() + " ");
				enterCoordinates.setText("");
				}
			}
		});
		enterCoordinates.setBounds(316, 242, 210, 22);
		panel.add(enterCoordinates);
		
		//Button to add the coordinates to the coordinates display. Even though just pressing enter works the same
		JButton addGPSCoord = new JButton("Add");
		addGPSCoord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Validates user input to only allow coordinates of a length no greater than 9 digits and that can have a hyphen to signify negative coordinates
				//Shows pop up if the input is invalid
				String text = enterCoordinates.getText();
				
				if (!text.matches("^-?([1]?[1-7][1-9]|[1]?[1-8][0]|[1-9]?[0-9])\\.{1}\\d{1,7}"))
				{
					JOptionPane.showMessageDialog(null, "Please enter a valid coordinate!\nie: 12.3456789, -11.1111");
					enterCoordinates.setText("");					
				}
				
				else if (text.matches("^-?([1]?[1-7][1-9]|[1]?[1-8][0]|[1-9]?[0-9])\\.{1}\\d{1,7}")){				
				displayGPSCoords.append(enterCoordinates.getText() + " ");
				enterCoordinates.setText("");
				}
			}
		});
		addGPSCoord.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addGPSCoord.setBounds(540, 242, 66, 22);
		panel.add(addGPSCoord);
		
		//Button for saving the current entry to the array list called "savedEntrys"
		JButton btnSaveEntry = new JButton("Save Entry");
		btnSaveEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//If statements determine which animal was selected and then Initiates the corresponding class and sets the entered data to the class
				//Creates a GPS class and assigns the entered coordinates to the the GPS class
				//Create a string that contains all the formated data and then append the string to the savedEntrys arraylist
				//Shows a pop up if the save is successful
				//If save is successful the panels components go to their default values for another entry to take place
				//If statements for each animal go from line 312-404
				if (animalOptions.getSelectedItem().toString().equals("Penguin"))
				{
					Penguin animal = new Penguin("", 0, 0);
					animal.setSex(sexOptions.getSelectedItem().toString());
					animal.setWeight(Integer.parseInt(enterWeight.getText()));
					animal.setBloodPressure(Integer.parseInt(enterBloodPressure.getText()));
					
					GPS penguinsGPSCoords = new GPS("");
					penguinsGPSCoords.setCoordinates(displayGPSCoords.getText());
					
					String lineToAppend = (animalOptions.getSelectedItem().toString() + ", Sex: " + animal.getSex().toString() + ", Weight: " + animal.getWeight() + ", Blood Pressure: " + animal.getBloodPressure() + "\n" + penguinsGPSCoords.getCoordinates());
					savedEntrys.add(lineToAppend);	
					
					JOptionPane.showMessageDialog(null, "   Entry Saved!");
					
					enterWeight.setText("");
					enterBloodPressure.setText("");
					enterNumOfSpots.setText("");
					sexOptions.setSelectedItem("<Select>");
					enterDentalHealth.setSelectedItem("<Select>");
					animalOptions.setSelectedItem("<Select>");
					enterCoordinates.setText("");
					displayGPSCoords.setText("");
					lblBloodPressure.setVisible(false);
					enterBloodPressure.setVisible(false);
					lblNumberOfSpots.setVisible(false);
					enterNumOfSpots.setVisible(false);
					lblDentalHealth.setVisible(false);
					enterDentalHealth.setVisible(false);
					
				}
				
				else if (animalOptions.getSelectedItem().toString().equals("Sea Lion"))
				{
					SeaLion animal = new SeaLion("", 0, 0);
					animal.setSex(sexOptions.getSelectedItem().toString());
					animal.setWeight(Integer.parseInt(enterWeight.getText()));
					animal.setNumOfSpots(Integer.parseInt(enterNumOfSpots.getText()));
					
					GPS sealionGPSCoords = new GPS("");
					sealionGPSCoords.setCoordinates(displayGPSCoords.getText());
					
					String lineToAppend = (animalOptions.getSelectedItem().toString() + ", Sex: " + animal.getSex().toString() + ", Weight: " + animal.getWeight() + ", Number of Spots: " + animal.getNumOfSpots() + "\n" + sealionGPSCoords.getCoordinates());
					savedEntrys.add(lineToAppend);
					
					JOptionPane.showMessageDialog(null, "   Entry Saved!");
					
					enterWeight.setText("");
					enterBloodPressure.setText("");
					enterNumOfSpots.setText("");
					sexOptions.setSelectedItem("<Select>");
					enterDentalHealth.setSelectedItem("<Select>");
					animalOptions.setSelectedItem("<Select>");
					enterCoordinates.setText("");
					displayGPSCoords.setText("");
					lblBloodPressure.setVisible(false);
					enterBloodPressure.setVisible(false);
					lblNumberOfSpots.setVisible(false);
					enterNumOfSpots.setVisible(false);
					lblDentalHealth.setVisible(false);
					enterDentalHealth.setVisible(false);
				}
				
				else if (animalOptions.getSelectedItem().toString().equals("Walrus"))
				{
					Walrus animal = new Walrus("", 0, "");
					animal.setSex(sexOptions.getSelectedItem().toString());
					animal.setWeight(Integer.parseInt(enterWeight.getText()));
					animal.setDentalHealth(enterDentalHealth.getSelectedItem().toString());
					
					GPS walrusGPSCoords = new GPS("");
					walrusGPSCoords.setCoordinates(displayGPSCoords.getText());
					
					String lineToAppend = (animalOptions.getSelectedItem().toString() + ", Sex: " + animal.getSex().toString() + ", Weight: " + animal.getWeight() + ", Dental Health: " + animal.getDentalHealth() + "\n" + walrusGPSCoords.getCoordinates());										
					savedEntrys.add(lineToAppend);
					
					JOptionPane.showMessageDialog(null, "Entry Saved!");
					
					enterWeight.setText("");
					enterBloodPressure.setText("");
					enterNumOfSpots.setText("");
					sexOptions.setSelectedItem("<Select>");
					enterDentalHealth.setSelectedItem("<Select>");
					animalOptions.setSelectedItem("<Select>");
					enterCoordinates.setText("");
					displayGPSCoords.setText("");
					lblBloodPressure.setVisible(false);
					enterBloodPressure.setVisible(false);
					lblNumberOfSpots.setVisible(false);
					enterNumOfSpots.setVisible(false);
					lblDentalHealth.setVisible(false);
					enterDentalHealth.setVisible(false);
				}				
			}
		});
		btnSaveEntry.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSaveEntry.setBounds(139, 314, 160, 38);
		panel.add(btnSaveEntry);
		
		//Button that generates a report from all of the saved entrys stored in the savedEntrys arraylist
		JButton btnGenerate = new JButton("Generate Report");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//If statement determines whether or not there are any saved entrys
				//If there aren't then a pop up occurs and nothing happens until an entry is saved
				//If there are entrys then a for loop prints each line of the saved entrys arraylist into the File "Animal Report"
				if (savedEntrys.isEmpty() == true)
				{
					JOptionPane.showMessageDialog(null, "Error! No entries saved!");					
				}
				
				else 
				{
					//I used this from the internet from https://stackoverflow.com/questions/1625234/how-to-append-text-to-an-existing-file-in-java
					try(FileWriter fw = new FileWriter("Animal Report", true);
						    BufferedWriter bw = new BufferedWriter(fw);
						    PrintWriter out = new PrintWriter(bw))
						{
							JOptionPane.showMessageDialog(null, "Report Generated! File Name: Animal Report");
							
							for (int x = 0; x <= savedEntrys.size(); x++)
							{
								out.println(savedEntrys.get(x));													
							}
			
						} catch (IOException e) {
							
						}
				}
			}
		});
		btnGenerate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGenerate.setBounds(330, 314, 160, 38);
		panel.add(btnGenerate);		
	}
}
