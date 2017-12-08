package com.github.cleonids.examples;

import com.github.cleonids.ParticleSystem;
import com.github.cleonids.examples.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;

public class OneShotAdvancedExampleActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_particle_system_example);
		findViewById(R.id.button1).setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// Launch 2 particle systems one for each image
		ParticleSystem ps = new ParticleSystem(this, 100, R.drawable.star_white_border, 800);
//		ps.setScaleRange(0.7f, 1.3f);
		ps.setSpeedRange(0.1f, 0.25f);
		ps.setAcceleration(0.0001f, 90);
		ps.setRotationSpeedRange(90, 180);
		ps.setFadeOut(200, new AccelerateInterpolator());

		ps.setScaleRange(20f, 10f, 60f, 20f);
		ps.setColor(100,100,100,50, 50, 50,
				200, 200, 200, 50, 50 , 50,
				245, 10, 125, 50 );

		ps.oneShot(arg0, 100);
	}

}
