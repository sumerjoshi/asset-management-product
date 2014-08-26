package GUI;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Core.ICore;

public class MainGUI
{
	
	private JFrame _baseForm;
	private JPanel _basePane;

	
	private ModeEnum _mode;
	
	private ICore _core;
	
	public MainGUI(ICore core)
	{
		this._baseForm = new JFrame("Gooey");
		this._basePane = new JPanel();

		this._core = core;
		this._mode = ModeEnum.AddItem;
		init();
	}
	
	public void init()
	{
		this._baseForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this._baseForm.getContentPane().setLayout(new FlowLayout());
		
		
		this._baseForm.add(this._basePane);
	    this._baseForm.pack();
	    this._baseForm.setLocationRelativeTo(null);
	    this._baseForm.setVisible(true);
		
	}
}
