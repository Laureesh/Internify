package mobile.internify;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText email, password;
    Button loginBtn, goToRegisterBtn;
    ImageView bodyImage, hatImage;
    TextView logoSubtitle;
    View headerGlow;
    AnimatorSet introAnimator;
    AnimatorSet loopAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bodyImage = findViewById(R.id.bodyImage);
        hatImage = findViewById(R.id.hatImage);
        logoSubtitle = findViewById(R.id.logoSubtitle);
        headerGlow = findViewById(R.id.headerGlow);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginBtn);
        goToRegisterBtn = findViewById(R.id.goToRegisterBtn);

        loginBtn.setOnClickListener(v -> {
            String userEmail = email.getText().toString();

            if (userEmail.contains("student")) {
                startActivity(new Intent(this, StudentMainActivity.class));
            } else {
                startActivity(new Intent(this, CompanyMainActivity.class));
            }
        });

        goToRegisterBtn.setOnClickListener(v ->
                startActivity(new Intent(this, RegisterActivity.class))
        );
    }

    @Override
    protected void onStart() {
        super.onStart();
        startHeaderAnimation();
    }

    @Override
    protected void onStop() {
        stopHeaderAnimation();
        super.onStop();
    }

    private void startHeaderAnimation() {
        stopHeaderAnimation();

        headerGlow.setAlpha(0f);
        headerGlow.setScaleX(0.86f);
        headerGlow.setScaleY(0.86f);
        bodyImage.setAlpha(0f);
        bodyImage.setScaleX(0.88f);
        bodyImage.setScaleY(0.88f);
        bodyImage.setTranslationY(28f);
        hatImage.setAlpha(0f);
        hatImage.setTranslationY(-54f);
        hatImage.setRotation(-12f);
        hatImage.setScaleX(0.94f);
        hatImage.setScaleY(0.94f);
        logoSubtitle.setAlpha(0f);
        logoSubtitle.setTranslationY(20f);

        ObjectAnimator glowFadeIn = ObjectAnimator.ofFloat(headerGlow, View.ALPHA, 0f, 0.9f);
        ObjectAnimator glowScaleX = ObjectAnimator.ofFloat(headerGlow, View.SCALE_X, 0.86f, 1f);
        ObjectAnimator glowScaleY = ObjectAnimator.ofFloat(headerGlow, View.SCALE_Y, 0.86f, 1f);
        ObjectAnimator bodyFadeIn = ObjectAnimator.ofFloat(bodyImage, View.ALPHA, 0f, 1f);
        ObjectAnimator bodyRise = ObjectAnimator.ofFloat(bodyImage, View.TRANSLATION_Y, 28f, 0f);
        ObjectAnimator bodyScaleX = ObjectAnimator.ofFloat(bodyImage, View.SCALE_X, 0.88f, 1f);
        ObjectAnimator bodyScaleY = ObjectAnimator.ofFloat(bodyImage, View.SCALE_Y, 0.88f, 1f);
        ObjectAnimator hatFadeIn = ObjectAnimator.ofFloat(hatImage, View.ALPHA, 0f, 1f);
        ObjectAnimator hatDrop = ObjectAnimator.ofFloat(hatImage, View.TRANSLATION_Y, -54f, 10f, -8f, 0f);
        ObjectAnimator hatRotate = ObjectAnimator.ofFloat(hatImage, View.ROTATION, -12f, 5f, -2f, 0f);
        ObjectAnimator hatScaleX = ObjectAnimator.ofFloat(hatImage, View.SCALE_X, 0.94f, 1.03f, 1f);
        ObjectAnimator hatScaleY = ObjectAnimator.ofFloat(hatImage, View.SCALE_Y, 0.94f, 1.03f, 1f);
        ObjectAnimator subtitleFadeIn = ObjectAnimator.ofFloat(logoSubtitle, TextView.ALPHA, 0f, 1f);
        ObjectAnimator subtitleRise = ObjectAnimator.ofFloat(logoSubtitle, TextView.TRANSLATION_Y, 20f, 0f);

        hatFadeIn.setStartDelay(150);
        hatDrop.setStartDelay(150);
        hatRotate.setStartDelay(150);
        hatScaleX.setStartDelay(150);
        hatScaleY.setStartDelay(150);

        introAnimator = new AnimatorSet();
        introAnimator.setDuration(980);
        introAnimator.setInterpolator(new DecelerateInterpolator());
        introAnimator.playTogether(
                glowFadeIn,
                glowScaleX,
                glowScaleY,
                bodyFadeIn,
                bodyRise,
                bodyScaleX,
                bodyScaleY,
                hatFadeIn,
                hatDrop,
                hatRotate,
                hatScaleX,
                hatScaleY,
                subtitleFadeIn,
                subtitleRise
        );
        introAnimator.start();

        ObjectAnimator glowPulse = ObjectAnimator.ofFloat(headerGlow, View.ALPHA, 0.82f, 1f, 0.82f);
        glowPulse.setRepeatCount(ObjectAnimator.INFINITE);
        glowPulse.setDuration(2400);

        ObjectAnimator bodyFloatY = ObjectAnimator.ofFloat(bodyImage, View.TRANSLATION_Y, 0f, -7f, 0f);
        bodyFloatY.setRepeatCount(ObjectAnimator.INFINITE);
        bodyFloatY.setDuration(2400);

        ObjectAnimator bodyPulseX = ObjectAnimator.ofFloat(bodyImage, View.SCALE_X, 1f, 1.02f, 1f);
        bodyPulseX.setRepeatCount(ObjectAnimator.INFINITE);
        bodyPulseX.setDuration(2400);

        ObjectAnimator bodyPulseY = ObjectAnimator.ofFloat(bodyImage, View.SCALE_Y, 1f, 1.02f, 1f);
        bodyPulseY.setRepeatCount(ObjectAnimator.INFINITE);
        bodyPulseY.setDuration(2400);

        ObjectAnimator hatBounce = ObjectAnimator.ofFloat(hatImage, View.TRANSLATION_Y, 0f, -18f, 0f, -8f, 0f);
        hatBounce.setRepeatCount(ObjectAnimator.INFINITE);
        hatBounce.setDuration(1900);

        ObjectAnimator hatSway = ObjectAnimator.ofFloat(hatImage, View.ROTATION, 0f, -4f, 3f, 0f);
        hatSway.setRepeatCount(ObjectAnimator.INFINITE);
        hatSway.setDuration(1900);

        ObjectAnimator hatPulseX = ObjectAnimator.ofFloat(hatImage, View.SCALE_X, 1f, 1.05f, 0.98f, 1f);
        hatPulseX.setRepeatCount(ObjectAnimator.INFINITE);
        hatPulseX.setDuration(1900);

        ObjectAnimator hatPulseY = ObjectAnimator.ofFloat(hatImage, View.SCALE_Y, 1f, 1.05f, 0.98f, 1f);
        hatPulseY.setRepeatCount(ObjectAnimator.INFINITE);
        hatPulseY.setDuration(1900);

        ObjectAnimator subtitleGlow = ObjectAnimator.ofFloat(logoSubtitle, TextView.ALPHA, 1f, 0.6f, 1f);
        subtitleGlow.setRepeatCount(ObjectAnimator.INFINITE);
        subtitleGlow.setDuration(2400);

        loopAnimator = new AnimatorSet();
        loopAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        loopAnimator.playTogether(
                glowPulse,
                bodyFloatY,
                bodyPulseX,
                bodyPulseY,
                hatBounce,
                hatSway,
                hatPulseX,
                hatPulseY,
                subtitleGlow
        );
        loopAnimator.setStartDelay(980);
        loopAnimator.start();
    }

    private void stopHeaderAnimation() {
        if (introAnimator != null) {
            introAnimator.cancel();
            introAnimator = null;
        }

        if (loopAnimator != null) {
            loopAnimator.cancel();
            loopAnimator = null;
        }

        if (headerGlow != null) {
            headerGlow.animate().cancel();
            headerGlow.setAlpha(1f);
            headerGlow.setScaleX(1f);
            headerGlow.setScaleY(1f);
        }

        if (bodyImage != null) {
            bodyImage.animate().cancel();
            bodyImage.setAlpha(1f);
            bodyImage.setRotation(0f);
            bodyImage.setTranslationY(0f);
            bodyImage.setScaleX(1f);
            bodyImage.setScaleY(1f);
        }

        if (hatImage != null) {
            hatImage.animate().cancel();
            hatImage.setAlpha(1f);
            hatImage.setRotation(0f);
            hatImage.setTranslationY(0f);
            hatImage.setScaleX(1f);
            hatImage.setScaleY(1f);
        }

        if (logoSubtitle != null) {
            logoSubtitle.animate().cancel();
            logoSubtitle.setAlpha(1f);
            logoSubtitle.setTranslationY(0f);
        }
    }
}
