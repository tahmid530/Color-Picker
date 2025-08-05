import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorPicker extends JFrame {
	private JComboBox<String> colorBox;
	private JPanel colorPanel;
	private JLabel colorNameLabel;

	public ColorPicker() {
		setTitle("Color Picker");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);

		JLabel titleLabel = new JLabel("Choose a color:");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(titleLabel, BorderLayout.NORTH);

		String[] colors = { "Red", "Green", "Blue", "Yellow", "Black", "White" };
		colorBox = new JComboBox<>(colors);
		colorBox.setFont(new Font("Arial", Font.PLAIN, 18));
		JPanel comboPanel = new JPanel();
		comboPanel.add(colorBox);

		colorPanel = new JPanel();
		colorPanel.setPreferredSize(new Dimension(0, 500));
		colorPanel.setBackground(Color.LIGHT_GRAY);
		colorPanel.setLayout(new BorderLayout());

		colorNameLabel = new JLabel("Current Color: None");
		colorNameLabel.setHorizontalAlignment(JLabel.CENTER);
		colorNameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		colorPanel.add(colorNameLabel, BorderLayout.CENTER);

		colorBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selected = (String) colorBox.getSelectedItem();
				String hexCode = "";

				switch (selected) {
				case "Red":
					colorPanel.setBackground(Color.RED);
					hexCode = "#FF0000";
					break;
				case "Green":
					colorPanel.setBackground(Color.GREEN);
					hexCode = "#00FF00";
					break;
				case "Blue":
					colorPanel.setBackground(Color.BLUE);
					hexCode = "#0000FF";
					break;
				case "Yellow":
					colorPanel.setBackground(Color.YELLOW);
					hexCode = "#FFFF00";
					break;
				case "Black":
					colorPanel.setBackground(Color.BLACK);
					hexCode = "#000000";
					break;
				case "White":
					colorPanel.setBackground(Color.WHITE);
					hexCode = "#FFFFFF";
					break;
				}
				colorNameLabel.setText("Current Color: " + selected + " (" + hexCode + ")");
			}
		});
		add(titleLabel, BorderLayout.NORTH);
		add(comboPanel, BorderLayout.CENTER);
		add(colorPanel, BorderLayout.SOUTH);

		setVisible(true);
	}

	public static void main(String[] args) {
		new ColorPicker();
	}
}
