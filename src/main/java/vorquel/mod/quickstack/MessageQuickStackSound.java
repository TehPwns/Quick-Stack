package vorquel.mod.quickstack;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class MessageQuickStackSound implements IMessage { 

    public static final MessageQuickStackSound instance = new MessageQuickStackSound();
    
    public static ResourceLocation location = new ResourceLocation("quickstack", "quick_stack_notify");
    public static SoundEvent quickStackNotifyEvent = new SoundEvent(location);

    public void fromBytes(ByteBuf buf) {}
    
    @Override
    public void toBytes(ByteBuf buf) {}
    
    public static class Handler implements IMessageHandler<MessageQuickStackSound, IMessage> {
        @Override
        public IMessage onMessage(MessageQuickStackSound message, final MessageContext ctx) {
            Minecraft.getMinecraft().thePlayer.playSound(quickStackNotifyEvent, 1.0F, 1.0F);
            return null;
        }
    }    
}