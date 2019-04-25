package guiBased;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StartMenu extends JPanel implements ActionListener {
	private JTextArea output = new JTextArea();
	private JPanel btnPnl;
	private JRadioButton twoPlyrBtn;
	private JRadioButton threePlyrBtn;
	private JRadioButton fourPlyrBtn;
	private ButtonGroup btns = new ButtonGroup();
	
	/**
	 * Create the panel.
	 */
	public StartMenu() {
		this.setBounds(100, 100, 500, 300);
		this.setLayout(new BorderLayout());
		
		this.buildOutput();
		output.setEditable(false);
		
		twoPlyrBtn = new JRadioButton("Two Players");
		twoPlyrBtn.addActionListener(this);
		threePlyrBtn = new JRadioButton("Three Players");
		threePlyrBtn.addActionListener(this);
		fourPlyrBtn = new JRadioButton("Four Players");
		fourPlyrBtn.addActionListener(this);
		
		btns.add(twoPlyrBtn);
		btns.add(threePlyrBtn);
		btns.add(fourPlyrBtn);
		
		btnPnl = new JPanel(new GridLayout(3, 1));
		btnPnl.add(twoPlyrBtn);
		btnPnl.add(threePlyrBtn);
		btnPnl.add(fourPlyrBtn);
		
		this.add(btnPnl, BorderLayout.CENTER);
	}
	
	private void buildOutput() {
		output.setBounds(5, 30, 490, 260);
		output.setBackground(new Color(240, 240, 240));
	}
	
	public void howToPlay() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("HowToPlay.txt"));
			String nextLine = reader.readLine();
			while (nextLine != null) {
				output.append(nextLine + "\n");
				nextLine = reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException ex) {
			output.append("File Not Found: \n");
			output.append(ex.getLocalizedMessage());
		} catch (IOException ex) {
			output.append("Issue Reading: \n");
			output.append(ex.getLocalizedMessage());
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		String btn = e.getActionCommand();
		if (btn == "Two Players") {
			
		}
	}
}
