package com.untamedears.JukeAlert.commands;

import static com.untamedears.JukeAlert.util.Utility.findLookingAtOrClosestSnitch;

import java.util.LinkedList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.untamedears.JukeAlert.model.Snitch;
import com.untamedears.JukeAlert.util.JukeAlertPermissionHandler;
import com.untamedears.JukeAlert.util.Utility;

import vg.civcraft.mc.civmodcore.command.CivCommand;
import vg.civcraft.mc.civmodcore.command.StandaloneCommand;

@CivCommand(id = "jaclear")
public class ClearCommand extends StandaloneCommand {

	@Override
	public boolean execute(final CommandSender sender, String[] args) {
		Player player = (Player) sender;
		Snitch snitch = findLookingAtOrClosestSnitch(player, JukeAlertPermissionHandler.getClearLogs());
		if (snitch == null) {
			sender.sendMessage(
					ChatColor.RED + "You do not own any snitches nearby or lack permission to delete their logs!");
			return true;
		}
		snitch.getLoggingDelegate().deleteAllLogs();
		sender.sendMessage(ChatColor.GREEN + "Deleted all logs for snitch " + Utility.genTextComponent(snitch));
		return true;
	}

	@Override
	public List<String> tabComplete(CommandSender sender, String[] args) {
		return new LinkedList<>();
	}
}