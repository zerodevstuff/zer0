package me.zerodevstuff.zer0.event.events;

import me.zerodevstuff.zer0.event.Event;

public class EventKey extends Event {
    private int key;

    public EventKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }
}
