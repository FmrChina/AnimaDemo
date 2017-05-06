package norton.animademo.weidget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;

import norton.animademo.utils.DenstyUtils;

/**
 * Created by liuhuiliang on 16/6/7.
 */
public class BezierPointView extends TextView implements ValueAnimator.AnimatorUpdateListener {

    public static final int VIEW_SIZE = 20;

    protected Context mContext;
    protected Paint mPaintCircle;
    protected int radius;

    protected Point startPosition;
    protected Point endPosition;


    public BezierPointView(Context context) {
        this(context, null);
    }

    public BezierPointView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BezierPointView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        mPaintCircle = new Paint();
        mPaintCircle.setColor(Color.RED);
        mPaintCircle.setAntiAlias(true);


        setGravity(Gravity.CENTER);
        setText("1");
        setTextColor(Color.WHITE);
        setTextSize(12);
    }


    public void setStartPosition(Point startPosition) {
        startPosition.y -= 10;
        this.startPosition = startPosition;
    }

    public void setEndPosition(Point endPosition) {
        this.endPosition = endPosition;
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int pointSize =  DenstyUtils.dip2px(mContext,VIEW_SIZE);
        setMeasuredDimension(pointSize, pointSize);
        radius = pointSize / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, radius, mPaintCircle);
        super.onDraw(canvas);
    }


    public void startBeizerAnimation() {
        if (startPosition == null || endPosition == null) {
            return;
        }

        int pointX = (startPosition.x + endPosition.x) / 2;
        int pointY = startPosition.y - DenstyUtils.dip2px(mContext,100);

        Point controllPoint = new Point(pointX, pointY);
        BezierEvaluator bezierEvaluator = new BezierEvaluator(controllPoint);

        ValueAnimator anim = ValueAnimator.ofObject(bezierEvaluator, startPosition, endPosition);
        anim.addUpdateListener(this);
        anim.setDuration(400);
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                ViewGroup viewGroup = (ViewGroup) getParent();
                viewGroup.removeView(BezierPointView.this);
            }
        });
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.start();
    }

    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
        Point point = (Point) animation.getAnimatedValue();
        setX(point.x);
        setY(point.y);
        invalidate();
    }

    public class BezierEvaluator implements TypeEvaluator<Point> {

        private Point controllPoint;
        public BezierEvaluator(Point controllPoint) {
            this.controllPoint = controllPoint;
        }
        @Override
        public Point evaluate(float t, Point startValue, Point endValue) {
            //二阶Bezier
            int x = (int) ((1 - t) * (1 - t) * startValue.x + 2 * t * (1 - t) * controllPoint.x + t * t * endValue.x);
            int y = (int) ((1 - t) * (1 - t) * startValue.y + 2 * t * (1 - t) * controllPoint.y + t * t * endValue.y);

            return new Point(x, y);
        }
    }


}
