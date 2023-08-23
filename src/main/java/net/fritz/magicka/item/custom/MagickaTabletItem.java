package net.fritz.magicka.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class MagickaTabletItem extends Item {
    public MagickaTabletItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        Player player = pPlayer;
       ItemStack itemstack = pPlayer.getItemInHand(pHand);
        if (!pLevel.isClientSide) {
            if (!hasRead) {
                outputText("Deciphering the text, you start to feel a headache...", player);
                hasRead = true;
            } else {
                outputText("You've already read this tablet", player);
            }
        }
        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }

    private boolean hasRead = false;

    private void outputText(String text, Player player) {
        player.sendSystemMessage(Component.literal(text));
    }
}
