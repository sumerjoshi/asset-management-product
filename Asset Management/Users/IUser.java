package Users;

import Core.ICore;
import Items.ItemProp;
import Items.ItemType;

public interface IUser {
	boolean addItem(ItemProp ip, ItemType it);
	boolean addItem(String name, String desc, String loc, String dep, ItemType it);
	
	boolean removeItem(int id);
	boolean addDepartment(String dept);
	boolean addLocation(String loc);
	boolean borrowItem(int id);
	
	void setID(int id);
	int getID();
	String getUserName();
	void setUserName(String name);
	void setLocation(String loc);
	String getLocation();
	void setDepartment(String dept);
	String getDepartment();
	
	ICore getCore();
}
