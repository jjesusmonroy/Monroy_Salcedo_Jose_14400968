package frameanimations.monroy.com.frameanimations;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button start,stop;
    AnimationDrawable animationDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        if(imageView == null) {
            throw new AssertionError();
        }

        imageView.setVisibility(View.INVISIBLE);
        imageView.setBackgroundResource(R.drawable.dancingshark);

        animationDrawable = (AnimationDrawable) imageView.getBackground();
        animationDrawable.setOneShot(false);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setVisibility(View.VISIBLE);
                if(animationDrawable.isRunning()){
                    animationDrawable.stop();
                }
                animationDrawable.start();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animationDrawable.stop();
            }
        });
    }

    private void init(){
        imageView=findViewById(R.id.imageView);
        start=findViewById(R.id.start);
        stop=findViewById(R.id.stop);
    }
}
