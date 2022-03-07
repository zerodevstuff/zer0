package me.zerodevstuff.zer0.module.movement;

import org.lwjgl.input.Keyboard;
import net.minecraft.network.play.client.*;
import me.zerodevstuff.zer0.module.Category;
import me.zerodevstuff.zer0.module.Module;

public class NoFall extends Module{

	public NoFall() {
		super("NoFall", 0, Category.MOVEMENT);
	}
	public void onUpdate() {
		if(this.isToggled()) {
			if(mc.thePlayer.fallDistance > 2F) {
				mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer(true));
			}
			super.onUpdate();
		}
	}
	

}
