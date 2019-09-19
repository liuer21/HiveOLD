package com.example.hive;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class GameBoard extends SurfaceView {

    public GameBoard(Context context, AttributeSet attrs) {
        super(context, attrs);

        //This is essential or your onDraw method won't get called
        setWillNotDraw(false);
    }

    public void drawHexagon(Canvas canvas, int startX, int startY, int size)
    {
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        canvas.drawLine(startX, startY, startX + size, startY, paint);
        canvas.drawLine(startX + size, startY, startX + (size/2) * 3^(1/2), startY + size/2, paint);
        canvas.drawLine(startX + (size/2)*3 ^(1/2), startY + size/2, startX + size, startY + size, paint);
        canvas.drawLine(startX + size, startY + size, startX, startY + size, paint);
        canvas.drawLine(startX, startY + size, startX - ((size/2) * 3^(1/2)) + size, startY + size/2, paint);
        canvas.drawLine(startX - ((size/2) * 3^(1/2)) + size, startY + size/2, startX, startY, paint);
    }

    public void onDraw(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(5.0f);

        drawHexagon(canvas, 400, 400, 150);
        drawHexagon(canvas, 400 + 75 * 3^(1/2), 475, 150);
        drawHexagon(canvas, 400 + 75 * 3^(1/2), 625, 150);
        drawHexagon(canvas, 400 + 75 * 3^(1/2), 775, 150);
        drawHexagon(canvas, 400 + 75 * 3^(1/2), 925, 150);
        drawHexagon(canvas, 400, 850, 150);
        drawHexagon(canvas, 700 + 50 * 3^(1/2), 850, 150);
        drawHexagon(canvas, 700 + 50 * 3^(1/2), 1000, 150);

        paint.setTextSize(25);

        canvas.drawText("White Queen Bee", 400, 475, paint);
        canvas.drawText("White Ant",670, 550, paint);
        canvas.drawText("White Spider", 625, 700, paint);
        canvas.drawText("White Beetle", 625, 850,paint);

        canvas.drawText("Black Queen Bee", 600,1000, paint);
        canvas.drawText("Black Ant",425, 925, paint);
        canvas.drawText("Black Spider", 850, 925, paint);
        canvas.drawText("Black Beetle", 850, 1075, paint);
    }
}
