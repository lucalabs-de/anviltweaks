package de.lucalabs.anvils;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnvilTweaks implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("anviltweaks");

	@Override
	public void onInitialize() {
		LOGGER.info("Loading Anvil Tweaks");
	}
}
