package fr.royalprog.royalscustomdiscs.item;

import fr.royalprog.royalscustomdiscs.RoyaLsCustomDiscs;
import fr.royalprog.royalscustomdiscs.sound.ModSounds;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

	public static final DeferredRegister<Item> ITEMS =
			DeferredRegister.create(ForgeRegistries.ITEMS, RoyaLsCustomDiscs.MODID);
	public static final RegistryObject<Item> CUSTOM_DISC =
			ITEMS.register("custom_disc",
					() -> new RecordItem(6, ModSounds.SOUND, new Item.Properties().stacksTo(1), 5560));

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

}
