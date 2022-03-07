package me.zerodevstuff.zer0.module.combat;

import java.util.Iterator;
import java.util.List;

import org.lwjgl.input.Keyboard;

import me.zerodevstuff.zer0.module.Category;
import me.zerodevstuff.zer0.module.Module;
import me.zerodevstuff.zer0.utils.Wrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;

public class KillAurarot extends Module {

	public KillAurarot() {
		super("KillAura rot", 0, Category.COMBAT);
	}

	public void onUpdate() {
		if (this.isToggled()) {
			this.killaura();
		}
	}

	int delay;

	private void killaura() {
		List list = Wrapper.mc.theWorld.playerEntities;
		delay++;

		for (int k = 0; k < list.size(); k++) {
			if (((EntityPlayer) list.get(k)).getName() == Wrapper.mc.thePlayer.getName()) {
				continue;
			}

			EntityPlayer entityplayer = (EntityPlayer) list.get(1);

			if (Wrapper.mc.thePlayer.getDistanceToEntity(entityplayer) > Wrapper.mc.thePlayer.getDistanceToEntity((Entity) list.get(k))) {
				entityplayer = (EntityPlayer) list.get(k);
			}

			float f = Wrapper.mc.thePlayer.getDistanceToEntity(entityplayer);

			if (f < 4F && Wrapper.mc.thePlayer.canEntityBeSeen(entityplayer) && delay > 7) {
				this.faceEntity(entityplayer);
				Wrapper.mc.playerController.attackEntity(Wrapper.mc.thePlayer, entityplayer);
				Wrapper.mc.thePlayer.swingItem();
				delay = 0;
				continue;
			}
		}
	}

	public static synchronized void faceEntity(EntityLivingBase entity) {
		final float[] rotations = getRotationsNeeded(entity);

		if (rotations != null) {
			Minecraft.getMinecraft().thePlayer.rotationYaw = rotations[0];
			Minecraft.getMinecraft().thePlayer.rotationPitch = rotations[1] + 1.0F;// 14
		}
	}

	public static float[] getRotationsNeeded(Entity entity) {
		if (entity == null) {
			return null;
		}

		final double diffX = entity.posX - Minecraft.getMinecraft().thePlayer.posX;
		final double diffZ = entity.posZ - Minecraft.getMinecraft().thePlayer.posZ;
		double diffY;

		if (entity instanceof EntityLivingBase) {
			final EntityLivingBase entityLivingBase = (EntityLivingBase) entity;
			diffY = entityLivingBase.posY + entityLivingBase.getEyeHeight() - (Minecraft.getMinecraft().thePlayer.posY + Minecraft.getMinecraft().thePlayer.getEyeHeight());
		} else {
			diffY = (entity.boundingBox.minY + entity.boundingBox.maxY) / 2.0D - (Minecraft.getMinecraft().thePlayer.posY + Minecraft.getMinecraft().thePlayer.getEyeHeight());
		}

		final double dist = MathHelper.sqrt_double(diffX * diffX + diffZ * diffZ);
		final float yaw = (float) (Math.atan2(diffZ, diffX) * 180.0D / Math.PI) - 90.0F;
		final float pitch = (float) -(Math.atan2(diffY, dist) * 180.0D / Math.PI);
		return new float[] { Minecraft.getMinecraft().thePlayer.rotationYaw + MathHelper.wrapAngleTo180_float(yaw - Minecraft.getMinecraft().thePlayer.rotationYaw), Minecraft.getMinecraft().thePlayer.rotationPitch + MathHelper.wrapAngleTo180_float(pitch - Minecraft.getMinecraft().thePlayer.rotationPitch) };
	}

}