package me.zerodevstuff.zer0.module.movement;

import me.zerodevstuff.zer0.module.Category;
import me.zerodevstuff.zer0.module.Module;

public class Jetpack extends Module{

	public Jetpack() {
		super("Jetpack", 0, Category.MOVEMENT);
	}
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			if(mc.gameSettings.keyBindJump.pressed) {
				mc.thePlayer.jump();
			}
		}
	}

}
