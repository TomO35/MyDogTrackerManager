package fr.mds.mydogtrackermanager.retrofit;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface DogTrackerService {

    String URL = "http://dogtracker.epizy.com/ws.php";

    @POST(URL)
    @FormUrlEncoded
    Call<DataContainer> add_user(@Query("name") String name, @Query("lastname") String lastname, @Query("password") String password, @Query("email") String email);

    @POST(URL)
    @FormUrlEncoded
    Call<DataContainer> add_position(@Query("spy_id") String spyId, @Query("longitude") String longitude, @Query("latitude") String latitude);

    @POST(URL)
    @FormUrlEncoded
    Call<DataContainer> add_spy(@Query("spy_name") String spy_name);

    @POST(URL)
    @FormUrlEncoded
    Call<DataContainer> remove_spy(@Query("spy_name") String spy_name);

    @POST(URL)
    @FormUrlEncoded
    Call<DataContainer> find_spy(@Query("spy_name") String spy_name);

    @POST(URL)
    @FormUrlEncoded
    Call<DataContainer> update_name_spy(@Query("spy_id") String spy_id, @Query("spy_name") String spy_name);

    @GET(URL)
    Call<DataContainer> retrieve_last_pos_spies(@Query("user_id") String user_id);

    @GET(URL)
    Call<DataContainer> retrieve_all_pos_spy(@Query("spy_id") String spy_id, @Query("user_id") String user_id);

    @GET(URL)
    Call<DataContainer> checkPassword(@Query("user_id") String id, @Query("password") String password);

}
