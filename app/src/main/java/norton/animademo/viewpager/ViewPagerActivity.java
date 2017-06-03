package norton.animademo.viewpager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import norton.animademo.R;

public class ViewPagerActivity extends AppCompatActivity {

    @Bind(R.id.vier_page1)
    ViewPager vierPage1;

    @Bind(R.id.vier_page2)
    ViewPager vierPage2;

    @Bind(R.id.vier_page3)
    ViewPager vierPage3;

    @Bind(R.id.vier_page4)
    ViewPager vierPage4;

    List<TextView> tvLists = new ArrayList<>();
    List<TextView> tvLists2 = new ArrayList<>();
    List<TextView> tvLists3 = new ArrayList<>();
    List<TextView> tvLists4 = new ArrayList<>();

    public static void startAction(Context context) {
        Intent mIntent = new Intent(context, ViewPagerActivity.class);
        context.startActivity(mIntent);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        ButterKnife.bind(this);

        setData();
        initViewPager1();
        initViewPager2();
        initViewPager3();
        initViewPager4();
    }

    private void initViewPager1(){
        vierPage1.setAdapter(new PagerAdapter() {

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(tvLists.get(position));
                return tvLists.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(tvLists.get(position));
            }

            @Override
            public int getCount() {
                return tvLists.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        });

        vierPage1.setPageTransformer(true,new DepthPageTransformer());
    }

    private void initViewPager2(){
        vierPage2.setAdapter(new PagerAdapter() {

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(tvLists2.get(position));
                return tvLists2.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(tvLists2.get(position));
            }

            @Override
            public int getCount() {
                return tvLists2.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        });

        vierPage2.setPageTransformer(true,new RotateDownPageTransformer());
    }

    private void initViewPager3(){
        vierPage3.setAdapter(new PagerAdapter() {

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(tvLists3.get(position));
                return tvLists3.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(tvLists3.get(position));
            }

            @Override
            public int getCount() {
                return tvLists3.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        });

        vierPage3.setPageTransformer(true,new CudeOutTransformer());
    }

    private void initViewPager4(){
        vierPage4.setAdapter(new PagerAdapter() {

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(tvLists4.get(position));
                return tvLists4.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(tvLists4.get(position));
            }

            @Override
            public int getCount() {
                return tvLists4.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        });

        vierPage4.setPageTransformer(true,new ZoomInTransformer());
    }




    private void setData() {
        int[] colors = new int[]{ContextCompat.getColor(this,R.color.green),
                ContextCompat.getColor(this,R.color.red),
                ContextCompat.getColor(this,R.color.mediumvioletred)};

        TextView textView = null;
        TextView textView2 = null;
        TextView textView3 = null;
        TextView textView4 = null;
        for (int i = 0; i < colors.length; i++) {
            textView = new TextView(this);
            textView2 = new TextView(this);
            textView3 = new TextView(this);
            textView4 = new TextView(this);

            textView.setBackgroundColor(colors[i]);
            textView.setText(i+"");
            textView.setGravity(Gravity.CENTER);

            textView2.setBackgroundColor(colors[i]);
            textView2.setText(i+"");
            textView2.setGravity(Gravity.CENTER);

            textView3.setBackgroundColor(colors[i]);
            textView3.setText(i+"");
            textView3.setGravity(Gravity.CENTER);

            textView4.setBackgroundColor(colors[i]);
            textView4.setText(i+"");
            textView4.setGravity(Gravity.CENTER);

            tvLists.add(textView);
            tvLists2.add(textView2);
            tvLists3.add(textView3);
            tvLists4.add(textView4);
        }


    }



}
