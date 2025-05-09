package com;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class MilkCollectionApp {

	// Table model to store data
	DefaultTableModel model;

	public MilkCollectionApp() {
		JFrame frame = new JFrame("Milk Collection Center");
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel nameLabel = new JLabel("Farmer Name:");
		JTextField nameField = new JTextField(10);

		JLabel dateLabel = new JLabel("Date (YYYY-MM-DD):");
		JTextField dateField = new JTextField(10);

		JLabel qtyLabel = new JLabel("Milk Quantity (L):");
		JTextField qtyField = new JTextField(5);

		JLabel fatLabel = new JLabel("Fat %:");
		JTextField fatField = new JTextField(5);

		JButton addButton = new JButton("Add Record");

		// Table setup
		String[] columns = { "Farmer", "Date", "Quantity (L)", "Fat (%)" };
		model = new DefaultTableModel(columns, 0);
		JTable table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);

		// Layout
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(5, 2, 10, 10));
		inputPanel.add(nameLabel);
		inputPanel.add(nameField);
		inputPanel.add(dateLabel);
		inputPanel.add(dateField);
		inputPanel.add(qtyLabel);
		inputPanel.add(qtyField);
		inputPanel.add(fatLabel);
		inputPanel.add(fatField);
		inputPanel.add(addButton);

		frame.add(inputPanel, BorderLayout.NORTH);
		frame.add(scrollPane, BorderLayout.CENTER);

		// Add button action
		addButton.addActionListener(e -> {
			String name = nameField.getText().trim();
			String date = dateField.getText().trim();
			String qty = qtyField.getText().trim();
			String fat = fatField.getText().trim();

			if (name.isEmpty() || date.isEmpty() || qty.isEmpty() || fat.isEmpty()) {
				JOptionPane.showMessageDialog(frame, "Please fill all fields.");
				return;
			}

			model.addRow(new Object[] { name, date, qty, fat });
			nameField.setText("");
			dateField.setText("");
			qtyField.setText("");
			fatField.setText("");
		});

		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(MilkCollectionApp::new);
	}
}
