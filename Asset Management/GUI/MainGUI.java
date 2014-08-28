package GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Dictionary;
import java.util.HashMap;

import javax.swing.*;

import Core.ICore;
import Items.Item;
import Items.ItemType;

//Main context behind the states
public class MainGUI implements ItemListener
{
	JPanel cards;
	
	private JFrame _baseForm;
	//private SubGUIPanel _currentPanel;
	
	private JPanel _mainPanel;
	private HashMap<ModeEnum, String> _paneNames;
	
	private ModeEnum _mode;		//State enum
	private ICore _core;
	
	public MainGUI(ICore core)
	{
		this._baseForm = new JFrame("Gooey");

		//this._panels = new HashMap<ModeEnum, SubGUIPanel>();
		this._paneNames = new HashMap<ModeEnum, String>();
		this._mainPanel = new JPanel(new CardLayout());
		
		this._core = core;
		this._mode = ModeEnum.AddItem;
		this.populatePanels(this._baseForm.getContentPane());
		
		this.init();
	}
	
	public void init()
	{
		this._baseForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this._baseForm.getContentPane().setLayout(new FlowLayout());
		
	    this._baseForm.pack();
    	//this._baseForm.setLocationRelativeTo(null);
	    this._baseForm.setVisible(true);
		this.changeState(ModeEnum.home);
	}
	
	private void populatePanels(Container pane)
	{
		//Put the JComboBox in a JPanel to get a nicer look.
        JPanel comboBoxPane = new JPanel(); //use FlowLayout
        String comboBoxItems[] = { "A", "B", "C", "D"};
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);
         
        
         
        
        cards = new JPanel(new CardLayout());
         
        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
		this._paneNames.put(ModeEnum.AddItem, ModeEnum.AddItem.toString());
		this._paneNames.put(ModeEnum.home, ModeEnum.home.toString());
		this._paneNames.put(ModeEnum.RemoveItem,ModeEnum.RemoveItem.toString());
		this._paneNames.put(ModeEnum.BorrowItem, ModeEnum.BorrowItem.toString());
		
		
		JPanel temp = new AddItemDlg(this, this._core);
		cards.add(temp, ModeEnum.AddItem.toString());
		temp = new MainDlg(this, this._core);
		cards.add(temp, ModeEnum.home.toString());
		temp = new RemoveItemDlg(this, this._core);
		cards.add(temp, ModeEnum.RemoveItem.toString());
		temp = new BorrowItemDlg(this, this._core);
		cards.add(temp, ModeEnum.BorrowItem.toString());
		//this._panels.put(ModeEnum.AddItem, );
		//this._panels.put(ModeEnum.home, new MainDlg(this, this._core));
		//this._panels.put(ModeEnum.RemoveItem, new RemoveItemDlg(this, this._core));
		//this._panels.put(ModeEnum.BorrowItem, new BorrowItemDlg(this, this._core));
	}
	
	public void changeState(ModeEnum newMode)
	{
		CardLayout cl = (CardLayout)(cards.getLayout());
		if(this._mode != newMode)
		{
			this._mode = newMode;
			//this.updatePanel();		
			String stuff = this._paneNames.get(this._mode);
			cl.show(cards, stuff);  //this._mode.toString());
		}
	}
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        String stuff = (String)evt.getItem();
        cl.show(cards, stuff);
    }
}
