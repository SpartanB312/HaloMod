package halocraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemAmmoAssaultRifle extends Item {
	public ItemAmmoAssaultRifle(){
		setCreativeTab(CreativeTabs.tabCombat);
		setUnlocalizedName("ammoAssaultRifle");
		setMaxStackSize(32);
		setMaxDamage(32);
	}
}
