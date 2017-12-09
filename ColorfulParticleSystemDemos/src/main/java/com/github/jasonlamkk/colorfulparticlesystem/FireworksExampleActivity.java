package com.github.jasonlamkk.colorfulparticlesystem;

import com.github.cleonids.examples.R;
import com.github.jasonlamkk.colorfulparticlesystem.ParticleSystem;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;

public class FireworksExampleActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_particle_system_example);
		findViewById(R.id.button1).setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		ParticleSystem ps = new ParticleSystem(this, 100, R.drawable.star_pink, 800);
//		ps.setScaleRange(0.7f, 1.3f);
		ps.setSpeedRange(0.1f, 0.25f);
		ps.setRotationSpeedRange(90, 180);

		ps.setScaleRange(20f, 10f, 60f, 20f);
		ps.setColor(100,100,100,50, 50, 50,
				200, 200, 200, 50, 50 , 50,
				245, 10, 125, 50 );

		ps.setFadeOut(200, new AccelerateInterpolator());
		ps.oneShot(arg0, 70);

		ParticleSystem ps2 = new ParticleSystem(this, 100, R.drawable.star_white, 800);
//		ps2.setScaleRange(0.7f, 1.3f);
		ps2.setSpeedRange(0.1f, 0.25f);
		ps.setRotationSpeedRange(90, 180);

		ps2.setScaleRange(20f, 10f, 60f, 20f);
		ps2.setColor(100,100,100,50, 50, 50,
				200, 200, 200, 50, 50 , 50,
				245, 10, 125, 50 );

		ps2.setFadeOut(200, new AccelerateInterpolator());
		ps2.oneShot(arg0, 70);
	}

}
