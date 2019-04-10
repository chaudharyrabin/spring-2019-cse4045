package seu.edu.bd.smartdeviceappdevelopment.networkcommunication;

import android.os.AsyncTask;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import seu.edu.bd.smartdeviceappdevelopment.entity.Employee;

public class APICall extends AsyncTask<String, Void,JSONArray> {

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected JSONArray doInBackground(String... strings) {
        try {
            String url = strings[0];
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = client.newCall(request).execute();
            JSONArray jsonArray = new JSONArray(response.body().string());
            return jsonArray;
        }catch (Exception ex){
            ex.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(JSONArray jsonArray) {
        try {
            ArrayList<Employee> employees = new ArrayList<>();
            if(jsonArray != null){
                for(int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String id = jsonObject.getString("id");
                    String name = jsonObject.getString("employee_name");
                    String salary = jsonObject.getString("employee_salary");
                    String age = jsonObject.getString("employee_age");
                    String pp = jsonObject.getString("profile_image");

                    employees.add(new Employee(id,name,salary,age,pp));
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
