package me.neo.refinedradiation.custom.armor.hazmat_suit;

import me.neo.refinedradiation.custom.item.HazmatSuitArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class HazmatSuitArmorRenderer extends GeoArmorRenderer<HazmatSuitArmorItem> {
    public HazmatSuitArmorRenderer() {
        super(new HazmatSuitArmorModel());

        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorLeftLeg";
        this.leftLegBone = "armorRightLeg";
        this.rightBootBone = "armorLeftBoot";
        this.leftBootBone = "armorRightBoot";
    }
}