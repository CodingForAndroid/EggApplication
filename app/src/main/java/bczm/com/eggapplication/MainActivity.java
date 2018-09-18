package bczm.com.eggapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    public void eggAnimation(View view){

        startActivity(new Intent(this,EggActivity.class));
    }
    public void packetAnimation(View view){
        startActivity(new Intent(this,PacketActivity.class));
    }

    public void packetReverseAnimation(View view){
        startActivity(new Intent(this,ReverseAnimationActivity.class));
    }

    public void upShow(View view){
        startActivity(new Intent(this,UpShowActivity.class));
    }

    public void slideShow(View view){
        startActivity(new Intent(this,SlideEggActivity.class));
    }
}
