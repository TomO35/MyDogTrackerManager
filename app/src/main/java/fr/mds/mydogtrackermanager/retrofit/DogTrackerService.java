package fr.mds.mydogtrackermanager.retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DogTrackerService {

    String ENDPOINT = "http://dogtracker.epizy.com/";

    @GET("ws.php?action=add_user")
    Call<BasicAnswer> add_user(@Query("name") String name, @Query("lastname") String lastname, @Query("password") String password, @Query("email") String email);

    @GET("ws.php?action=add_position")
    Call<BasicAnswer> add_position(@Field("spy_id") String spyId, @Field("longitude") String longitude, @Field("latitude") String latitude);

    @GET("ws.php?action=remove_spy")
    Call<BasicAnswer> remove_spy(@Field("spy_name") String spy_name);

    @GET("ws.php?action=find_spy")
    Call<BasicAnswer> find_spy(@Field("spy_name") String spy_name);

    @GET("ws.php?action=update_name_spy")
    Call<BasicAnswer> update_name_spy(@Field("spy_id") String spy_id, @Field("spy_name") String spy_name);

    @GET("ws.php?action=link_spy")
    Call<BasicAnswer> link_spy(@Field("spy_id") String spy_id, @Field("user_id") String user_id);

    @GET("ws.php?action=retrieve_last_pos_spies")
    Call<Positions> retrieve_last_pos_spies(@Field("user_id") String user_id);

    @GET("ws.php?action=retrieve_all_pos_spy")
    Call<Positions> retrieve_all_pos_spy(@Field("spy_id") String spy_id, @Field("user_id") String user_id);

    @GET("ws.php?action=check_password")
    Call<BasicAnswer> checkPassword(@Field("user_id") String id, @Field("password") String password);

}
