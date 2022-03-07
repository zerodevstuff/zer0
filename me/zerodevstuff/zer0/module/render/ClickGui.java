package me.zerodevstuff.zer0.module.render;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import de.Hero.settings.Setting;
import me.zerodevstuff.zer0.zer0;
import me.zerodevstuff.zer0.module.Category;
import me.zerodevstuff.zer0.module.Module;

public class ClickGui extends Module{

        public ClickGui() {
        super("ClickGui", Keyboard.KEY_RSHIFT, Category.RENDER);
    }

    @Override
    public void setup() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("New");
        options.add("JellyLike");
        zer0.instance.settingsManager.rSetting(new Setting("Design", this, "New", options));
        zer0.instance.settingsManager.rSetting(new Setting("Sound", this, false));
        zer0.instance.settingsManager.rSetting(new Setting("GuiRed", this, 255, 0, 255, true));
        zer0.instance.settingsManager.rSetting(new Setting("GuiGreen", this, 26, 0, 255, true));
        zer0.instance.settingsManager.rSetting(new Setting("GuiBlue", this, 42, 0, 255, true));
    }

    @Override
    public void onEnable() {
        super.onEnable();

        mc.displayGuiScreen(zer0.instance.clickGUI);
        toggle();
    }
}