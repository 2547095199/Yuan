package fragment.bwie.com.lianxi4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by CZ on 2017/11/1.
 */
public class CustomProgrssView extends View{

    private boolean runing = true;
    private int progress =  0;
    private Paint paint;

    public CustomProgrssView(Context context) {
        super(context);
    }

    public CustomProgrssView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (runing){
                    if (progress >= 360){
                        runing = false;
                        return;
                    }
                    System.out.println("progress" + progress);
                    progress += 10;
                    postInvalidate();
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    float sweep;
    public CustomProgrssView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int x = getWidth() / 2;
        int y = getHeight() / 2;
        int radius = 100;
        paint.setStrokeWidth(30);
        RectF rectF = new RectF(x - radius, y - radius, x + radius, y + radius);
        canvas.drawArc(rectF,-90,progress,false,paint);
        int text = (int) ((float)progress/360 * 100);
        float textWidth = paint.measureText(text + "%");
        Rect recttext = new Rect();
        paint.getTextBounds(text+"%",0,(text+"%").length(),recttext);
        paint.setTextSize(30);
        paint.setStrokeWidth(1);
        canvas.drawText(text+"%",x-textWidth/2,y+recttext.height()/4,paint);

    }
}
