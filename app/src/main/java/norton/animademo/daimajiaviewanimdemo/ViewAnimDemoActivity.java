package norton.animademo.daimajiaviewanimdemo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import norton.animademo.R;
import norton.animademo.typeevaluator.BounceEaseOut;

public class ViewAnimDemoActivity extends AppCompatActivity {

    @Bind(R.id.tv_view)
    TextView tvView;

    @Bind(R.id.wrapper)
    LinearLayout wrapper;

    @Bind(R.id.tv_dropout)
    TextView tvDropout;

    public static void startAction(Context context) {
        Intent mIntent = new Intent(context, ViewAnimDemoActivity.class);
        context.startActivity(mIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_anim_demo);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv_dropout)
    public void onViewClicked() {
        setDropout();
    }

    private void setDropout(){
        int distance = tvView.getTop() + tvView.getHeight();
        AnimatorSet animSet = new AnimatorSet();

        ObjectAnimator alpha =  ObjectAnimator.ofFloat(tvView, "alpha", 0, 1);

        BounceEaseOut b = new BounceEaseOut(1000);
        ValueAnimator dropout = ObjectAnimator.ofFloat(tvView, "translationY", -distance, 0);
        dropout.setEvaluator(b);

        animSet.playTogether(alpha,dropout);
        animSet.setDuration(1200);
        animSet.start();
    }
}
