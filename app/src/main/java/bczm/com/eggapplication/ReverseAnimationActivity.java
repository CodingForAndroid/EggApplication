package bczm.com.eggapplication;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class ReverseAnimationActivity extends AppCompatActivity {

    private RelativeLayout relativeLayout;
    private ImageView ivCover;
    private ImageView ivTriangle;
    private ImageView ivCoupon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reverse_animation);

//        relativeLayout = findViewById(R.id.rl);

        ivTriangle = findViewById(R.id.ivTriangle);

        ivCover = findViewById(R.id.ivCover);

        ivCoupon = findViewById(R.id.ivCoupon);

    }

    @Override
    protected void onResume() {
        super.onResume();
        MyAnimation animation = new MyAnimation();
//        animation.setRepeatCount(2);
//        ivCover.setPivotX(0);
//        ivCover.setPivotY(0);
//        ivCover.startAnimation(animation);
        rotate();

    }


    public void rotate() {

//        image.setPivotX(image.getWidth()/2);
//        image.setPivotY(image.getHeight()/2);//支点在图片中心
//        ObjectAnimator ra = ObjectAnimator.ofFloat(ivCover,"rotation", 0f, 360f);
//        ra.setDuration(3000);
//        ra.start();
        ivCover.setPivotY(0);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(ivCover, "scaleY", 1f, 0f);
//        ObjectAnimator animator1 = ObjectAnimator.ofFloat(ivCover, "rotationX", 0, 180);
        animator1.setDuration(1500);
        ivTriangle.setPivotY(357);
        //钱包打开背面
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(ivTriangle, "scaleY", 0f, 1f);
        animator2.setDuration(1500);
        animator2.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                ivTriangle.setVisibility(View.VISIBLE);


            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
//        animator2.setInterpolator(new OvershootInterpolator(2.0f));
//        animator2.setDuration(5000).start();
        animator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                Log.e("addUpdateListener","---------"+   animation.getCurrentPlayTime());
            }
        });
        animator1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                ivCover.setVisibility(View.GONE);

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        //蛋从下往上
        PropertyValuesHolder translationY1 = PropertyValuesHolder.ofFloat("translationY", 0f, -220f);
        ObjectAnimator animatorTranslationY1 = ObjectAnimator.ofPropertyValuesHolder(ivCoupon, translationY1);
        animatorTranslationY1.setDuration(1500);
//        animator1.setDuration(6000).start();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.play(animator2).after(animator1);
        animatorSet.play(animatorTranslationY1).with(animator2);
//         animatorSet.play().after(100);
//        animatorSet.setDuration(1000);
        //开始执行

        animatorSet.start();
    }
}
