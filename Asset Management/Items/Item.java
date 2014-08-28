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
		return this._context;
	}
	public void setContext(ItemProp _context) {
		this._context = _context;
	}

	public ItemType getType() {
		return this._type;
	}
	public void setType(ItemType _type) {
		this._type = _type;
	}
	
	
	public void setLocation(String loc)
	{
		if (this._context != null)
			this._context.setLocation(loc);
	}
	public String getLocation()
	{
		if (this._context != null)
			return this._context.getLocation();
		else
			return  "";
	}
	
	public void setDepartment(String dep)
	{
		if (this._context != null)
			this._context.setDepartment(dep);
	}
	public String getDepartment()
	{
		if (this._context != null)
			return this._context.getDepartment();
		else
			return  "";
	}
	
	public void setName(String name)
	{
		if (this._context != null)
			this._context.setName(name);
	}
	public String getName()
	{
		if (this._context != null)
			return this._context.getName();
		else
			return  "";
	}
	
	public void setDescription(String desc)
	{
		if (this._context != null)
			this._context.setDescription(desc);
	}
	public String getDescription()
	{
		if (this._context != null)
			return this._context.getDescription();
		else
			return  "";
	}
	public void setID(Integer id)
	{
		if (this._context != null)
			this._context.setID(id);
	}
	public Integer getID()
	{
		if(this._context != null)
			return this._context.getID();
		else
			return -1;
	}
	public void setUserID(Integer id)
	{
		if (this._context != null)
			this._context.setUserID(id);
	}
	public Integer getUserID()
	{
		if(this._context != null)
			return this._context.getUserID();
		else
			return -1;
	}
}

