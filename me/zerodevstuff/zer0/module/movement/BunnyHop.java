package me.zerodevstuff.zer0.module.movement;

import org.lwjgl.input.Keyboard;

import me.zerodevstuff.zer0.module.Category;
import me.zerodevstuff.zer0.module.Module;

public class BunnyHop extends Module{

	public BunnyHop() {
		super("Bhop", 0, Category.MOVEMENT);
	}
	
	@Override
	public void onDisable() {
		mc.gameSettings.keyBindJump.pressed = false;
		super.onDisable();
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			mc.gameSettings.keyBindJump.pressed = true;
			if(mc.thePlayer.onGround) {
				mc.thePlayer.motionX *= 2.19f;
				mc.thePlayer.motionZ *= 2.19f;
			}
		}
	}

}
