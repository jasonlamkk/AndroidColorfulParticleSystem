package com.github.jasonlamkk.colorfulparticlesystem;

import com.github.jasonlamkk.colorfulparticlesystem.examples.R;
import com.github.jasonlamkk.colorfulparticlesystem.ParticleSystem;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class ConfettiExampleActivity extends Activity implements OnClickListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_confetti_example);
		findViewById(R.id.button1).setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {		
		new ParticleSystem(this, 80, R.drawable.confeti2, 10000)
		.setSpeedModuleAndAngleRange(0f, 0.1f, 180, 180)
		.setRotationSpeed(144)
		.setAcceleration(0.000017f, 90)
				.setScaleRange(20f, 10f, 60f, 20f)
				.setColor(100,100,100,50, 50, 50,
						200, 200, 200, 50, 50 , 50,
						245, 10, 125, 50 )
		.emit(findViewById(R.id.emiter_top_right), 8);
				
		new ParticleSystem(this, 80, R.drawable.confeti3, 10000)
		.setSpeedModuleAndAngleRange(0f, 0.1f, 0, 0)
		.setRotationSpeed(144)
		.setAcceleration(0.000017f, 90)
				.setScaleRange(20f, 10f, 60f, 20f)
				.setColor(100,100,100,50, 50, 50,
						200, 200, 200, 50, 50 , 50,
						245, 10, 125, 50 )
		.emit(findViewById(R.id.emiter_top_left), 8);
	}
}
