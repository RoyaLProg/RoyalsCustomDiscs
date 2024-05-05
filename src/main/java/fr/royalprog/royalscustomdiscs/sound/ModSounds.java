package fr.royalprog.royalscustomdiscs.sound;

import com.mojang.logging.LogUtils;
import fr.royalprog.royalscustomdiscs.RoyaLsCustomDiscs;
import fr.royalprog.royalscustomdiscs.utils.FileManager;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.sounds.SoundEvent;
import org.slf4j.Logger;

public class ModSounds {
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
			DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, RoyaLsCustomDiscs.MODID);
	public static final RegistryObject<SoundEvent>	SOUND = registerSoundEvents("custom");

	private static final Logger LOGGER = LogUtils.getLogger();

	private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
		return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(RoyaLsCustomDiscs.MODID, name)));
	}

	public static void registerNewMusic(String name, String path) {
		FileManager fm = new FileManager();
		ResourceLocation rl = new ResourceLocation(RoyaLsCustomDiscs.MODID, name.replace("\\.ogg", ""));
		try {
			fm.CopyFile(path, rl.getPath());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		LOGGER.debug(rl.getPath());


		SOUND_EVENTS.register(name.replace("\\.ogg", ""), () -> SoundEvent.createVariableRangeEvent(rl));
	}

	public static void register(IEventBus eventBus) {
		SOUND_EVENTS.register(eventBus);
	}
}
