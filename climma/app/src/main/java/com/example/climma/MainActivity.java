package com.example.climma;

/*
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ExampleAdapter mExampleAdapter;
    private ArrayList<ExampleItem> mExampleList;
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}*/
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/*
 * Main Activity class that loads {@link MainFragment}.
 */
public class MainActivity extends FragmentActivity {
    // vv Weather App vv
    private RecyclerView mRecyclerView;
    private ExampleAdapter mExampleAdapter;
    private ArrayList<ExampleItem> mExampleList;
    private RequestQueue mRequestQueue;
    // ^^ Weather App ^^

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// vv WeatherWidget vv
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mExampleList = new ArrayList<>();
        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON();
//^^WeatherWidget ^^

        //Calendar View
        CalendarView cal = findViewById(R.id.calendarView);
        cal.setDate(System.currentTimeMillis(),false,true);
        //Calendar View

    }

    private void parseJSON(){
        /*String url= "http://api.weatherapi.com/v1/current" +
                ".json?key=b9a026455d694e49b46130959231110&q=Sabana%20Grande%20PR&aqi=no";*/
        String url =  "https://api.weatherbit.io/v2.0/current?lat=18.0777&lon=-66" +
                ".96&key=a15132d7eff4416dad163a2ed237d444&include=minutely&units=I";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {

                    JSONArray arrayLoc = response.getJSONArray("data");

                    for(int i = 0; i< arrayLoc.length(); i++){
                        JSONObject jsonData = arrayLoc.getJSONObject(i);

                        String City = jsonData.getString("city_name");
                        String Time = jsonData.getString("timezone");
                        String Precip = jsonData.getString("precip")+("%");
                        String Cond = jsonData.getJSONObject("weather").getString("description");
                        String Temp = jsonData.getString("temp") + ("°C");
                        String Humdt = jsonData.getString("rh") + ("%");
                        String Feel = jsonData.getString("app_temp");
                        String ImageUrl = "https://media.istockphoto.com/id/824800468/photo/sun-on-blue-sky-with-clouds.jpg?s=612x612&w=is&k=20&c=ZY1Q2wPQ-tBJA8Nsk6w-ceznGDW-gds6_RpqWMQVI1o=";

                        if (ImageUrl== "d"){
                            Toast.makeText(MainActivity.this, "aqui", Toast.LENGTH_SHORT).show();
                            ImageUrl = "http://172.16.0.180/iptv-api/images/channel/cartoon.png";
                        }else{
                            Toast.makeText(MainActivity.this, "No pa", Toast.LENGTH_SHORT).show();
                            ImageUrl= "https://images.unsplash" +
                                    ".com/photo-1588746853740-bd35aad10bfd?ixlib=rb-4.0" +
                                    ".3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8ZGF5fGVufDB8fDB8fHww&auto=format&fit=crop&w=1000&q=60";
                        }

                        mExampleList.add(new ExampleItem( City,Time,Cond, Precip, Temp,Humdt,Feel,ImageUrl));
                    }

                    mExampleAdapter = new ExampleAdapter(MainActivity.this,mExampleList);

                    mRecyclerView.setAdapter(mExampleAdapter);

                }catch (JSONException e) {
                    throw new RuntimeException(e);
                }

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueue.add(request);

    }

}

