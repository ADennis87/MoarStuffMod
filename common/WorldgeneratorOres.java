package ninjapancakes87.morestuff.common;

import java.util.Random;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldgeneratorOres implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
        switch (world.provider.dimensionId) {
            case 0: generateSurface(world, random, chunkX*16, chunkZ*16);
        }
	}
    private void generateSurface(World world, Random random, int blockX, int blockZ) {
		 
        int Xcoord = blockX + random.nextInt(16);
		int Ycoord = random.nextInt(60);
        int Zcoord = blockZ + random.nextInt(16);
        
        new WorldGenMinable(mod_MoreStuff.CorundumOre.blockID, 10).generate(world, random, Xcoord, Ycoord, Zcoord);	
        new WorldGenMinable(mod_MoreStuff.ZirconOre.blockID, 10).generate(world, random, Xcoord, Ycoord, Zcoord);	 
	 }
}
