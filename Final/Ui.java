import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class UiButton extends JButton {
    public UiButton(String text) {
        this.setText(text);
        this.setFocusable(false);
        this.setBackground(new Color(0x00BCD4));  // Cyan background
        this.setForeground(Color.BLACK);  
        this.setFont(new Font("Arial", Font.BOLD, 16));  // Larger and bold font
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));  // Border color
        this.setPreferredSize(new Dimension(200, 50));  // Adjusted size for buttons
    }
}

class UiLabel extends JLabel {
    public UiLabel() {
        this.setText("Let's get Clicking..");
        try {
            ImageIcon oimg = new ImageIcon("5566599.png");
            Image simg = oimg.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            ImageIcon img = new ImageIcon(simg);
            this.setIcon(img);
        } catch (Exception e) {
            System.out.println("Image not found: " + e.getMessage());
        }

        this.setIconTextGap(20);
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setVerticalTextPosition(JLabel.BOTTOM);
        this.setForeground(Color.WHITE);
        this.setFont(new Font("Arial", Font.PLAIN, 24));  // Larger font for label
        this.setVerticalAlignment(JLabel.CENTER);
        this.setHorizontalAlignment(JLabel.CENTER);
    }
}

class UiFrame extends JFrame {
    public UiFrame() {
        this.setTitle("Advanced AutoClicker");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420, 420);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(0x0F2A38));  // Dark background
        this.setLayout(new BorderLayout());

        // Label setup
        UiLabel label = new UiLabel();

        // Button panel setup
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));  // Reduced gap
        buttonPanel.setBackground(new Color(0x0F2A38));

        // Buttons
        UiButton recorderButton = new UiButton("Recorder");
        UiButton clickerButton = new UiButton("Clicker");

        // Action listeners for buttons
        recorderButton.addActionListener(e -> {
            System.out.println("Recorder button clicked!");
            RecorderFrame recorderFrame = new RecorderFrame();
            recorderFrame.setVisible(true);
            this.dispose();
        });

        clickerButton.addActionListener(e -> {
            System.out.println("Clicker button clicked!");
            ClickerFrame clickerFrame = new ClickerFrame();
            clickerFrame.setVisible(true);
            this.dispose();
        });

        buttonPanel.add(recorderButton);
        buttonPanel.add(clickerButton);

        this.add(label, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.CENTER);

        // Set frame icon
        try {
            ImageIcon img = new ImageIcon("5566599.png");
            this.setIconImage(img.getImage());
        } catch (Exception e) {
            System.out.println("Icon not found: " + e.getMessage());
        }

        this.setVisible(true);
    }
}

// ToggleButton UI adjustments

class UiToggleButton extends JToggleButton {
    public UiToggleButton(String text) {
        this.setText(text);
        this.setFocusable(false);
        this.setBackground(new Color(0x546E7A)); // Button background
        this.setForeground(Color.WHITE);
        this.setFont(new Font("Arial", Font.BOLD, 14));
        this.setBorder(BorderFactory.createLineBorder(new Color(0x37474F), 2));
    }
}

class RecorderFrame extends JFrame {
    public RecorderFrame() {
        this.setTitle("Recorder Settings");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(0x0F2A38)); // Darker background
        this.setLayout(new GridBagLayout());

        // Set the frame icon
        try {
            ImageIcon img = new ImageIcon("5566599.png");
            this.setIconImage(img.getImage());
        } catch (Exception e) {
            System.out.println("Icon not found: " + e.getMessage());
        }

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Start recording key
        JLabel recordKeyLabel = new JLabel("Press key to start recording:");
        recordKeyLabel.setForeground(Color.WHITE);
        JTextField recordKeyField = new JTextField(15);

        recordKeyField.setPreferredSize(new Dimension(200, 30)); // Adjust input field size
        JPanel recordKeyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        recordKeyPanel.setBackground(new Color(0x0F2A38));
        recordKeyPanel.add(recordKeyLabel);
        recordKeyPanel.add(recordKeyField);

        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(recordKeyPanel, gbc);

        // Start playing key
        JLabel playKeyLabel = new JLabel("Press key to start playing:");
        playKeyLabel.setForeground(Color.WHITE);
        JTextField playKeyField = new JTextField(15);

        playKeyField.setPreferredSize(new Dimension(200, 30)); // Adjust input field size
        JPanel playKeyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        playKeyPanel.setBackground(new Color(0x0F2A38));
        playKeyPanel.add(playKeyLabel);
        playKeyPanel.add(playKeyField);

        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(playKeyPanel, gbc);

        // Options Panel (Toggle Buttons)
        JPanel optionPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        optionPanel.setBackground(new Color(0x0F2A38));
        UiToggleButton untilStopped = new UiToggleButton("Until Stopped");
        UiToggleButton timeInterval = new UiToggleButton("Time Interval");
        ButtonGroup group = new ButtonGroup();
        group.add(untilStopped);
        group.add(timeInterval); // Adding to group ensures mutual exclusivity
        optionPanel.add(untilStopped);
        optionPanel.add(timeInterval);

        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(optionPanel, gbc);

        // Time interval inputs (initially hidden)
        JPanel timePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        timePanel.setBackground(new Color(0x0F2A38));
        JLabel minutesLabel = new JLabel("Minutes:");
        JLabel secondsLabel = new JLabel("Seconds:");
        minutesLabel.setForeground(Color.WHITE);
        secondsLabel.setForeground(Color.WHITE);
        JTextField minutesField = new JTextField(3);
        JTextField secondsField = new JTextField(3);
        minutesField.setPreferredSize(new Dimension(50, 30)); // Adjust input field size
        secondsField.setPreferredSize(new Dimension(50, 30)); // Adjust input field size
        timePanel.add(minutesLabel);
        timePanel.add(minutesField);
        timePanel.add(secondsLabel);
        timePanel.add(secondsField);
        timePanel.setVisible(false); // Initially hidden

