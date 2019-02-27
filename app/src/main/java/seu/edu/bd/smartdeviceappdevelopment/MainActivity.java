package seu.edu.bd.smartdeviceappdevelopment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import seu.edu.bd.smartdeviceappdevelopment.fragment.ProductListFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button clickMe;
    EditText username, password, mobileno;

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
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        mobileno = findViewById(R.id.mobileNo);

        // button on click
        clickMe.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ABC", "on resume callback");
    }



    @Override
    public void onClick(View v) {
        // call to another activity

        String username = this.username.getText().toString();
        String password = this.password.getText().toString();
        String mobileNo = this.mobileno.getText().toString();


        Intent intent = new Intent(MainActivity.this, CartActivity.class);

        intent.putExtra("user_name", username);
        intent.putExtra("password",password);
        intent.putExtra("mobile_no", mobileNo);



        startActivity(intent);
    }
}
