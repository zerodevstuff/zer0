package me.zerodevstuff.zer0.event;

import java.lang.reflect.InvocationTargetException;

import me.zerodevstuff.zer0.zer0;

public abstract class Event {

	private boolean cancelled;

	public enum State {
		PRE("PRE", 0), POST("POST", 1);
		private State(String string, int number) {
		}
	}

	public Event call() {
		this.cancelled = false;
		this.call(this);
		return this;
	}

	public boolean isCancelled() {
		return this.cancelled;
	}

	public void setCancelled(boolean cancelled) {

		this.cancelled = cancelled;
	}

	private static void call(Event event) {
		ArrayHelper<Data> dataList = zer0.instance.eventManager.get(event.getClass());
		if (dataList != null) {
			for (Data data : dataList) {
				try {
					data.target.invoke(data.source, event);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}

			}
		}
	}
}