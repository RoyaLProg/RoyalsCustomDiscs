package fr.royalprog.royalscustomdiscs.datagen;

import fr.royalprog.royalscustomdiscs.RoyaLsCustomDiscs;
import fr.royalprog.royalscustomdiscs.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelGenerator extends ItemModelProvider {
	public ModItemModelGenerator(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, RoyaLsCustomDiscs.MODID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		simpleItem(ModItems.CUSTOM_DISC);
	}

	private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
		return withExistingParent(item.getId().getPath(),
				new ResourceLocation("item/generated")).texture("layer0",
				new ResourceLocation(RoyaLsCustomDiscs.MODID,"item/" + item.getId().getPath()));
	}
}
