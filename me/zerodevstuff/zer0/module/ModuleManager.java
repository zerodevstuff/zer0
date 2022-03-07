package me.zerodevstuff.zer0.module;

import java.util.ArrayList;

import me.zerodevstuff.zer0.module.combat.*;
import me.zerodevstuff.zer0.module.funny.*;
import me.zerodevstuff.zer0.module.misc.*;
import me.zerodevstuff.zer0.module.movement.*;
import me.zerodevstuff.zer0.module.player.*;
import me.zerodevstuff.zer0.module.render.*;

public class ModuleManager {
	
	private static ArrayList<Module> mods;
	
	public ModuleManager() {
		mods = new ArrayList<Module>();
		newMod(new ChestStealer());
		//combat
		newMod(new Aimbot());
		newMod(new FastBow());
		newMod(new KillAura());
		newMod(new KillAurarot());
		//movement
		newMod(new AutoSprint());
		newMod(new AutoWalk());
		newMod(new BunnyHop());
		newMod(new CreativeFly());
		newMod(new Dolphin());
		newMod(new Flight());
		newMod(new Glide());
		newMod(new Jetpack());
		newMod(new NoFall());
		newMod(new Parkour());
		newMod(new Sneak());
		newMod(new Speed());
		newMod(new Spider());
		newMod(new Step());
		newMod(new Trampoline());
		//player
		newMod(new AntiAFK());
		newMod(new AntiCobweb());
		newMod(new AutoMine());
		newMod(new AutoRespawn());
		newMod(new FastPlace());
		newMod(new FastLadder());
		//render
		newMod(new ESP());
		newMod(new FullBright());
		newMod(new Xray());
		newMod(new ClickGui());
		//misc
		newMod(new FastFall());
		newMod(new TestModule());
		//funny
		newMod(new Headless());
		newMod(new Launch());
		
	}
	
	public static void newMod(Module m) {
		mods.add(m);
	}
	
	public static ArrayList<Module> getModules(){
		return mods;
	}
	
	public static void onUpdate() {
		for(Module m : mods) {
			m.onUpdate();
		}
	}
	
	public static void onRender() {
		for(Module m : mods) {
			m.onRender();
		}
	}
	
	public static void onKey(int k) {
		for(Module m : mods) {
			if(m.getKey() == k) {
				m.toggle();
			}
		}
	}

}
