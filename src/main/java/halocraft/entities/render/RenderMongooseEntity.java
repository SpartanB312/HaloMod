package halocraft.entities.render;

import halocraft.entities.EntityMongoose;
import halocraft.entities.EntityWarthog;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.arisux.xlib.api.wavefrontapi.Part;
import com.arisux.xlib.api.wavefrontapi.WavefrontAPI;
import com.arisux.xlib.api.wavefrontapi.WavefrontModel;
import com.arisux.xlib.client.render.XLibRenderer;

@SideOnly(Side.CLIENT)
public class RenderMongooseEntity extends Render
{
	public WavefrontModel model = WavefrontAPI.instance().loadModel(halocraft.Main.class, "halocraft", "Mongoose", "/assets/halocraft/models/entity/Mongoose");

	public RenderMongooseEntity(RenderManager renderManager)
	{
		super(renderManager);
		this.shadowSize = 0.5F;
	}
	public void doRender(EntityMongoose mongooseIn, double posX, double posY, double posZ, float yaw, float partialTicks)
	{
		XLibRenderer.pushMatrix();
		XLibRenderer.translate(posX, posY, posZ);
		double curVelocity = Math.sqrt(mongooseIn.motionX * mongooseIn.motionX + mongooseIn.motionZ * mongooseIn.motionZ);
		float tireRotation = curVelocity > 0.1 ? -(mongooseIn.worldObj.getWorldTime() % 360 * 8) - partialTicks : 0;

		if(mongooseIn.riddenByEntity != null && mongooseIn.riddenByEntity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) mongooseIn.riddenByEntity;
			GlStateManager.rotate(-(player.rotationYawHead + 90), 0, 1, 0);
		}

		for(Part p : model.nameToPartHash.values())
		{
			XLibRenderer.pushMatrix();
			{
				if(p == model.getPart("the_node.014_tri_564_geometry") || p == model.getPart("the_node.013_tri_540_geometry"))
				{
					XLibRenderer.pushMatrix();
					{
						XLibRenderer.translate(-1.4, 0.48, 0);
						GlStateManager.rotate(tireRotation, 0, 0, 1);
						XLibRenderer.translate(1.4, -0.48, 0);
						p.draw();
					}
					XLibRenderer.popMatrix();
				}
				else if(p == model.getPart("the_node.015_tri_540_geometry.001") || p == model.getPart("the_node.016_tri_540_geometry.002"))
				{
					XLibRenderer.pushMatrix();
					{
						XLibRenderer.translate(0.65, 0.45, 0);
						GlStateManager.rotate(tireRotation, 0, 0, 1);
						XLibRenderer.translate(-0.65, -0.45, 0);
						p.draw();
					}
					XLibRenderer.popMatrix();
				}
				else
				{
					p.draw();
				}
			}
			XLibRenderer.popMatrix();
		}

		XLibRenderer.popMatrix();
		super.doRender(mongooseIn, posX, posY, posZ, yaw, partialTicks);
	}

	protected ResourceLocation getEntityTexture(EntityWarthog entityWarthog)
	{
		return null;
	}

	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return null;
	}

	public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTicks)
	{
		this.doRender((EntityMongoose)entity, x, y, z, yaw, partialTicks);
	}
}