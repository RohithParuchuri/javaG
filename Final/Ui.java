import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
        this.getContentPane().setBackground(new Color(0x0F2A38));
        this.setLayout(new BorderLayout(10, 10));

        JPanel topPanel = new JPanel(new BorderLayout(10, 10));
        topPanel.setBackground(new Color(0x0F2A38));

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
        savePanel.setBackground(new Color(0x0F2A38));
        RoundedButton saveButton = new RoundedButton("Save");
        savePanel.add(saveButton);
        topPanel.add(savePanel, BorderLayout.EAST);

        saveButton.addActionListener(e -> {
            isSaved = true;
            JOptionPane.showMessageDialog(this, "Changes have been saved!", "Save", JOptionPane.INFORMATION_MESSAGE);
        });

        this.add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(new Color(0x0F2A38));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 10, 15, 10);

        JPanel notePanel = new JPanel();
        notePanel.setPreferredSize(new Dimension(350, 50));
        notePanel.setBackground(new Color(0x4CAF50));
        JLabel noteLabel = new JLabel("Note: Ctrl + lorem ipsum elnijsioeng sdskfj engk");
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
        repetitionTextPanel.setBackground(new Color(0x0F2A38));
        repetitionTextPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        repetitionTextPanel.add(repsField);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        centerPanel.add(repetitionTextPanel, gbc);

        this.add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        bottomPanel.setBackground(new Color(0x0F2A38));

        RoundedButton runButton = new RoundedButton("Run");
        runButton.addActionListener(e -> {
            if (untilStoppedButton.isSelected()) {
                JOptionPane.showMessageDialog(this, "Running until stopped...");
            } else if (numRepsButton.isSelected()) {
                String input = repsField.getText().trim();
                if (input.isEmpty() || !input.matches("\\d+")) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid number of repetitions!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    int repetitions = Integer.parseInt(input);
                    JOptionPane.showMessageDialog(this, "Running for " + repetitions + " repetitions...");
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

    public ClickerFrame() {
        this.setTitle("Clicker Settings");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(430, 480); // Same size as Uiframe
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(0x0F2A38));
        this.setLayout(new BorderLayout(10, 10));

        // Top Panel with Logo and Title
        JPanel topPanel = new JPanel(new BorderLayout(10, 10));
        topPanel.setBackground(new Color(0x0F2A38));

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
        centerPanel.setBackground(new Color(0x0F2A38));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 10, 15, 10);

        // Time Input Panel
        JPanel timeInputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10)); // Left alignment
        timeInputPanel.setBackground(new Color(0x4CAF50));
        timeInputPanel.setPreferredSize(new Dimension(350, 120)); // Height increased by 50

        String[] labels = {"Hour:", "Min:", "Sec:", "Millisec:"};
        boolean isMillisec = false;
        for (String label : labels) {
            JLabel textLabel = new JLabel(label);
            textLabel.setForeground(Color.WHITE);
            textLabel.setFont(new Font("Arial", Font.BOLD, 14));

            JTextField textField = new JTextField(5);
            textField.setPreferredSize(new Dimension(50, 30));

            JPanel fieldPanel = new JPanel(new FlowLayout(isMillisec ? FlowLayout.LEFT : FlowLayout.CENTER, 5, 5));
            fieldPanel.setBackground(new Color(0x4CAF50));
            fieldPanel.add(textLabel);
            fieldPanel.add(textField);

            timeInputPanel.add(fieldPanel);
            if (label.equals("Millisec:")) isMillisec = true;
        }

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
        repetitionTextPanel.setBackground(new Color(0x0F2A38));
        repetitionTextPanel.add(repsField);

        gbc.gridx = 1;
        gbc.gridy = 2;
        centerPanel.add(repetitionTextPanel, gbc);

        this.add(centerPanel, BorderLayout.CENTER);

        // Bottom Panel
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        bottomPanel.setBackground(new Color(0x0F2A38));

        RoundedButton runButton = new RoundedButton("Run");
        runButton.addActionListener(e -> {
            if (untilStoppedButton.isSelected()) {
                JOptionPane.showMessageDialog(this, "Running until stopped...");
            } else if (numRepsButton.isSelected()) {
                String input = repsField.getText().trim();
                if (input.isEmpty() || !input.matches("\\d+")) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid number of repetitions!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    int repetitions = Integer.parseInt(input);
                    JOptionPane.showMessageDialog(this, "Running for " + repetitions + " repetitions...");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select an option!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        bottomPanel.add(runButton);

        RoundedButton backButton = new RoundedButton("Back");
        backButton.setBackground(new Color(0x5A5A5A));
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


public class Ui{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Uiframe::new);
    }
} 