package com.github.jasonlamkk.colorfulparticlesystem.initializers;

import com.github.jasonlamkk.colorfulparticlesystem.Particle;

import java.util.Random;

public interface ParticleInitializer {

    void initParticle(Particle p, Random r);

}
