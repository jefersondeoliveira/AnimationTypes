package com.example.testeanimacoes;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

public class MainActivity extends Activity {
	
	Button button;
	ImageView imagem;
	Animation animation,pulse;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button = (Button) findViewById(R.id.button);		
		imagem = (ImageView) findViewById(R.id.image);
		animation = AnimationUtils.loadAnimation(this, R.anim.teste_translate);
		pulse = AnimationUtils.loadAnimation(this, R.anim.teste_pulse);
		
		
		
		
		
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				imagem.startAnimation(animation);
			}
		});
		
		
	}



}
