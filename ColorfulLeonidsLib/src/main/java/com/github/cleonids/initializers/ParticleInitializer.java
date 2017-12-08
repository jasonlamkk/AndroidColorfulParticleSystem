package com.github.cleonids.initializers;

import com.github.cleonids.Particle;

import java.util.Random;

public interface ParticleInitializer {

    void initParticle(Particle p, Random r);

}
