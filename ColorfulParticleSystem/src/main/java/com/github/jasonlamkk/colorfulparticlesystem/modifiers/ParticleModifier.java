package com.github.jasonlamkk.colorfulparticlesystem.modifiers;

import com.github.jasonlamkk.colorfulparticlesystem.Particle;

public interface ParticleModifier {

    /**
     * modifies the specific value of a particle given the current milliseconds
     *
     * @param particle
     * @param milliseconds
     */
    void apply(Particle particle, long milliseconds);

}
