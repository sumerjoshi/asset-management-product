package Items;

import java.util.Enumeration;
import java.util.HashMap;

public class ItemProtoManager {

	private HashMap<ItemType, IItem> _itemDict;
	
	public ItemProtoManager()
	{
		this._itemDict = new HashMap<ItemType, IItem>();
	}
	
	public void populateDict()
	{
		ItemType[] vals = ItemType.values();
		for(int i = 0; i < vals.length; i++)
		{
			_itemDict.put(vals[i], new Item(vals[i]));
		}
	}
	
	
	
}
