package me.zerodevstuff.zer0.module.player;

import me.zerodevstuff.zer0.module.Category;
import me.zerodevstuff.zer0.module.Module;

public class AntiCobweb extends Module{

	public AntiCobweb() {
		super("AntiCobweb", 0, Category.PLAYER);
	}
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			mc.thePlayer.isInWeb = false;
		}
	}

}
