package com.example.paint;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class CircleShape extends AreaShape {
    private int size;
    private int xEnd;
    private int yEnd;
    public static float currentSize = 0;
    private Boolean strokeType;

    public CircleShape(int x, int y, String color, Boolean strokeType1, int size1) {
        super(x, y, color);
        xEnd = x;
        yEnd = y;
        strokeType = strokeType1;
        size = size1;
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
        super.draw(canvas, paint);
        calculateArea();
        PaintView.shapes.get(PaintView.shapes.size() - 1).sizeShape = currentSize;


        canvas.drawCircle(
                x,
                y,
                (float) Math.sqrt(Math.pow(xEnd - x, 2) + Math.pow(yEnd - y, 2)),
                paint
        );
    }

    public void calculateArea() {
        currentSize = (float) Math.sqrt(Math.pow(xEnd - x, 2) + Math.pow(yEnd - y, 2));
        currentSize = (float) ((float) Math.pow(currentSize, 2) * Math.PI);

    }


}