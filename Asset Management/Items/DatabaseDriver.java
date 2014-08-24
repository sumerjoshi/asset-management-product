package Items;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import java.net.UnknownHostException;


public class DatabaseDriver {
	
	public Mongo mongoClient;
	public DB db;
	public DBCollection table;
	public ItemBuilder itemBuilder;
	public ArrayList<IItem> itemsList;
	public ItemPropProtoManager manager;
	
	public DatabaseDriver(){
		
	}

	public void createDatabase() throws UnknownHostException, MongoException{
		try{
			manager = ItemPropProtoManager.instance();
			itemsList = new ArrayList<IItem>();
			itemBuilder = new ItemBuilder();
			mongoClient = new MongoClient("localhost", 27017);
			db = mongoClient.getDB("test");
			System.out.println(db.getMongo().getVersion());
			table = db.getCollection("Items");
			System.out.println("DatabaseConnected");
		} catch(UnknownHostException e){
			e.printStackTrace();
		} catch(MongoException e){
			e.printStackTrace();
		}
	}
	
	public void addItems(){
		BasicDBObject document = new BasicDBObject();
		document.put("name", "sumerjoshi");
		document.put("age", 30);
		document.put("createdDate", new Date());
		table.insert(document);
		table.remove(document);
	}
	
	public void addManager(){
		manager.addDepartment("Hardware Engineering");
		manager.addLocation("Ireland");
		System.out.println(ItemPropProtoManager.instance().getDepartments());
		System.out.println(ItemPropProtoManager.instance().getLocations());
		IItem temp = itemBuilder.buildItem(1, "Cable Box", "Set Top Box", "Ireland", "Hardware Engineering", ItemType.Cable);
	}
	
	
	
	

}





