
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class Controller implements Callback<ResponseDTO> {

    static final String BASE_URL = "https://api.stackexchange.com/2.3/";

    private List<String> locations = new ArrayList<>();
    private List<String> tags = new ArrayList<>();
    private UserService userService = new UserService();
    private Map<String, String> options;
    List<User> resultList = new ArrayList<>();
    private int answerCount;

    public Controller() {
    }

    public Controller(List<String> locations, List<String> tags, Map<String, String> options, int answerCount) {
        this.locations = locations;
        this.tags = tags;
        this.options = options;
        this.answerCount = answerCount;
    }

    public void start() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        StackExchange stackExchange = retrofit.create(StackExchange.class);
        Call<ResponseDTO> call = stackExchange.getUserResponse(options);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<ResponseDTO> call, Response<ResponseDTO> response) {
        if (response.isSuccessful()) {
            HttpUrl url = call.request().url();
            System.out.println(url);
            ResponseDTO responseDTO = response.body();

            assert responseDTO != null;
            List<UserDTO> users = responseDTO.getItems();
            userService.filterUsersByAnswerCount(users, answerCount);

            users = userService.filterUsersByLocation(users, locations);

            users = userService.filterUsersByTags(users, tags);
            users.forEach(userDTO -> resultList.add(userService.convertUserDTOToUser(userDTO)));
            boolean hasMore = responseDTO.isHas_more();
            int page = Integer.parseInt(options.get("page"));
            if (hasMore) {
                page += 1;
                options.put("page", Integer.toString(page));
                System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
                start();
            } else {
                System.out.println("finished");
                if (resultList.size() == 0) {
                    System.out.println("Not found");
                } else {
                    resultList.forEach(System.out::println);
                }

            }

        } else {
            ObjectMapper objectMapper = new ObjectMapper();
            ResponseBody responseBody = (ResponseBody) response.errorBody();

            String str = null;
            try {
                str = responseBody.string();
                APIError apiError = objectMapper.readValue(str, APIError.class);
                System.out.println(apiError);
            } catch (JsonProcessingException jsonProcessingException) {
                jsonProcessingException.printStackTrace();
            } catch (IOException e) {
                if (resultList.size() == 0) {
                    System.out.println("Not Found");
                }
                resultList.forEach(System.out::println);
                throw new RuntimeException(e);
            }
            if (resultList.size() == 0) {
                System.out.println("Not Found");
            }
            resultList.forEach(System.out::println);
        }
    }

    @Override
    public void onFailure(Call<ResponseDTO> call, Throwable throwable) {
        throwable.printStackTrace();
        if (resultList.size() == 0) {
            System.out.println("Not Found");
        }
        resultList.forEach(System.out::println);
    }
}
