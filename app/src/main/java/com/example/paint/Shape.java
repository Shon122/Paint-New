package com.example.paint;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public abstract class Shape {
    protected int x;
    protected int y;
    protected String color;
    public Shape(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public abstract void updatePoint(int xe,int ye);

    public void draw(Canvas canvas, Paint paint)
    {
        paint.setColor(Color.parseColor(color));
    }

}