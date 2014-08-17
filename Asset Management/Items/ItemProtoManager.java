package Items;

import java.util.HashMap;

public class ItemProtoManager {

	private HashMap<ItemType, Item> _itemDict;
	
	public ItemProtoManager()
	{
		this._itemDict = new HashMap<ItemType, Item>();
	}
	
	public void populateDict()
	{
		ItemType[] vals = ItemType.values();
		for(int i = 0; i < vals.length; i++)
		{
			_itemDict.put(vals[i], new Item(vals[i]));
		}
	}
	
	public Item getItem(ItemType type)
	{
		Item retval = null;
		retval = this._itemDict.get(type);
		
		return retval;
	}
	
}
