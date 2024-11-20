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
        // TODO
    }

    //EFFECTS: create navigation bars for software functionalities 
    private JPanel createNavigationPanel() {
        // TODO
    }

}