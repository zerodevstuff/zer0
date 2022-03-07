package me.zerodevstuff.zer0.module.movement;

import org.lwjgl.input.Keyboard;

import me.zerodevstuff.zer0.module.Category;
import me.zerodevstuff.zer0.module.Module;
import me.zerodevstuff.zer0.utils.Wrapper;

public class AutoSprint extends Module {

	public AutoSprint() {
		super("Sprint", 0, Category.MOVEMENT);
	}

	public void onUpdate() {
		if (!this.isToggled()) {
			return;
		}
		if (!(Wrapper.mc.thePlayer.isCollidedHorizontally) && Wrapper.mc.thePlayer.moveForward > 0.0f) {
			Wrapper.mc.thePlayer.setSprinting(true);
		} else {
			Wrapper.mc.thePlayer.setSprinting(false);
		}
	}

}