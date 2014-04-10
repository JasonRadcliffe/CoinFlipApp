package com.jasonradcliffe.coinflip;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
	
	private Coin coin = new Coin();
	private TextView mAnswerText;
	private Button mFlipButton;
	private Button mResetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        //Declare view variables
        mAnswerText = (TextView)findViewById(R.id.answerText);
        mFlipButton = (Button)findViewById(R.id.flipButton);
        mResetButton = (Button)findViewById(R.id.resetButton);
        /*
        final ImageView headsImage = (ImageView)findViewById(R.id.imageView1);
        final ImageView tailsImage = (ImageView)findViewById(R.id.imageView2);
        */
        
        
        mFlipButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {				
				String answer = coin.flip();
				mAnswerText.setText(answer);
				animateAnswer();
				playSound();
				
			}
		});
        
        
        mResetButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String empty = "";
				mAnswerText.setText(empty);
				
				
				
			}
		});
        
        
        
    }
    
    
    private void animateAnswer(){
    	AlphaAnimation fadeInAnimation = new AlphaAnimation(0, 1);
    	fadeInAnimation.setDuration(1500);
    	fadeInAnimation.setFillAfter(true);
    	mAnswerText.setAnimation(fadeInAnimation);
    	
    	
    }
    
    private void playSound(){
    	MediaPlayer player = MediaPlayer.create(this, R.raw.coinflip);
    	player.start();
    	player.setOnCompletionListener(new OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				mp.release();
				
			}
		});
    	
    	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
