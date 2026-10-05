package com.elduin.red_stick_figure.client;

import com.elduin.red_stick_figure.RedStickFigure;
import com.elduin.red_stick_figure.entity.ModEntities;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
//? if >=26 {
/*import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
*///? } else {
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
//? }
import net.minecraft.client.model.geom.ModelLayerLocation;

public final class RedStickFigureClient {

	public static final ModelLayerLocation RED = new ModelLayerLocation(RedStickFigure.id("red_stick_figure"), "main");

	private RedStickFigureClient() {
	}

	public static void register() {
		// Fabric renamed its model layer registry in 26.
		//? if >=26 {
		/*ModelLayerRegistry.registerModelLayer(RED, RedStickFigureModel::createBodyLayer);
		*///? } else {
		EntityModelLayerRegistry.registerModelLayer(RED, RedStickFigureModel::createBodyLayer);
		//? }
		EntityRendererRegistry.register(ModEntities.RED, RedStickFigureRenderer::new);
	}
}
