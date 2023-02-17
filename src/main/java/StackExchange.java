
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;


import java.util.List;
import java.util.Map;

public interface StackExchange {
    @GET("users")
    public Call<ResponseDTO> getUserResponse(@QueryMap Map<String,String> options);

}
