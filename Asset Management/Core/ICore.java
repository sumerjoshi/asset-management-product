package Core;

import java.util.List;

import Items.ItemProp;
import Items.ItemType;

public interface ICore {
	boolean addItem(ItemProp ip, ItemType it);
<<<<<<< HEAD
	boolean addItem(String name, String desc, String loc, String dep, ItemType it);
	boolean deleteItem(long id);
=======
	boolean deleteItem(Integer id);
>>>>>>> a13e233aaf5809e7f234de531c8c19ffc60a6a6d
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
}