        // Toggle visibility of timePanel based on selected option
        timeInterval.addItemListener(e -> timePanel.setVisible(e.getStateChange() == ItemEvent.SELECTED));
        untilStopped.addItemListener(e -> timePanel.setVisible(false));

        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(timePanel, gbc);

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(80, 30));
        backButton.addActionListener(e -> {
            new UiFrame();
            this.dispose();
        });

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.SOUTHEAST; // Place at bottom-right
        this.add(backButton, gbc);

        this.setVisible(true);
    }
}

class ClickerFrame extends JFrame {
    public ClickerFrame() {
        this.setTitle("Clicker Settings");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 500);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(0x0F2A38)); // Darker background
        this.setLayout(new GridBagLayout());

        // Set the frame icon
        try {
            ImageIcon img = new ImageIcon("5566599.png");
            this.setIconImage(img.getImage());
        } catch (Exception e) {
            System.out.println("Icon not found: " + e.getMessage());
        }

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Time inputs (Minutes, Seconds, Milliseconds)
        JPanel timePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        timePanel.setBackground(new Color(0x0F2A38));
        JLabel minutesLabel = new JLabel("Minutes:");
        JLabel secondsLabel = new JLabel("Seconds:");
        JLabel millisecondsLabel = new JLabel("Milliseconds:");
        minutesLabel.setForeground(Color.WHITE);
        secondsLabel.setForeground(Color.WHITE);
        millisecondsLabel.setForeground(Color.WHITE);
        JTextField minutesField = new JTextField(4);
        JTextField secondsField = new JTextField(4);
        JTextField millisecondsField = new JTextField(4);
        minutesField.setPreferredSize(new Dimension(60, 30)); // Adjust input field size
        secondsField.setPreferredSize(new Dimension(60, 30)); // Adjust input field size
        millisecondsField.setPreferredSize(new Dimension(60, 30)); // Adjust input field size
        timePanel.add(minutesLabel);
        timePanel.add(minutesField);
        timePanel.add(secondsLabel);
        timePanel.add(secondsField);
        timePanel.add(millisecondsLabel);
        timePanel.add(millisecondsField);

        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(timePanel, gbc);

        // Key to Click dropdown (ComboBox)
        JPanel keyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        keyPanel.setBackground(new Color(0x0F2A38));
        JLabel keyLabel = new JLabel("Key to Click:");
        keyLabel.setForeground(Color.WHITE);

        String[] keyOptions = {"Left Mouse Button", "Right Mouse Button", "Custom Key"};
        JComboBox<String> keyComboBox = new JComboBox<>(keyOptions);
        keyComboBox.setPreferredSize(new Dimension(200, 30)); // Adjust combo box size

        keyPanel.add(keyLabel);
        keyPanel.add(keyComboBox);

        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(keyPanel, gbc);

        // Custom key input (initially hidden)
        JPanel customKeyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        customKeyPanel.setBackground(new Color(0x0F2A38));
        JLabel customKeyLabel = new JLabel("Press the key or click the mouse button:");
        customKeyLabel.setForeground(Color.WHITE);
        JTextField customKeyField = new JTextField(10);
        customKeyPanel.add(customKeyLabel);
        customKeyPanel.add(customKeyField);
        customKeyPanel.setVisible(false);

        keyComboBox.addItemListener(e -> customKeyPanel.setVisible(e.getStateChange() == ItemEvent.SELECTED && keyComboBox.getSelectedIndex() == 2));

        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(customKeyPanel, gbc);

        // Options Panel (Toggle Buttons)
        JPanel optionPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        optionPanel.setBackground(new Color(0x0F2A38));
        UiToggleButton untilStopped = new UiToggleButton("Until Stopped");
        UiToggleButton timeInterval = new UiToggleButton("Time Interval");
        ButtonGroup group = new ButtonGroup();
        group.add(untilStopped);
        group.add(timeInterval);
        optionPanel.add(untilStopped);
        optionPanel.add(timeInterval);

        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(optionPanel, gbc);

        // Time interval inputs (initially hidden)
        JPanel timeIntervalPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        timeIntervalPanel.setBackground(new Color(0x0F2A38));
        JLabel minutesLabel2 = new JLabel("Minutes:");
        JLabel secondsLabel2 = new JLabel("Seconds:");
        minutesLabel2.setForeground(Color.WHITE);
        secondsLabel2.setForeground(Color.WHITE);
        JTextField minutesField2 = new JTextField(3);
        JTextField secondsField2 = new JTextField(3);
        minutesField2.setPreferredSize(new Dimension(50, 30)); // Adjust input field size
        secondsField2.setPreferredSize(new Dimension(50, 30)); // Adjust input field size
        timeIntervalPanel.add(minutesLabel2);
        timeIntervalPanel.add(minutesField2);
        timeIntervalPanel.add(secondsLabel2);
        timeIntervalPanel.add(secondsField2);
        timeIntervalPanel.setVisible(false);

        timeInterval.addItemListener(e -> timeIntervalPanel.setVisible(e.getStateChange() == ItemEvent.SELECTED));
        untilStopped.addItemListener(e -> timeIntervalPanel.setVisible(false));

        gbc.gridx = 0;
        gbc.gridy = 4;
        this.add(timeIntervalPanel, gbc);

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(80, 30));
        backButton.addActionListener(e -> {
            new UiFrame();
            this.dispose();
        });

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.SOUTHEAST;
        this.add(backButton, gbc);

        this.setVisible(true);
    }
}


public class Ui {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new UiFrame();
        });
    }
}
