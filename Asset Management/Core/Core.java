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
		ItemProp prop = null;
		ItemProp prop1 = null;
		try {
			
			
			this._database.createDatabase();
			

			this._database.manager.addDepartment("Engineering");
			this._database.manager.addDepartment("Support");
			this._database.manager.addDepartment("Design");
			this._database.manager.addDepartment("IT");
			
			this._database.manager.addLocation("Ireland");
			this._database.manager.addLocation("Japan");
			this._database.manager.addLocation("San Jose");
			this._database.manager.addLocation("Research Triangle");
			
			System.out.println(ItemPropProtoManager.instance().getDepartments());
			System.out.println(ItemPropProtoManager.instance().getLocations());
			
			itemTable = this._database.createDBCollection("Items");
			usersTable = this._database.createDBCollection("Users");
			System.out.println("");
			
			prop1 = new ItemProp("San Jose", "IT", "Cable Box", "This is a Cable Box", 1, null);
			this._database.insertItemintoDB(itemTable, prop1, ItemType.Monitor);
			
			prop = new ItemProp("Ireland", "Engineering", "John Smith", "", 0, 102);
			this._database.insertUserintoDB(usersTable, prop, ItemType.Cable);
			
			System.out.println("");
			this._database.getData(itemTable);
			System.out.println("");
			this._database.getData(usersTable);
			System.out.println("");
			
//			this._database.transferItem(usersTable, 101, 0 , itemTable, 2, 0);
//			this._database.getData(itemTable);
//			System.out.println("");
//			this._database.transferItem(usersTable, 100, 0 , itemTable, 3, 0);
//			this._database.getData(itemTable);
//			System.out.println("");
//			
//			this._database.transferItem(usersTable, 100, 101 , itemTable, 2, 3);
//			this._database.getData(itemTable);
//			
//		
//			
//			this._database.getData(usersTable);
			
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
	public boolean addItem(DBCollection collection, ItemProp ip, ItemType it) {
		// TODO Add this item to db.
		this._database.insertItemintoDB(collection, ip, it);
		return true;
	}
	
	@Override
	public boolean deleteItem(DBCollection collection, int id) {
		// TODO Auto-generated method stub
		this._database.removeItemByID(collection, id);
		return true;
	}
	
	@Override
	public boolean deleteUser(DBCollection collection, int id) {
		// TODO Auto-generated method stub
		this._database.removeUserByID(collection, id);
		return true;
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
	public boolean borrowItem(DBCollection collection, ItemProp pt1, ItemProp pt2) {
		// TODO Auto-generated method stub
		this._database.transferItem(collection, pt1, pt2);
		return true;
	}

	@Override
	public List<ItemProp> getItemList(ItemType it) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean verifyUser(DBCollection collection, String username) {
		// TODO return true if username is found
		this._database.queryForUsername(username, collection);
		return true;
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
	public boolean addItem(DBCollection collection, String name, String desc, String loc, String dep, int id,
			ItemType it) {
		ItemBuilder ib = new ItemBuilder();
		ItemProp ip = ib.buildItemProp(id, name, desc, loc, dep, 0);
		return this.addItem(collection, ip, it);
	}

	@Override
	public IUser getCurrentUser() {
		return this._curUser;
	}

	@Override
	public boolean borrowItem(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifyUser(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DBCollection getUserDBC() {
		return this._database.createDBCollection("Users");
	}

	@Override
	public DBCollection getItemDBC() {
		return this._database.createDBCollection("Items");
	}


}
