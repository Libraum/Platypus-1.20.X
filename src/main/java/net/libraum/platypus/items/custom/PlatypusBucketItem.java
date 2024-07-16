package net.libraum.platypus.items.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;

public class PlatypusBucketItem extends Item {
    public PlatypusBucketItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        

        return ActionResult.SUCCESS;
    }

}
