package com.example.basic;

import android.app.IntentService;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;

import com.aware.providers.Accelerometer_Provider;
import com.aware.utils.DatabaseHelper;
import com.aware.utils.Https;

import java.util.Hashtable;

public class ProviderService extends IntentService {

    public ProviderService() {
        super("ProviderService");
        Log.d("Provider", "constructor");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // Gets data from the incoming Intent
//        //Get the last 1000 records from accelerometer
        Log.d("Provider", "onHandle");
        Cursor accelerometer_data = getContentResolver().query(Accelerometer_Provider.Accelerometer_Data.CONTENT_URI, null, null, null, Accelerometer_Provider.Accelerometer_Data.TIMESTAMP);

        String check = "";
        if (accelerometer_data == null)
            check = "True";
        else
            check = "False";
        Log.d("before IF, Provider:", check);

        if( accelerometer_data != null && accelerometer_data.getCount() > 0 ) {
            Https https = new Https(getResources().openRawResource(R.raw.server));
            Hashtable<String, String> postData = new Hashtable<>();
            postData.put("accelerometer_data", DatabaseHelper.cursorToString(accelerometer_data));
            Log.d("POSTDATA", postData.toString());
            https.dataPOST("https://compwell.ece.rice.edu/AWARE/index.php/webservice/index/25/obl56DNEE2mw", postData, false); //set to true if your server supports gzip compression
        }
        if( accelerometer_data != null && ! accelerometer_data.isClosed() ) accelerometer_data.close();

    }

}
