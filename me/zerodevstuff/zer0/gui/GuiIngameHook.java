package me.zerodevstuff.zer0.gui;

import me.zerodevstuff.zer0.zer0;
import me.zerodevstuff.zer0.module.Module;
import me.zerodevstuff.zer0.utils.ColorUtils;
import me.zerodevstuff.zer0.utils.Wrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;

public class GuiIngameHook extends GuiIngame{

	public GuiIngameHook(Minecraft mcIn) {
		super(mcIn);
	}
	
	public void renderGameOverlay(float p_175180_1_) {
		super.renderGameOverlay(p_175180_1_);
		
		if(!mc.gameSettings.showDebugInfo) {
			drawRect(2, 2, 100, 14, 0x80000000);
			Wrapper.fr.drawString("zer0", 4,4, 0xd4af37);
			Wrapper.fr.drawString("FPS: " + mc.getDebugFPS(), 40, 4 , -1);
			
			renderArrayList();
		}
		

	}
	
	private void renderArrayList() {
		int yCount = 10;
		int index = 0;
		long x = 0;
		for(Module m : zer0.instance.moduleManager.getModules()) {
			m.onRender();
			
			if(m.isToggled()) {
				Wrapper.fr.drawString("- " +m.getName(), 5, yCount + 5, ColorUtils.rainbowEffect(index + x*2000000000, 1.0F).getRGB());
				yCount += 10;
				index++;
				x++;
			}
		}
	}
	

}
