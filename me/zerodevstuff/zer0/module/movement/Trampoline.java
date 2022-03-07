package me.zerodevstuff.zer0.module.movement;

import org.lwjgl.input.Keyboard;

import me.zerodevstuff.zer0.module.Category;
import me.zerodevstuff.zer0.module.Module;

public class Trampoline extends Module{

	public Trampoline() {
		super("Trampoline", 0, Category.MOVEMENT);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			if(mc.thePlayer.isInWater()) {
				mc.thePlayer.motionY += 2.0;
			}
		}
	}

}
