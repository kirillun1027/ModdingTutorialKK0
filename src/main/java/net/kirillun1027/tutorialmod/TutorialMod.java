package net.kirillun1027.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.kirillun1027.tutorialmod.block.ModBlocks;
import net.kirillun1027.tutorialmod.component.ModDataComponentTypes;
import net.kirillun1027.tutorialmod.item.ModItemGroups;
import net.kirillun1027.tutorialmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();

        ModDataComponentTypes.registerDataComponents();

        FuelRegistry.INSTANCE.add(ModItems.BIOFUEL_POWDER, 600);
	}
}