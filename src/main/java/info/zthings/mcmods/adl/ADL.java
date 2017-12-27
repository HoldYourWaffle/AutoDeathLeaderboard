package info.zthings.mcmods.adl;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = ADL.MODID, version = ADL.VERSION, dependencies="required-after:deathcounter", acceptableRemoteVersions = "*")
public class ADL {
	public static final String MODID = "adl";
	public static final String VERSION = "1.1";
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void onDeath(LivingDeathEvent e) {
		if (e.getEntity() instanceof EntityPlayer && !e.getEntityLiving().world.isRemote) {
			e.getEntityLiving().getServer().getCommandManager().executeCommand(e.getEntityLiving().getServer(), "dc leaderboard all");
		}
	}
	
}
