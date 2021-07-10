package com.example.infs3605;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ArtService {
    @GET("object?collection=\"Aboriginal%20and%20Torres%20Strait%20Islander%20Affairs%20Art%20(ATSIAA)%20collection%20no.%201\"&text=painting&offset=100")
    Call<Art> getArt();
}
