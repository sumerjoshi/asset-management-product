package Items;

import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.DB;
import com.mongodb.MongoClient;

public class DatabaseDriver {
	
	public Mongo mongoClient;
	public DB db;
	public DBCollection collection;
	public ItemBuilder itemBuilder;
	public ArrayList<IItem> itemsList;
	public ItemPropProtoManager manager;
	
	public DatabaseDriver(){
		manager = ItemPropProtoManager.instance();
		itemsList = new ArrayList<IItem>();
		itemBuilder = new ItemBuilder();
	}

	public void createDatabase() throws IOException{
		try{
			mongoClient = new MongoClient("localhost", 27017);
			db = mongoClient.getDB("test");
			collection = db.getCollection("Items");
		} catch(IOException e){
			throw new IOException("Cannot Connect");
		}
	}
	
	public void createItemObjects(){
		manager.addDepartment("Hardware Engineering");
		manager.addDepartment("Support Engineering");
		manager.addLocation("Ireland");
		manager.addLocation("Japan");
		IItem temp = itemBuilder.buildItem(1, "Cable Box", "A Cable Box for My Stuff", "Ireland", "Hardware Engineering", ItemType.Cable);
		if(temp != null)
			this.itemsList.add(temp); 
		itemBuilder.buildItem(2, "Asus 70P Monitor", "A Display Monitor by Asus", "Japan", "Support Engineering", ItemType.Monitor);
		itemsList.add(itemBuilder);
	}
	
	public void insertItemObjects() {
		BasicDBObject dbObject;
		for(int i = 0; i < itemsList.size(); i++){
			dbObject = new BasicDBObject();
			dbObject.append("Items", itemsList.get(i));
			collection.insert(dbObject);
			DBCursor cursor = collection.find();
		  while(cursor.hasNext()){
		    System.out.println(cursor.next());
		   }
		}
	}
	

}





