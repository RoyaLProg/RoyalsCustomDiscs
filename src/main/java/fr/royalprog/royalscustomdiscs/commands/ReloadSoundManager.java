package fr.royalprog.royalscustomdiscs.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.logging.LogUtils;
import fr.royalprog.royalscustomdiscs.sound.ModSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import org.slf4j.Logger;

public class ReloadSoundManager {

	private static final Logger LOGGER = LogUtils.getLogger();
	public ReloadSoundManager(CommandDispatcher<CommandSourceStack> dispatcher){
		dispatcher.register(Commands.literal("reloadsounds").executes(ReloadSoundManager::execute));
	}

	private static int execute(CommandContext<CommandSourceStack> command){
		Minecraft.getInstance().getSoundManager().reload();
		try {
			ModSounds.registerNewMusic("chopin-nocturne-op.9-no.2",
					Minecraft.getInstance().gameDirectory.getAbsolutePath().replaceFirst("\\.", "musics/chopin-nocturne-op.9-no.2.ogg"));
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return Command.SINGLE_SUCCESS;
	}
}
