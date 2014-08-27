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
	public ItemBuilder itemBuilder;
	public ItemPropProtoManager manager;
	
	public DatabaseDriver(){
		
	}

	public void createDatabase() throws UnknownHostException, MongoException{
		try{
			manager = ItemPropProtoManager.instance();
			itemBuilder = new ItemBuilder();
			mongoClient = new MongoClient("localhost", 27017);
			db = mongoClient.getDB("test");
		} catch(UnknownHostException e){
			e.printStackTrace();
		} catch(MongoException e){
			e.printStackTrace();
		}
	}
	
	public DBCollection createDBCollection(String name, DBCollection c){
		c = db.getCollection(name);
		return c;
	}

	
	public void createSeedData(DBCollection collection, ArrayList<IItem> itemsList){
		itemsList = new ArrayList<IItem>(); 
		
		manager.addDepartment("Engineering");
		manager.addDepartment("Support");
		manager.addDepartment("Design");
		manager.addDepartment("IT");
	
		manager.addLocation("Ireland");
		manager.addLocation("Japan");
		manager.addLocation("San Jose");
		manager.addLocation("Research Triangle");
			
		insertItemintoDB(collection, itemsList, 1, "Cable Box", "Cable Box", "Ireland", "Engineering", ItemType.Cable);
		insertItemintoDB(collection, itemsList, 2, "Monitor Box", "Screen Box", "Japan", "Support", ItemType.Monitor);
		insertItemintoDB(collection, itemsList, 3, "Question Box", "Set Question Box", "Ireland", "Support", ItemType.Monitor);
		insertItemintoDB(collection, itemsList, 4, "Windows Laptop", "Lenovo TL900", "San Jose", "IT", ItemType.PC);
		insertItemintoDB(collection, itemsList, 5, "Adobe Design Studio", "Macbook Retina Display", "Research Triangle", "Engineering", ItemType.PC);
	}
	
	public void createUserData(DBCollection collection, ArrayList<IItem> userList){
		userList = new ArrayList<IItem>(); 
		manager.addDepartment("Engineering");
		manager.addDepartment("Support");
		manager.addDepartment("Design");
		manager.addDepartment("IT");
		
		manager.addLocation("Botswana");
		manager.addLocation("Osaka");
	
		System.out.println(ItemPropProtoManager.instance().getDepartments());
		System.out.println(ItemPropProtoManager.instance().getLocations());
		
		insertItemintoDB(collection, userList, 1, "Cable Box", "Cable Box", "Botswana", "Engineering", ItemType.Cable);
		insertItemintoDB(collection, userList, 2, "Monitor Box", "Screen Box", "Osaka", "Support", ItemType.Monitor);
	}

	
	public void getData(DBCollection collection){
		DBCursor cursor = collection.find();
    try {
       while(cursor.hasNext()) {
           System.out.println(cursor.next());
       }
    } finally {
       cursor.close();
    }
	}
	
	public void dropTable(DBCollection collection){
		collection.drop();
	}
	
	public void queryForSingleAttribute(String query, DBCollection collection){
		BasicDBObject allQuery = new BasicDBObject();
		BasicDBObject fields = new BasicDBObject();
		
		fields.put(query, 1);
	  fields.put("_id", 0);
		
	  DBCursor cursor = collection.find(allQuery, fields);
		while (cursor.hasNext()) {
			System.out.println(cursor.next());
			
		}
	}
		
	public void insertItemintoDB(DBCollection collection, ArrayList<IItem> myList, Integer item_id, String item_name, String item_description, String location, String dept, ItemType t){
		IItem temp = itemBuilder.buildItem(item_id, item_name, item_description, location, dept, t);
		BasicDBObject x = null;
		for(int i = 0; i < myList.size(); i++){
			if(temp.getID() == myList.get(i).getID()){
					return;
			}
		}
		x = new BasicDBObject();
		x.append("ID", temp.getID());
		x.append("Description", temp.getDescription());
		x.append("Name", temp.getName());
		x.append("Location", temp.getLocation());
		x.append("Department", temp.getDepartment());
		x.append("Type", temp.getType().toString());
		collection.insert(x);
	}
	
	public void removeItem(DBCollection collection, String query, String value){
	  BasicDBObject match = new BasicDBObject();
	  match.append(query, value);
	  collection.remove(match);
	}
	
	
}





