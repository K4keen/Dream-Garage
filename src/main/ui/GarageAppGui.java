package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

public class GarageAppGui {
    private JFrame frame;
    private JPanel contentPanel;
    private Collection myCollection;
    private static final String JSON_STORE = "./data/Collection.json";

    public static void main(String[] args) {
        new GarageAppGui();
    }

    public GarageAppGui() {
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
        JPanel panel = new JPanel();
        ArrayList<Car> cars = myCollection.getCars();
        if (cars.isEmpty()) {
            panel.add(new JLabel("No cars in collection."));
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
            panel.add(new JScrollPane(table));
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

    //EFFECTS: Call JsonWriter to save the data
    private void saveCollectionToFile() {
        
    }

    //EFFECTS: Call JsonReader to load the data.
    private void loadCollectionFromFile() {
        
    }

    //EFFECTS: Display a list of garages stored in the collection
    private void showViewGaragesPanel() {
        
    }

    //EFFECTS: Display the user interface of the smart generator
    private void showSmartGeneratorPanel() {
        
    }

}