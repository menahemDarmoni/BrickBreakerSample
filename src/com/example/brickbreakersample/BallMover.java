package com.example.brickbreakersample;

public class BallMover extends Thread {

	/**
	 * @param args
	 */
	private Ball ball;
	private GameView gameVive;
	public BallMover(Ball b ,GameView gv)
	{
		this.ball=b;
		this.gameVive=gv;
	}
	@Override
	public void run()
	{
		while(true)
		{
			this.ball.moveBall();
			this.gameVive.postInvalidate();
			try 
			{
				sleep(3);
			} 
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
