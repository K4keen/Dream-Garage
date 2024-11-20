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

    //EFFECTS: set up the basic panel of the software
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

    //EFFECTS: create a menu bar for saving and loading function 
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


    //EFFECTS: create navigation bars for software functionalities 
    private JPanel createNavigationPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JButton viewCarsButton = new JButton("View Cars");
        viewCarsButton.addActionListener(e -> showViewCarsPanel());
        JButton viewGaragesButton = new JButton("View Garages");
        viewGaragesButton.addActionListener(e -> showViewGaragesPanel());
        JButton addCarButton = new JButton("Add Car");
        addCarButton.addActionListener(e -> showAddCarPanel());
        JButton smartGeneratorButton = new JButton("Smart Generator");
        smartGeneratorButton.addActionListener(e -> showSmartGeneratorPanel());
        JButton statsButton = new JButton("Price Distribution");
        statsButton.addActionListener(e -> displayPriceChart());

        panel.add(viewCarsButton);
        panel.add(viewGaragesButton);
        panel.add(addCarButton);
        panel.add(smartGeneratorButton);
        panel.add(statsButton);

        return panel;
    }

   
    

}