package me.zerodevstuff.zer0.module.misc;

import me.zerodevstuff.zer0.zer0;
import me.zerodevstuff.zer0.module.Category;
import me.zerodevstuff.zer0.module.Module;
import me.zerodevstuff.zer0.utils.Invoker;

public class TestModule extends Module{

	public TestModule() {
		super("Test", 0, Category.MISC);
	}
	public void onUpdate() {
		if(this.isToggled()) {
			Invoker.sendChatMessage("test");
			toggle();
		}
	}
	public void onDisable() {
		super.onDisable();
	}
	

	
}
