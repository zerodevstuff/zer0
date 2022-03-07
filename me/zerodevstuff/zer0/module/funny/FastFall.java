package me.zerodevstuff.zer0.module.funny;

import me.zerodevstuff.zer0.module.Category;
import me.zerodevstuff.zer0.module.Module;

public class FastFall extends Module{

	public FastFall() {
		super("FastFall", 0, Category.MISC);
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
			if(!mc.thePlayer.onGround) {
				mc.thePlayer.motionY *= 2.0f;
			}
		}
	}

}