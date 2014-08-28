package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.JButton;
import Core.ICore;

public class MainDlg extends SubGUIPanel{
	private MainGUI _parent;
	private JButton _addButton;
	private JButton _removeButton;
	private JButton _borrowButton;
	private ICore _core;
	
	public MainDlg(MainGUI par, ICore core)
	{
		this._core  = core;
		this._addButton = new JButton();
		this._removeButton = new JButton();
		this._borrowButton = new JButton();
		this._parent = par;
		init();
	}
	
	public void init()
	{

		this._addButton.setText("Add Item");
		this._addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				changePanels(ModeEnum.AddItem);
			}
		});
		
		this.add(this._addButton);
		
		this._removeButton.setText("Remove Item");
		this._removeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				changePanels(ModeEnum.RemoveItem);
			}
		});
		
		this.add(this._removeButton);
		this._borrowButton.setText("Borrow Item");
		this._borrowButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				changePanels(ModeEnum.BorrowItem);
			}
		});
		
		this.add(this._borrowButton);
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
