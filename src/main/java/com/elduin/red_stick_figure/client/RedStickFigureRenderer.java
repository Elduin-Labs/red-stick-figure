package com.elduin.red_stick_figure.client;

import com.elduin.red_stick_figure.RedStickFigure;
import com.elduin.red_stick_figure.entity.RedStickFigureEntity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class RedStickFigureRenderer extends MobRenderer<RedStickFigureEntity, RedStickFigureRenderState, RedStickFigureModel> {

	private static final Identifier TEXTURE = RedStickFigure.id("textures/entity/red_stick_figure/red_stick_figure.png");

	public RedStickFigureRenderer(EntityRendererProvider.Context context) {
		super(context, new RedStickFigureModel(context.bakeLayer(RedStickFigureClient.RED)), 0.4F);
	}

	@Override
	public Identifier getTextureLocation(RedStickFigureRenderState state) {
		return TEXTURE;
	}

	@Override
	public RedStickFigureRenderState createRenderState() {
		return new RedStickFigureRenderState();
	}
}
