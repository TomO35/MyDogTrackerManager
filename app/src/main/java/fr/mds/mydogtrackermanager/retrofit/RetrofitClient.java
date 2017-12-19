package fr.mds.mydogtrackermanager.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static DogTrackerService dogTrackerService = null;

    public static DogTrackerService getService() {
        Retrofit retrofit = null;

        if (dogTrackerService == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(DogTrackerService.ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            dogTrackerService = retrofit.create(DogTrackerService.class);
        }
        return dogTrackerService;
    }
}
