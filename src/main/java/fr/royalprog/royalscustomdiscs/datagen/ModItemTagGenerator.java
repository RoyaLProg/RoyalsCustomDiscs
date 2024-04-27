package fr.royalprog.royalscustomdiscs.datagen;

import fr.royalprog.royalscustomdiscs.RoyaLsCustomDiscs;
import fr.royalprog.royalscustomdiscs.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
	public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
							   CompletableFuture<TagLookup<Block>> p_275322, @Nullable ExistingFileHelper existingFileHelper)
	{
		super(p_275343_, p_275729_, p_275322, RoyaLsCustomDiscs.MODID, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		this.tag(ItemTags.MUSIC_DISCS)
				.add(ModItems.CUSTOM_DISC.get());
	}
}
