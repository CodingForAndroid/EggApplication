package bczm.com.eggapplication;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class PacketActivity extends AppCompatActivity {

    private RelativeLayout rlTicket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_packet);

        rlTicket = findViewById(R.id.rlTicket);
    }

//    private Handler handler = new Handler() {
//        @Override
//        public void handleMessage(android.os.Message msg) {
//            switch (msg.what) {
//                case 1:
//                    startAnimation();
//                    break;
//
//                default:
//                    break;
//            }
//
//        };
//    };
//    /**
//     * 测试用的,开启子线程
//     */
//    private void newThread() {
//        new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(1500);
//                } catch (InterruptedException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//
//                Message msg = new Message();
//                msg.what = 1;
//                handler.sendMessage(msg);
//
//            }
//        }).start();
//    }
    @Override
    protected void onResume() {
        super.onResume();
        startAnimation();
//        newThread() ;
    }
    /**
     * 启动
     */
    private void startAnimation() {
//        Animation anim = AnimationUtils.loadAnimation(this, R.anim.slide_down_in);
//        anim.setDuration(1000);
//        anim.setFillAfter(true);
//        rlTicket.startAnimation(anim);

        Animation  anim = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.0f);
        anim.setDuration(1000);
        anim.setFillAfter(true);
        rlTicket.startAnimation(anim);
    }


}
