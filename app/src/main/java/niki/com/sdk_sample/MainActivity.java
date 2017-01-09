package niki.com.sdk_sample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.niki.config.NikiConfig;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        NikiConfig.initNiki(this, "key", "Sample APP");
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", "ABC");
            jsonObject.put("email", "ABC@ced.com");
            jsonObject.put("phoneNumber", "9911446321");
            jsonObject.put("regId", "regid");
            NikiConfig.getInstance().setUserData(this, jsonObject);
        } catch (Exception e) {

        }
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NikiConfig.getInstance().startNikiChat(MainActivity.this);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            if (NikiConfig.isNikiInitialized()) {
                NikiConfig.getInstance().logout(this);

            }
            NikiConfig.initNiki(this, "key", "Merchant");
            try {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("name", "xyz");
                jsonObject.put("email", "xyz@xyz.com");
                jsonObject.put("phoneNumber", "9711151751");
                jsonObject.put("regId", "xyz");
                NikiConfig.getInstance().setUserData(this, jsonObject);
            } catch (Exception e) {

            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
