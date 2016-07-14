package com.example.brickbreakersample;

public class Ball {
	private float x;
	private float y;
	private float radius;
	private int horDirection;
	private int verDirection;
	private int screenWidth;
	private int screenHeight;
	
	public Ball(float startX,float startY,float r,int width,int height)
	{
		this.x=startX;
		this.y=startY;
		this.radius=r;
		this.screenWidth=width;
		this.screenHeight=height;
		horDirection=-1;
		verDirection=-1;
	}
	public float getX()
	{
		return this.x;
	}
	public float getY()
	{
		return this.y;
	}
	public float getRadius()
	{
		return this.radius;
	}
    public void moveBall()
	{
		if(horDirection==1)
			this.x++;
		if(horDirection==-1)
			this.x--;
		if(verDirection==1)
			this.y++;
		if(verDirection==-1)
			this.y--;
		
		if(Right()>=this.screenWidth)
			this.horDirection=-1;
		else if(Left()<=1)
			this.horDirection=1;
		if(Buttom()>(float)(this.screenHeight*0.8))
		//if(Buttom()>=this.screenHeight)
			this.verDirection=-1;
		if(Top()<=1)
			this.verDirection=1;
	}
	public float Left()
	{
		return x- radius;
	}
	public float Right()
	{
		return x + radius;
	}
    public float Top()
	{
		return y- radius;
	}
	public float Buttom()
	{
		return y+ radius;
	}
}
