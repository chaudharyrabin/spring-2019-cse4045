package seu.edu.bd.smartdeviceappdevelopment;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import seu.edu.bd.smartdeviceappdevelopment.entity.Employee;
import seu.edu.bd.smartdeviceappdevelopment.listcontent.StudentListActivity;
import seu.edu.bd.smartdeviceappdevelopment.networkcommunication.APICall;
import seu.edu.bd.smartdeviceappdevelopment.service.MyService;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button clickMe, startService, stopService, webapicall, camera;
    EditText username, password, mobileno;
    private Intent myServiceIntent;
    private ArrayList<Employee> employees;
    private String currentPathUri;


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
        webapicall = findViewById(R.id.webapi);
        camera = findViewById(R.id.camera);

        // button on click
        clickMe.setOnClickListener(this);
        startService.setOnClickListener(this);
        stopService.setOnClickListener(this);
        webapicall.setOnClickListener(this);
        camera.setOnClickListener(this);
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
        }else if(v.getId() == R.id.webapi){
            // call APICall class
            //APICall apiCall = new APICall();
            //apiCall.execute("http://dummy.restapiexample.com/api/v1/employees");
            networkCommunication();
        }else if(v.getId() == R.id.camera){
            startActivity(new Intent(this, CameraActivity.class));
        }else {
            // call to another activity

        /*String username = this.username.getText().toString();
        String password = this.password.getText().toString();
        String mobileNo = this.mobileno.getText().toString();*/

            Intent intent = new Intent(MainActivity.this, StudentListActivity.class);
            startActivity(intent);
        }

    }

    private void networkCommunication() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://dummy.restapiexample.com/api/v1/employees";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(com.android.volley.Request.Method.GET, url, null, new com.android.volley.Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    Employee employee = new Gson().fromJson(response.toString(),Employee.class);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG",error.networkResponse.toString());
            }
        });
        queue.add(jsonArrayRequest);
    }
}
