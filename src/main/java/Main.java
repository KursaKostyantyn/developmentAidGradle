import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<String> locations = new ArrayList<>();
        locations.add("Moldova");
        locations.add("Romania");


        List<String> tags = new ArrayList<>();
        tags.add("java");
        tags.add("docker");
        tags.add("c#");
        tags.add(".net");

        int page = 2700;
        int pageSize = 100;
        String key = "n6rG9EFfSd8jxLHWzfZwtQ((";
        String filter = "!56B6mzzRU_TPpXtJ*V.WOVRiGHlNkti85siKJ3";
        String sort = "reputation";
        int min = 223;
        String order = "desc";
        String site = "stackoverflow";

        Map<String, String> options = new HashMap<>();
        options.put("page", Integer.toString(page));
        options.put("pagesize", Integer.toString(pageSize));
        options.put("key", key);
        options.put("filter", filter);
        options.put("sort", sort);
        options.put("min", Integer.toString(min));
        options.put("order", order);
        options.put("site", site);

        int answerCount = 1;
        Controller controller = new Controller(locations, tags, options, answerCount);

        List<UserDTO> resultList = new ArrayList<>();
        controller.start();

    }
}
