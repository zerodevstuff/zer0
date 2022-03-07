package me.zerodevstuff.zer0.module.player;

import org.lwjgl.input.Keyboard;

import me.zerodevstuff.zer0.module.Category;
import me.zerodevstuff.zer0.module.Module;
import me.zerodevstuff.zer0.utils.Wrapper;

public class FastPlace extends Module {
	public FastPlace() {
		super("Fastplace", 0, Category.PLAYER);
	}

	public void onUpdate() {
		if (this.isToggled()) {
			Wrapper.mc.rightClickDelayTimer = 0;
		}
	}

	public void onDisable() {
		Wrapper.mc.rightClickDelayTimer = 6;
	}
}