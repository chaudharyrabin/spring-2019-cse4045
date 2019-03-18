package seu.edu.bd.smartdeviceappdevelopment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import seu.edu.bd.smartdeviceappdevelopment.listcontent.StudentListActivity;
import seu.edu.bd.smartdeviceappdevelopment.service.MyService;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button clickMe, startService, stopService;
    EditText username, password, mobileno;
    private Intent myServiceIntent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("ABC", "on create callback");


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ABC", "on start callback");
        clickMe = findViewById(R.id.next_page_button);
        startService = findViewById(R.id.start_service);
        stopService = findViewById(R.id.stop_service);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        mobileno = findViewById(R.id.mobileNo);

        // button on click
        clickMe.setOnClickListener(this);
        startService.setOnClickListener(this);
        stopService.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ABC", "on resume callback");
    }



    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.start_service){
            myServiceIntent = new Intent(this, MyService.class);
            startService(myServiceIntent);
        }else if(v.getId() == R.id.stop_service){
            stopService(myServiceIntent);
        }else {
            // call to another activity

        /*String username = this.username.getText().toString();
        String password = this.password.getText().toString();
        String mobileNo = this.mobileno.getText().toString();*/

            Intent intent = new Intent(MainActivity.this, StudentListActivity.class);
            startActivity(intent);
        }

    }
}
