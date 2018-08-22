package bczm.com.eggapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class EggActivity extends AppCompatActivity {

    private ImageView ivTiltEgg;
    private ImageView ivEgg;
    private ImageView ivEggBottom;
    private ImageView ivPacket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egg);


        ivTiltEgg = findViewById(R.id.ivTiltEgg);
        ivEgg = findViewById(R.id.ivEgg);
        ivEggBottom = findViewById(R.id.ivEggBottom);
        ivPacket = findViewById(R.id.ivPacket);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        translate_up();
        xTranslate();
    }


    public void translate(){
//        ObjectAnimator translationX = ObjectAnimator.ofFloat(ivEgg,"translationX",0,600f);
//        ObjectAnimator translationY = ObjectAnimator.ofFloat(ivEgg,"translationY",0,0);
//
//        AnimatorSet animatorSet = new AnimatorSet();  //组合动画
//        animatorSet.playTogether(translationX,translationY); //设置动画
//        animatorSet.setDuration(3000);  //设置动画时间
//        animatorSet.start(); //启动

        Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        rotateAnimation.setFillAfter(false);
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                scale();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        ivEgg.setVisibility(View.VISIBLE);
        ivEggBottom.setVisibility(View.VISIBLE);
        ivEgg.startAnimation(rotateAnimation);
    }

    private void xTranslate() {
        ObjectAnimator translationX = ObjectAnimator.ofFloat(ivTiltEgg, "translationX", 200, 0);
        //创建透明度动画
        ObjectAnimator alpha = ObjectAnimator.ofFloat(ivTiltEgg, "alpha", 0f, 1.0f);
        //动画集合
        AnimatorSet set = new AnimatorSet();
        //添加动画
        set.play(translationX);//.with(alpha)
//        set.play(translationX).with(alpha);
//        set.play(alpha);
        //设置时间等
        set.setDuration(1000);
        set.start();
        ivTiltEgg.setVisibility(View.VISIBLE);
        //动画监听
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                ivTiltEgg.setVisibility(View.GONE);
                upTranslateY();
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

    private void upTranslateY(){
        Animation rotateAnimation =  AnimationUtils.loadAnimation(this, R.anim.translate_up);

        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                downTranslateY();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        ivEgg.setVisibility(View.VISIBLE);
        ivEgg.startAnimation(rotateAnimation);
    }

    private void downTranslateY(){
        Animation rotateAnimation =  AnimationUtils.loadAnimation(this, R.anim.translate_down);

        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                translate();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
//        ivEgg.setVisibility(View.VISIBLE);
        ivEgg.startAnimation(rotateAnimation);
    }
    private void yTranslate() {
        Animation translationY = new TranslateAnimation(0,0,0,-200);
        translationY.setFillAfter(true);
        translationY.setDuration(1000);
        translationY.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                translate();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        ivEgg.setVisibility(View.VISIBLE);
        ivEgg.startAnimation(translationY);
    }

    private  void  scale(){

        ivPacket.setVisibility(View.VISIBLE);
        Animation scaleAnimation = new ScaleAnimation(0.5f,1,0.5f,1f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,1f);
        scaleAnimation.setDuration(500);
        ivPacket.startAnimation(scaleAnimation);
    }
}
