package me.zerodevstuff.zer0.module.movement;

import org.lwjgl.input.Keyboard;

import me.zerodevstuff.zer0.module.Category;
import me.zerodevstuff.zer0.module.Module;
import net.minecraft.entity.Entity;

public class Parkour extends Module{

	public Parkour() {
		super("Parkour", 0, Category.MOVEMENT);
	}
	public void onUpdate() {
		if(this.isToggled()) {
			if(mc.thePlayer.onGround && !mc.thePlayer.isSneaking() && !this.mc.gameSettings.keyBindSneak.isPressed() &&
					this.mc.theWorld.getCollidingBoundingBoxes((Entity)mc.thePlayer, mc.thePlayer.getEntityBoundingBox().offset(0.0d, -0.5d, 0.0d).expand(-0.01d, 0.0d, -0.001d)).isEmpty())
				mc.thePlayer.jump();
		}
	}

}
