package Items;

import java.util.List;

public interface IItemPropProtoManager {

	void addLocation(String loc);
	void addDepartment(String dep);
	
	List<String> getLocations();
	List<String> getDepartments();	
	void populateLists();
	boolean locationExists(String loc);
	boolean departmentExists(String dept);
}
