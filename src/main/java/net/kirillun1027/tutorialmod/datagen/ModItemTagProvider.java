package net.kirillun1027.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.kirillun1027.tutorialmod.item.ModItems;
import net.kirillun1027.tutorialmod.util.ModTags;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.PINK_GEM)
                .add(ModItems.RAW_GEMSTONE)
                .add(Items.DIAMOND)
                .add(Items.COAL);

        getOrCreateTagBuilder(ItemTags.SWORDS).add(ModItems.PINK_GEM_SWORD);
        getOrCreateTagBuilder(ItemTags.AXES).add(ModItems.PINK_GEM_AXE);
        getOrCreateTagBuilder(ItemTags.PICKAXES).add(ModItems.PINK_GEM_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS).add(ModItems.PINK_GEM_SHOVEL);
        getOrCreateTagBuilder(ItemTags.HOES).add(ModItems.PINK_GEM_HOE);

    }


}
