package app.akexorcist.simpleanimation;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Main extends Activity {
	ImageView imgLogo;
	Animation anim;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		imgLogo = (ImageView)findViewById(R.id.imgLogo);

		Button btnFade = (Button)findViewById(R.id.btnFade);
		btnFade.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				if(imgLogo.getVisibility() == View.VISIBLE) {
					anim = AnimationUtils.loadAnimation(getApplicationContext()
							, android.R.anim.fade_out);
					imgLogo.startAnimation(anim);
					imgLogo.setVisibility(View.INVISIBLE);
				} else {
					anim = AnimationUtils.loadAnimation(getApplicationContext()
							, android.R.anim.fade_in);
					imgLogo.startAnimation(anim);
					imgLogo.setVisibility(View.VISIBLE);
				}
			}
		});

		Button btnSlideIn = (Button)findViewById(R.id.btnSlideIn);
		btnSlideIn.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				imgLogo.setVisibility(View.VISIBLE);
				anim = AnimationUtils.loadAnimation(getApplicationContext()
						, android.R.anim.slide_in_left);
				anim.setDuration(1000);
				imgLogo.startAnimation(anim);
			}
		});

		Button btnSlideOut = (Button)findViewById(R.id.btnSlideOut);
		btnSlideOut.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				imgLogo.setVisibility(View.VISIBLE);
				anim = AnimationUtils.loadAnimation(getApplicationContext()
						, android.R.anim.slide_out_right);

				anim.setAnimationListener(new AnimationListener() {
					public void onAnimationEnd(Animation arg0) {
						Log.i("Animation", "On Animation End");
					}

					public void onAnimationRepeat(Animation animation) {
						Log.i("Animation", "On Animation Repeat");
					}

					public void onAnimationStart(Animation animation) {
						Log.i("Animation", "On Animation Start");
					}
				});	
				
				imgLogo.startAnimation(anim);
			}
		});
	}
}
