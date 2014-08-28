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

import Core.ICore;

public class AddItemDlg extends SubGUIPanel{
	
	private JButton _addButton;
	private JButton _cancelButton;
	private MainGUI _parent;
	
	
	private JPanel _lCol = new JPanel();
	private JPanel _tCol = new JPanel();
	private JPanel _bCol = new JPanel();
	
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
	private JLabel _status = new JLabel("");
	
	
	private ICore _core;
	
	public AddItemDlg(MainGUI par, ICore core)
	{
		this._addButton = new JButton();
		this._cancelButton = new JButton();
		this._core = core;
		this._parent = par;
		
		this._lCol.setLayout(new BoxLayout(this._lCol, BoxLayout.Y_AXIS));
		this._tCol.setLayout(new BoxLayout(this._tCol, BoxLayout.Y_AXIS));
		this._bCol.setLayout(new BoxLayout(this._bCol, BoxLayout.Y_AXIS));
		
		init();
	}
	
	public void init()
	{
		populateComboBoxes();
		
		this._nameTF.setPreferredSize(new Dimension(100, 20));
		this._descTF.setPreferredSize(new Dimension(100, 20));
		
		this._lCol.add(_nameL);
		this._tCol.add(_nameTF);
		this._lCol.add(_descL);
		this._tCol.add(_descTF);
		this._lCol.add(_locL);
		this._tCol.add(_locCB);
		this._lCol.add(_depL);
		this._tCol.add(_depCB);
		this._lCol.add(_typeL);
		this._tCol.add(_typeCB);
		
		this._addButton.setText("Add Item");
		this._addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		
		this._bCol.add(this._addButton);
		
		this._cancelButton.setText("Cancel");
		this._cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				changePanels(ModeEnum.home);
			}
		});
		
		this._bCol.add(this._cancelButton);
		this.add(this._lCol);
		this.add(this._tCol);
		this.add(this._bCol);
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
