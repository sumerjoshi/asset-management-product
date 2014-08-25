package Items;


public class ItemProp
{
	private String _location;
	private String _department;
	private String _name;
	private String _description;
	private Integer id;
	
	public ItemProp()
	{
	}
	
	public ItemProp(String loc, String dep, String name, String desc, Integer id)
	{
		this._location = loc;
		this._department = dep;
		this._name = name;
		this._description = desc;
		this.id = id;
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
	public String getDescription()
	{
		return this._description;
	}

	public Integer getID() {
		return id;
	}

	public void setID(Integer _id) {
		this.id = _id;
	}
}