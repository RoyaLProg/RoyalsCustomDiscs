package fr.royalprog.royalscustomdiscs.events;

import fr.royalprog.royalscustomdiscs.RoyaLsCustomDiscs;
import fr.royalprog.royalscustomdiscs.commands.ReloadSoundManager;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
@Mod.EventBusSubscriber(modid = RoyaLsCustomDiscs.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {
	@SubscribeEvent
	public static void onCommandRegister(RegisterCommandsEvent event) {
		new ReloadSoundManager(event.getDispatcher());
	}
}
