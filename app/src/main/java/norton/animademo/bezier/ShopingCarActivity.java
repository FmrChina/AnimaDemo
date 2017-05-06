package norton.animademo.bezier;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import norton.animademo.R;
import norton.animademo.adapter.ShoppingCaradpater;
import norton.animademo.weidget.BezierPointView;

public class ShopingCarActivity extends AppCompatActivity  implements ShoppingCaradpater.onItemClickListenter {

    @Bind(R.id.rcv)
    RecyclerView rcv;

    @Bind(R.id.img_buttom)
    ImageView imgButtom;

    @Bind(R.id.rl_buttom)
    RelativeLayout rlButtom;

    private ShoppingCaradpater mAdapter;

    public static void startAction(Context context) {
        Intent mIntent = new Intent(context, ShopingCarActivity.class);
        context.startActivity(mIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoping_car);
        ButterKnife.bind(this);

        setAdapter();
    }

    private void setAdapter(){
        rcv.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ShoppingCaradpater(this);

        rcv.setAdapter(mAdapter);

        mAdapter.setOnItemClickListenter(this);
    }

    @OnClick({R.id.img_buttom, R.id.rl_buttom})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_buttom:
                break;
            case R.id.rl_buttom:
                break;
        }
    }

    @Override
    public void onItemClick(View view, int p) {
        BezierPointView bezierPointView = new BezierPointView(this);
        ViewGroup rootView = (ViewGroup) this.getWindow().getDecorView();
        rootView.addView(bezierPointView);

        int position[] = new int[2];
        int endPosition[] = new int[2];

        view.getLocationInWindow(position);
        imgButtom.getLocationInWindow(endPosition);

        bezierPointView.setStartPosition(new Point(position[0], position[1]));
        bezierPointView.setEndPosition(new Point(endPosition[0], endPosition[1]));
        bezierPointView.startBeizerAnimation();
    }
}
