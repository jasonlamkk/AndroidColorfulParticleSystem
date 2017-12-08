package com.github.cleonids.examples;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.github.cleonids.ParticleSystem;
import com.github.cleonids.examples.R;
import com.github.cleonids.modifiers.ScaleModifier;

public class StarsExampleActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_particle_system_example);
		findViewById(R.id.button1).setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		new ParticleSystem(this, 10, R.drawable.star, 3000)		
		.setSpeedByComponentsRange(-0.1f, 0.1f, -0.1f, 0.02f)
		.setAcceleration(0.000003f, 90)
		.setInitialRotationRange(0, 360)
		.setRotationSpeed(120)
		.setFadeOut(2000)
		.setScaleRange(20f, 10f, 60f, 20f)
		.setColor(100,100,100,50, 50, 50,
				200, 200, 200, 50, 50 , 50,
				245, 10, 125, 50 )
		.addModifier(new ScaleModifier(0f, 1.5f, 0, 1500))
		.oneShot(arg0, 10);
	}
}
