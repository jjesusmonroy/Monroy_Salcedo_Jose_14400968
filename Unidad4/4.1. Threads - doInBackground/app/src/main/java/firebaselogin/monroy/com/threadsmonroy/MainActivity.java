package firebaselogin.monroy.com.threadsmonroy;

import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText caja1;
    Button button2;
    EditText caja2;
    Button button4;

    ProgressBar progressBar1;
    ProgressBar progressBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        button2.setOnClickListener(this);
        button4.setOnClickListener(this);
    }

    private void init(){
        caja1 =findViewById(R.id.et1);
        button2 =findViewById(R.id.button2);
        caja2 = findViewById(R.id.et2);
        button4 = findViewById(R.id.button4);
        progressBar1 = findViewById(R.id.progressBar1);
        progressBar2 = findViewById(R.id.progressBar2);
    }

    private void UnSegundo() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        int i;
        switch (v.getId()) {

            case R.id.button2:
                String num=caja1.getText()+"";
                AsyncTarea asyncTarea = new AsyncTarea();
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    asyncTarea.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,num);
                }
                else {
                    asyncTarea.execute(num);
                }
                break;
            case R.id.button4:
                String num2=caja2.getText().toString();
                AsyncTarea2 asyncTarea2 = new AsyncTarea2();
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    asyncTarea2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,num2);
                }
                else{
                    asyncTarea2.execute(num2);
                }
                break;
            default:
                break;
        }
    }

    private class  AsyncTarea extends AsyncTask<String, Integer,Boolean> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar1.setMax(100);
        }

        @Override
        protected Boolean doInBackground(String... params) {
            int p=Integer.parseInt(params[0]);
            for (int i=1; i<=p; i++){
                UnSegundo();
                publishProgress(i*1);
                if (isCancelled()){
                    break;
                }
            }
            return true;
        }


        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar1.setProgress(values[0].intValue());
        }

        @Override
        protected void onPostExecute(Boolean aVoid) {
            //super.onPostExecute(aVoid);
            if (aVoid){
                Toast.makeText(getApplicationContext(),"Tarea finalizada AsyncTask",Toast.LENGTH_SHORT).show();
            }
        }


        @Override
        protected void onCancelled() {
            super.onCancelled();

            Toast.makeText(getApplicationContext(),"Tarea NO finalizada AsyncTask",Toast.LENGTH_SHORT).show();

        }


    }
    private class  AsyncTarea2 extends AsyncTask<String, Integer,Boolean> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar2.setMax(100);
        }

        @Override
        protected Boolean doInBackground(String... params) {
            int p=Integer.parseInt(params[0]);
            for (int i=1; i<=p; i++){
                UnSegundo();
                publishProgress(i*1);

                if (isCancelled()){
                    break;
                }
            }
            return true;
        }


        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar2.setProgress(values[0].intValue());
        }

        @Override
        protected void onPostExecute(Boolean aVoid) {
            if (aVoid){
                Toast.makeText(getApplicationContext(),"Tarea finalizada AsyncTask",Toast.LENGTH_SHORT).show();
            }
        }


        @Override
        protected void onCancelled() {
            super.onCancelled();
            Toast.makeText(getApplicationContext(),"Tarea NO finalizada AsyncTask",Toast.LENGTH_SHORT).show();

        }
    }
}
