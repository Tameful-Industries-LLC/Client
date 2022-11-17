package gg.tame.client.ui.elements.fade.types;

import gg.tame.client.ui.elements.fade.AbstractFade;

/**
 * @author Noxiuam
 * https://noxiuam.gq
 */
public class FloatFade extends AbstractFade {

    public FloatFade(long duration) {
        super(duration, 1.0f);
    }

    public FloatFade(long duration, float f) {
        super(duration, f);
    }

    @Override
    protected float getValue() {
        return (float) (this.duration - this.getTimeLeft()) / (float) this.duration;
    }

}
