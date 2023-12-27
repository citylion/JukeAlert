package com.untamedears.jukealert.model.field;

import com.google.common.collect.Lists;
import com.untamedears.jukealert.model.Snitch;
import com.untamedears.jukealert.model.SnitchQTEntry;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.Collection;

public class CurtainBiasedCubeRangeManager implements FieldManager{
	//downward biased

	private Snitch snitch;
	private SnitchQTEntry entry;
	private int width;


	public CurtainBiasedCubeRangeManager(int width, Snitch snitch) {

		entry = new SnitchQTEntry(snitch, snitch.getLocation(), width);
		this.snitch = snitch;
		this.width = width;
	}

	@Override
	public boolean isInside(Location location) {

		System.out.println("Hit1");
		int x = snitch.getLocation().getBlockX();
		if (location.getBlockX() > (x + width) || location.getBlockX() < (x - width)) {
			return false;
		}
		int y = snitch.getLocation().getBlockY();
		if (location.getBlockY() > (y + width)) {
			return false;
		}
		int z = snitch.getLocation().getBlockZ();
		if (location.getBlockZ() > (z + width) || location.getBlockZ() < (z - width)) {
			return false;
		}
		System.out.println("Hit2");
		return true;
	}

	@Override
	public Collection<SnitchQTEntry> getQTEntries() {
		return Lists.asList(entry, new SnitchQTEntry[0]);
	}

}
