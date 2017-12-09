package com.github.jasonlamkk.colorfulparticlesystem.initializers;

import com.github.jasonlamkk.colorfulparticlesystem.Particle;

import java.util.Random;

public class ScaleInitializer implements ParticleInitializer {


    private float startSize;
    private float startVarianceSize;
    private float endSize;
    private float endVarianceSize;


    public ScaleInitializer(float startSize, float startVarianceSize, float endSize, float endVarianceSize) {
        this.startSize = startSize;
        this.startVarianceSize = startVarianceSize;
        this.endSize = endSize;
        this.endVarianceSize = endVarianceSize;
    }

    @Override
    public void initParticle(Particle p, Random r) {
        p.startSize = dealOverRange((r.nextFloat() - 0.5f) * 2f * startVarianceSize + startSize);
        p.endSize = dealOverRange((r.nextFloat() - 0.5f) * 2f * endVarianceSize + endSize);
    }

    private int dealOverRange(float value) {
        if (value < 1) {
            return 1;//always display something
        }
        return (int) value;
    }

	/*
    private float mMaxScale;
	private float mMinScale;

	public ScaleInitializer(float minScale, float maxScale) {
		mMinScale = minScale;
		mMaxScale = maxScale;
	}

	@Override
	public void initParticle(Particle p, Random r) {
		float scale = r.nextFloat()*(mMaxScale-mMinScale) + mMinScale;
		p.mScale = scale;
	}
*/
}
