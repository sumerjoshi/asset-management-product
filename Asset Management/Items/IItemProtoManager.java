package Items;

public interface IItemProtoManager {

	// TODO will need fixing upon expansion of weight
	void populateDict();
	public Item getItem(ItemType type);
}
