package com.github.jasonlamkk.colorfulparticlesystem;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.github.jasonlamkk.colorfulparticlesystem.examples.R;
import com.github.jasonlamkk.colorfulparticlesystem.ParticleSystem;

public class EmiterBackgroundSimpleExampleActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_particle_system_example);
		findViewById(R.id.button1).setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		new ParticleSystem(this, 50, R.drawable.star_pink, 1000, R.id.background_hook)
		.setSpeedRange(0.1f, 0.25f)
		.emit(arg0, 100);
	}

}
