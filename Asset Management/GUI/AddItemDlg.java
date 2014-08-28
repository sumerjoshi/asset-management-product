package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.JButton;
import Core.ICore;

public class AddItemDlg extends SubGUIPanel{
	
	private JButton _addButton;
	private JButton _cancelButton;
	private MainGUI _parent;
	private ICore _core;
	
	public AddItemDlg(MainGUI par, ICore core)
	{
		this._addButton = new JButton();
		this._cancelButton = new JButton();
		this._core = core;
		this._parent = par;
		init();
	}
	
	public void init()
	{
		
		this._addButton.setText("Add Item");
		this._addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//add some stuff
				
			}
		});
		
		this.add(this._addButton);
		
		this._cancelButton.setText("Cancel");
		this._cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				changePanels(ModeEnum.home);
			}
		});
		
		this.add(this._cancelButton);
	}
	
	public void updateValues()
	{
		//Empty, does not need it.
	}
	
	private void changePanels(ModeEnum newMode)
	{
		this._parent.changeState(newMode);
	}
    public void itemStateChanged(ItemEvent evt) {
        String stuff = (String)evt.getItem();
    }

}
