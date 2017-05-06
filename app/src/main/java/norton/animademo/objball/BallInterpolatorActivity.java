package norton.animademo.objball;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import norton.animademo.R;

public class BallInterpolatorActivity extends AppCompatActivity {

    @Bind(R.id.rl_root)
    RelativeLayout rootView;

    @Bind(R.id.img_ball)
    ImageView imgBall;

    public static void startAction(Context context) {
        Intent mIntent = new Intent(context, BallInterpolatorActivity.class);
        context.startActivity(mIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ball_interpolator);
        ButterKnife.bind(this);
    }

    /**
     *  这个方法hasFocus true表示页面绘制完成，这样 view.getWidth 之类的方法就不会返回 0
     * @param hasFocus
     */
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus){
            init();
        }
    }

    private void init() {

        Interpolator line = new LinearInterpolator();//线性
        Interpolator acc = new AccelerateInterpolator();//加速
        Interpolator dce = new DecelerateInterpolator();//减速
        Interpolator accdec = new AccelerateDecelerateInterpolator();//先加速后减速

        int width = rootView.getWidth();
        int height = rootView.getHeight();
        PointF pointF1 = new PointF(rootView.getWidth()/2, 0);
        PointF pointF2 = new PointF(width / 2 - imgBall.getWidth(), height - imgBall.getHeight());

        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setObjectValues(pointF1, pointF2);
        valueAnimator.setInterpolator(dce); //设置插值器 默认是 LinearInterpolator（线性）；

        valueAnimator.setEvaluator(new TypeEvaluator() {
            @Override
            public Object evaluate(float fraction, Object startValue, Object endValue) {
                PointF startPoint = (PointF) startValue;
                PointF endPoint = (PointF) endValue;
                float x = startPoint.x + fraction * (endPoint.x - startPoint.x);
                float y = startPoint.y + fraction * (endPoint.y - startPoint.y);
                PointF point = new PointF(x, y);
                Log.d("Interpolator","fraction" + fraction );
                return point;
            }
        });
        valueAnimator.setDuration(1000);
        valueAnimator.start();

        //这里并没有给 View 设置动画，而是监听动画变化值，不断更新View 的位置，
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                PointF pointF = (PointF) animation.getAnimatedValue();
                imgBall.setX(pointF.x);
                imgBall.setY(pointF.y);

            }
        });

    }

}
