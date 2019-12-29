package mobManager;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;


public class equip {

	public static void updateEquipment(Entity creature, Material blockId) {
		
		EntityEquipment equiped = ((LivingEntity) creature).getEquipment();
		
		equiped.setItemInHand(new ItemStack(blockId, 1));
	
		
	}
	
}
