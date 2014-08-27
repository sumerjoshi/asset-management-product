package GUI;

import java.awt.FlowLayout;
import java.util.Dictionary;
import java.util.HashMap;

import javax.swing.*;

import Core.ICore;

//Main context behind the states
public class MainGUI
{
	
	private JFrame _baseForm;
	private SubGUIPanel _currentPanel;
	
	private HashMap<ModeEnum, SubGUIPanel> _panels;
	
	private ModeEnum _mode;		//State enum
	private ICore _core;
	
	public MainGUI(ICore core)
	{
		this._baseForm = new JFrame("Gooey");

		this._panels = new HashMap<ModeEnum, SubGUIPanel>();
		
		this._core = core;
		this._mode = ModeEnum.AddItem;
		this.populatePanels();
		
		this.init();
	}
	
	public void init()
	{
		this._baseForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this._baseForm.getContentPane().setLayout(new FlowLayout());
		
	    this._baseForm.pack();
	    this._baseForm.setLocationRelativeTo(null);
	    this._baseForm.setVisible(true);
		
	}
	
	private void populatePanels()
	{
		this._panels.put(ModeEnum.AddItem, new AddItemDlg(this, this._core));
		this._panels.put(ModeEnum.AddItem, new MainDlg(this, this._core));
	}
	
	public void changeState(ModeEnum newMode)
	{
		if(this._mode != newMode)
		{
			this._mode = newMode;
			this.updatePanel();			
		}
	}
	
	private void updatePanel()
	{
		switch (this._mode)
		{
		case AddItem:
			//additemdlg
		
		
		}
	}
}
