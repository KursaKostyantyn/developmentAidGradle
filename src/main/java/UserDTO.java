

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    private int answer_count;
    private int question_count;
    private int reputation;
    private String location;
    private String link;
    private String profile_image;
    private String display_name;
    private List<CollectiveMemberships> collectives;

    public UserDTO() {
    }

    public UserDTO(int answer_count, int question_count, int reputation, String location, String link, String profile_image, String display_name, List<CollectiveMemberships> collectives) {
        this.answer_count = answer_count;
        this.question_count = question_count;
        this.reputation = reputation;
        this.location = location;
        this.link = link;
        this.profile_image = profile_image;
        this.display_name = display_name;
        this.collectives = collectives;
    }

    public int getAnswer_count() {
        return answer_count;
    }

    public void setAnswer_count(int answer_count) {
        this.answer_count = answer_count;
    }

    public int getQuestion_count() {
        return question_count;
    }

    public void setQuestion_count(int question_count) {
        this.question_count = question_count;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public List<CollectiveMemberships> getCollectives() {
        return collectives;
    }

    public void setCollectives(List<CollectiveMemberships> collectives) {
        this.collectives = collectives;
    }

    @Override
    public String toString() {
        return "User{" +
                "answer_count=" + answer_count +
                ", question_count=" + question_count +
                ", reputation=" + reputation +
                ", location='" + location + '\'' +
                ", link='" + link + '\'' +
                ", profile_image='" + profile_image + '\'' +
                ", display_name='" + display_name + '\'' +
                ", collectives=" + collectives +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO user = (UserDTO) o;
        return answer_count == user.answer_count && question_count == user.question_count && reputation == user.reputation && Objects.equals(location, user.location) && Objects.equals(link, user.link) && Objects.equals(profile_image, user.profile_image) && Objects.equals(display_name, user.display_name) && Objects.equals(collectives, user.collectives);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answer_count, question_count, reputation, location, link, profile_image, display_name, collectives);
    }
}
