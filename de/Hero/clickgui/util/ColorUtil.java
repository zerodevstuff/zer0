package de.Hero.clickgui.util;

import java.awt.Color;

//Deine Imports
import me.zerodevstuff.zer0.zer0;


public class ColorUtil {
	
	public static Color getClickGUIColor(){
		return new Color((int)zer0.instance.settingsManager.getSettingByName("GuiRed").getValDouble(), (int)zer0.instance.settingsManager.getSettingByName("GuiGreen").getValDouble(), (int)zer0.instance.settingsManager.getSettingByName("GuiBlue").getValDouble());
	}
}
