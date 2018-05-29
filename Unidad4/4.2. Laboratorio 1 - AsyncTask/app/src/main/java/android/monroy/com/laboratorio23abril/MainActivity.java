package android.monroy.com.laboratorio23abril;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    ListView listView;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                arrayList);
        listView.setAdapter(arrayAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(editText.getText().toString());
                Task task = new Task();
                task.execute(num);
            }
        });

    }

    private void init(){
        editText=findViewById(R.id.editText);
        button=findViewById(R.id.button);
        listView=findViewById(R.id.listview);
        clean();
    }
    private void clean(){
        arrayList=new ArrayList<>();
        arrayList.add("0");
    }

    private void segundo(){
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private class Task extends AsyncTask<Integer,String,Boolean> {

        @Override
        protected Boolean doInBackground(Integer... integers) {
            int p=integers[0];
            int f0=0;
            int f1=1;
            int f_2=0;
            int f_1=0;
            int f_actual;
            for (int i=2; i<=p; i++){
                segundo();
                if(i==2){
                    f_actual=f0+f1;
                }else{
                    f_actual=f_2+f_1;
                }
                publishProgress(   f_actual+"");
                f_2=f_1;
                f_1=f_actual;
                if (isCancelled()){
                    break;
                }
            }
            return true;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            arrayList.add(values[0]);
            arrayAdapter.notifyDataSetChanged();
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
        }
    }
}
