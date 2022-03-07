package me.zerodevstuff.zer0.module.movement;

import me.zerodevstuff.zer0.module.Category;
import me.zerodevstuff.zer0.module.Module;
import me.zerodevstuff.zer0.utils.*;

public class Spider extends Module{

	public Spider() {
		super("Spider", 0, Category.MOVEMENT);
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			if(Invoker.isCollidedHorizontally()) {
				Invoker.setMotionY(0.2);
				
				float var6 = 0.015f;
				if(Invoker.getMotionX() < (double)-var6) {
					Invoker.setMotionX((double)-var6);
				}
				if(Invoker.getMotionX() > (double)-var6) {
					Invoker.setMotionX((double)-var6);
			}
				
				if(Invoker.getMotionZ() > (double)-var6) {
					Invoker.setMotionZ((double)-var6);
			}
				
				if(Invoker.getMotionZ() < (double)-var6) {
					Invoker.setMotionZ((double)-var6);
			}
				Invoker.setFallDistance(0);
				
				if(Invoker.getMotionY() < 0.15D) {
					Invoker.setMotionY(-0.15D);
				}
		}
	}

}
}
