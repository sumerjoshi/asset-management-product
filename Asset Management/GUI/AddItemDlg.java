package GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sun.xml.internal.ws.api.Component;

import Core.ICore;
import Items.ItemType;

public class AddItemDlg extends SubGUIPanel{
	
	private JButton _addButton;
	private JButton _cancelButton;
	private MainGUI _parent;
	

	private JPanel _tRow = new JPanel();
	private JPanel _nRow = new JPanel();
	private JPanel _dRow = new JPanel();
	private JPanel _lRow = new JPanel();
	private JPanel _deRow = new JPanel();
	private JPanel _idRow = new JPanel();
	private JPanel _bRow = new JPanel();

	
	private JLabel _nameL = new JLabel("Name");
	private JTextField _nameTF = new JTextField();
	private JLabel _descL = new JLabel("Description");
	private JTextField _descTF = new JTextField();
	private JLabel _locL = new JLabel("Location");
	private JComboBox<String> _locCB;
	private JLabel _depL = new JLabel("Department");
	private JComboBox<String> _depCB;
	private JLabel _typeL = new JLabel("Item Type");
	private JComboBox<String> _typeCB;
	private JLabel _status = new JLabel("Idle");
	private JLabel _idL = new JLabel("Item ID");
	private JTextField _idTF = new JTextField("");
	
	
	private ICore _core;
	
	public AddItemDlg(MainGUI par, ICore core)
	{
		this._addButton = new JButton();
		this._cancelButton = new JButton();
		this._core = core;
		this._parent = par;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		init();
	}
	
	public void init()
	{
		populateComboBoxes();
		
		this._nameTF.setPreferredSize(new Dimension(100, 20));
		this._descTF.setPreferredSize(new Dimension(100, 20));
		this._idTF.setPreferredSize(new Dimension(100, 20));
		
		this._nRow.add(_nameL);
		this._nRow.add(_nameTF);
		this._dRow.add(_descL);
		this._dRow.add(_descTF);
		this._lRow.add(_locL);
		this._lRow.add(_locCB);
		this._deRow.add(_depL);
		this._deRow.add(_depCB);
		this._tRow.add(_typeL);
		this._tRow.add(_typeCB);
		this._idRow.add(_idL);
		this._idRow.add(_idTF);
		
		this._addButton.setText("Add Item");
		this._addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try
				{
				int temp = Integer.parseInt(_idTF.getText());
				ItemType it = _core.convertToIT((String)_typeCB.getSelectedItem());
				boolean stat = _core.addItem(_nameTF.getText(), _descTF.getText(), 
						(String)_locCB.getSelectedItem(), (String)_depCB.getSelectedItem(), temp, it);
				if (stat)
					_status.setText("Item successfully added");
				else
					_status.setText("Item Adding failed");
				}
				catch(Exception e)
				{
					_status.setText("Add Item Failed EX");
				}
			}
		});
		
		this._bRow.add(this._addButton);
		
		this._cancelButton.setText("Cancel");
		this._cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				changePanels(ModeEnum.home);
			}
		});
		
		this._bRow.add(this._cancelButton);
		this._status.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
		this.add(this._tRow);
		this.add(this._nRow);
		this.add(this._dRow);
		this.add(this._lRow);
		this.add(this._deRow);
		this.add(this._idRow);
		this.add(this._bRow);
		this.add(this._status);
	}
	
	private void populateComboBoxes()
	{
		List<String> sel = this._core.getLocations();
		String[] temp = sel.toArray(new String[0]);
		this._locCB = new JComboBox<String>(temp);
		
		sel = this._core.getDepartments();
		temp = sel.toArray(new String[0]);
		this._depCB = new JComboBox<String>(temp);
		
		sel = this._core.getTypes();
		temp = sel.toArray(new String[0]);
		this._typeCB = new JComboBox<String>(temp);
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
