package animation.monroy.com.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imagen;
    Button botonGrow,botonFade,botonBlink,botonMove;
    Animation animFadein;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagen=findViewById(R.id.image);
        botonGrow=findViewById(R.id.button1);
        botonFade=findViewById(R.id.button2);
        botonBlink=findViewById(R.id.button3);
        botonMove=findViewById(R.id.button4);
        botonGrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // load the animation
                animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.grow);
                imagen.startAnimation(animFadein);
            }
        });
        botonFade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // load the animation
                animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.fade);
                imagen.startAnimation(animFadein);
            }
        });
        botonBlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // load the animation
                animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.blink);
                imagen.startAnimation(animFadein);
            }
        });
        botonMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // load the animation
                animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.move);
                imagen.startAnimation(animFadein);
            }
        });


    }


}
