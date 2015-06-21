package halocraft.render;

import halocraft.entities.EntityBullet;
import halocraft.models.ModelBullet;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderBulletEntity extends Render{
	private static final ResourceLocation bulletTextures = new ResourceLocation("halocraft:textures/entities/BulletRender.png");
	public RenderBulletEntity(RenderManager rendermanager) {
		super(rendermanager);
		shadowSize = 0.5F;
		// TODO Auto-generated constructor stub
	}
	protected ResourceLocation getEntityTexture(Entity entity){
		return bulletTextures;
	}
	public void render(EntityBullet bullet, double d, double d1, double d2, float f, float f1)
	{
		if(bullet.ticksExisted < 1)
			return;
		bindEntityTexture(bullet);
		GL11.glPushMatrix();
		GL11.glTranslatef((float) d, (float) d1, (float) d2);
		GL11.glRotatef(f, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(90F -bullet.prevRotationPitch - (bullet.rotationPitch - bullet.prevRotationPitch) * f1, 1.0F, 0.0F, 0.0F);
		ModelBase model = new ModelBullet();
		if(model != null)
			model.render(bullet, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	@Override
	public void doRender(Entity entity, double d, double d1, double d2, float f, float f1)
	{
		render((EntityBullet) entity, d, d1, d2, f, f1);
	}
	
}