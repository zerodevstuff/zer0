package me.zerodevstuff.zer0.module.movement;

import org.lwjgl.input.Keyboard;

import me.zerodevstuff.zer0.module.Category;
import me.zerodevstuff.zer0.module.Module;

public class CreativeFly extends Module{

	public CreativeFly() {
		super("CreativeFly", 0, Category.MOVEMENT);
	}
	
	public void onDisable() {
		mc.thePlayer.capabilities.isFlying = false;
		super.onDisable();
	}
	
	public void onUpdate() {
		if(this.isToggled()) {
			mc.thePlayer.capabilities.isFlying = true;
		}
	}

}
