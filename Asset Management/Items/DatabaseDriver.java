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
	public ItemPropProtoManager manager;
	
	public ArrayList<IItem> cableType;
	
	public DatabaseDriver(){
		
	}

	public void createDatabase() throws UnknownHostException, MongoException{
		try{
			manager = ItemPropProtoManager.instance();
			itemBuilder = new ItemBuilder();
			mongoClient = new MongoClient("localhost", 27017);
			db = mongoClient.getDB("test");
			System.out.println(db.getMongo().getVersion());
			table = db.getCollection("Items");
		} catch(UnknownHostException e){
			e.printStackTrace();
		} catch(MongoException e){
			e.printStackTrace();
		}
	}

	
	public void createSeedData(){
		cableType = new ArrayList<IItem>(); 
		manager.addDepartment("Hardware Engineering");
		manager.addLocation("Ireland");
		manager.addDepartment("Support Engineering");
		manager.addLocation("Japan");
		System.out.println(ItemPropProtoManager.instance().getDepartments());
		System.out.println(ItemPropProtoManager.instance().getLocations());
		IItem temp = itemBuilder.buildItem(1, "Cable Box", "Set Top Box", "Ireland", "Hardware Engineering", ItemType.Cable);
		IItem temp2 = itemBuilder.buildItem(2, "Monitor Box", "Set Top Box for Screen", "Japan", "Support Engineering", ItemType.Monitor);
		IItem temp3 = itemBuilder.buildItem(3, "Question Box", "Set Question Box", "Ireland", "Support Engineering", ItemType.Monitor);
		cableType.add(temp);
		cableType.add(temp2);
		cableType.add(temp3);
		BasicDBObject x = null;
		for(int i = 0; i < cableType.size(); i++){
			if(cableType.get(i) != null){
					x = new BasicDBObject();
					x.append("ID", cableType.get(i).getID());
					x.append("Description", cableType.get(i).getDescription());
					x.append("Name", cableType.get(i).getName());
					x.append("Location", cableType.get(i).getLocation());
					x.append("Department", cableType.get(i).getDepartment());
					x.append("Type", cableType.get(i).getType().toString());
					table.insert(x);
			}
		}
	}
	
	public void getData(){
		DBCursor cursor = table.find();
    try {
       while(cursor.hasNext()) {
           System.out.println(cursor.next());
       }
    } finally {
       cursor.close();
    }
	}

	
	
	
	

}





