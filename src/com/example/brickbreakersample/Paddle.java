package com.example.brickbreakersample;

import android.text.style.LineHeightSpan.WithDensity;

public class Paddle {

	/**
	 * @param args
	 */
	private float x ,y;
	private int height , width;
	private int screenWidth;
	private float destination;
	private int direction;
	
	public Paddle(float _x , float _y , int _height , int _width , int _screenW)
	{
		this.x = _x;
		this.y = _y;
		this.height = _height;
		this.width = _width;
		this.screenWidth = _screenW;
		this.destination = this.screenWidth/4;
		this.direction = 1;
	}
	
	public void movePaddle(){
		if(direction == 1)
			this.x++;
		if(direction == -1)
			this.x--;
		if(Left() <= 1)
			direction = 1;
		if(Right() >= this.screenWidth)
			direction = -1;
	}
	
	public float Left() {
		return x-width;
	}
	
	public float Right() {
		return x+ width;
	}
	
	public float Top()	{
		return y- height;
	}
	
	public float Buttom() {
		return y+ height;
	}
}
