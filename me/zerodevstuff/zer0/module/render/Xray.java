package me.zerodevstuff.zer0.module.render;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import me.zerodevstuff.zer0.module.Category;
import me.zerodevstuff.zer0.module.Module;
import net.minecraft.block.Block;


public class Xray extends Module{
	
	public static boolean enabled;
	private float oldGamma;
	public ArrayList<Block>  xrayBlocks = new ArrayList<Block>();

	public Xray() {
		super("Xray", 0, Category.RENDER);
	}
	
	@Override
	public void onEnable() {
		Xray.enabled = true;
		this.oldGamma = mc.gameSettings.gammaSetting;
		mc.gameSettings.gammaSetting = 10.0f;
		mc.gameSettings.ambientOcclusion = 0;
		mc.renderGlobal.loadRenderers();
	}
	
	@Override
	public void onDisable() {
		Xray.enabled = false;
		mc.gameSettings.gammaSetting = this.oldGamma;
		mc.gameSettings.ambientOcclusion = 1;
		mc.renderGlobal.loadRenderers();
	}
	
	public boolean shouldXrayBlock(Block blockid) {
		if(this.xrayBlocks.contains(blockid)) {
			return true;
		}
		return false;
		
	}

}