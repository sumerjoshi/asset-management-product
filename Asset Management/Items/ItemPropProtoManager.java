package Items;

import java.util.ArrayList;
import java.util.List;

public class ItemPropProtoManager implements IItemPropProtoManager
{
	
	private List<String> _locationList;
	private List<String> _departmentList;
	private static ItemPropProtoManager _inst = new ItemPropProtoManager();
	
	private ItemPropProtoManager()
	{
		this._locationList = new ArrayList<String>();
		this._departmentList = new ArrayList<String>();
	}
	
	public static ItemPropProtoManager instance()
	{
		return _inst;
	}
	
	public boolean addLocation(String loc)
	{
		if (!locationExists(loc))
		{
			this._locationList.add(loc);
			return true;
		}
		return false;
	}
	public boolean addDepartment(String dep)
	{
		if(!departmentExists(dep))
		{
			this._departmentList.add(dep);
			return true;
		}
		return false;
	}
	
	public List<String> getLocations()
	{
		return this._locationList;
	}
	
	public List<String> getDepartments()
	{
		return this._departmentList;
	}
	
	public boolean locationExists(String loc)
	{
		if(this._locationList.contains(loc))
			return true;
		return false;
	}
	public boolean departmentExists(String dept)
	{
		if(this._departmentList.contains(dept))
			return true;
		return false;
	}
	
	//TODO Flesh this one out
	public void populateLists()
	{
		
	}
}
