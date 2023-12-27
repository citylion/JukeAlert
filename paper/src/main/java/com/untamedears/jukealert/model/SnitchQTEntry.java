package com.untamedears.jukealert.model;

import org.bukkit.Location;
import vg.civcraft.mc.civmodcore.world.locations.QTBoxImpl;

public class SnitchQTEntry extends QTBoxImpl {

	private final Snitch snitch;

	public SnitchQTEntry(Snitch snitch, Location loc, int range) {
		super(loc, range);
		this.snitch = snitch;
	}

	public SnitchQTEntry(Snitch snitch, int lowerXBound, int upperXBound, int lowerZBound, int upperZBound){
		super(lowerXBound, upperXBound, lowerZBound, upperZBound);
		this.snitch = snitch;
	}
	
	public Snitch getSnitch() {
		return snitch;
	}

}
