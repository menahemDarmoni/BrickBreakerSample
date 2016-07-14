package com.example.brickbreakersample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class PaddleView extends View {

	private Paddle paddle;
	private Paint paddlePaint;
	public PaddleView(Context context , Paddle newPaddle) 
	{
		super(context);
	    this.paddle=newPaddle;
	    paddlePaint= new Paint();
	}

	private Paint getPaddlePaint()
	{
		paddlePaint.setColor(Color.BLUE);
		paddlePaint.setAntiAlias(true);
		return paddlePaint;
	}
	public void draw(Canvas canvas)
	{
		canvas.drawRect(paddle.Left(),paddle.Top(),paddle.Right(),paddle.Buttom(), paddlePaint);
	}
}
