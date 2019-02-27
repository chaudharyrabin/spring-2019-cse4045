package seu.edu.bd.smartdeviceappdevelopment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CartActivity extends AppCompatActivity implements View.OnClickListener {

    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
    }

    @Override
    protected void onStart() {
        super.onStart();
        backButton = findViewById(R.id.back_button);

        backButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // back to main activity
        Intent intent = new Intent(CartActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
