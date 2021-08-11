package sheylli.myappcompany.covid_19tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recview;
    private ArrayList<Model> modelArrayList;
    private ModelAdapter modelAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recview=findViewById(R.id.recview);
        modelArrayList= new ArrayList<>();
        modelAdapter= new ModelAdapter(modelArrayList,this);
        recview.setLayoutManager(new LinearLayoutManager(this));
        recview.setAdapter(modelAdapter);
        processData();
    }


    private void processData() {

        String url= "https://api.covid19india.org/state_district_wise.json";
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try{
                    Iterator<String> keys = response.keys();
                    keys.next();
                    while(keys.hasNext())
                    {
                        String stateName = keys.next();
                        JSONObject jsonObject= response.getJSONObject(stateName);
                        JSONObject districtdata= jsonObject.getJSONObject("districtData");
                        Iterator<String> districts = districtdata.keys();
                        while(districts.hasNext()) {
                            String districtName = districts.next();
                            JSONObject district = districtdata.getJSONObject(districtName);
                            long active = district.getLong("active");
                            long confirmed = district.getLong("confirmed");
                            long decreased = district.getLong("deceased");
                            long recovered = district.getLong("recovered");
                            Toast.makeText(getApplicationContext(), "" + stateName + " " + districtName + " " + active + " " + confirmed, Toast.LENGTH_SHORT).show();
                            modelArrayList.add(new Model(stateName,districtName,active,recovered,decreased,confirmed));

                        }
                        modelAdapter.notifyDataSetChanged();
                    }

                } catch (JSONException e) {
                    Toast.makeText(MainActivity.this,"Fail to extract json data!!",Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();

            }
        }){

        };
        requestQueue.add(jsonObjectRequest);
    }
}