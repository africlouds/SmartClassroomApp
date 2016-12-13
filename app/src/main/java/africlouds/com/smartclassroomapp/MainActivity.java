package africlouds.com.smartclassroomapp;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        IoTAPI api = ServiceGenerator.createService(IoTAPI.class, "admin", "admin");

        // Fetch and print a list of the contributors to this library.
        Call<Preference> call = api.get_preferences("aimable");

        TextView feedbackText = (TextView) findViewById(R.id.temperature);
        try {
                Preference preference = call.execute().body();
                feedbackText.setText("Temperature: "+preference.temperature);
        } catch (IOException e) {
            // handle errors
            feedbackText.setText(e.toString());
        }

    }
}
