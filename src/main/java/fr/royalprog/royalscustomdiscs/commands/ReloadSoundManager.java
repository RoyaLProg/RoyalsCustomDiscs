package fr.royalprog.royalscustomdiscs.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class ReloadSoundManager {
	public static void register(CommandDispatcher<CommandSourceStack> dispatcher){
		dispatcher.register(Commands.literal("reloadsounds").executes(ReloadSoundManager::execute));
	}

	private static int execute(CommandContext<CommandSourceStack> command){
		if(command.getSource().getEntity() instanceof Player player) {
			player.sendSystemMessage(Component.literal("Hello World")); // Test response
		}
		return Command.SINGLE_SUCCESS;
	}
}
