package halocraft.blocks;

import halocraft.HaloCraft;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class RoofBlock extends Block
{
	public static final RoofBlock instance = new RoofBlock(Material.iron);
	public static final String name = "RoofBlock";

	public RoofBlock(Material material)
	{
		super(material);
		this.lightValue = 15;
		setHardness(4.0F); // 33% harder than diamond
		setStepSound(Block.soundTypePiston); // sounds got renamed, look in Block class for what blocks have what sounds
		setUnlocalizedName("halocraft:" + name.toLowerCase()); // changed in 1.7
		setCreativeTab(halocraft.HaloCraft.haloCreativeTab);
		setHarvestLevel("pickaxe", 3);
	}

	public Block getItemDropped(int metadata, Random random, int fortune)
	{
		return HaloBlock.instance;
	}

}
