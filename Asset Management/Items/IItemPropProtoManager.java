package Items;

import java.util.List;

public interface IItemPropProtoManager {

	boolean addLocation(String loc);
	boolean addDepartment(String dep);
	
	List<String> getLocations();
	List<String> getDepartments();	
	void populateLists();
	boolean locationExists(String loc);
	boolean departmentExists(String dept);
}
