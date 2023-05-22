package me.neo.refinedradiation.custom.armor.hazmat_suit;

import me.neo.refinedradiation.RefinedRadiation;
import me.neo.refinedradiation.custom.item.HazmatSuitArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class HazmatSuitArmorModel extends AnimatedGeoModel<HazmatSuitArmorItem> {
    @Override
    public ResourceLocation getModelResource(HazmatSuitArmorItem object) {
        return new ResourceLocation(RefinedRadiation.MOD_ID, "geo/hazmat_suit_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HazmatSuitArmorItem object) {
        return new ResourceLocation(RefinedRadiation.MOD_ID, "textures/models/armor/hazmat_suit_armor_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HazmatSuitArmorItem animatable) {
        return new ResourceLocation(RefinedRadiation.MOD_ID, "animations/armor_animation.json");
    }
}