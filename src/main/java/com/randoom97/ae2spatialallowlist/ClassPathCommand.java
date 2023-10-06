package com.randoom97.ae2spatialallowlist;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ClassPathCommand extends CommandBase {

	private static final String CommandName = "saClassPath";
	
	@Override
	public String getCommandName() {
		return CommandName;
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "/" + CommandName + " | Lists the class paths of the tile entity being looked at.";
	}
	
	@Override
	public int getRequiredPermissionLevel() {
		return 0;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) {
		MovingObjectPosition mop = Minecraft.getMinecraft().objectMouseOver;
		World world = sender.getEntityWorld();
		TileEntity tileEntity = world.getTileEntity(mop.blockX, mop.blockY, mop.blockZ);
		if(tileEntity == null) {
			sender.addChatMessage(new ChatComponentText("No TileEntity found"));
			return;
		}
		sender.addChatMessage(new ChatComponentText("The class paths are as follows"));
		sender.addChatMessage(new ChatComponentText("------------------------------"));
		@SuppressWarnings("rawtypes")
		Class clazz = tileEntity.getClass();
		do {
			sender.addChatMessage(new ChatComponentText(clazz.getCanonicalName()));
		} while ((clazz = clazz.getSuperclass()) != null && clazz != TileEntity.class);	
	}
	
}
