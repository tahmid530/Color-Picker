import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class ColorPicker extends JFrame {
	private JComboBox<String> colorBox;
	private JPanel colorPanel;
	private JLabel colorNameLabel;
	private String currentHex = "";
	private ImageIcon defaultIcon;

	public ColorPicker() {
		setTitle("Color Picker");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout(10, 10));
		setLocationRelativeTo(null);

		defaultIcon = new ImageIcon("src/image/Color Picker.png");
		Image img = defaultIcon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
		defaultIcon = new ImageIcon(img);

		JLabel titleLabel = new JLabel("Choose a color:");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
		titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		add(titleLabel, BorderLayout.NORTH);

		String[] colors = { "Select a color", "Red", "Green", "Blue", "Yellow", "Black", "White" };
		colorBox = new JComboBox<>(colors);
		colorBox.setFont(new Font("Arial", Font.PLAIN, 18));

		JPanel comboPanel = new JPanel();
		comboPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		comboPanel.add(colorBox);
		add(comboPanel, BorderLayout.CENTER);

		JButton copyButton = new JButton("Copy");
		copyButton.setFont(new Font("Arial", Font.PLAIN, 16));

		JPanel topRightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		topRightPanel.setOpaque(false);
		topRightPanel.add(copyButton);

		colorPanel = new JPanel(new BorderLayout());
		colorPanel.setPreferredSize(new Dimension(0, 450));
		colorPanel.setBackground(Color.LIGHT_GRAY);
		colorPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

		colorNameLabel = new JLabel(defaultIcon);
		colorNameLabel.setHorizontalAlignment(JLabel.CENTER);
		colorPanel.add(colorNameLabel, BorderLayout.CENTER);
		colorPanel.add(topRightPanel, BorderLayout.NORTH);

		add(colorPanel, BorderLayout.SOUTH);

		colorBox.addActionListener(e -> {
			String selected = (String) colorBox.getSelectedItem();
			switch (selected) {
			case "Red":
				updateColor(Color.RED, "#FF0000", "Red");
				break;
			case "Green":
				updateColor(Color.GREEN, "#00FF00", "Green");
				break;
			case "Blue":
				updateColor(Color.BLUE, "#0000FF", "Blue");
				break;
			case "Yellow":
				updateColor(Color.YELLOW, "#FFFF00", "Yellow");
				break;
			case "Black":
				updateColor(Color.BLACK, "#000000", "Black");
				break;
			case "White":
				updateColor(Color.WHITE, "#FFFFFF", "White");
				break;
			default:
				colorPanel.setBackground(Color.LIGHT_GRAY);
				currentHex = "";
				colorNameLabel.setText("");
				colorNameLabel.setIcon(defaultIcon);
				break;
			}
		});

		copyButton.addActionListener(e -> {
			if (!currentHex.isEmpty()) {
				StringSelection selection = new StringSelection(currentHex);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(selection, null);
				JOptionPane.showMessageDialog(ColorPicker.this, "HEX code copied: " + currentHex);
			} else {
				JOptionPane.showMessageDialog(ColorPicker.this, "Please select a color first.");
			}
		});

		setVisible(true);
	}

	private void updateColor(Color color, String hex, String name) {
		colorPanel.setBackground(color);
		currentHex = hex;
		colorNameLabel.setIcon(null);
		colorNameLabel.setText("Current Color: " + name + " (" + hex + ")");
	}

	public static void main(String[] args) {
		new ColorPicker();
	}
}
