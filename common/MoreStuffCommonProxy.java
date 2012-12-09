package ninjapancakes87.morestuff.common;

import net.minecraftforge.client.MinecraftForgeClient;

public class MoreStuffCommonProxy {

	public void registerRenderThings()
	{
		MinecraftForgeClient.preloadTexture("/gfx/MoreStuff/blocks.png");
	}
	
	
}
