package com.example.paint;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

public class PathShape extends AreaShape {

    private int xEnd;
    private int yEnd;
    private Path Path;
    private Boolean strokeType;
private int size;
    public PathShape(int x, int y, String color,Boolean strokeType1,int size1) {
        super(x, y, color);
        xEnd = x;
        yEnd = y;
        Path=new Path();
        Path.moveTo(xEnd,yEnd);
        strokeType=strokeType1;
        size=size1;
    }

    @Override
    public void updatePoint(int xe, int ye) {
        xEnd = xe;
        yEnd = ye;
        Path.lineTo(xe,ye);
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
        canvas.drawPath(Path,paint);

    }

}