package me.Tiernanator.Utilities.Serialization;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import java.io.Serializable;

public class SerializableLocation implements Serializable {

	private static final long serialVersionUID = -4917919431258937531L;

	private int x, y, z;
	private String worldName;
	private float yaw, pitch;

	public SerializableLocation(Location location) {

		this(location.getWorld().getName(), location.getBlockX(), location.getBlockY(), location.getBlockZ(), location.getYaw(), location.getPitch());

	}

	public SerializableLocation(String worldName, int x, int y, int z, float yaw, float pitch) {

		this.worldName = worldName;
		this.x = x;
		this.y = y;
		this.z = z;
		this.yaw = yaw;
		this.pitch = pitch;

	}

	public String getWorldName() {
		return worldName;
	}

	public void setWorldName(String worldName) {
		this.worldName = worldName;
	}

	public World getWorld() {
		return Bukkit.getWorld(getWorldName());
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public float getYaw() {
		return yaw;
	}

	public void setYaw(float yaw) {
		this.yaw = yaw;
	}

	public float getPitch() {
		return pitch;
	}

	public void setPitch(float pitch) {
		this.pitch = pitch;
	}

	public Location asLocation() {

		World world = Bukkit.getServer().getWorld(getWorldName());
		return new Location(world, getX(), getY(), getZ(), getYaw(), getPitch());
	}

	@Override
	public String toString() {

		return getWorldName() + " (" + getX() + ", " + getY() + ", " + getZ() + ") @ (" + getYaw() + ", " + getPitch() + ")";

	}

}
