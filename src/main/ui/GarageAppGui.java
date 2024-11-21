package ui;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

public class GarageAppGUI {
    private JFrame frame;
    private JPanel contentPanel;
    private Collection myCollection;
    private static final String JSON_STORE = "./data/Collection.json";

    public static void main(String[] args) {
        new GarageAppGUI();
    }

    public GarageAppGUI() {
        myCollection = new Collection();
        initUI();
    }

    // EFFECTS: set up the basic panel of the software
    private void initUI() {

        frame = new JFrame("Dream Garage");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        frame.setJMenuBar(createMenuBar());

        JPanel navigationPanel = createNavigationPanel();
        frame.add(navigationPanel, BorderLayout.WEST);

        contentPanel = new JPanel();
        contentPanel.setLayout(new CardLayout());
        frame.add(contentPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    // EFFECTS: create a menu bar for saving and loading function
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.addActionListener(e -> saveCollectionToFile());
        JMenuItem loadItem = new JMenuItem("Load");
        loadItem.addActionListener(e -> loadCollectionFromFile());
        fileMenu.add(saveItem);
        fileMenu.add(loadItem);

        menuBar.add(fileMenu);
        return menuBar;
    }

    // EFFECTS: create navigation bars for software functionalities
    private JPanel createNavigationPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JButton viewCarsButton = new JButton("View Cars");
        viewCarsButton.addActionListener(e -> showViewCarsPanel());
        JButton viewGaragesButton = new JButton("View Garages");
        viewGaragesButton.addActionListener(e -> showViewGaragesPanel());
        JButton addCarButton = new JButton("Add Car");
        addCarButton.addActionListener(e -> showAddCarPanel());
        JButton smartGeneratorButton = new JButton("Smart Generator");
        smartGeneratorButton.addActionListener(e -> showSmartGeneratorPanel());

        panel.add(viewCarsButton);
        panel.add(viewGaragesButton);
        panel.add(addCarButton);
        panel.add(smartGeneratorButton);
        return panel;
    }

    // EFFECTS: Display a table of cars on a panel
    private void showViewCarsPanel() {
        contentPanel.removeAll();
        JPanel panel = new JPanel(new BorderLayout());
    
        ArrayList<Car> cars = myCollection.getCars();
    
        if (cars.isEmpty()) {
            panel.add(new JLabel("No cars in collection."), BorderLayout.CENTER);
        } else {
            String[] columnNames = {"Name", "Type", "Color", "Year", "Miles", "HP", "Price"};
            String[][] data = new String[cars.size()][7];
            for (int i = 0; i < cars.size(); i++) {
                Car car = cars.get(i);
                data[i][0] = car.getName();
                data[i][1] = car.getType();
                data[i][2] = car.getColor();
                data[i][3] = String.valueOf(car.getYear());
                data[i][4] = String.valueOf(car.getMiles());
                data[i][5] = String.valueOf(car.getHp());
                data[i][6] = String.valueOf(car.getPrice());
            }
    
            JTable table = new JTable(data, columnNames);
            panel.add(new JScrollPane(table), BorderLayout.CENTER);
    
            JPanel buttonPanel = new JPanel();
            JButton removeButton = new JButton("Remove Selected Car");
    
            removeButton.addActionListener(e -> {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    Car selectedCar = cars.get(selectedRow);
                    myCollection.getCars().remove(selectedCar);
                    JOptionPane.showMessageDialog(frame, selectedCar.getName() + " removed!");
                    showViewCarsPanel();
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a car to remove.");
                }
            });
    
            buttonPanel.add(removeButton);
            panel.add(buttonPanel, BorderLayout.SOUTH);
        }
    
