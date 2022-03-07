package me.zerodevstuff.zer0.module.render;

import de.Hero.settings.Setting;
import me.zerodevstuff.zer0.zer0;
import me.zerodevstuff.zer0.module.Category;
import me.zerodevstuff.zer0.module.Module;
import me.zerodevstuff.zer0.utils.esp.ChestESPUtils;
import me.zerodevstuff.zer0.utils.esp.EntityEspUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntityChest;

public class ESP extends Module{

	public ESP() {
		super("ESP", 0, Category.RENDER);
	}
	public void setup() {
		zer0.instance.settingsManager.rSetting(new Setting("Player", this, false));
		zer0.instance.settingsManager.rSetting(new Setting("Mob", this, false));
		zer0.instance.settingsManager.rSetting(new Setting("Animal", this, false));
		zer0.instance.settingsManager.rSetting(new Setting("Chest", this, false));
	}
	public void onRender() {
		if(this.isToggled() && zer0.instance.settingsManager.getSettingByName("Player").getValBoolean()) {
			for(Object e: mc.theWorld.loadedEntityList) {
				if(e instanceof EntityPlayer) {
					EntityEspUtils.entityESPBox((Entity)e, 0);
				}
			}
		}
		if(this.isToggled() && zer0.instance.settingsManager.getSettingByName("Mob").getValBoolean()) {
			for(Object m: mc.theWorld.loadedEntityList) {
				if(m instanceof EntityMob) {
					EntityEspUtils.entityESPBox((Entity)m, 1);
				}
			}
		}
		if(this.isToggled() && zer0.instance.settingsManager.getSettingByName("Animal").getValBoolean()) {
			for(Object a: mc.theWorld.loadedEntityList) {
				if(a instanceof EntityAnimal) {
					EntityEspUtils.entityESPBox((Entity)a, 2);
				}
			}
		}
		if(this.isToggled() && zer0.instance.settingsManager.getSettingByName("Chest").getValBoolean()) {
			for(Object c: mc.theWorld.loadedTileEntityList) {
				if(c instanceof TileEntityChest) {
					ChestESPUtils.blockESPBox(((TileEntityChest)c).getPos());
				}
			}
		}
	}
}
