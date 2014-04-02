package com.example.testeanimacoes;

 
import android.app.Activity;  
import android.os.Bundle;  
import android.util.Log;  
import android.view.View;  
import android.view.View.OnClickListener;  
import android.view.animation.AlphaAnimation;  
import android.view.animation.Animation;  
import android.view.animation.AnimationSet;  
import android.view.animation.AnimationUtils;  
import android.view.animation.ScaleAnimation;  
import android.view.animation.TranslateAnimation;  
import android.view.animation.Animation.AnimationListener;  
import android.view.animation.RotateAnimation;  
import android.widget.Button;  
import android.widget.ImageView; 

public class Testes extends Activity {  
    private ImageView imageView;  
 
    // define animationType enum
    enum AnimationType{  
        Alpha,  
        Rotate,  
        Scale,  
        Translate,  
        Complex  
    } 
 
    /** Called when the activity is first created. */ 
    @Override 
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.testes);  
 
        //define 4 button for each tween animation 
        imageView = (ImageView)findViewById(R.id.imageView);  
        Button alpha = (Button)findViewById(R.id.Alpha);  
        alpha.setOnClickListener(new AnimationClickListener(AnimationType.Alpha));  
        Button rotate = (Button)findViewById(R.id.Rotate);  
        rotate.setOnClickListener(new AnimationClickListener(AnimationType.Rotate));  
        Button scale = (Button)findViewById(R.id.Scale);  
        scale.setOnClickListener(new AnimationClickListener(AnimationType.Scale));  
        Button translate = (Button)findViewById(R.id.Translate);  
        translate.setOnClickListener(new AnimationClickListener(AnimationType.Translate));  
        Button complex = (Button)findViewById(R.id.Complex);  
        complex.setOnClickListener(new AnimationClickListener(AnimationType.Complex));  
    }  
   
      
 
    // create a listener inner class
    class AnimationClickListener implements OnClickListener{  
        private AnimationType animationType;  
        public AnimationClickListener(AnimationType animType){  
            animationType = animType;  
        }  
        public void onClick(View v) {  
            // TODO Auto-generated method stub  
            switch (animationType) {  
            case Alpha:  
 
                //Alpha animation. repeat 5 times, last for 1 mins                 
                AlphaAnimation alphaAnimation = (AlphaAnimation)AnimationUtils.loadAnimation(Testes.this, R.anim.teste_alpha);  
                imageView.startAnimation(alphaAnimation);  
                break;  
            case Rotate:  
                //rotate animation
                RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);  
                rotateAnimation.setDuration(3000);  
                rotateAnimation.setRepeatCount(3);  
                //start animation 
                imageView.startAnimation(rotateAnimation);  
                break;  
            case Scale:  
                //scale animation
                ScaleAnimation scaleAnimation = new ScaleAnimation(1, 1.5f, 1, 1.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);  
                scaleAnimation.setDuration(3000);  
                scaleAnimation.setRepeatCount(3);  
                //start animation 
                imageView.startAnimation(scaleAnimation);  
                break;  
            case Translate:  
                //translate animation
                TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 2, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 2);  
                translateAnimation.setDuration(3000);  
                translateAnimation.setRepeatCount(3);  
                //start animation 
                imageView.startAnimation(translateAnimation);  
                break;  
   
            case Complex:  
                //four animation overlap
                AnimationSet sets = new AnimationSet(false);  
                 
                AlphaAnimation _animation1 = new AlphaAnimation(1f, 0.1f);  
                _animation1.setDuration(3000);  
                 
                RotateAnimation rotateAnimation1 = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);  
                rotateAnimation1.setDuration(3000);  
                 
                ScaleAnimation scaleAnimation1 = new ScaleAnimation(1, 1.5f, 1, 1.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);  
                scaleAnimation1.setDuration(3000);  
                 
                TranslateAnimation translateAnimation1 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 2, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 2);  
                translateAnimation1.setDuration(3000);  
                 
                sets.addAnimation(_animation1);  
                sets.addAnimation(rotateAnimation1);  
                sets.addAnimation(scaleAnimation1);  
                sets.addAnimation(translateAnimation1);  
                imageView.startAnimation(sets);  
                break;  
            default:  
                break;  
            }  
        }  
    }  
} 
