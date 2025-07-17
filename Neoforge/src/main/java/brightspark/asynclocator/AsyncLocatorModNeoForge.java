package brightspark.asynclocator;

import fuzs.forgeconfigapiport.neoforge.api.forge.v4.ForgeConfigRegistry;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;
import net.neoforged.neoforge.event.server.ServerStoppingEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.bus.api.IEventBus;

@Mod("asynclocator")
public class AsyncLocatorModNeoForge {
    public AsyncLocatorModNeoForge(IEventBus modEventBus) {
        // Logging before config registration
        System.out.println("[AsyncLocator] Registering server config...");
        try {
            ForgeConfigRegistry.INSTANCE.register(
                ModLoadingContext.get().getActiveContainer(),
                net.neoforged.fml.config.ModConfig.Type.SERVER,
                AsyncLocatorConfigNeoForge.SPEC
            );
            System.out.println("[AsyncLocator] Server config registered successfully.");
        } catch (Exception e) {
            System.out.println("[AsyncLocator] Error during server config registration: " + e);
            e.printStackTrace();
        }

        // Register server lifecycle listeners on the global event bus
        NeoForge.EVENT_BUS.addListener((ServerAboutToStartEvent event) -> AsyncLocator.setupExecutorService());
        NeoForge.EVENT_BUS.addListener((ServerStoppingEvent event) -> AsyncLocator.shutdownExecutorService());

        // Register config loading listener on the mod event bus
        modEventBus.addListener((ModConfigEvent.Loading event) -> brightspark.asynclocator.AsyncLocatorModCommon.printConfigs());
    }
}
