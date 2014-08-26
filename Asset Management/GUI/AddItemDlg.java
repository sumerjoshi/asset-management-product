package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Core.ICore;

public class AddItemDlg extends JPanel{
	
	private JButton _addButton;
	private JButton _cancelButton;
	private ICore _core;
	
	public AddItemDlg(ICore core)
	{
		this._addButton = new JButton();
		this._cancelButton = new JButton();
		this._core = core;
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
		
		this._cancelButton.setText("Remove Item");
		this._cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		this.add(this._cancelButton);
	}

}
