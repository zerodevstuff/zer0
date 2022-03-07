package me.zerodevstuff.zer0.module.player;

import me.zerodevstuff.zer0.module.Category;
import me.zerodevstuff.zer0.module.Module;
import me.zerodevstuff.zer0.utils.Invoker;
import net.minecraft.util.MovingObjectPosition;

public class AutoMine extends Module{

	public AutoMine() {
		super("AutoMine", 0, Category.PLAYER);
	}
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			MovingObjectPosition hover = Invoker.getObjectMouseOver();
			
			if(hover.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
				Invoker.setKeyBindAttackPressed(true);
			}
		}else {
			Invoker.setKeyBindAttackPressed(false);
		}
	}

}
