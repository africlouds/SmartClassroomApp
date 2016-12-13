package africlouds.com.smartclassroomapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by rwm on 12/12/16.
 */

public interface IoTAPI {
    @GET("/preference/{user}")
    Call<Preference> get_preferences(
            @Path("user") String user
    );
}

