package norton.animademo.objball;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import norton.animademo.R;

public class RotationActivity extends AppCompatActivity {

    @Bind(R.id.ll_point_circle_1)
    LinearLayout llPointCircle1;

    @Bind(R.id.ll_point_circle_2)
    LinearLayout llPointCircle2;

    @Bind(R.id.ll_point_circle_3)
    LinearLayout llPointCircle3;

    @Bind(R.id.ll_point_circle_4)
    LinearLayout llPointCircle4;

    @Bind(R.id.ll_point_circle_11)
    LinearLayout llPointCircle11;

    @Bind(R.id.ll_point_circle_22)
    LinearLayout llPointCircle22;

    @Bind(R.id.ll_point_circle_33)
    LinearLayout llPointCircle33;

    @Bind(R.id.ll_point_circle_44)
    LinearLayout llPointCircle44;

    public static void startAction(Context context) {
        Intent mIntent = new Intent(context, RotationActivity.class);
        context.startActivity(mIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotation);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.start)
    public void onViewClicked() {
        starAnim();
        starAnim1();
    }

    private void starAnim() {
        ObjectAnimator ballAnim1 = ObjectAnimator.ofFloat(llPointCircle1,
                "rotation", 0, 360);
        ballAnim1.setDuration(2000);
        ballAnim1.setInterpolator(new AccelerateDecelerateInterpolator());

        ObjectAnimator ballAnim2 = ObjectAnimator.ofFloat(llPointCircle2,
                "rotation", 0, 360);
        ballAnim2.setStartDelay(150);
        ballAnim2.setDuration(2000 );
        ballAnim2.setInterpolator(new AccelerateDecelerateInterpolator());

        ObjectAnimator ballAnim3 = ObjectAnimator.ofFloat(llPointCircle3,
                "rotation", 0, 360);
        ballAnim3.setStartDelay(2 * 150);
        ballAnim3.setDuration(2000 );
        ballAnim3.setInterpolator(new AccelerateDecelerateInterpolator());

        ObjectAnimator ballAnim4 = ObjectAnimator.ofFloat(llPointCircle4,
                "rotation", 0, 360);
        ballAnim4.setStartDelay(3 * 150);
        ballAnim4.setDuration(2000 );
        ballAnim4.setInterpolator(new AccelerateDecelerateInterpolator());

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ballAnim1).with(ballAnim2).with(ballAnim3).with(ballAnim4);
        animatorSet.start();
    }

    private void starAnim1() {
        ObjectAnimator ballAnim1 = ObjectAnimator.ofFloat(llPointCircle11,
                "rotation", 0, 360);
        ballAnim1.setDuration(2000);
        ballAnim1.setInterpolator(new AccelerateDecelerateInterpolator());

        ObjectAnimator ballAnim2 = ObjectAnimator.ofFloat(llPointCircle22,
                "rotation", 0, 360);
        ballAnim2.setStartDelay(150);
        ballAnim2.setDuration(2000 + 150);
        ballAnim2.setInterpolator(new AccelerateDecelerateInterpolator());

        ObjectAnimator ballAnim3 = ObjectAnimator.ofFloat(llPointCircle33,
                "rotation", 0, 360);
        ballAnim3.setStartDelay(2 * 150);
        ballAnim3.setDuration(2000 + 2 * 150);
        ballAnim3.setInterpolator(new AccelerateDecelerateInterpolator());

        ObjectAnimator ballAnim4 = ObjectAnimator.ofFloat(llPointCircle44,
                "rotation", 0, 360);
        ballAnim4.setStartDelay(3 * 150);
        ballAnim4.setDuration(2000 + 3 * 150);
        ballAnim4.setInterpolator(new AccelerateDecelerateInterpolator());

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ballAnim1).with(ballAnim2).with(ballAnim3).with(ballAnim4);
        animatorSet.start();
    }
}
