package com.github.namiuni.moripakiss

import org.bukkit.Location
import org.bukkit.Particle
import org.bukkit.Sound
import org.bukkit.SoundCategory
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEntityEvent
import org.bukkit.inventory.EquipmentSlot
import java.util.*


class KissListener :Listener  {

    @EventHandler
    fun onClickedPlayer(event: PlayerInteractEntityEvent) {
        if (event.rightClicked !is Player ) return
        if (event.hand !== EquipmentSlot.HAND) return

        val player = event.player
        val clickedPlayer = event.rightClicked as Player

        if (!player.isSneaking || !clickedPlayer.isSneaking) return

        val playerEyeLocation = player.eyeLocation
        val clickedPlayerFaceLocation = clickedPlayer.eyeLocation

        spawnParticles(playerEyeLocation, clickedPlayerFaceLocation)
    }

    private fun spawnParticles(loc1: Location, loc2: Location) {
        val kissLoc: Location = loc1.clone().add((loc2.x - loc1.x) / 2, (loc2.y - loc1.y) / 2, (loc2.z - loc1.z) / 2)
        val amount: Int = 3 + Random().nextInt(3)
        loc1.world.spawnParticle(Particle.HEART, kissLoc, amount, 0.3, 0.3, 0.3)
        loc1.world.playSound(kissLoc,Sound.ENTITY_BAT_AMBIENT,SoundCategory.MASTER,1.0f,1.2f)
    }
}