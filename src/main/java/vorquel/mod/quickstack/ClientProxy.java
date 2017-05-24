package vorquel.mod.quickstack;


import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

@SideOnly(Side.CLIENT)
public class ClientProxy extends Proxy {
    
    QuickStackHandler handler = new QuickStackHandler();
    
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        ClientRegistry.registerKeyBinding(handler.keyBinding);
    }
    
    @Override
    public void init(FMLInitializationEvent e) {
        MinecraftForge.EVENT_BUS.register(handler);
    }
    
    public static class QuickStackHandler {
    
        public KeyBinding keyBinding = new KeyBinding("Quick Stack", Keyboard.KEY_X, "Quick Stack");
    
        @SubscribeEvent
        public void quickStack(InputEvent.KeyInputEvent event) {
            if(!keyBinding.isPressed())
                return;
            QuickStack.network.sendToServer(MessageQuickStack.instance);
        }
    }
}
