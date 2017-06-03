package norton.animademo.fragmenttransformer;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import norton.animademo.R;

public class FragmentTransformerActivity extends AppCompatActivity {

    @Bind(R.id.fragment)
    FrameLayout fragment;


    private OneFragment oneFragment;
    private TwoFragment twoFragment;


    public static void startAction(Context context) {
        Intent mIntent = new Intent(context, FragmentTransformerActivity.class);
        context.startActivity(mIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_transformer);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle("FragmentTransformerActivity");

        oneFragment = new OneFragment();
        twoFragment = new TwoFragment();

        setOneFragment();
    }

    private void setOneFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.setCustomAnimations(R.anim.enter_scale,R.anim.exit_scale);
        ft.replace(R.id.fragment, oneFragment);
        ft.commit();

    }


    private void setTwoFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.setCustomAnimations(R.anim.enter_scale,R.anim.exit_scale);
        ft.replace(R.id.fragment, twoFragment);
        ft.commit();
    }



    @OnClick({R.id.btn_one, R.id.btn_two})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_one:
                setOneFragment();
                break;
            case R.id.btn_two:
                setTwoFragment();
                break;
        }
    }
}
