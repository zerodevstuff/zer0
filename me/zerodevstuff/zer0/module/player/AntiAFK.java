package me.zerodevstuff.zer0.module.player;

import javax.management.Notification;

import me.zerodevstuff.zer0.zer0;
import me.zerodevstuff.zer0.module.Category;
import me.zerodevstuff.zer0.module.Module;
import me.zerodevstuff.zer0.utils.notifications.NotificationManager;

public class AntiAFK extends Module{

	public AntiAFK() {
		super("AntiAFK", 0, Category.PLAYER);
	}
	public void onUpdate() {
		if(this.isToggled()) {
			if(mc.thePlayer.onGround) {
				mc.thePlayer.jump();
				
			}
		}
	}
	public void onDisable() {
		super.onDisable();
	}

}
