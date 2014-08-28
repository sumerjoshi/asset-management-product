package Core;

import java.util.List;

import Items.ItemProp;
import Items.ItemType;

public interface ICore {
	boolean addItem(ItemProp ip, ItemType it);
	boolean deleteItem(long id);
	boolean addDepartment(String dept);
	boolean addLocation(String loc);
	boolean borrowItem(long id);
	List<ItemProp> getItemList(ItemType it);
	
	boolean verifyUser(String username);
	boolean verifyLocation(String loc);
	boolean verifyDepartment(String dept);
}
