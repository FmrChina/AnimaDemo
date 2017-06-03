package norton.animademo.activitytransformer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.ButterKnife;
import norton.animademo.R;

public class ThreeActivity extends AppCompatActivity {

    @Bind(R.id.sharedView)
    View sharedView;

    @Bind(R.id.img_view)
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle("ThreeActivity");

        String url = "http://imgsrc.baidu.com/imgad/pic/item/caef76094b36acaf0accebde76d98d1001e99ce7.jpg";
        Glide.with(this).load(url).centerCrop().into(imgView);
    }
}
