package Items;

public class Item implements IItem
{
	private ItemProp _context;
	private ItemType _type;
	
	public Item()
	{
	}
	
	public Item(ItemType type)
	{
		this.setType(type);
	}

	public ItemProp getContext() {
		return _context;
	}

	public void setContext(ItemProp _context) {
		this._context = _context;
	}

	public ItemType getType() {
		return _type;
	}

	public void setType(ItemType _type) {
		this._type = _type;
	}
	
	
	
}
