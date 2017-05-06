package norton.animademo.bezier;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import norton.animademo.R;

public class BezierActivity extends AppCompatActivity {

    public static void startAction(Context context) {
        Intent mIntent = new Intent(context, BezierActivity.class);
        context.startActivity(mIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bezier);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.btn_shopping_car, R.id.btn_bubbing})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_shopping_car:
                ShopingCarActivity.startAction(BezierActivity.this);
                break;
            case R.id.btn_bubbing:
                BubbingActivity.startAction(BezierActivity.this);
                break;
        }
    }
}
