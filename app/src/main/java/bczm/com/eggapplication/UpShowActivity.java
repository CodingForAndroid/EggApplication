package bczm.com.eggapplication;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class UpShowActivity extends AppCompatActivity {

    private ImageView imageView;
    private View whiteView;
    /**
     * 斜着的蛋
     */
    private ImageView ivTiltEgg;
    private ImageView ivEggBottom;
    private ImageView ivPacket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_show);

        imageView = findViewById(R.id.ivEgg);
        whiteView = findViewById(R.id.whiteView);
        ivTiltEgg = findViewById(R.id.ivTiltEgg);
        ivEggBottom = findViewById(R.id.ivEggBottom);
        ivPacket = findViewById(R.id.ivPacket);
    }

    @Override
    protected void onResume() {
        super.onResume();
        upShowAnimation();
    }


    public void doAnimation() {
        PropertyValuesHolder alpha1 = PropertyValuesHolder.ofFloat("alpha", 1f, 0f, 1f);
        PropertyValuesHolder scaleX1 = PropertyValuesHolder.ofFloat("scaleX", 1f, 0f, 1f);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY", 1f, 0f, 1f);
        PropertyValuesHolder rotation1 = PropertyValuesHolder.ofFloat("rotation", 0.0f, 360f);
        PropertyValuesHolder translationX1 = PropertyValuesHolder.ofFloat("translationX", 200f);
        PropertyValuesHolder translationY1 = PropertyValuesHolder.ofFloat("translationY", 200f);
        PropertyValuesHolder translationX2 = PropertyValuesHolder.ofFloat("translationX", 0f);
        PropertyValuesHolder translationY2 = PropertyValuesHolder.ofFloat("translationY", 0f);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(imageView, alpha1, scaleX1, scaleY, rotation1, translationX1, translationY1);
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofPropertyValuesHolder(imageView, alpha1, scaleX1, scaleY, rotation1, translationX2, translationY2);
        //可以直接执行,不过不能拼接动画，这是组合动画
        //ObjectAnimator.ofPropertyValuesHolder(mimg, alpha1, scaleX1, scaleY, rotation1, translationX1, translationY1).setDuration(3000).start();
        //实例化AnimatorSet
        AnimatorSet animatorSet = new AnimatorSet();
        //使用play方法把两个动画拼接起来
        animatorSet.play(objectAnimator1).after(objectAnimator);
        //时间
        animatorSet.setDuration(3000);
        //开始执行
        animatorSet.start();
    }

    public enum AnimationState {
        STATE_SHOW,
        STATE_HIDDEN
    }

    /**
     * 渐隐渐现动画
     *
     * @param view     需要实现动画的对象
     * @param state    需要实现的状态
     * @param duration 动画实现的时长（ms）
     */

    public static void showAndHiddenAnimation(final View view, AnimationState state, long duration) {
        float start = 0f;
        float end = 0f;
        if (state == AnimationState.STATE_SHOW) {
            end = 1f;
            view.setVisibility(View.VISIBLE);
        } else if (state == AnimationState.STATE_HIDDEN) {
            start = 1f;
            view.setVisibility(View.INVISIBLE);
        }
        AlphaAnimation animation = new AlphaAnimation(start, end);
        animation.setDuration(duration);
        animation.setFillAfter(true);
        animation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.clearAnimation();
            }
        });
        view.setAnimation(animation);
        animation.start();
    }

    public void upShowAnimation() {
        //蛋从下往上
        PropertyValuesHolder translationY1 = PropertyValuesHolder.ofFloat("translationY", 156f, -156f);
        ////蛋从上往下
        PropertyValuesHolder translationY2 = PropertyValuesHolder.ofFloat("translationY", -156f, 0);
        //斜着的蛋从右边进入
        ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(ivTiltEgg, "translationX", 200, 0);
        objectAnimatorX.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                ivTiltEgg.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                //斜着的蛋隐藏
                ivTiltEgg.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        ObjectAnimator objectAnimatorY1 = ObjectAnimator.ofPropertyValuesHolder(imageView, translationY1);
        objectAnimatorY1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                //蛋开始从下往上滑
                imageView.setVisibility(View.VISIBLE);
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
        ObjectAnimator objectAnimatorY2 = ObjectAnimator.ofPropertyValuesHolder(imageView, translationY2);
        //旋转动画
//        PropertyValuesHolder rotate = PropertyValuesHolder.ofFloat("translationY", -156f, 0);
        Keyframe frame0 = Keyframe.ofFloat(0f, 0);

        Keyframe frame1 = Keyframe.ofFloat(0.1f, -30f);
        Keyframe frame2 = Keyframe.ofFloat(0.3f, 30f);
//        Keyframe frame3 = Keyframe.ofFloat(0.3f, -20f);
//        Keyframe frame4 = Keyframe.ofFloat(0.4f, 20f);
        Keyframe frame5 = Keyframe.ofFloat(0.5f, -30f);
        Keyframe frame6 = Keyframe.ofFloat(0.8f, 30f);
//        Keyframe frame7 = Keyframe.ofFloat(0.7f, -20f);
//        Keyframe frame8 = Keyframe.ofFloat(0.8f, 20f);
//        Keyframe frame9 = Keyframe.ofFloat(0.9f, -25f);
        Keyframe frame10 = Keyframe.ofFloat(1, 0);
        PropertyValuesHolder frameHolder = PropertyValuesHolder.ofKeyframe("rotation",frame0,frame1,frame2,frame5,frame6,frame10);

        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(imageView,frameHolder);
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                ivEggBottom.setVisibility(View.VISIBLE);
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
        //52  42
        imageView.setPivotX(78);
        imageView.setPivotY(126);
        PropertyValuesHolder scaleX1 = PropertyValuesHolder.ofFloat("scaleX",  0f, 1f);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY",  0f, 1f);
        ObjectAnimator animatorScale = ObjectAnimator.ofPropertyValuesHolder(ivPacket,scaleX1,scaleY);
        animatorScale.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                ivPacket.setVisibility(View.VISIBLE);
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
        AnimatorSet animatorSet = new AnimatorSet();
        //使用play方法把两个动画拼接起来
        animatorSet.play(objectAnimatorY1).after(objectAnimatorX);
        animatorSet.play(objectAnimatorY2).after(objectAnimatorY1);
        animatorSet.play(animator).after(objectAnimatorY2);
        animatorSet.play(animatorScale).after(animator);


        //时间
        animatorSet.setDuration(1000);
        //开始执行
        animatorSet.start();

    }
}
