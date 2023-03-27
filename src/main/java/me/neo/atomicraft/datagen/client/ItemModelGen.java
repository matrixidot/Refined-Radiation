package me.neo.atomicraft.datagen.client;

import me.neo.atomicraft.AtomiCraft;
import me.neo.atomicraft.datagen.DataGenerators;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModelGen extends ItemModelProvider {
    public ItemModelGen(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, AtomiCraft.MOD_ID, helper);
    }

    @Override
    protected void registerModels() {
        withExistingParent("ctm_transparency_test", modLoc("block/ctm_transparency_test"));
    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }
}
