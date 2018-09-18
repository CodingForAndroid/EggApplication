package bczm.com.eggapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SlideEggActivity extends AppCompatActivity {

    private ImageView ivSlideEgg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_egg);

        ivSlideEgg = findViewById(R.id.ivSlideEgg);
        ivSlideEgg.setVisibility(View.INVISIBLE);
    }


    @Override
    protected void onResume() {
        super.onResume();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                xTranslate();
            }
        },500);
    }

    private void xTranslate() {
        ObjectAnimator translationX = ObjectAnimator.ofFloat(ivSlideEgg, "translationX", 200, 0);
        //创建透明度动画
        ObjectAnimator alpha = ObjectAnimator.ofFloat(ivSlideEgg, "alpha", 0f, 1.0f);
        //动画集合
        AnimatorSet set = new AnimatorSet();
        //添加动画
        set.play(translationX);//.with(alpha)
//        set.play(translationX).with(alpha);
//        set.play(alpha);
        //设置时间等
        set.setDuration(1000);
        set.start();
        ivSlideEgg.setVisibility(View.VISIBLE);
        //动画监听
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
//                ivTiltEgg.setVisibility(View.GONE);
//                upTranslateY();
//                yTranslate();
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }
        });
    }
}
