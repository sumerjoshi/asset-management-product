package Items;

import java.io.IOException;

public class Core {
	public static void main(String[] args){
		DatabaseDriver database = new DatabaseDriver();
		try {
			database.createDatabase();
			database.createItemObjects();
			database.insertItemObjects();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
