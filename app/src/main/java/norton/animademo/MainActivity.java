package norton.animademo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import norton.animademo.activitytransformer.OneActivity;
import norton.animademo.bezier.BezierActivity;
import norton.animademo.daimajiaviewanimdemo.ViewAnimDemoActivity;
import norton.animademo.fragmenttransformer.FragmentTransformerActivity;
import norton.animademo.objball.BallInterpolatorActivity;
import norton.animademo.objball.BallTypeEvaluatorActivity;
import norton.animademo.objball.RotationActivity;
import norton.animademo.viewpager.ViewPagerActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick({ R.id.btn_Dropout, R.id.btn_rotation_ball, R.id.btn_bezier
            ,R.id.btn_interpolator_ball,R.id.btn_type_evaluator_ball,R.id.btn_viewpager_transformer,
    R.id.btn_activity_transformer,R.id.btn_fragment_transformer})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_type_evaluator_ball:
                BallTypeEvaluatorActivity.startAction(MainActivity.this);
                break;
            case R.id.btn_interpolator_ball:
                BallInterpolatorActivity.startAction(MainActivity.this);
                break;
            case R.id.btn_Dropout:
                ViewAnimDemoActivity.startAction(MainActivity.this);
                break;
            case R.id.btn_rotation_ball:
                RotationActivity.startAction(MainActivity.this);
                break;
            case R.id.btn_bezier:
                BezierActivity.startAction(MainActivity.this);
                break;
            case R.id.btn_viewpager_transformer:
                ViewPagerActivity.startAction(MainActivity.this);
                break;
            case R.id.btn_activity_transformer:
                OneActivity.startAction(MainActivity.this);
                break;
            case R.id.btn_fragment_transformer:
                FragmentTransformerActivity.startAction(MainActivity.this);
                break;
        }
    }
}
