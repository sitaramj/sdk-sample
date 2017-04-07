package niki.com.sdk_sample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.niki.config.NikiConfig;
import com.niki.config.SessionConfig;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SessionConfig config = new SessionConfig.Builder()
                .setAccessKey("1480670100")
                .setSecret("f2IRd4YC552QZAqu2DThFdzwYAHyuxbu1NfVJghYazw=")
                .setMerchantTitle("Sample App").build();
        NikiConfig.initNiki(this, config);
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
            SessionConfig config = new SessionConfig.Builder()
                    .setAccessKey("1480670100")
                    .setSecret("f2IRd4YC552QZAqu2DThFdzwYAHyuxbu1NfVJghYazw=")
                    .setMerchantTitle("Sample App").build();
            NikiConfig.initNiki(this, config);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
