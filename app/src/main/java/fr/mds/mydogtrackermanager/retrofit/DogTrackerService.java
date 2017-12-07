package fr.mds.mydogtrackermanager.retrofit;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface DogTrackerService {

    @GET("/MYURL")
    Call<DataContainer> myMethod(@Query("parameter") int parameterValue);

    @POST("/URL")
    @FormUrlEncoded
    Call<DataContainer> checkPassword(@Query("user_id") String id, @Query("password") String password);

}
