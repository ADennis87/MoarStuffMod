package ninjapancakes87.morestuff.common;

import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;

public class BlockZO extends Block {
	
	public BlockZO(int par1, int par2){
		super(par1, par2, Material.rock);
		
		this.setCreativeTab(CreativeTabs.tabBlock);
		
		this.setHardness(7);
		
		this.setResistance(25F);
		
		this.setStepSound(this.soundStoneFootstep);
	}

	@Override
	public String getTextureFile(){
		return "/gfx/MoreStuff/blocks.png";
	}
	public int idDropped(int par1, Random par2Random, int par3)
    {
        return mod_MoreStuff.RawZircon.shiftedIndex;
    }
}