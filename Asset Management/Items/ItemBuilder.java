package Items;

import java.util.List;

public class ItemBuilder {

	private IItem _holder;
	private ItemProp _context;
	private IItemProtoManager _manager;
	
	public ItemBuilder()
	{
		this._manager = ItemProtoManager.instance();
	}
	
	public IItem buildItem(long id, String name, String desc, String loc, String dept, ItemType it)
	{
		boolean continueBuild = true;
		this._holder = null;
		
		if(!verifyLoc(loc))
			continueBuild = false;
		
		if(!verifyDept(dept))
			continueBuild = false;
		
		if (continueBuild)
		{
			this._context = new ItemProp(name, desc, loc, dept);
			
			this._holder = this._manager.getItem(it);
			this._holder.setContext(this._context);					
		}
		return this._holder;
	}
	
	public IItem buildItem(ItemProp props, ItemType it)
	{
		boolean continueBuild = true;
		this._holder = null;
		
		if(!verifyLoc(props.getLocation()))
			continueBuild = false;
		
		if(!verifyDept(props.getDepartment()))
			continueBuild = false;
		
		if (continueBuild)
		{
			this._context = props;
			
			this._holder = this._manager.getItem(it);
			this._holder.setContext(this._context);					
		}
		return this._holder;
	}
	
	
	public ItemProp buildItemProp(long id, String name, String desc, String loc, String dept)
	{
		boolean continueBuild = true;
		this._context = null;
		
		if(!verifyLoc(loc))
			continueBuild = false;
		
		if(!verifyDept(dept))
			continueBuild = false;
		
		if (continueBuild)
		{
			this._context = new ItemProp(name, desc, loc, dept);
			
		}
		return this._context;
	}
	
	
	private boolean verifyLoc(String loc)
	{
		boolean retval = true;
		List<String> locations = ItemPropProtoManager.instance().getLocations();
		
		if(loc == "")
			retval = false;
		if(!locations.contains(loc))
			retval = false;
		
		return retval;
	}
	private boolean verifyDept(String dept)
	{
		boolean retval = true;
		List<String> departments = ItemPropProtoManager.instance().getDepartments();
		
		if(dept == "")
			retval = false;
		if(!departments.contains(dept))
			retval = false;
		
		return retval;
	}
	
}
