package norton.animademo.viewpager;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Norton on 2017/5/9.
 */

public class CudeOutTransformer implements ViewPager.PageTransformer {
    @Override
    public void transformPage(View page, float position) {

        page.setPivotX(position < 0f ? page.getWidth() : 0f);
        page.setPivotY(page.getHeight() * 0.5f);
        page.setRotationY(90f * position);

        page.setAlpha(position <= -1f || position >= 1f ? 0f : 1f); // 看不见的view

    }
}