        contentPanel.add(panel);
        contentPanel.revalidate();
        contentPanel.repaint();
    }
    

    // EFFECTS: Display a panel of adding cars to the collection
    private void showAddCarPanel() {
        contentPanel.removeAll();
        JPanel panel = new JPanel(new GridLayout(8, 2));

        JTextField nameField = new JTextField();
        JTextField typeField = new JTextField();
        JTextField colorField = new JTextField();
        JTextField yearField = new JTextField();
        JTextField milesField = new JTextField();
        JTextField hpField = new JTextField();
        JTextField priceField = new JTextField();

        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Type:"));
        panel.add(typeField);
        panel.add(new JLabel("Color:"));
        panel.add(colorField);
        panel.add(new JLabel("Year:"));
        panel.add(yearField);
        panel.add(new JLabel("Miles:"));
        panel.add(milesField);
        panel.add(new JLabel("HP:"));
        panel.add(hpField);
        panel.add(new JLabel("Price:"));
        panel.add(priceField);

        JButton addButton = new JButton("Add Car");
        addButton.addActionListener(e -> {
            Car car = new Car(
                    nameField.getText(),
                    typeField.getText(),
                    colorField.getText(),
                    Integer.parseInt(yearField.getText()),
                    Integer.parseInt(milesField.getText()),
                    Integer.parseInt(hpField.getText()),
                    Integer.parseInt(priceField.getText()));
            myCollection.addCar(car);
            JOptionPane.showMessageDialog(frame, "Car added successfully!");
            showViewCarsPanel();
        });
        panel.add(addButton);

        contentPanel.add(panel);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    // EFFECTS: Call JsonWriter to save the data
    private void saveCollectionToFile() {
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showSaveDialog(frame);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                JsonWriter writer = new JsonWriter(file.getAbsolutePath());
                writer.open();
                writer.write(myCollection);
                writer.close();
                JOptionPane.showMessageDialog(frame, "Collection saved successfully!");
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(frame, "Error saving file: " + e.getMessage());
            }
        }
    }

    // EFFECTS: Call JsonReader to load the data.
    private void loadCollectionFromFile() {
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showOpenDialog(frame);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                JsonReader reader = new JsonReader(file.getAbsolutePath());
                myCollection = reader.read();
                JOptionPane.showMessageDialog(frame, "Collection loaded successfully!");
                showViewCarsPanel();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(frame, "Error loading file: " + e.getMessage());
            }
        }
    }

    // EFFECTS: Display a list of garages stored in the collection
    private void showViewGaragesPanel() {
        contentPanel.removeAll(); 
        JPanel panel = new JPanel(new BorderLayout()); 

        ArrayList<Garage> garages = myCollection.getSavedGarages();

        if (garages.isEmpty()) {
            panel.add(new JLabel("No garages in collection."), BorderLayout.CENTER); 
        } else {
            String[] columnNames = { "Garage Name", "Number of Cars" }; 
            String[][] data = new String[garages.size()][2];
            for (int i = 0; i < garages.size(); i++) {
                Garage garage = garages.get(i);
                data[i][0] = garage.getName();
                data[i][1] = String.valueOf(garage.getCars().size());
            }

            JTable table = new JTable(data, columnNames); 
            panel.add(new JScrollPane(table), BorderLayout.CENTER); 

            JPanel buttonPanel = new JPanel();
            JButton viewDetailsButton = new JButton("View Selected Garage");
            JButton removeButton = new JButton("Remove Selected Garage");

            viewDetailsButton.addActionListener(e -> {
                int selectedRow = table.getSelectedRow(); 
                if (selectedRow >= 0) {
                    Garage selectedGarage = garages.get(selectedRow);
                    showGarageDetails(selectedGarage);
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a garage to view.");
                }
            });

            removeButton.addActionListener(e -> {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    Garage selectedGarage = garages.get(selectedRow); 
                    myCollection.getSavedGarages().remove(selectedGarage);
                    JOptionPane.showMessageDialog(frame, selectedGarage.getName() + " removed!");
                    showViewGaragesPanel();
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a garage to remove.");
                }
            });

            buttonPanel.add(viewDetailsButton);
            buttonPanel.add(removeButton);
            panel.add(buttonPanel, BorderLayout.SOUTH);
        }

        contentPanel.add(panel);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    // EFFECTS: Display the cars which are stored in the selected garage
    private void showGarageDetails(Garage garage) {
        contentPanel.removeAll();
        JPanel panel = new JPanel(new BorderLayout());

        ArrayList<Car> cars = garage.getCars();

        if (cars.isEmpty()) {
            panel.add(new JLabel("No cars in this garage."), BorderLayout.CENTER);
        } else {
            String[] columnNames = { "Name", "Type", "Color", "Year", "Miles", "HP", "Price" };
            String[][] data = new String[cars.size()][7];
            for (int i = 0; i < cars.size(); i++) {
                Car car = cars.get(i);
                data[i][0] = car.getName();
                data[i][1] = car.getType();
                data[i][2] = car.getColor();
                data[i][3] = String.valueOf(car.getYear());
                data[i][4] = String.valueOf(car.getMiles());
                data[i][5] = String.valueOf(car.getHp());
                data[i][6] = String.valueOf(car.getPrice());
            }

            JTable table = new JTable(data, columnNames); 
            panel.add(new JScrollPane(table), BorderLayout.CENTER);

            JButton backButton = new JButton("Back to Garages");
            backButton.addActionListener(e -> showViewGaragesPanel());
            panel.add(backButton, BorderLayout.SOUTH);
        }

        contentPanel.add(panel);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    // EFFECTS: Display the user interface of the smart generator
    private void showSmartGeneratorPanel() {
        contentPanel.removeAll();
        JPanel panel = new JPanel(new BorderLayout());
    
        String[] options = {"By Price", "By Year"};
        JComboBox<String> generatorOptions = new JComboBox<>(options);
    
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10)); 
        JLabel lowerLabel = new JLabel("Lower Bound:");
        JTextField lowerField = new JTextField();
        JLabel upperLabel = new JLabel("Upper Bound:");
        JTextField upperField = new JTextField();
    
        inputPanel.add(lowerLabel);
        inputPanel.add(lowerField);
        inputPanel.add(upperLabel);
        inputPanel.add(upperField);
    
        generatorOptions.addActionListener(e -> {
            String selectedOption = (String) generatorOptions.getSelectedItem();
            if ("By Price".equals(selectedOption)) {
                lowerLabel.setText("Lower Price:");
                upperLabel.setText("Upper Price:");
            } else if ("By Year".equals(selectedOption)) {
                lowerLabel.setText("Start Year:");
                upperLabel.setText("End Year:");
            }
        });
    
        JPanel buttonPanel = new JPanel();
        JButton generateButton = new JButton("Generate Garage");
    
        generateButton.addActionListener(e -> {
            try {
                int lower = Integer.parseInt(lowerField.getText());
                int upper = Integer.parseInt(upperField.getText());
    
                String selectedOption = (String) generatorOptions.getSelectedItem();
                ArrayList<Car> filteredCars;
                if ("By Price".equals(selectedOption)) {
                    filteredCars = filterByPriceRange(myCollection.getCars(), lower, upper);
                } else {
                    filteredCars = filterByYearRange(myCollection.getCars(), lower, upper);
                }
    
                String garageName = selectedOption + ": " + lower + "-" + upper;
                Garage garage = new Garage(garageName, filteredCars);
                myCollection.addGarage(garage);
    
                JOptionPane.showMessageDialog(frame, "Garage \"" + garageName + "\" created successfully!");
                showViewGaragesPanel();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input. Please enter valid numbers.");
            }
        });
    
        buttonPanel.add(generateButton);
    
        panel.add(generatorOptions, BorderLayout.NORTH);
        panel.add(inputPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
    
        contentPanel.add(panel);
        contentPanel.revalidate();
        contentPanel.repaint();
    }
    

    //EFFECTS: Helper method of filtering the Price
    private ArrayList<Car> filterByPriceRange(ArrayList<Car> cars, int lower, int upper) {
        ArrayList<Car> filtered = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPrice() >= lower && car.getPrice() <= upper) {
                filtered.add(car);
            }
        }
        return filtered;
    }

    //EFFECTS: Helper method of filtering the Year
    private ArrayList<Car> filterByYearRange(ArrayList<Car> cars, int lower, int upper) {
        ArrayList<Car> filtered = new ArrayList<>();
        for (Car car : cars) {
            if (car.getYear() >= lower && car.getYear() <= upper) {
                filtered.add(car);
            }
        }
        return filtered;
    }
    
    

}