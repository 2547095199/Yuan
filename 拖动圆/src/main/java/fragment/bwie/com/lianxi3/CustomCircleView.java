package fragment.bwie.com.lianxi3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by CZ on 2017/11/1.
 */
public class CustomCircleView extends View {
    private Paint mPaint;

    private int cx = 200;
    private int cy = 200;
    public CustomCircleView(Context context) {
        super(context);
    }

    public CustomCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        //设置字体颜色
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(10);
    }

    public CustomCircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                System.out.print("exent ACTION_DOWN =" +event.getRawX()+"  "+event.getRawY());
                break;
            case MotionEvent.ACTION_MOVE:
                System.out.print("exent ACTION_MOVE =" +event.getRawX()+"  "+event.getRawY());
                cx = (int) event.getX();
                cy = (int) event.getY();
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                System.out.print("exent ACTION_UP =" +event.getRawX()+"  "+event.getRawY());
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(cx,cy,10,mPaint);
    }
}
