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
			this._context = new ItemProp(loc, dept,name, desc);
			
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
			this._context = new ItemProp(loc, dept,name, desc);
			
		}
		return this._context;
	}
	
	
	private boolean verifyLoc(String loc)
	{
		return ItemPropProtoManager.instance().locationExists(loc);
	}
	private boolean verifyDept(String dept)
	{
		return ItemPropProtoManager.instance().departmentExists(dept);
	}
	
}
