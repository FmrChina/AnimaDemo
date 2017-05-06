package norton.animademo.bezier;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import norton.animademo.R;
import norton.animademo.weidget.BubbingLayout;

public class BubbingActivity extends AppCompatActivity {


    @Bind(R.id.bubbing_layout)
    BubbingLayout bubbingLayout;

    public static void startAction(Context context) {
        Intent mIntent = new Intent(context, BubbingActivity.class);
        context.startActivity(mIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubbing);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bubbing_layout)
    public void onViewClicked() {
        bubbingLayout.setHeart();
    }
}
