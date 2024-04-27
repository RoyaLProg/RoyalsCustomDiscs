package fr.royalprog.royalscustomdiscs.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class ReloadSoundManager {
	public ReloadSoundManager(CommandDispatcher<CommandSourceStack> dispatcher){
		dispatcher.register(Commands.literal("reloadsounds").executes(ReloadSoundManager::execute));
	}

	private static int execute(CommandContext<CommandSourceStack> command){
		Minecraft.getInstance().getSoundManager().reload();
		return Command.SINGLE_SUCCESS;
	}
}
