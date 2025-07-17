package brightspark.asynclocator.platform;

import brightspark.asynclocator.AsyncLocatorConfigNeoForge;
import brightspark.asynclocator.platform.services.ConfigHelper;

public class NeoForgeConfigHelper implements ConfigHelper {
	@Override
	public int locatorThreads() {
		return AsyncLocatorConfigNeoForge.LOCATOR_THREADS.get();
	}

	@Override
	public boolean removeOffer() {
		return AsyncLocatorConfigNeoForge.REMOVE_OFFER.get();
	}

	@Override
	public boolean dolphinTreasureEnabled() {
		return AsyncLocatorConfigNeoForge.DOLPHIN_TREASURE_ENABLED.get();
	}

	@Override
	public boolean eyeOfEnderEnabled() {
		return AsyncLocatorConfigNeoForge.EYE_OF_ENDER_ENABLED.get();
	}

	@Override
	public boolean explorationMapEnabled() {
		return AsyncLocatorConfigNeoForge.EXPLORATION_MAP_ENABLED.get();
	}

	@Override
	public boolean locateCommandEnabled() {
		return AsyncLocatorConfigNeoForge.LOCATE_COMMAND_ENABLED.get();
	}

	@Override
	public boolean villagerTradeEnabled() {
		return AsyncLocatorConfigNeoForge.VILLAGER_TRADE_ENABLED.get();
	}

	@Override
	public int mapNameCacheExpiryMinutes() {
		return AsyncLocatorConfigNeoForge.MAP_NAME_CACHE_EXPIRY_MINUTES.get();
	}

	@Override
	public int biomeSearchRadius() {
		return AsyncLocatorConfigNeoForge.BIOME_SEARCH_RADIUS.get();
	}

	@Override
	public int structureSearchRadius() {
		return AsyncLocatorConfigNeoForge.STRUCTURE_SEARCH_RADIUS.get();
	}
}
