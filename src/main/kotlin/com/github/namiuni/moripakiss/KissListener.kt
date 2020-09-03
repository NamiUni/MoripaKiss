package com.github.namiuni.moripakiss

import org.bukkit.Location
import org.bukkit.Particle
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEntityEvent
import java.util.*


class KissListener :Listener  {

    @EventHandler
    fun onClickedPlayer(event: PlayerInteractEntityEvent) {
        if (event.rightClicked !is Player) return

        val player = event.player
        val clickedPlayer = event.rightClicked as Player

        val playerEyeLocation = player.eyeLocation
        val clickedPlayerFaceLocation = clickedPlayer.location.clone().add(0.0,1.75,0.0)

        spawnParticles(playerEyeLocation, clickedPlayerFaceLocation)
    }

    private fun spawnParticles(loc1: Location, loc2: Location) {
        val kissLoc: Location = loc1.clone().add((loc2.x - loc1.x) / 2, (loc2.y - loc1.y) / 2, (loc2.z - loc1.z) / 2)
        val amount: Int = 5 + Random().nextInt(10 - 5 + 1)
        loc1.world.spawnParticle(Particle.HEART, kissLoc, amount, 0.3, 0.3, 0.3)
    }
}