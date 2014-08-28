package Users;

import Core.ICore;
import Items.ItemProp;
import Items.ItemType;

public class Admin implements IUser {

	private IUser _base;
	
	@Override
	public boolean addItem(ItemProp ip, ItemType it) {
		return this._base.addItem(ip, it);
	}

	@Override
	public boolean removeItem(int id) {
		return this._base.getCore().deleteItem(id);
	}

	@Override
	public boolean addDepartment(String dept) {
		return this._base.getCore().addDepartment(dept);
	}

	@Override
	public boolean addLocation(String loc) {
		return this._base.addLocation(loc);
	}

	@Override
	public boolean borrowItem(int id) {
		return this._base.borrowItem(id);
	}

	@Override
	public void setID(int id) {
		this._base.setID(id);

	}

	@Override
	public int getID() {
		return this._base.getID();
	}

	@Override
	public String getUserName() {
		return this._base.getUserName();
	}

	@Override
	public void setUserName(String name) {
		this._base.setUserName(name);
	}

	@Override
	public void setLocation(String loc) {
		this._base.setLocation(loc);
	}

	@Override
	public String getLocation() {
		return this._base.getLocation();
	}

	@Override
	public void setDepartment(String dept) {
		this._base.setDepartment(dept);
	}

	@Override
	public String getDepartment() {
		return this._base.getDepartment();
	}

	@Override
	public ICore getCore() {
		return this._base.getCore();
	}

	@Override
	public boolean addItem(String name, String desc, String loc, String dep,
			int id, ItemType it) {
		
		return this._base.addItem(name, desc, loc, dep, id, it);
	}

}
