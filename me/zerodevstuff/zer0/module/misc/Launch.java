package me.zerodevstuff.zer0.module.misc;

import me.zerodevstuff.zer0.module.Category;
import me.zerodevstuff.zer0.module.Module;

public class Launch extends Module{

	public Launch() {
		super("Launch (risky)", 0, Category.FUNNY);
	}
	
	@Override
	public void onDisable() {
		mc.gameSettings.keyBindJump.pressed = false;
		super.onDisable();
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			mc.gameSettings.keyBindJump.pressed = false;
			if(mc.thePlayer.onGround) {
				mc.thePlayer.motionY += 100.0f;
			}
		}
	}

}