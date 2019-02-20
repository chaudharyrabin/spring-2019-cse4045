package seu.edu.bd.smartdeviceappdevelopment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    TextView locationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("ABC", "on create callback");

        image = findViewById(R.id.imageview1);
        locationText = findViewById(R.id.text);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ABC", "on start callback");
        locationText.setText("Location Name");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ABC", "on resume callback");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ABC", "on pause callback");
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
