package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.JButton;

import Core.ICore;

public class RemoveItemDlg extends SubGUIPanel {
	private MainGUI _parent;
	private JButton _cancelButton;
	private JButton _removeButton;
	private ICore _core;
	
	public RemoveItemDlg(MainGUI par, ICore core)
	{
		this._core  = core;
		this._cancelButton = new JButton();
		this._removeButton = new JButton();
		this._parent = par;
		init();
	}
	
	public void init()
	{		
		this._removeButton.setText("Remove Item");
		this._removeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//remove said item
			}
		});
		
		this.add(this._removeButton);
		this._cancelButton.setText("Cancel");
		this._cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				changePanels(ModeEnum.home);
			}
		});
		
		this.add(this._cancelButton);
	}
	
	private void changePanels(ModeEnum newMode)
	{
		this._parent.changeState(newMode);
	}
	
	public void updateValues()
	{
	}
	public void itemStateChanged(ItemEvent evt) {
        String stuff = (String)evt.getItem();
    }
}
