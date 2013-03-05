package com.massivecraft.mcore.event;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.massivecraft.mcore.PS;

public class MCorePlayerPSTeleportEvent extends Event implements Cancellable, Runnable
{
	// -------------------------------------------- //
	// REQUIRED EVENT CODE
	// -------------------------------------------- //
	
	private static final HandlerList handlers = new HandlerList();
	@Override public HandlerList getHandlers() { return handlers; }
	public static HandlerList getHandlerList() { return handlers; }
	
	// -------------------------------------------- //
	// FIELDS
	// -------------------------------------------- //
	
	private boolean cancelled;
	@Override public boolean isCancelled() { return this.cancelled; }
	@Override public void setCancelled(boolean cancelled) { this.cancelled = cancelled; }
	
	private final Player player;
	public Player getPlayer() { return this.player; }
	
	private final Location from;
	public Location getFrom() { return this.from; }
	
	private PS to;
	public PS getTo() { return this.to; }
	public void setTo(PS to) { this.to = to; }
	
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public MCorePlayerPSTeleportEvent(Player player, Location from, PS to)
	{
		this.player = player;
		this.from = from;
		this.to = to;
	}
	
	// -------------------------------------------- //
	// RUN
	// -------------------------------------------- //
	
	@Override
	public void run()
	{
		Bukkit.getPluginManager().callEvent(this);
	}
	
}