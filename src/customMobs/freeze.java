package customMobs;

import org.bukkit.craftbukkit.v1_8_R1.entity.CraftEntity;
import org.bukkit.entity.Entity;

import net.minecraft.server.v1_8_R1.NBTTagCompound;

public class freeze {
	public static void freezeEntity(Entity en) {
		net.minecraft.server.v1_8_R1.Entity nmsEn = ((CraftEntity) en).getHandle();
	    NBTTagCompound compound = new NBTTagCompound();
	    ((net.minecraft.server.v1_8_R1.Entity) nmsEn).c(compound);
	    compound.setByte("NoAI", (byte) 1);
	    ((net.minecraft.server.v1_8_R1.Entity) nmsEn).f(compound);
	}	
}
