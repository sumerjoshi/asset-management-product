package Users;

import Core.ICore;
import Items.ItemProp;
import Items.ItemType;

public class NormalUser implements IUser {

	protected ICore _core;
	private int _id;
	private String _loc;
	private String _dept;
	private String _username;
	
	public NormalUser(ICore core)
	{
		this._core = core;
	}
	
	@Override
	public boolean addItem(ItemProp ip, ItemType it) {
		return this._core.addItem(ip, it);
	}

	@Override
	//only for admins
	public boolean removeItem(int id) {
		return false;
	}

	@Override
	//admin only
	public boolean addDepartment(String dept) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	//admin only
	public boolean addLocation(String loc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrowItem(int id) {
		return this._core.borrowItem(id);
	}

	@Override
	public int getID() {
		return this._id;
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return this._username;
	}

	@Override
	public void setUserName(String name) {
		if(name != "")
			this._username = name;
	}

	@Override
	public void setLocation(String loc) {
		if (this._core.verifyLocation(loc))
			this._loc = loc;
	}

	@Override
	public String getLocation() {
		return this._loc;
	}

	@Override
	public void setDepartment(String dept) {
		if(this._core.verifyDepartment(dept))
			this._dept = dept;

	}

	@Override
	public String getDepartment() {
		return this._dept;
	}

	@Override
	public void setID(int id) {
		if (id != 0)
			this._id = id;
		
	}

	@Override
	public ICore getCore() {
		return this._core;
	}

}
