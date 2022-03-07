package me.zerodevstuff.zer0.module.movement;

import org.lwjgl.input.Keyboard;

import me.zerodevstuff.zer0.module.Category;
import me.zerodevstuff.zer0.module.Module;
import net.minecraft.block.material.Material;

public class Glide extends Module{

	public Glide() {
		super("Glide", 0, Category.MOVEMENT);
	}
	
	public void onUpdate() {
		double oldY = mc.thePlayer.motionY;
		float oldJ = mc.thePlayer.jumpMovementFactor;
		if(this.isToggled()) {
			if((mc.thePlayer.motionY < 0.0d) && (mc.thePlayer.isAirBorne) && (!mc.thePlayer.isInWater()) && (!mc.thePlayer.isOnLadder())) {
				if(!mc.thePlayer.isInsideOfMaterial(Material.lava)) {
					mc.thePlayer.motionY = -.125d;
					mc.thePlayer.jumpMovementFactor *= 1.12337f;
				}
			}
		}else {
			mc.thePlayer.motionY = oldY;
			mc.thePlayer.jumpMovementFactor = oldJ;
		}
	}

}
