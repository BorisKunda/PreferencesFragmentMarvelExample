package com.happytrees.settings;

import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getFragmentManager().beginTransaction().replace(R.id.mylayout, new ListFragment()).commit(); //way of committing and creating fragment one line




    }
    //inflate menu xml files
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.showSettings) {
            getFragmentManager().beginTransaction().addToBackStack("replacing")
                    .replace(R.id.mylayout, new MyPreferencesFragment()).commit();
        }


        return true;

    }


}
