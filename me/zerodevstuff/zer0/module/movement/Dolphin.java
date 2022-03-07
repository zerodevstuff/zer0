package me.zerodevstuff.zer0.module.movement;

import org.lwjgl.input.Keyboard;

import me.zerodevstuff.zer0.module.Category;
import me.zerodevstuff.zer0.module.Module;

public class Dolphin extends Module{

	public Dolphin() {
		super("Dolphin", 0, Category.MOVEMENT);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			if(mc.thePlayer.isInWater()) {
				mc.thePlayer.motionY += 0.4;
			}
		}
	}

}
