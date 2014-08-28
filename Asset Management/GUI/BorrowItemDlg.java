package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.JButton;

import Core.ICore;

public class BorrowItemDlg extends SubGUIPanel
{
	private MainGUI _parent;
	private JButton _cancelButton;
	private JButton _takeButton;
	private ICore _core;
	
	public BorrowItemDlg(MainGUI par, ICore core)
	{
		this._core  = core;
		this._cancelButton = new JButton();
		this._takeButton = new JButton();
		this._parent = par;
		init();
	}
	
	public void init()
	{		
		this._takeButton.setText("Take Item");
		this._takeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//items get said item
			}
		});
		
		this.add(this._takeButton);
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
