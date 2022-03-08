package me.zerodevstuff.zer0.event.events;

import me.zerodevstuff.zer0.event.Event;
import net.minecraft.network.Packet;

public class EventSendPacket extends Event {
    private Packet packet;

    public EventSendPacket(Packet packet) {
        this.packet = null;
        setPacket(packet);
    }

    public Packet getPacket() {
        return packet;
    }
    public void setPacket(Packet packet) {
        this.packet = packet;
    }
}
