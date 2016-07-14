package com.example.brickbreakersample;

import com.example.brickbreakersample.ShakeDetector.OnShakeListener;
import android.support.v7.app.ActionBarActivity;
//import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Context;
//import android.app.Activity;
//import android.content.Context;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
//import android.util.DisplayMetrics;
//import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
//import android.view.WindowManager;
//import android.os.Build;	
// The following are used for the shake detection
import android.widget.Toast;


/*public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new SampleView(this));
	}
 
	private static class SampleView extends View {
 
		// CONSTRUCTOR
		public SampleView(Context context) {
			super(context);
			setFocusable(true);
 
		}
 
		@Override
		protected void onDraw(Canvas canvas) {
 
			//canvas.drawColor(Color.CYAN);
			Paint p = new Paint();
			// smooths
			p.setAntiAlias(true);
			p.setColor(Color.RED);
			p.setStyle(Paint.Style.STROKE); 
			p.setStrokeWidth(4.5f);
			// opacity
			//p.setAlpha(0x80); //
			canvas.drawCircle(50, 50, 30, p);
		}
 
	}
//}

*/

public class MainActivity extends ActionBarActivity {

	private SensorManager mSensorManager;
	private Sensor mAccelerometer;
	private ShakeDetector mShakeDetector;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		int screenWidth;
		int screenHeight;
		Point p = new Point();
		
	//	DisplayMetrics displaymetrics = new DisplayMetrics();
//		getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
	//	screenHeight = displaymetrics.heightPixels;
		//screenWidth= displaymetrics.widthPixels;
		//try {
			this.getWindowManager().getDefaultDisplay().getSize(p);
			screenWidth = p.x;
			screenHeight = p.y;
		//} catch (NoSuchMethodError e) {
			// TODO Auto-generated catch block
			//this.getWindowManager().getDefaultDisplay().getSize(p);
			//screenWidth = p.x;
			//screenHeight = p.y;
		//}
		
	
		
		Ball ball=new Ball(screenWidth/4,screenHeight/4,20 ,screenWidth,screenHeight);
	//	Ball ball=new Ball(0,0,20 ,screenWidth,screenHeight);
		BallView ballView= new BallView(this, ball);
		//Paddle paddle = new Paddle(screenWidth/4 , (float)(screenWidth *0.8) , 10 , 50 , screenWidth);
		//Paddle paddle = new Paddle((float)(screenWidth *0.5),(float)(screenWidth *0.5) , 10 , 50 , screenWidth);
		Paddle paddle = new Paddle((float)(screenWidth *0.5),(float)(screenHeight*0.8), 10 , 50 , screenWidth);
		PaddleView paddleView= new PaddleView(this,paddle);
		GameView gameView=new GameView(this);
		gameView.setViews(ballView,paddleView);
		setContentView(gameView);
        BallMover ballMover= new BallMover(ball, gameView);
        ballMover.start();
        PaddleMover paddleMover = new PaddleMover(paddle, gameView);
        paddleMover.start();
		//	if (savedInstanceState == null) {
		//getSupportFragmentManager().beginTransaction()
			//	.add(R.id.container, new PlaceholderFragment()).commit();
		//}
      
      	// ShakeDetector initialization
		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		mAccelerometer = mSensorManager
				.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		mShakeDetector = new ShakeDetector();
		mShakeDetector.setOnShakeListener(new OnShakeListener() {
			@Override
			public void onShake(int count) {
				/*
				 * The following method, "handleShakeEvent(count):" is a stub //
				 * method you would use to setup whatever you want done once the
				 * device has been shook.
				 */
				//handleShakeEvent(count);
				Toast.makeText(MainActivity.this,"Ha Ha Ha Well Done!", Toast.LENGTH_SHORT).show();
					
			}
			public void handleShakeEvent(int count){
				
			}
		});
	}
	@Override
	public void onResume() {
		super.onResume();
		// Add the following line to register the Session Manager Listener onResume
		mSensorManager.registerListener(mShakeDetector, mAccelerometer,	SensorManager.SENSOR_DELAY_UI);
	}
 
	@Override
	public void onPause() {
		// Add the following line to unregister the Sensor Manager onPause
		mSensorManager.unregisterListener(mShakeDetector);
		super.onPause();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
