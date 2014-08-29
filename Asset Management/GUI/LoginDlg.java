package GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import Core.ICore;
import Items.ItemType;

public class LoginDlg extends SubGUIPanel
{
	private MainGUI _parent;
	private ICore _core;
	private JButton _loginButton = new JButton("Login");
	private JTextField _userTF = new JTextField();
	private JLabel _userL = new JLabel("User Name");
	private JLabel _status = new JLabel();
	private JPanel _userRow = new JPanel();
	
	public LoginDlg(MainGUI par,ICore core)
	{
		this._parent = par;
		this._core = core;
		
		
		init();
	}
	@Override
	void init() {
		
		this._userTF.setPreferredSize(new Dimension(200,20));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this._status.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
		
		this._loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					boolean stat = _core.verifyUser(_userTF.getText());
					if (stat)
					{
						_parent.setUser(_core.getCurrentUser());
						_parent.changeState(ModeEnum.home);
					}
					else
					{
						_status.setText("Login invalid");
						updateValues();
					}
				}
				catch(Exception e)
				{
					_status.setText("Something Broke");
				}
			}
		});
		this._userRow.add(this._userL);
		this._userRow.add(this._userTF);
		
		this.add(this._userRow);
		this.add(this._loginButton);
		this.add(this._status);
		
	}

	@Override
	void updateValues() {
		this._userTF.setText("");
		
	}

	
}
