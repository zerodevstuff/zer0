package me.zerodevstuff.zer0.module.funny;

import me.zerodevstuff.zer0.module.Category;
import me.zerodevstuff.zer0.module.Module;

public class Headless extends Module{

	public Headless() {
		super("Headless", 0, Category.FUNNY);
	}
	public void onUpdate() {
		if(this.isToggled()) {
			mc.thePlayer.setRotationYawHead(180);
		}
	}
	public void onDisable() {
		super.onDisable();
	}

}
