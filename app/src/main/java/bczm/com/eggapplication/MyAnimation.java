package bczm.com.eggapplication;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BaseInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

/**
 * @author zhangjun
 * @date 2018/8/23
 */
public class MyAnimation extends Animation {
    int centerX, centerY;
    Camera camera = new Camera();

    @Override
    public void initialize(int width, int height, int parentWidth,
                           int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        //获取中心点坐标
        centerX = width/ 2;;
        centerY = height / 2;
        //动画执行时间  自行定义
        setDuration(1200);
        setInterpolator(new LinearInterpolator());
    }

    float index = 0;
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        final Matrix matrix = t.getMatrix();
        camera.save();
        //中心是绕Y轴旋转  这里可以自行设置X轴 Y轴 Z轴
//        camera.rotateY(360 * interpolatedTime);
//        camera.rotateZ(360 * interpolatedTime);

//        if(index<1){
//            Log.e("applyTransformation","index="+index);
//            camera.rotateX(180 * index);
            //把我们的摄像头加在变换矩阵上
            camera.getMatrix(matrix);
            //设置翻转中心点
//        matrix.setScale(1,1);
//matrix
            matrix.rectStaysRect();
//        matrix.preTranslate(-centerX, -centerY*2);
//        matrix.postTranslate(centerX, centerY*2);
//
        matrix.setScale(1f,1f,1f,0.1f);
//            matrix.preTranslate(-centerX, 0);
//
//            matrix.postTranslate(centerX, 0);

            camera.restore();
//            index =index+0.01f;
        }


}