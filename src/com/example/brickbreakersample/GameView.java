package com.example.brickbreakersample;
import java.lang.reflect.Constructor;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.View;


public class GameView extends View 
{
	private BallView ballView;
	private PaddleView paddleView;
	public GameView(Context context)
	{
		super(context);
		//setFocusable(true);
	}
	public void setViews(BallView bv ,PaddleView pv)
	{
		this.ballView=bv;
		this.paddleView=pv;
	}
	@Override
	public void onDraw(Canvas canvas)
	{
		 ballView.draw(canvas);
		 paddleView.draw(canvas);
		//ballView.draw(canvas);
		//Point p=new Point();
		//this.getWindowManager().getDefaultDisplay().getSize(p);
		//int screenWidth=p.x;
		//int screenHeight=p.y;
		
		/*Ball ball=new Ball(10,10,30);
		BallView bv= new BallView(_context, ball);
		this.setViews(bv);*/   
	}
}
