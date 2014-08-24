package GUI;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainGUI
{
	private JFrame _baseForm;
	private JPanel _basePane;
	private JButton _addButton;
	private JButton _removeButton;
	
	public MainGUI()
	{
		this._baseForm = new JFrame("Gooey");
		this._basePane = new JPanel();
		this._addButton = new JButton();
		this._removeButton = new JButton();
		init();
	}
	
	public void init()
	{
		this._baseForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this._baseForm.getContentPane().setLayout(new FlowLayout());
		this._addButton.setText("Add Item");
		this._addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		this._baseForm.add(this._addButton);
		
		this._addButton.setText("Remove Item");
		this._addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		this._baseForm.add(this._removeButton);
		
	    this._baseForm.pack();
	    this._baseForm.setLocationRelativeTo(null);
	    this._baseForm.setVisible(true);
		
	}
}
