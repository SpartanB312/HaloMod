package halocraft.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityGreenPlasma extends EntityThrowable{
    public EntityGreenPlasma(World par1World)
    {
        super(par1World);
    }
    public EntityGreenPlasma(World par1World, EntityLivingBase par2EntityLivingBase)
    {
        super(par1World, par2EntityLivingBase);
    }
    public EntityGreenPlasma(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }
	protected void onImpact(MovingObjectPosition p_70184_1_)
    {
        if (p_70184_1_.entityHit != null)
        {
            p_70184_1_.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 6);
        }
        if(!this.worldObj.isRemote){
        	this.setDead();
        }
    }
	@Override
	protected float getGravityVelocity()
    {
        return 0F;
    }
}

