package net.kirillun1027.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.kirillun1027.tutorialmod.block.ModBlocks;
import net.kirillun1027.tutorialmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.RAW_GEMSTONE_BLOCK);
        addDrop(ModBlocks.MAGIC_BLOCK);

        addDrop(ModBlocks.PINK_GEM_BLOCK);
        addDrop(ModBlocks.PINK_GEM_BUTTON);
        addDrop(ModBlocks.PINK_GEM_DOOR, doorDrops(ModBlocks.PINK_GEM_DOOR));
        addDrop(ModBlocks.PINK_GEM_TRAPDOOR);
        addDrop(ModBlocks.PINK_GEM_WALL);
        addDrop(ModBlocks.PINK_GEM_STAIRS);
        addDrop(ModBlocks.PINK_GEM_SLAB, slabDrops(ModBlocks.PINK_GEM_SLAB));
        addDrop(ModBlocks.PINK_GEM_PRESSURE_PLATE);
        addDrop(ModBlocks.PINK_GEM_FENCE);
        addDrop(ModBlocks.PINK_GEM_FENCE_GATE);

        addDrop(ModBlocks.RAW_GEMSTONE_BUTTON);
        addDrop(ModBlocks.RAW_GEMSTONE_DOOR, doorDrops(ModBlocks.RAW_GEMSTONE_DOOR));
        addDrop(ModBlocks.RAW_GEMSTONE_TRAPDOOR);
        addDrop(ModBlocks.RAW_GEMSTONE_WALL);
        addDrop(ModBlocks.RAW_GEMSTONE_STAIRS);
        addDrop(ModBlocks.RAW_GEMSTONE_SLAB, slabDrops(ModBlocks.RAW_GEMSTONE_SLAB));
        addDrop(ModBlocks.RAW_GEMSTONE_PRESSURE_PLATE);
        addDrop(ModBlocks.RAW_GEMSTONE_FENCE);
        addDrop(ModBlocks.RAW_GEMSTONE_FENCE_GATE);


        addDrop(ModBlocks.GEMSTONE_ORE, multipleOreDrops(ModBlocks.GEMSTONE_ORE, ModItems.RAW_GEMSTONE, 1,2));
        addDrop(ModBlocks.GEMSTONE_DEEPSLATE_ORE, multipleOreDrops(ModBlocks.GEMSTONE_DEEPSLATE_ORE, ModItems.RAW_GEMSTONE, 1,4));



    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
