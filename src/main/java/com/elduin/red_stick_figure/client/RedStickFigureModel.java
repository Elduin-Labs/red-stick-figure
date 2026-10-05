package com.elduin.red_stick_figure.client;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

/**
 * A stick figure: every line is one pixel thick. The head is an empty square ring with no face,
 * then a straight body, two arms and two legs. 32 pixels tall, which is two blocks.
 */
public class RedStickFigureModel extends EntityModel<RedStickFigureRenderState> {

	private final ModelPart head;
	private final ModelPart rightArm;
	private final ModelPart leftArm;
	private final ModelPart rightLeg;
	private final ModelPart leftLeg;

	public RedStickFigureModel(ModelPart root) {
		super(root);
		this.head = root.getChild("head");
		this.rightArm = root.getChild("right_arm");
		this.leftArm = root.getChild("left_arm");
		this.rightLeg = root.getChild("right_leg");
		this.leftLeg = root.getChild("left_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();

		// The head: four thin bars make a hollow square. Its bottom edge is the neck.
		root.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-4.0F, -8.0F, -0.5F, 8.0F, 1.0F, 1.0F)
						.addBox(-4.0F, -1.0F, -0.5F, 8.0F, 1.0F, 1.0F)
						.addBox(-4.0F, -7.0F, -0.5F, 1.0F, 6.0F, 1.0F)
						.addBox(3.0F, -7.0F, -0.5F, 1.0F, 6.0F, 1.0F),
				PartPose.offset(0.0F, 8.0F, 0.0F));

		root.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 12.0F, 1.0F),
				PartPose.offset(0.0F, 8.0F, 0.0F));

		root.addOrReplaceChild("right_arm",
				CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 10.0F, 1.0F),
				PartPose.offset(0.0F, 10.0F, 0.0F));
		root.addOrReplaceChild("left_arm",
				CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 10.0F, 1.0F),
				PartPose.offset(0.0F, 10.0F, 0.0F));

		root.addOrReplaceChild("right_leg",
				CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 12.0F, 1.0F),
				PartPose.offset(0.0F, 20.0F, 0.0F));
		root.addOrReplaceChild("left_leg",
				CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 12.0F, 1.0F),
				PartPose.offset(0.0F, 20.0F, 0.0F));

		return LayerDefinition.create(mesh, 32, 32);
	}

	@Override
	public void setupAnim(RedStickFigureRenderState state) {
		this.head.yRot = state.yRot * Mth.DEG_TO_RAD;
		this.head.xRot = state.xRot * Mth.DEG_TO_RAD;

		// Walking: arms and legs swing against each other.
		float swing = Mth.cos(state.walkAnimationPos * 0.6662F) * 1.2F * state.walkAnimationSpeed;
		this.rightLeg.xRot = swing;
		this.leftLeg.xRot = -swing;
		this.rightArm.xRot = -swing;
		this.leftArm.xRot = swing;

		// Arms and legs stick out to the sides a little, like a drawing of a stick figure.
		this.rightArm.zRot = 0.5F;
		this.leftArm.zRot = -0.5F;
		this.rightLeg.zRot = 0.15F;
		this.leftLeg.zRot = -0.15F;
	}
}
