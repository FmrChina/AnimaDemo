package norton.animademo.viewpager;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Norton on 2017/5/9.
 */

public class RotateDownPageTransformer implements ViewPager.PageTransformer   {
    private static final String TAG = "RotateDownPageTransform";

    private float MINALPHA = 0.5f;

    /**
     * position取值特点：
     * 假设页面从0～1，则：
     * 第一个页面position变化为[0,-1] 当前的View
     * 第二个页面position变化为[1,0]  进入的View
     *
     * @param page
     * @param position
     */
    @Override
    public void transformPage(View page, float position) {
        if (position < -1 || position > 1) { //不可见的View
            page.setAlpha(MINALPHA);
        } else {
            if (position < 0) {//[0,-1]  当前的View

                //不透明->半透明  大小慢慢变成原来的一半
                float scalex = MINALPHA + (1 + position) * (1 - MINALPHA);
                page.setAlpha(scalex);
                page.setScaleX(scalex);
                page.setScaleY(scalex);
            } else {//[1,0] 进入的VIew

                //半透明->不透明 大小由原来的一半慢慢还原
                float scale = MINALPHA + (1 - position) * (1 - MINALPHA);
                page.setAlpha(scale);
                page.setScaleX(scale);
                page.setScaleY(scale);
            }
        }

    }
}
