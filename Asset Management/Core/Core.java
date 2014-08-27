package Core;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import GUI.MainGUI;
import Items.DatabaseDriver;
import Items.IItem;
import Items.ItemProp;
import Items.ItemPropProtoManager;
import Items.ItemType;
import com.mongodb.DBCollection;
import com.mongodb.MongoException;

public class Core implements ICore {
	public static void main(String[] args){
		DatabaseDriver database = new DatabaseDriver();
		DBCollection itemTable = null; 
		DBCollection usersTable = null; 
		ArrayList<IItem> usersList = new ArrayList<IItem>();
		ArrayList<IItem> itemsList = new ArrayList<IItem>();
		try {
			database.createDatabase();
			itemTable = database.createDBCollection("Items", itemTable);
			usersTable = database.createDBCollection("Users", usersTable);
			System.out.println("");
			database.createSeedData(itemTable, itemsList);
			database.createUserData(usersTable, usersList);
			System.out.println("");
			database.getData(itemTable);
			System.out.println("");
			database.getData(usersTable);
			System.out.println("");
			database.queryForSingleAttribute("Name", usersTable);
			database.removeItem(itemTable,"Department", "Support");
			database.getData(itemTable);

			database.dropTable(usersTable);
			database.dropTable(itemTable);
			
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
