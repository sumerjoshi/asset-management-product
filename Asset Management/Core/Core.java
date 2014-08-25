package Core;

import java.net.UnknownHostException;
import java.util.List;

import GUI.MainGUI;
import Items.DatabaseDriver;
import Items.ItemProp;
import Items.ItemPropProtoManager;
import Items.ItemType;

import com.mongodb.MongoException;

public class Core implements ICore {
	public static void main(String[] args){
		DatabaseDriver database = new DatabaseDriver();
		try {
			database.createDatabase();
			//database.addItems();
			database.createSeedData();
			database.getData();
			database.addManager();
		}
		catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (MongoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MainGUI mg = new MainGUI(null);
	}

	@Override
	public boolean addItem(ItemProp ip, ItemType it) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteItem(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addDepartment(String dept) {
		return ItemPropProtoManager.instance().addDepartment(dept);
	}

	@Override
	public boolean addLocation(String loc) {
		return ItemPropProtoManager.instance().addLocation(loc);
	}

	@Override
	public boolean borrowItem(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ItemProp> getItemList(ItemType it) {
		// TODO Auto-generated method stub
		return null;
	}

}
