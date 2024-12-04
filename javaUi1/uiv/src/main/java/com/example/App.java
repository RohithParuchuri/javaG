package com.example;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

class UiButton extends JButton {
    public UiButton(String text) {
        this.setText(text);
        this.setFocusable(false);
        this.setBackground(new Color(0x386775)); // Original background color
        this.setForeground(Color.WHITE);
        this.setFont(new Font("Arial", Font.BOLD, 16));
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setPreferredSize(new Dimension(200, 50));

        // Hover effect
        this.setContentAreaFilled(false);
        this.setOpaque(false);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(new Color(0x4A7F89));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(new Color(0x386775));
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.GRAY);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
    }
}

class UiLabel extends JLabel {
    public UiLabel() {
        this.setText("Let's get Clicking..");
        try {
            // Load image from resources
            URL imageUrl = getClass().getResource("resources/5566599.png");
            if (imageUrl != null) {
                ImageIcon oimg = new ImageIcon(imageUrl);
                Image simg = oimg.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                ImageIcon img = new ImageIcon(simg);
                this.setIcon(img);
            } else {
                System.out.println("Image not found: Check if the file exists in src/main/resources");
            }
        } catch (Exception e) {
            System.out.println("Error loading image: " + e.getMessage());
        }
        
        

        this.setIconTextGap(20);
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setVerticalTextPosition(JLabel.BOTTOM);
        this.setForeground(Color.WHITE);
        this.setFont(new Font("Arial", Font.PLAIN, 24));
        this.setVerticalAlignment(JLabel.CENTER);
        this.setHorizontalAlignment(JLabel.CENTER);
    }
}


class RoundedButton extends JButton {
    public RoundedButton(String text) {
        this.setText(text);
        this.setFocusable(false);
        this.setBackground(new Color(0x386775)); // Cyan background
        this.setForeground(Color.WHITE);
        this.setFont(new Font("Arial", Font.BOLD, 16));
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setPreferredSize(new Dimension(100, 30));

        // Hover effect
        this.setContentAreaFilled(false);
        this.setOpaque(false);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(new Color(0x4A7F89)); // Slightly lighter cyan
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(new Color(0x386775)); // Original cyan
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.GRAY);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
    }
}
class RoundedRadioButton extends JRadioButton {
    public RoundedRadioButton(String text) {
        this.setText(text);
        this.setFocusable(false);
        this.setBackground(new Color(0x386775)); // Default background
        this.setForeground(Color.WHITE);
        this.setFont(new Font("Arial", Font.BOLD, 16));
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setPreferredSize(new Dimension(200, 50));

        // Disable default appearance
        this.setContentAreaFilled(false);
        this.setOpaque(false);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!isSelected()) {
                    setBackground(new Color(0x4A7F89)); // Hover color
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!isSelected()) {
                    setBackground(new Color(0x386775)); // Default color
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.GRAY);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
    }
}

class RecorderFrame extends JFrame {

    private boolean isSaved = false;

