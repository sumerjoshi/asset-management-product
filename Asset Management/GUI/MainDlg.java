package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Core.ICore;

public class MainDlg extends JPanel{

	private JButton _addButton;
	private JButton _removeButton;
	private ICore _core;
	
	public MainDlg(ICore core)
	{
		this._core  = core;
		this._addButton = new JButton();
		this._removeButton = new JButton();
		
		init();
	}
	
	public void init()
	{

		this._addButton.setText("Add Item");
		this._addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		this.add(this._addButton);
		
		this._removeButton.setText("Remove Item");
		this._removeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		this.add(this._removeButton);
	}
	
	
}
