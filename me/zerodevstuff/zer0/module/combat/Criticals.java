package me.zerodevstuff.zer0.module.combat;

import me.zerodevstuff.zer0.zer0;
import me.zerodevstuff.zer0.event.EventTarget;
import me.zerodevstuff.zer0.event.events.EventSendPacket;
import me.zerodevstuff.zer0.event.events.EventUpdate;
import me.zerodevstuff.zer0.module.Category;
import me.zerodevstuff.zer0.module.Module;
import me.zerodevstuff.zer0.utils.PlayerUtils;
import de.Hero.settings.Setting;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C03PacketPlayer;

import java.util.ArrayList;

public class Criticals extends Module {
    public Criticals() {
        super("Criticals", 0, Category.COMBAT);
    }

    @Override
    public void setup() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("Packet");
        options.add("MiniJump");
        zer0.instance.settingsManager.rSetting(new Setting("Criticals Mode", this, "Packet", options));
    }

    @EventTarget
    public void onUpdate(EventUpdate event) {
        String mode = zer0.instance.settingsManager.getSettingByName("Criticals Mode").getValString();
        this.setName("Criticals \u00A77" + mode);
    }

    @EventTarget
    public void onSendPacket(EventSendPacket event) {
        String mode = zer0.instance.settingsManager.getSettingByName("Criticals Mode").getValString();

        if(canCrit()) {
            if (event.getPacket() instanceof C02PacketUseEntity) {
                C02PacketUseEntity packet = (C02PacketUseEntity)event.getPacket();
                if(packet.getAction() == C02PacketUseEntity.Action.ATTACK) {
                    if(mode.equalsIgnoreCase("Packet")) {
                        mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(mc.thePlayer.posX, mc.thePlayer.posY + .1625, mc.thePlayer.posZ, false));
                        mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(mc.thePlayer.posX, mc.thePlayer.posY, mc.thePlayer.posZ, false));
                        mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(mc.thePlayer.posX, mc.thePlayer.posY + 4.0E-6, mc.thePlayer.posZ, false));
                        mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(mc.thePlayer.posX, mc.thePlayer.posY, mc.thePlayer.posZ, false));
                        mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(mc.thePlayer.posX, mc.thePlayer.posY + 1.0E-6, mc.thePlayer.posZ, false));
                        mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(mc.thePlayer.posX, mc.thePlayer.posY, mc.thePlayer.posZ, false));
                        mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer());
                    }
                }
            }
            if(mode.equalsIgnoreCase("MiniJump")) {
                mc.thePlayer.jump();
                mc.thePlayer.motionY -= .30000001192092879;
            }
        }
    }

    private boolean canCrit() {
        return !PlayerUtils.isInLiquid() && mc.thePlayer.onGround;
    }
}
