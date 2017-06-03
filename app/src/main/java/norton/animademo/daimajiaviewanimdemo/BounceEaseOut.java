package norton.animademo.daimajiaviewanimdemo;

import android.animation.TypeEvaluator;

/**
 * Created by Norton on 2017/5/2.
 */

public class BounceEaseOut implements TypeEvaluator<Number> {

    private float mDuration;

    public BounceEaseOut(float mDuration) {
        this.mDuration = mDuration;
    }

    @Override
    public Number evaluate(float fraction, Number startValue, Number endValue) {
        float t = mDuration * fraction;
        float b = startValue.floatValue();
        float c = endValue.floatValue() - startValue.floatValue();
        float d = mDuration;

        if ((t/=d) < (1/2.75f)) {
            return c*(7.5625f*t*t) + b;
        } else if (t < (2/2.75f)) {
            return c*(7.5625f*(t-=(1.5f/2.75f))*t + .75f) + b;
        } else if (t < (2.5/2.75)) {
            return c*(7.5625f*(t-=(2.25f/2.75f))*t + .9375f) + b;
        } else {
            return c*(7.5625f*(t-=(2.625f/2.75f))*t + .984375f) + b;
        }
    }
}
