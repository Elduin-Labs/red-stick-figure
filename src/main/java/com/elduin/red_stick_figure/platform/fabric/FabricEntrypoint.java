package com.elduin.red_stick_figure.platform.fabric;

//? fabric {

import com.elduin.red_stick_figure.RedStickFigure;
import dev.kikugie.fletching_table.annotation.fabric.Entrypoint;
import net.fabricmc.api.ModInitializer;

@Entrypoint("main")
public class FabricEntrypoint implements ModInitializer {

	@Override
	public void onInitialize() {
		RedStickFigure.onInitialize();
		FabricEventSubscriber.registerEvents();
	}
}
//?}
