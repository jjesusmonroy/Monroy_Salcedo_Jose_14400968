package objectanimator.monroy.com.objectanimator;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RelativeLayout relativeLayout;
    ImageView imageView;
    Button a1,a2,a3,a4;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int height= relativeLayout.getHeight();
                int targetY=height - imageView.getHeight();

                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(
                        imageView, "y", targetY, 0)
                        .setDuration(1000);
                objectAnimator.setInterpolator(new AnticipateInterpolator());
                textView.setText("Anticipate");
                objectAnimator.setDuration(300L);
                objectAnimator.start();
            }
        });
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int height= relativeLayout.getHeight();
                int targetY=height - imageView.getHeight();

                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(
                        imageView, "y", targetY, 0)
                        .setDuration(1000);
                objectAnimator.setInterpolator(new BounceInterpolator());
                textView.setText("Bounce");
                objectAnimator.setDuration(300L);
                objectAnimator.start();
            }
        });
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int height= relativeLayout.getHeight();
                int targetY=height - imageView.getHeight();

                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(
                        imageView, "y", targetY, 0)
                        .setDuration(1000);
                objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                textView.setText("Accelerate Decelerate");
                objectAnimator.setDuration(300L);
                objectAnimator.start();
            }
        });
        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int height= relativeLayout.getHeight();
                int targetY=height - imageView.getHeight();

                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(
                        imageView, "y", targetY, 0)
                        .setDuration(1000);
                objectAnimator.setInterpolator(new OvershootInterpolator());
                textView.setText("Overshoot");
                objectAnimator.setDuration(300L);
                objectAnimator.start();
            }
        });
    }

    private void init(){
        imageView=findViewById(R.id.imageView);
        relativeLayout=findViewById(R.id.relativeLayout);
        a1=findViewById(R.id.a1);
        a2=findViewById(R.id.a2);
        a3=findViewById(R.id.a3);
        a4=findViewById(R.id.a4);
        textView=findViewById(R.id.textView);
    }


}
