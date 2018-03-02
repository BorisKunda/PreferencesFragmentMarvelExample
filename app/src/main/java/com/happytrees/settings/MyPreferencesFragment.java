package com.happytrees.settings;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by Boris on 3/2/2018.
 */

public class MyPreferencesFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);


    }
}
