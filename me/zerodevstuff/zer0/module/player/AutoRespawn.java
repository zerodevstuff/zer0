package me.zerodevstuff.zer0.module.player;

import me.zerodevstuff.zer0.module.Category;
import me.zerodevstuff.zer0.module.Module;
import net.minecraft.network.play.client.C16PacketClientStatus;

public class AutoRespawn extends Module{

	public AutoRespawn() {
		super("AutoRespawn", 0,  Category.PLAYER);
	}
    public void onUpdate() {
    	if(this.isToggled()) {
    	
        if (mc.thePlayer.isDead || mc.thePlayer.getHealth() <= 0) {
            mc.thePlayer.respawnPlayer();
            mc.thePlayer.sendQueue.addToSendQueue(new C16PacketClientStatus(C16PacketClientStatus.EnumState.PERFORM_RESPAWN));
        }
    }
    }
    public void onDisable() {
    	super.onDisable();
    }
}
