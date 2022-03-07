package me.zerodevstuff.zer0.module.movement;

import me.zerodevstuff.zer0.module.Category;
import me.zerodevstuff.zer0.module.Module;

public class Sneak extends Module{

	public Sneak() {
		super("Sneak", 0, Category.MOVEMENT);
	}
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			mc.gameSettings.keyBindSneak.pressed = true;
		}
	}
	@Override
	public void onDisable() {
		mc.gameSettings.keyBindSneak.pressed = false;
		super.onDisable();
	}

}
