package fr.royalprog.royalscustomdiscs.sound;

import fr.royalprog.royalscustomdiscs.RoyaLsCustomDiscs;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.sounds.SoundEvent;

public class ModSounds {
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
			DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, RoyaLsCustomDiscs.MODID);
	public static final RegistryObject<SoundEvent>	SOUND = registerSoundEvents("custom");

	private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
		return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(RoyaLsCustomDiscs.MODID, name)));
	}

	public static void register(IEventBus eventBus) {
		SOUND_EVENTS.register(eventBus);
	}
}
