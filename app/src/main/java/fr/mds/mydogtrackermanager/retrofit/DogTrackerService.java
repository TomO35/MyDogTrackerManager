package fr.mds.mydogtrackermanager.retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DogTrackerService {

    String ENDPOINT = "http://dogtracker.epizy.com/";

    @POST("ws.php?action=add_user")
    @FormUrlEncoded
    Call<BasicAnswer> add_user(@Field("name") String name, @Field("lastname") String lastname, @Field("password") String password, @Field("email") String email);

    @POST("ws.php?action=add_position")
    @FormUrlEncoded
    Call<BasicAnswer> add_position(@Field("spy_id") String spyId, @Field("longitude") String longitude, @Field("latitude") String latitude);

    @POST("ws.php?action=add_spy")
    @FormUrlEncoded
    Call<BasicAnswer> add_spy(@Field("spy_name") String spy_name);

    @POST("ws.php?action=remove_spy")
    @FormUrlEncoded
    Call<BasicAnswer> remove_spy(@Field("spy_name") String spy_name);

    @POST("ws.php?action=find_spy")
    @FormUrlEncoded
    Call<BasicAnswer> find_spy(@Field("spy_name") String spy_name);

    @POST("ws.php?action=update_name_spy")
    @FormUrlEncoded
    Call<BasicAnswer> update_name_spy(@Field("spy_id") String spy_id, @Field("spy_name") String spy_name);

    @GET("ws.php?action=retrieve_last_pos_spies")
    Call<Positions> retrieve_last_pos_spies(@Field("user_id") String user_id);

    @GET("ws.php?action=retrieve_all_pos_spy")
    Call<Positions> retrieve_all_pos_spy(@Field("spy_id") String spy_id, @Field("user_id") String user_id);

    @GET("ws.php?action=check_password")
    Call<BasicAnswer> checkPassword(@Field("user_id") String id, @Field("password") String password);

}
