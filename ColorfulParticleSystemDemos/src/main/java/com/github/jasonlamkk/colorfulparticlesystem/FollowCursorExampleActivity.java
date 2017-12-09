package com.github.jasonlamkk.colorfulparticlesystem;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.animation.AccelerateInterpolator;

import com.github.cleonids.examples.R;
import com.github.jasonlamkk.colorfulparticlesystem.ParticleSystem;

public class FollowCursorExampleActivity extends Activity  {

	private ParticleSystem ps;

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			// Create a particle system and start emiting
			ps = new ParticleSystem(this, 100, R.drawable.star_pink, 800);

			ps.setScaleRange(20f, 10f, 60f, 20f);
			ps.setColor(100,100,100,50, 50, 50,
						200, 200, 200, 50, 50 , 50,
						245, 10, 125, 50 );

//			ps.setScaleRange(0.7f, 1.3f);
			ps.setSpeedRange(0.05f, 0.1f);
			ps.setRotationSpeedRange(90, 180);
			ps.setFadeOut(200, new AccelerateInterpolator());
			ps.emit((int) event.getX(), (int) event.getY(), 40);
			break;
		case MotionEvent.ACTION_MOVE:
			ps.updateEmitPoint((int) event.getX(), (int) event.getY());
			break;
		case MotionEvent.ACTION_UP:
			ps.stopEmitting();
			break;
		}
		return true;
	}

	
	
}