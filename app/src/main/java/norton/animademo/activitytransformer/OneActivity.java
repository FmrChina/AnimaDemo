package norton.animademo.activitytransformer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import norton.animademo.R;

public class OneActivity extends AppCompatActivity {

    @Bind(R.id.btn_to_two)
    Button btnToTwo;

    public static void startAction(Context context) {
        Intent mIntent = new Intent(context, OneActivity.class);
        context.startActivity(mIntent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        getSupportActionBar().setTitle("OneActivity");
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_to_two)
    public void onViewClicked() {
        Intent mIntent = new Intent(OneActivity.this,TwoActivity.class);
        startActivity(mIntent);
//        overridePendingTransition(R.anim.enter_right,R.anim.exit_left);
        overridePendingTransition(R.anim.enter_scale,0);
    }
}
