package com.elduin.red_stick_figure.platform.fabric;

//? fabric {

import com.elduin.red_stick_figure.RedStickFigure;
import dev.kikugie.fletching_table.annotation.fabric.Entrypoint;
import net.fabricmc.api.ClientModInitializer;

@Entrypoint("client")
public class FabricClientEntrypoint implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		RedStickFigure.onInitializeClient();
	}

}
//?}
