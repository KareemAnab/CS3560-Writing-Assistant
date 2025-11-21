package view;

import model.DocumentModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainFrame extends JFrame implements DocumentModel.DocumentListener {

    private final JTextArea inputArea = new JTextArea(10, 40);
    private final JTextArea outputArea = new JTextArea(10, 40);
    private final JComboBox<String> modeCombo =
            new JComboBox<>(new String[]{"Creative", "Professional", "Academic"});
    private final JButton generateButton = new JButton("Generate");
    private final JButton saveButton = new JButton("Save");
    private final JButton loadButton = new JButton("Load");
    private final JLabel statusLabel = new JLabel("Done");

    // Dark theme colors
    private static final Color BG_DARK = new Color(18, 18, 18);
    private static final Color PANEL_DARK = new Color(28, 28, 28);
    private static final Color TEXT_PRIMARY = new Color(230, 230, 230);
    private static final Color BORDER_ACCENT = new Color(255, 111, 97); // orange/pink
    private static final Color BUTTON_ACCENT = new Color(255, 111, 97);
    private static final Color BUTTON_TEXT = Color.BLACK;

    public MainFrame() {
        super("Writing Assistant");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(900, 600));

        // Apply dark background to frame
        getContentPane().setBackground(BG_DARK);

        // Global font
        Font baseFont = new Font("SansSerif", Font.PLAIN, 14);
        UIManager.put("Label.font", baseFont);
        UIManager.put("Button.font", baseFont);
        UIManager.put("ComboBox.font", baseFont);

        // Text areas
        configureTextArea(inputArea);
        configureTextArea(outputArea);
        outputArea.setEditable(false);

        // Panels
        JPanel rootPanel = new JPanel(new BorderLayout(10, 10));
        rootPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        rootPanel.setBackground(BG_DARK);

        // Input panel
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(PANEL_DARK);
        topPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(BORDER_ACCENT),
                "Input"));
        ((javax.swing.border.TitledBorder) topPanel.getBorder()).setTitleColor(TEXT_PRIMARY);
        topPanel.add(new JScrollPane(inputArea), BorderLayout.CENTER);

        // Output panel
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(PANEL_DARK);
        centerPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(BORDER_ACCENT),
                "Output"));
        ((javax.swing.border.TitledBorder) centerPanel.getBorder()).setTitleColor(TEXT_PRIMARY);
        centerPanel.add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Controls row
        JPanel controls = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        controls.setBackground(BG_DARK);

        JLabel modeLabel = new JLabel("Mode:");
        modeLabel.setForeground(TEXT_PRIMARY);
        modeCombo.setBackground(PANEL_DARK);
        modeCombo.setForeground(TEXT_PRIMARY);

        styleButton(generateButton);
        styleButton(saveButton);
        styleButton(loadButton);

        controls.add(modeLabel);
        controls.add(modeCombo);
        controls.add(generateButton);
        controls.add(saveButton);
        controls.add(loadButton);

        // Status bar
        JPanel statusPanel = new JPanel(new BorderLayout());
        statusPanel.setBackground(BG_DARK);
        statusLabel.setForeground(TEXT_PRIMARY.darker());
        statusLabel.setBorder(new EmptyBorder(4, 4, 4, 4));
        statusPanel.add(statusLabel, BorderLayout.WEST);

        // Assemble
        rootPanel.add(topPanel, BorderLayout.NORTH);
        rootPanel.add(centerPanel, BorderLayout.CENTER);
        rootPanel.add(controls, BorderLayout.SOUTH);

        add(rootPanel, BorderLayout.CENTER);
        add(statusPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    private void configureTextArea(JTextArea area) {
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setBackground(PANEL_DARK);
        area.setForeground(TEXT_PRIMARY);
        area.setCaretColor(TEXT_PRIMARY);
        area.setBorder(new EmptyBorder(8, 8, 8, 8));
    }

    private void styleButton(JButton button) {
        button.setBackground(BUTTON_ACCENT);
        button.setForeground(BUTTON_TEXT);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(6, 16, 6, 16));
    }

    // Existing public API (for controller) stays the same

    public String getInputText() {
        return inputArea.getText();
    }

    public void setInputText(String text) {
        inputArea.setText(text);
    }

    public void setOutputText(String text) {
        outputArea.setText(text);
    }

    public void setStatus(String text) {
        statusLabel.setText(text);
    }

    public JButton getGenerateButton() {
        return generateButton;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JButton getLoadButton() {
        return loadButton;
    }

    public JComboBox<String> getModeCombo() {
        return modeCombo;
    }

    @Override
    public void documentChanged(String inputText, String outputText) {
        setInputText(inputText);
        setOutputText(outputText);
    }
}
