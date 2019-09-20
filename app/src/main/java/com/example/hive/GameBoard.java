package com.example.hive;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class GameBoard extends SurfaceView {

    //paint class
    Paint currentMove = new Paint();
    Paint paint = new Paint();

    protected static int WHITE = 0;
    protected static int RED = 1;

    public GameBoard(Context context, AttributeSet attrs) {
        super(context, attrs);



        //This is essential or your onDraw method won't get called
        setWillNotDraw(false);
    }

    public void drawHexagon(Canvas canvas, int startX, int startY, int size, int color)
    {
        if(color == WHITE)
            paint.setColor(Color.WHITE);
        else if(color == RED)
            paint.setColor(Color.RED);

        canvas.drawLine(startX, startY, startX + size, startY, paint);
        canvas.drawLine(startX + size, startY, startX + (size/2) * 3^(1/2), startY + size/2, paint);
        canvas.drawLine(startX + (size/2)*3 ^(1/2), startY + size/2, startX + size, startY + size, paint);
        canvas.drawLine(startX + size, startY + size, startX, startY + size, paint);
        canvas.drawLine(startX, startY + size, startX - ((size/2) * 3^(1/2)) + size, startY + size/2, paint);
        canvas.drawLine(startX - ((size/2) * 3^(1/2)) + size, startY + size/2, startX, startY, paint);
    }

    public void onDraw(Canvas canvas)
    {
        //Colors and Size for Pieces
        currentMove.setColor(Color.RED);
        currentMove.setTextSize(25);


        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(5.0f);

        //Hexagons are drawn in mid game
        drawHexagon(canvas, 400, 400, 150, WHITE);
        drawHexagon(canvas, 400 + 75 * 3^(1/2), 475, 150, WHITE);

        drawHexagon(canvas, 400 + 75 * 3^(1/2), 625, 150, WHITE);

        drawHexagon(canvas, 400 + 75 * 3^(1/2), 775, 150, WHITE);
        drawHexagon(canvas, 400 + 75 * 3^(1/2), 925, 150, WHITE);
        drawHexagon(canvas, 400, 850, 150, WHITE);
        drawHexagon(canvas, 700 + 50 * 3^(1/2), 850, 150, WHITE);
        drawHexagon(canvas, 700 + 50 * 3^(1/2), 1000, 150, WHITE);

        //drawing hexagons for avaliable moves

        drawHexagon(canvas, 400, 550, 150, RED);
        drawHexagon(canvas, 400 - 75 * 3^(1/2), 475, 150, RED);
        drawHexagon(canvas, 400 - 75 * 3^(1/2), 325, 150, RED);
        drawHexagon(canvas, 400, 250, 150, RED);
        drawHexagon(canvas, 400 + 75 * 3^(1/2), 325, 150, RED);
        drawHexagon(canvas, 700 + 50 * 3^(1/2), 400, 150, RED);
        drawHexagon(canvas, 700 + 50 * 3^(1/2), 550, 150, RED);

        //text written for pieces already on board
        paint.setColor(Color.WHITE);
        paint.setTextSize(25);

        canvas.drawText("White Queen Bee", 400, 475, paint);
        canvas.drawText("White Ant",670, 550, paint);
        canvas.drawText("White Spider", 625, 700, paint);
        canvas.drawText("White Beetle", 625, 850,paint);

        canvas.drawText("Black Queen Bee", 600,1000, paint);
        canvas.drawText("Black Ant",425, 925, paint);
        canvas.drawText("Black Spider", 850, 925, paint);
        canvas.drawText("Black Beetle", 850, 1075, paint);


        //Bottom selection board

        drawHexagon(canvas, 75, 1450, 150, WHITE);
        canvas.drawText("Queen Bee", 90, 1530, paint);
        drawHexagon(canvas, 375, 1450, 150, RED);
        canvas.drawText("Ant", 420, 1530, currentMove);
        drawHexagon(canvas, 675, 1450, 150, WHITE);
        canvas.drawText("Spider", 705, 1530, paint);
        drawHexagon(canvas, 975, 1450, 150, WHITE);
        canvas.drawText("Beetle", 1005, 1530, paint);

        //Who's turn it is
        canvas.drawText("WHITE'S TURN", 50, 50, paint);
    }
}
