package Core;

import java.util.List;
import com.mongodb.DBCollection;
import Items.ItemProp;
import Items.ItemType;
import Users.IUser;

public interface ICore {

	boolean deleteItem(DBCollection collection, int id);
	boolean deleteUser(DBCollection collection, int userid);

	boolean addDepartment(String dept);
	boolean addLocation(String loc);
	boolean borrowItem(Integer id);
	List<ItemProp> getItemList(ItemType it);
	
	List<String> getLocations();
	List<String> getDepartments();
	List<String> getTypes();
	ItemType convertToIT(String type);
	
	boolean verifyUser(String username);
	boolean verifyLocation(String loc);
	boolean verifyDepartment(String dept);
	IUser getCurrentUser();

	boolean addItem(DBCollection collection, String name, String desc,
			String loc, String dep, int id, ItemType it);

	boolean addItem(DBCollection collection, ItemProp ip, ItemType it);
	boolean borrowItem(DBCollection collection, ItemProp pt1, ItemProp pt2);
	boolean verifyUser(DBCollection collection, String username);
	
	DBCollection getUserDBC();
	DBCollection getItemDBC();
}
