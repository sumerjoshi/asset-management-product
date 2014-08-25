package Items;

import java.util.HashMap;

public class ItemProtoManager implements IItemProtoManager
{

	private HashMap<ItemType, Item> _itemDict;
	private static ItemProtoManager _inst = new ItemProtoManager();
	
	private ItemProtoManager()
	{
		this._itemDict = new HashMap<ItemType, Item>();
		populateDict();
	}
	
	public static ItemProtoManager instance()
	{
		return _inst;
	}
	
	// TODO will need fixing upon expansion of weight
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
		retval = new Item(type);//this._itemDict.get(type);
		
		return retval;
	}
	
}
