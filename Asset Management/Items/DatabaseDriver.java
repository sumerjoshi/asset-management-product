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
			
		insertItemintoDB(collection, itemsList, 1, "Cable Box", "Cable Box", "Ireland", "Engineering", ItemType.Cable, null);
		insertItemintoDB(collection, itemsList, 2, "Monitor Box", "Screen Box", "Japan", "Support", ItemType.Monitor, null);
		insertItemintoDB(collection, itemsList, 3, "Question Box", "Set Question Box", "Ireland", "Support", ItemType.Monitor, null);
		insertItemintoDB(collection, itemsList, 4, "Windows Laptop", "Lenovo TL900", "San Jose", "IT", ItemType.PC, null);
		insertItemintoDB(collection, itemsList, 5, "Adobe Design Studio", "Macbook Retina Display", "Research Triangle", "Engineering", ItemType.PC, null);
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
		
		insertUserintoDB(collection, userList, 100, 0, "Josh Smith", "Cable Box", "Botswana", "Engineering", ItemType.Cable);
		insertUserintoDB(collection, userList, 101, 0, "Mary Jones", "Screen Box", "Osaka", "Support", ItemType.Monitor);
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
		
	public void insertItemintoDB(DBCollection collection, ArrayList<IItem> myList, Integer item_id, String item_name, String item_description, String location, String dept, ItemType t, Integer user_id){
		IItem temp = itemBuilder.buildItem(item_id, item_name, item_description, location, dept, t, user_id);
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
		x.append("UID", temp.getUserID());
		collection.insert(x);
	}
	
	public void insertUserintoDB(DBCollection collection, ArrayList<IItem> myList, Integer user_id, Integer item_id, String item_name, String item_description, String location, String dept, ItemType t){
		IItem temp = itemBuilder.buildItem(item_id, item_name, item_description, location, dept, t, user_id);
		BasicDBObject x = null;
		for(int i = 0; i < myList.size(); i++){
			if(temp.getUserID() == myList.get(i).getUserID()){
					return;
			}
		}
		x = new BasicDBObject();
		x.append("UID", temp.getUserID());
		x.append("Name", temp.getName());
		x.append("Location", temp.getLocation());
		x.append("Department", temp.getDepartment());
		x.append("Type", temp.getType().toString());
		collection.insert(x);
	}
	
	
	//Removing all instances in the Collection when a query has a specific value
	public void removeAllItemInstances(DBCollection collection, String query, String value){
	  BasicDBObject match = new BasicDBObject();
	  match.append(query, value);
	  collection.remove(match);
	}
	
	
	//Specific Method for Removing an Item Specifying its ItemID
	public void removeItemByID(DBCollection collection, int value){
		BasicDBObject match = new BasicDBObject();
	  match.append("ID", value);
	  collection.remove(match);
	}
	

	//Specific Method for Removing Item specifying its UserID
	public void removeUserByID(DBCollection collection, int value){
		BasicDBObject match = new BasicDBObject();
	  match.append("UID", value);
	  collection.remove(match);
	}
	
	//Could Be UID or ID
	public void removeElementGivenByID(DBCollection collection, String id, Integer id_value, String query, String value) {
		BasicDBObject match = new BasicDBObject(id,id_value);
		BasicDBObject update = new BasicDBObject(query,value);
		collection.update(match, new BasicDBObject("$unset", update));
	}
		
	//Claiming an Item for a User
	public void claimItem(DBCollection userCollection, int user_id_value, DBCollection itemCollection, int item_id_value){	
		BasicDBObject userIDfromUsersTable = new BasicDBObject("UID", user_id_value);
		BasicDBObject userIDtoBeReplaced = new BasicDBObject("ID", item_id_value);
		itemCollection.update(userIDtoBeReplaced, new BasicDBObject("$set", userIDfromUsersTable));
	}
	
	
	public void transferItem(DBCollection userCollection, int user_id_value, int new_user_id_value, DBCollection itemCollection, int item_id_value, int new_item_id_value){
		BasicDBObject ref = new BasicDBObject("ID", item_id_value);
		BasicDBObject ref2 = new BasicDBObject("UID", user_id_value);
		BasicDBObject ref3 = new BasicDBObject("ID", new_item_id_value);
		BasicDBObject ref4 = new BasicDBObject("UID", new_user_id_value);
		DBCursor cursor = itemCollection.find(ref, ref2);
		if(cursor.hasNext() && cursor.count() == 1){
			BasicDBObject dbObject = (BasicDBObject) cursor.next(); 
			String a = dbObject.getString("UID");
			if(a == null){
				claimItem(userCollection, user_id_value, itemCollection, item_id_value);
			} else {
				System.out.println("Do you want to swap item?");
				DBCursor cursor2 = itemCollection.find(ref3, ref4);
				if(cursor2.hasNext() && cursor2.count() == 1){
					itemCollection.update(ref, new BasicDBObject("$unset", ref2));
					itemCollection.update(ref, new BasicDBObject("$set", ref2));
					itemCollection.update(ref3, new BasicDBObject("$set", ref4));
			}
			}
		}
	}
}





