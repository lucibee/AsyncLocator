package brightspark.asynclocator.platform;

import brightspark.asynclocator.platform.services.PlatformHelper;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.fml.ModList;

public class NeoForgePlatformHelper implements PlatformHelper {
	@Override
	public String getPlatformName() {
		return "NeoForge";
	}

	@Override
	public boolean isModLoaded(String modId) {
		return ModList.get().isLoaded(modId);
	}

	@Override
	public boolean isDevelopmentEnvironment() {
		return !FMLLoader.isProduction();
	}
}
