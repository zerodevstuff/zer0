package me.zerodevstuff.zer0.module.movement;

import me.zerodevstuff.zer0.module.Category;
import me.zerodevstuff.zer0.module.Module;
import net.minecraft.network.play.client.C03PacketPlayer;

public class Step extends Module{

	public Step() {
		super("Step", 0, Category.MOVEMENT);
	}
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			if((mc.thePlayer.isCollidedHorizontally) && (mc.thePlayer.onGround)) {
				mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(mc.thePlayer.posX, mc.thePlayer.posY+0.42, mc.thePlayer.posZ, mc.thePlayer.onGround));
				mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(mc.thePlayer.posX, mc.thePlayer.posY+0.72, mc.thePlayer.posZ, mc.thePlayer.onGround));
				mc.thePlayer.stepHeight = 1.0F;
			}
		
	}else {
		mc.thePlayer.stepHeight = 0.5f;
	}

}
}
