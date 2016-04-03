package com.example.mutilineedittext;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.style.LineHeightSpan;
import android.util.AttributeSet;
import android.widget.EditText;

public class MyMultiLineEditText extends EditText {

	private static final String TAG = "MyMultiLineEditText";  
   
    private Rect mRect;
    private Paint mPaint;
    // we need this constructor for LayoutInflater
    public MyMultiLineEditText(Context context, AttributeSet attrs) 
    {
        super(context, attrs);           
        mRect = new Rect();
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(0x80999999);
    }
 
    
    @Override
    protected void onDraw(Canvas canvas)
    {
        int count = getLineCount() ;
        if(count <100) {
        	count = 100;
        } 
        Rect r = mRect;
        Paint paint = mPaint;
        int lineHeight = getLineHeight();
        int baseline = getLineBounds(0, r);
        for (int i = 0; i < count; i++) 
        {
        	if(i>=100) {
        		baseline = getLineBounds(i, r);
        	}
            
        	int floatY = lineHeight*(i+1);
            canvas.drawLine(r.left, floatY, r.right, floatY, paint);
            canvas.save();
        }
        super.onDraw(canvas);
    }
    
    

}
