package Items;

public enum ItemType{
	Cable, Monitor, PCAccessory, PC
}

public interface IItem
{
	
	
}

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


public class ItemProp
{
	private String _location;
	private String _department;
	private String _name;
	private String _description;
	
	public ItemProp()
	{
	}
	
	public ItemProp(String loc, String dep, String name, String desc)
	{
		this._location = loc;
		this._department = dep;
		this._name = name;
		this._description = desc;
	}
	
	public void setLocation(String loc)
	{
		this._location = loc;
	}
	public String getLocation()
	{
		return this._location;
	}
	
	public void setDepartment(String dep)
	{
		this._department= dep;
	}
	public String getDepartment()
	{
		return this._department;
	}
	
	public void setName(String name)
	{
		this._name = name;
	}
	public String getName()
	{
		return this._name;
	}
	
	public void setDescription(String desc)
	{
		this._description = desc;
	}
}