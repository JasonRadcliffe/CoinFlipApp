package com.jasonradcliffe.coinflip;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
	
	private Coin coin = new Coin();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        //Declare view variables
        final TextView answerText = (TextView)findViewById(R.id.answerText);
        Button flipButton = (Button)findViewById(R.id.flipButton);
        Button resetButton = (Button)findViewById(R.id.resetButton);
        /*
        final ImageView headsImage = (ImageView)findViewById(R.id.imageView1);
        final ImageView tailsImage = (ImageView)findViewById(R.id.imageView2);
        */
        
        
        flipButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {				
				String answer = coin.flip();
				answerText.setText(answer);
				/*
				headsImage.setVisibility(1);
				*/
				
			}
		});
        
        
        resetButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String empty = "";
				answerText.setText(empty);
				/*
				headsImage.setVisibility(2);
				tailsImage.setVisibility(2);
				*/
				
				
				
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
