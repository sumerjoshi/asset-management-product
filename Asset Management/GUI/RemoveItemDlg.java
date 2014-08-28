package GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Core.ICore;

public class RemoveItemDlg extends SubGUIPanel {
	private MainGUI _parent;
	private JButton _cancelButton;
	private JButton _removeButton;
	private JLabel _idL = new JLabel("ID");
	private JTextField _idTF = new JTextField();
	private JLabel _status = new JLabel(" ");
	private JPanel _idRow = new JPanel();
	
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
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this._idTF.setPreferredSize(new Dimension(100,20));

		this._idRow.add(this._idL);
		this._idRow.add(this._idTF);
		this._idRow.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
		this._idRow.setAlignmentY(java.awt.Component.CENTER_ALIGNMENT);
		
		this._removeButton.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
		this._removeButton.setAlignmentY(java.awt.Component.BOTTOM_ALIGNMENT);
		this._cancelButton.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
		this._status.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
		
		
		this._idRow.add(this._idTF);
		this.add(this._idRow);
		this._removeButton.setText("Remove Item");
		this._removeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					int temp = Integer.parseInt(_idTF.getText());
					boolean stat = _parent.getUser().removeItem(temp);
					if (stat)
						_status.setText("Item Removed");
					else
						_status.setText("Invalid ID");
				}
				catch (Exception e)
				{
					_status.setText("Invalid Entry");
				}
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
		this.add(this._status);
	}
	
	private void changePanels(ModeEnum newMode)
	{
		this._parent.changeState(newMode);
	}
	
	public void updateValues()
	{
		this._idTF.setText("");
	}
	public void itemStateChanged(ItemEvent evt) {
        String stuff = (String)evt.getItem();
    }
}
