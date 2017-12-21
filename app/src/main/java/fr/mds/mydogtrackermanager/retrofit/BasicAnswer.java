package fr.mds.mydogtrackermanager.retrofit;

import com.google.gson.annotations.SerializedName;

public class BasicAnswer {

    @SerializedName("response")
    private String myAnswer;

    public String getMyAnswer() {
        return myAnswer;
    }

    public void setMyAnswer(String myAnswer) {
        this.myAnswer = myAnswer;
    }
}
