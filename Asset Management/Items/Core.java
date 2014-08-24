package Items;

import java.net.UnknownHostException;
import com.mongodb.MongoException;

public class Core {
	public static void main(String[] args){
		DatabaseDriver database = new DatabaseDriver();
		try {
			database.createDatabase();
			database.addItems();
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
	}

}
