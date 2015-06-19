package halocraft;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class HaloBlock extends Block {
    public HaloBlock(Material material) 
    {
            super(material);
            setHardness(4.0F); // 33% harder than diamond
            setStepSound(Block.soundTypePiston); // sounds got renamed, look in Block class for what blocks have what sounds
            setUnlocalizedName("HaloBlock"); // changed in 1.7
            setCreativeTab(CreativeTabs.tabBlock);
            setHarvestLevel("pickaxe", 3);
    }

 
	public Block getItemDropped(int metadata, Random random, int fortune) {
        return halocraft.Main.HaloBlock;
    }

}