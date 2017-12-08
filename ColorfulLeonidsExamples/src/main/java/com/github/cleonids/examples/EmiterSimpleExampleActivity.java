package com.github.cleonids.examples;

import com.github.cleonids.ParticleSystem;
import com.github.cleonids.examples.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

public class EmiterSimpleExampleActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_particle_system_example);
		findViewById(R.id.button1).setOnClickListener(this);
		ParticleSystem.setFPS(15);
	}

	@Override
	public void onClick(View arg0) {
		new ParticleSystem(this, 50, R.drawable.star_pink, 1000)
			.setSpeedRange(0.1f, 0.25f)
				.setScaleRange(20f, 10f, 60f, 20f)
				.setColor(100,100,100,50, 50, 50,
						200, 200, 200, 50, 50 , 50,
						245, 10, 125, 50 )
		.emit(arg0, 100);
	}

}
