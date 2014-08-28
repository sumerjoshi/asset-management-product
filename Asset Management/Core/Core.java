package Core;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import GUI.MainGUI;
import Items.DatabaseDriver;
import Items.IItem;
import Items.ItemBuilder;
import Items.ItemProp;
import Items.ItemPropProtoManager;
import Items.ItemType;
import Users.IUser;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoException;

public class Core implements ICore {
	public static void main(String[] args){
		DatabaseDriver database = new DatabaseDriver();
		ICore mainCore = new Core(database);
		
		MainGUI mg = new MainGUI(mainCore);
	}
	
	private DatabaseDriver _database;
	private IUser _curUser;
	private HashMap<String, ItemType> _itLookup;
	
	public Core(DatabaseDriver database)
	{
		this._database = database;
		this._itLookup = new HashMap<String, ItemType>();
		this.initializeDB();
		this.populateITLookup();
	}
	
	private void initializeDB()
	{
		DBCollection itemTable = null; 
		DBCollection usersTable = null; 
		ArrayList<IItem> usersList = new ArrayList<IItem>();
		ArrayList<IItem> itemsList = new ArrayList<IItem>();
		BasicDBObject x = null;
		try {
			x = new BasicDBObject();
			this._database.createDatabase();
			itemTable = this._database.createDBCollection("Items", itemTable);
			usersTable = this._database.createDBCollection("Users", usersTable);
			System.out.println("");
			this._database.createSeedData(itemTable, itemsList);
			this._database.createUserData(usersTable, usersList);
			System.out.println("");
			this._database.getData(itemTable);
			System.out.println("");
			this._database.getData(usersTable);
			System.out.println("");
			
			this._database.transferItem(usersTable, 101, 0 , itemTable, 2, 0);
			this._database.getData(itemTable);
			System.out.println("");
			this._database.transferItem(usersTable, 100, 0 , itemTable, 3, 0);
			this._database.getData(itemTable);
			System.out.println("");
			
			this._database.transferItem(usersTable, 100, 101 , itemTable, 2, 3);
			this._database.getData(itemTable);
			
			this._database.dropTable(usersTable);
			this._database.dropTable(itemTable);
			
		}
		catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (MongoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void populateITLookup()
	{
		ItemType[] total = ItemType.values();
		for(int i = 0; i < total.length; i++)
		{
			this._itLookup.put(total[i].toString(), total[i]);
		}
	}
	
	@Override
	public boolean addItem(ItemProp ip, ItemType it) {
		// TODO Add this item to db.
		
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


	@Override
	public boolean verifyUser(String username) {
		// TODO return true if username is found
		return false;
	}


	@Override
	public boolean verifyLocation(String loc) {
		return ItemPropProtoManager.instance().locationExists(loc);
	}


	@Override
	public boolean verifyDepartment(String dept) {
		return ItemPropProtoManager.instance().departmentExists(dept);
	}


	@Override
	public List<String> getLocations() {
		return ItemPropProtoManager.instance().getLocations();
	}


	@Override
	public List<String> getDepartments() {
		return ItemPropProtoManager.instance().getDepartments();
	}


	@Override
	public List<String> getTypes() {
		List<String> types = new ArrayList<String>();
		ItemType[] total = ItemType.values();
		for(int i = 0; i < total.length; i++)
		{
			types.add(total[i].toString());
		}
		return types;
	}


	@Override
	public ItemType convertToIT(String type) {
		return this._itLookup.get(type);
	}

	@Override
	public boolean addItem(String name, String desc, String loc, String dep,
			ItemType it) {
		// Add stuff here
		return false;
	}

}
