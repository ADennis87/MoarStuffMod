package ninjapancakes87.morestuff.common;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;

public class BlockCO extends Block {
	
	public BlockCO(int par1, int par2){
		super(par1, par2, Material.rock);
		
		this.setCreativeTab(CreativeTabs.tabBlock);
		
		this.setHardness(15);
		
		this.setResistance(55F);
		
		this.setStepSound(this.soundStoneFootstep);
	}

	@Override
	public String getTextureFile(){
		return "/gfx/MoreStuff/blocks.png";
	}
}