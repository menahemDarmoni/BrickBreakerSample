package com.example.brickbreakersample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class BallView extends View {

	//public Canvas canvas;
	private Ball ball;
	private Paint ballSetting;
	public BallView(Context context ,Ball newBall)
	{
		super(context);
		this.ball=newBall;
		this.ballSetting=new Paint();
	}
	private Paint getBallPaint()
	{
		ballSetting.setColor(Color.BLUE);
		ballSetting.setAntiAlias(true);
		return ballSetting;
	}
	public void draw (Canvas canvas)
	{
		canvas.drawCircle(ball.getX(), ball.getY(), ball.getRadius(), getBallPaint());
	}
}
