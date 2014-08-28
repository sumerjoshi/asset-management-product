package Core;

import java.util.List;

import Items.ItemProp;
import Items.ItemType;

public interface ICore {
	boolean addItem(ItemProp ip, ItemType it);
	boolean deleteItem(Integer id);
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
