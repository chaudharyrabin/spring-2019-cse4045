package seu.edu.bd.smartdeviceappdevelopment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import seu.edu.bd.smartdeviceappdevelopment.fragment.ProductListFragment;

public class MainActivity extends AppCompatActivity {


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

        // call a fragment
        Fragment fragment = new ProductListFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainFrame, fragment);
        fragmentTransaction.commit();
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
