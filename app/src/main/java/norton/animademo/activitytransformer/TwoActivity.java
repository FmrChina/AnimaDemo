package norton.animademo.activitytransformer;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import norton.animademo.R;

public class TwoActivity extends AppCompatActivity {

    @Bind(R.id.btn_to_one)
    Button btnToOne;

    @Bind(R.id.sharedView)
    View mView;

    @Bind(R.id.img_view)
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        getSupportActionBar().setTitle("TwoActivity");
        ButterKnife.bind(this);

        String url = "http://imgsrc.baidu.com/imgad/pic/item/caef76094b36acaf0accebde76d98d1001e99ce7.jpg";

        Glide.with(this).load(url).into(imgView);
    }


    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.exit_scale);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @OnClick({R.id.sharedView, R.id.img_view,R.id.btn_to_one})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sharedView:
                Intent mIntent1 = new Intent(TwoActivity.this, ThreeActivity.class);
                ActivityOptions options1 = ActivityOptions
                        .makeSceneTransitionAnimation(TwoActivity.this, view, "sharedView");

                ActivityCompat.startActivity(TwoActivity.this, mIntent1, options1.toBundle());
                break;
            case R.id.img_view:
                Intent mIntent2 = new Intent(TwoActivity.this, ThreeActivity.class);
                ActivityOptions options2 = ActivityOptions
                        .makeSceneTransitionAnimation(TwoActivity.this, view, "sharedImage");

                ActivityCompat.startActivity(TwoActivity.this, mIntent2, options2.toBundle());
                break;
            case R.id.btn_to_one:
                Pair first = new Pair<>(mView, ViewCompat.getTransitionName(mView));
                Pair second = new Pair<>(imgView, ViewCompat.getTransitionName(imgView));

                ActivityOptionsCompat transitionActivityOptions =
                        ActivityOptionsCompat.makeSceneTransitionAnimation(this, first, second);
                Intent mIntent = new Intent(TwoActivity.this, ThreeActivity.class);
                ActivityCompat.startActivity(TwoActivity.this, mIntent, transitionActivityOptions.toBundle());
                break;
        }
    }
}
