package com.example.brickbreakersample;

public class PaddleMover extends Thread{
	private Paddle paddle;
	private GameView gameView;
	public PaddleMover(Paddle _paddle, GameView _gameView) {
		// TODO Auto-generated constructor stub
		this.paddle = _paddle;
		this.gameView = _gameView;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			this.paddle.movePaddle();
			this.gameView.postInvalidate();
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
