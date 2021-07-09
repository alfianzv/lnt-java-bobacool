package lntFinalProject;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class InsertBoba extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 2L;
	
	JLabel nameLabel = new JLabel("Nama Boba: ");
	JTextField nameInput = new JTextField();
	
	JLabel priceLabel = new JLabel("Price: ");
	JTextField priceInput = new JTextField();
	
	JLabel stockLabel = new JLabel("Stock: ");
	JTextField stockInput = new JTextField();
	
	JButton submitBtn = new JButton("Submit");
	JButton cancelBtn = new JButton ("Cancel");
	
	
	public InsertBoba() {
		ViewMenu();
	}
	
	private void ViewMenu() {
		setTitle("BobaCool");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);
		setLocation(450,150);
		setVisible(true);
		
		createMenuTitle();
		createInputs();
	}

	private void createMenuTitle() {
		JLabel menuTitle = new JLabel("BobaCool");
		menuTitle.setHorizontalAlignment(JLabel.CENTER);
		add(menuTitle, BorderLayout.NORTH);
	}
	
	private void createInputs() {
		JPanel insertInput = new JPanel();
		insertInput.setLayout(new GridLayout(4,2));
		
		insertInput.add(nameLabel);
		insertInput.add(nameInput);
		
		insertInput.add(priceLabel);
		insertInput.add(priceInput);
		
		insertInput.add(stockLabel);
		insertInput.add(stockInput);
		
		insertInput.add(cancelBtn);
		insertInput.add(submitBtn);
		
		add(insertInput);
		
		cancelBtn.addActionListener(this);
		submitBtn.addActionListener(this);
		
	}
	
	private String createRandomCode(JTextField nameInput2) {
		Random rand = new Random();
		
		String textFieldtoString = "";
		textFieldtoString = nameInput2.getText();
		
		int a = rand.nextInt(999);
		
		String id = "BC-";
		id = id + a;
		
		return id;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(submitBtn)) {
			DatabaseController controller = new DatabaseController();
			controller.insertBoba(createRandomCode(nameInput), nameInput.getText(), priceInput.getText(), stockInput.getText());
			nameInput.setText(null);
			priceInput.setText(null);
			stockInput.setText(null);
		}
		else if(e.getSource().equals(cancelBtn)) {
			new CreateMenu();
			setVisible(false);
		}
		
	}
	

}
