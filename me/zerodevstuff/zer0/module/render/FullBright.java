package me.zerodevstuff.zer0.module.render;

import org.lwjgl.input.Keyboard;

import me.zerodevstuff.zer0.module.Category;
import me.zerodevstuff.zer0.module.Module;
import me.zerodevstuff.zer0.utils.Wrapper;

public class FullBright extends Module {

	public FullBright() {
		super("FullBright", 0, Category.RENDER);
	}

	public void onUpdate() {
		if (this.isToggled()) {
			Wrapper.mc.gameSettings.gammaSetting = 10f;
		} else {
			Wrapper.mc.gameSettings.gammaSetting = 1f;
		}
	}

}
