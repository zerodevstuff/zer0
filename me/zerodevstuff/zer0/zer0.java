package me.zerodevstuff.zer0;

import org.lwjgl.opengl.Display;

import de.Hero.clickgui.ClickGUI;
import de.Hero.settings.SettingsManager;
import me.zerodevstuff.zer0.alt.AltManager;
import me.zerodevstuff.zer0.extensions.DiscordRP;
import me.zerodevstuff.zer0.module.ModuleManager;

public class zer0 {
	
	public static zer0 instance = new zer0();
	
	public static String name = "zer0", version = "early alpha", creator = "zerodevstuff";
	
	public static SettingsManager settingsManager;
	public static ModuleManager moduleManager;
	public static ClickGUI clickGUI;
	public static AltManager altManager;
	
	public static DiscordRP discordRP = new DiscordRP();
	
	public static void startClient() {
		settingsManager = new SettingsManager();
		moduleManager = new ModuleManager();
		clickGUI = new ClickGUI();
		discordRP.start();

		
		
		
		Display.setTitle(name + " " + version + " by " + creator);
	}
	public static DiscordRP getDiscordRP() {
		return discordRP;
	}

}