package me.zerodevstuff.zer0.module.player;

import me.zerodevstuff.zer0.module.Category;
import me.zerodevstuff.zer0.module.Module;

public class FastLadder extends Module{

	public FastLadder() {
		super("FastLadder", 0 , Category.PLAYER);
	}
	
	public void onUpdate() {
		if(this.isToggled()) {
			if(mc.thePlayer.isOnLadder() && mc.thePlayer.isCollidedHorizontally && mc.gameSettings.keyBindForward.pressed) {
				mc.thePlayer.motionY = 2f;
			}
		}
	}
	public void onDisable() {
		super.onDisable();
	}

}
