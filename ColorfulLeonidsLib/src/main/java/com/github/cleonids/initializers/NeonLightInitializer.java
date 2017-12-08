package com.github.cleonids.initializers;

import com.github.cleonids.Particle;

import java.util.Random;

/**
 * Created by jason.lam on 12/8/17.
 */

public class NeonLightInitializer implements ParticleInitializer {

    private float redStart;
    private float greenStart;
    private float blueStart;
    private float redStartVariance;
    private float greenStartVariance;
    private float blueStartVariance;

    private float redEnd;
    private float greenEnd;
    private float blueEnd;
    private float redEndVariance;
    private float greenEndVariance;
    private float blueEndVariance;

    private float startAlpha;
    private float startVarianceAlpha;
    private float endAlpha;
    private float endVarianceAlpha;

    public NeonLightInitializer(float redStart, float greenStart, float blueStart, float redStartVariance, float greenStartVariance,
                                float blueStartVariance, float redEnd, float greenEnd, float blueEnd, float redEndVariance, float greenEndVariance, float blueEndVariance,
                                float startAlpha, float startVarianceAlpha, float endAlpha, float endVarianceAlpha) {
        this.redStart = redStart;
        this.greenStart = greenStart;
        this.blueStart = blueStart;
        this.redStartVariance = redStartVariance;
        this.greenStartVariance = greenStartVariance;
        this.blueStartVariance = blueStartVariance;

        this.redEnd = redEnd;
        this.greenEnd = greenEnd;
        this.blueEnd = blueEnd;
        this.redEndVariance = redEndVariance;
        this.greenEndVariance = greenEndVariance;
        this.blueEndVariance = blueEndVariance;

        this.startAlpha = startAlpha;
        this.startVarianceAlpha = startVarianceAlpha;
        this.endAlpha = endAlpha;
        this.endVarianceAlpha = endVarianceAlpha;
    }

    @Override
    public void initParticle(Particle p, Random r) {

        p.hasColorFilter = true; // enable color , otherwise will skip filter code to save some calculation

        p.startRed = (int) (dealOverRange(((r.nextFloat() - 0.5f) * 2f * redStartVariance + redStart) / (float) Particle.RGB_MAX) * Particle.RGB_MAX);
        p.startGreen = (int) (dealOverRange(((r.nextFloat() - 0.5f) * 2f * greenStartVariance + greenStart) / (float) Particle.RGB_MAX) * Particle.RGB_MAX);
        p.startBlue = (int) (dealOverRange(((r.nextFloat() - 0.5f) * 2f * blueStartVariance + blueStart) / (float) Particle.RGB_MAX) * Particle.RGB_MAX);

        p.endRed = (int) (dealOverRange(((r.nextFloat() - 0.5f) * 2f * redEndVariance + redEnd) / (float) Particle.RGB_MAX) * Particle.RGB_MAX);
        p.endGreen = (int) (dealOverRange(((r.nextFloat() - 0.5f) * 2f * greenEndVariance + greenEnd) / (float) Particle.RGB_MAX) * Particle.RGB_MAX);
        p.endBlue = (int) (dealOverRange(((r.nextFloat() - 0.5f) * 2f * blueEndVariance + blueEnd) / (float) Particle.RGB_MAX) * Particle.RGB_MAX);

        p.startAlpha = (int) (dealOverRange(((r.nextFloat() - 0.5f) * 2f * startVarianceAlpha + startAlpha) / (float) Particle.ALPHA_MAX) * Particle.ALPHA_MAX);
        p.endAlpha = (int) (dealOverRange(((r.nextFloat() - 0.5f) * 2f * endVarianceAlpha + endAlpha) / (float) Particle.ALPHA_MAX) * Particle.ALPHA_MAX);

    }

    private float dealOverRange(float value) {
        if (value < 0) {
            return 0f;
        }
        if (value > 1) {
            return 1f;
        }
        return value;
    }
}
