package vorquel.mod.quickstack;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Proxy {
    public void preInit(FMLPreInitializationEvent e) { }
    public void init(FMLInitializationEvent e)
    {
         MinecraftForge.EVENT_BUS.register(this);
    }
}