    public RecorderFrame() {
        this.setTitle("Recorder Settings");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 500);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(0x1d2e28));
        this.setLayout(new BorderLayout(10, 10));

        JPanel topPanel = new JPanel(new BorderLayout(10, 10));
        topPanel.setBackground(new Color(0x1d2e28));
        
        try {
            ImageIcon oimg = new ImageIcon("5566599.png");
            Image simg = oimg.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(simg));
            topPanel.add(imageLabel, BorderLayout.WEST);
        } catch (Exception e) {
            System.out.println("Image not found: " + e.getMessage());
        }

        JLabel recorderLabel = new JLabel("Recorder");
        recorderLabel.setForeground(Color.WHITE);
        recorderLabel.setFont(new Font("Arial", Font.BOLD, 20));
        recorderLabel.setHorizontalAlignment(SwingConstants.CENTER);
        topPanel.add(recorderLabel, BorderLayout.CENTER);

        JPanel savePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        savePanel.setBackground(new Color(0x1d2e28));
        RoundedButton saveButton = new RoundedButton("Save");
        savePanel.add(saveButton);
        topPanel.add(savePanel, BorderLayout.EAST);

        saveButton.addActionListener(e -> {
            isSaved = true;
            JOptionPane.showMessageDialog(this, "Changes have been saved!", "Save", JOptionPane.INFORMATION_MESSAGE);
        });

        this.add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(new Color(0x1d2e28));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 10, 15, 10);

        JPanel notePanel = new JPanel();
        notePanel.setPreferredSize(new Dimension(350, 50));
        notePanel.setBackground(new Color(0x0a5c36));
        JLabel noteLabel = new JLabel("Note: Ctrl+r to start and stop recording.");
        noteLabel.setForeground(Color.WHITE);
        noteLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        notePanel.add(noteLabel);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        centerPanel.add(notePanel, gbc);

        // Radio buttons for Until Stopped and Number of Repetitions
        RoundedRadioButton untilStoppedButton = new RoundedRadioButton("Until Stopped");
        RoundedRadioButton numRepsButton = new RoundedRadioButton("No of Repetitions");

        ButtonGroup group = new ButtonGroup();
        group.add(untilStoppedButton);
        group.add(numRepsButton);

        JTextField repsField = new JTextField(10);
        repsField.setPreferredSize(new Dimension(100, 30));
        repsField.setEnabled(false);

        untilStoppedButton.addActionListener(e -> repsField.setEnabled(false));
        numRepsButton.addActionListener(e -> repsField.setEnabled(true));

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        centerPanel.add(untilStoppedButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        centerPanel.add(numRepsButton, gbc);

        JPanel repetitionTextPanel = new JPanel();
        repetitionTextPanel.setBackground(new Color(0x1d2e28));
        repetitionTextPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        repetitionTextPanel.add(repsField);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        centerPanel.add(repetitionTextPanel, gbc);

        this.add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        bottomPanel.setBackground(new Color(0x1d2e28));

        RoundedButton runButton = new RoundedButton("Run");
        runButton.addActionListener(e -> {
            if (untilStoppedButton.isSelected()) {
                JOptionPane.showMessageDialog(this, "Running until stopped...");
                Play.playIndefinitely();
            } else if (numRepsButton.isSelected()) {
                String input = repsField.getText().trim();
                if (input.isEmpty() || !input.matches("\\d+")) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid number of repetitions!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    int repetitions = Integer.parseInt(input);
                    JOptionPane.showMessageDialog(this, "Running for " + repetitions + " repetitions...");
                    Play.playWithRepetitions(repetitions);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select an option!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        bottomPanel.add(runButton);

        RoundedButton historyButton = new RoundedButton("History");
        historyButton.setBackground(new Color(0x007BB5));
        historyButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "History functionality coming soon!"));
        bottomPanel.add(historyButton);

        RoundedButton backButton = new RoundedButton("Back");
        backButton.setBackground(new Color(0x5A5A5A));
        backButton.addActionListener(e -> {
            // Play.stopPlayback(); // stop button is not there and back is not woking while run in clicked
            if (!isSaved) {
                int response = JOptionPane.showConfirmDialog(this, "Do you want to save your changes?", "Save Changes", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    isSaved = true;
                    JOptionPane.showMessageDialog(this, "Changes have been saved!", "Save", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            new Uiframe();
            this.dispose();
        });
        bottomPanel.add(backButton);

        this.add(bottomPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }
}
class ClickerFrame extends JFrame {
    public int m = 0, s = 0;

    public ClickerFrame() {
        this.setTitle("Clicker Settings");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(430, 480); // Same size as Uiframe
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(0x1d2e28));
        this.setLayout(new BorderLayout(10, 10));

        // Top Panel with Logo and Title
        JPanel topPanel = new JPanel(new BorderLayout(10, 10));
        topPanel.setBackground(new Color(0x1d2e28));

        try {
            ImageIcon oimg = new ImageIcon("5566599.png");
            Image simg = oimg.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(simg));
            topPanel.add(imageLabel, BorderLayout.WEST);
        } catch (Exception e) {
            System.out.println("Image not found: " + e.getMessage());
        }

        JLabel clickerLabel = new JLabel("Clicker");
        clickerLabel.setForeground(Color.WHITE);
        clickerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        clickerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        topPanel.add(clickerLabel, BorderLayout.CENTER);

        this.add(topPanel, BorderLayout.NORTH);

        // Center Panel
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(new Color(0x1d2e28));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 10, 15, 10);

        // Time Input Panel
        JPanel timeInputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10)); // Left alignment
        timeInputPanel.setBackground(new Color(0x0a5c36));
        timeInputPanel.setPreferredSize(new Dimension(350, 60)); // Height increased by 50

        JLabel textLabel1 = new JLabel("Min:");
        textLabel1.setForeground(Color.WHITE);
        textLabel1.setFont(new Font("Arial", Font.BOLD, 14));
        
        JTextField textField1 = new JTextField(5);
        textField1.setPreferredSize(new Dimension(50, 30));
        
        
        JPanel fieldPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        fieldPanel1.setBackground(new Color(0x0a5c36));
        fieldPanel1.add(textLabel1);
        fieldPanel1.add(textField1);
        
        timeInputPanel.add(fieldPanel1);
        
        JLabel textLabel2 = new JLabel("Sec:");
        textLabel2.setForeground(Color.WHITE);
        textLabel2.setFont(new Font("Arial", Font.BOLD, 14));
        
        JTextField textField2 = new JTextField(5);
        textField2.setPreferredSize(new Dimension(50, 30));
        
        JPanel fieldPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        fieldPanel2.setBackground(new Color(0x0a5c36));
        fieldPanel2.add(textLabel2);
        fieldPanel2.add(textField2);
        
        timeInputPanel.add(fieldPanel2);
        

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        centerPanel.add(timeInputPanel, gbc);

        // Radio Buttons
        RoundedRadioButton untilStoppedButton = new RoundedRadioButton("Until Stopped");
        RoundedRadioButton numRepsButton = new RoundedRadioButton("No of Repetitions");

        ButtonGroup group = new ButtonGroup();
        group.add(untilStoppedButton);
        group.add(numRepsButton);

        JTextField repsField = new JTextField(10);
        repsField.setPreferredSize(new Dimension(100, 30));
        repsField.setEnabled(false);

        untilStoppedButton.addActionListener(e -> repsField.setEnabled(false));
        numRepsButton.addActionListener(e -> repsField.setEnabled(true));

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        centerPanel.add(untilStoppedButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        centerPanel.add(numRepsButton, gbc);

        JPanel repetitionTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        repetitionTextPanel.setBackground(new Color(0x1d2e28));
        repetitionTextPanel.add(repsField);

        gbc.gridx = 1;
        gbc.gridy = 2;
        centerPanel.add(repetitionTextPanel, gbc);

        this.add(centerPanel, BorderLayout.CENTER);

        // Bottom Panel
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        bottomPanel.setBackground(new Color(0x1d2e28));

        RoundedButton runButton = new RoundedButton("Run");
        runButton.addActionListener(e -> {
            if (untilStoppedButton.isSelected()) {
                JOptionPane.showMessageDialog(this, "Running until stopped...");
                try {
                    m = Integer.parseInt(textField1.getText().trim());
                    s = Integer.parseInt(textField2.getText().trim());
                    s += m*60;
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "Please enter valid integers for time values!", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                AutoClick.clickMouse(s, -1);
            } else if (numRepsButton.isSelected()) {
                String input = repsField.getText().trim();
                if (input.isEmpty() || !input.matches("\\d+")) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid number of repetitions!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    int repetitions = Integer.parseInt(input);
                    JOptionPane.showMessageDialog(this, "Running for " + repetitions + " repetitions...");
                    try {
                        m = Integer.parseInt(textField1.getText().trim());
                        s = Integer.parseInt(textField2.getText().trim());
                        s += m*60;
                    } catch (NumberFormatException e1) {
                        JOptionPane.showMessageDialog(null, "Please enter valid integers for time values!", "Input Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    AutoClick.clickMouse(s, repetitions);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select an option!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        bottomPanel.add(runButton);

        RoundedButton backButton = new RoundedButton("Back");
        backButton.setBackground(new Color(0x386775));
        backButton.addActionListener(e -> {
            new Uiframe();
            this.dispose();
        });
        bottomPanel.add(backButton);

        this.add(bottomPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }
}

class Uiframe extends JFrame {
    public Uiframe() {
        this.setTitle("Advanced AutoClicker");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(430, 480);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(0x1d2e28));
        this.setLayout(new BorderLayout());

        UiLabel label = new UiLabel();

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.setBackground(new Color(0x1d2e28));

        UiButton recorderButton = new UiButton("Recorder");
        UiButton clickerButton = new UiButton("Clicker");

        buttonPanel.add(recorderButton);
        buttonPanel.add(clickerButton);

        recorderButton.addActionListener(e -> {
            RecorderFrame recorderFrame = new RecorderFrame();
            recorderFrame.setVisible(true);
            this.dispose();
        });

        clickerButton.addActionListener(e -> {
            ClickerFrame clickerFrame = new ClickerFrame();
            clickerFrame.setVisible(true);
            this.dispose();
        });

        this.add(label, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }
}


public class App{
    public void runUI() {
        SwingUtilities.invokeLater(Uiframe::new);
    }
} 