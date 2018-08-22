package bczm.com.eggapplication;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class ReverseAnimationActivity extends AppCompatActivity {

    private RelativeLayout relativeLayout;
    private ImageView ivCover;
    private ImageView ivTriangle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reverse_animation);

        relativeLayout = findViewById(R.id.rl);

        ivTriangle = findViewById(R.id.ivTriangle);

        ivCover = findViewById(R.id.ivCover);
    }

    @Override
    protected void onResume() {
        super.onResume();

        rotate();

    }


    public void rotate(){
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(ivCover, "rotationX", 0, 90);
        final ObjectAnimator animator2 = ObjectAnimator.ofFloat(ivTriangle, "rotationX", 180, 0);
        animator2.setInterpolator(new OvershootInterpolator(2.0f));

        animator1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                ivCover.setVisibility(View.GONE);
                animator2.setDuration(1000).start();
                ivTriangle.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator1.setDuration(1000).start();
    }
}
