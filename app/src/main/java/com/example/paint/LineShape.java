package com.example.paint;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class LineShape extends AreaShape {
    private int size;
    private int xEnd;
    private int yEnd;
    private Boolean strokeType;
    public LineShape(int x, int y, String color,Boolean strokeType1,int size1) {
        super(x, y, color);
        xEnd = x;
        yEnd = y;
        strokeType=strokeType1;
        size=size1;
    }

    @Override
    public void updatePoint(int xe, int ye) {
        xEnd = xe;
        yEnd = ye;
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setStrokeWidth(size);
        if (!strokeType) {
            paint.setStyle(Paint.Style.STROKE);
        } else {
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
        }
        super.draw(canvas,paint);
        canvas.drawLine(x,y,xEnd,yEnd,paint);
    }

}