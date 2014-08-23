package Items;

import java.util.ArrayList;
import java.util.List;

public class ItemPropProtoManager implements IItemPropProtoManager
{
	
	private List<String> _locationList;
	private List<String> _departmentList;
	private static ItemPropProtoManager _inst;
	
	private ItemPropProtoManager()
	{
		this._locationList = new ArrayList<String>();
		this._departmentList = new ArrayList<String>();
	}
	
	public static ItemPropProtoManager instance()
	{
		return _inst;
	}
	
	public void addLocation(String loc)
	{
		this._locationList.add(loc);
	}
	public void addDepartment(String dep)
	{
		this._departmentList.add(dep);
	}
	
	public List<String> getLocations()
	{
		return this._locationList;
	}
	
	public List<String> getDepartments()
	{
		return this._departmentList;
	}
	
	//TODO Flesh this one out
	public void populateLists()
	{
		
	}
}
