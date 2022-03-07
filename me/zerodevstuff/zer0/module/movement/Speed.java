package me.zerodevstuff.zer0.module.movement;

import org.lwjgl.input.Keyboard;

import de.Hero.settings.Setting;
import me.zerodevstuff.zer0.zer0;
import me.zerodevstuff.zer0.module.Category;
import me.zerodevstuff.zer0.module.Module;
import net.minecraft.client.Minecraft;

public class Speed extends Module{

	public Speed() {
		super("Speed", 0, Category.MOVEMENT);
	}
	public void setup() {

	}
	
	public void onUpdate() {
		if(this.isToggled() ) {
			//if (zer0.instance.settingsManager.getSettingByName("SpeedMode").getValString().equalsIgnoreCase("Yport")) {
				if (mc.thePlayer == null || mc.theWorld == null) {
				return;
				}
				mc.thePlayer.distanceWalkedModified = 0.0f;
				if (mc.gameSettings.keyBindForward.pressed || mc.gameSettings.keyBindLeft.pressed || mc.gameSettings.keyBindRight.pressed || mc.gameSettings.keyBindBack.pressed) {
				if (mc.thePlayer.motionY > 0.1) {
				mc.thePlayer.motionY = -2.0;
				} else if (mc.thePlayer.motionY > -0.155) {
				mc.thePlayer.jump();
				}
				}
				
		}

	}
	public void onDisable() {
		super.onDisable();
	}
}
