package com.github.namiuni.moripakiss;

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class MoripaKiss : JavaPlugin() {

    override fun onEnable() {
        Bukkit.getPluginManager().registerEvents(KissListener(),this);
    }


    override fun onDisable() {

    }
}
