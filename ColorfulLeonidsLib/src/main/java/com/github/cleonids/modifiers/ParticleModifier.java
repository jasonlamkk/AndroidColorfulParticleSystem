package com.github.cleonids.modifiers;

import com.github.cleonids.Particle;

public interface ParticleModifier {

    /**
     * modifies the specific value of a particle given the current milliseconds
     *
     * @param particle
     * @param milliseconds
     */
    void apply(Particle particle, long milliseconds);

}
