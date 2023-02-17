

import java.util.ArrayList;
import java.util.List;

public class UserService {
    public List<UserDTO> filterUsersByTags(List<UserDTO> users, List<String> tags) {
        List<UserDTO> filteredUsers = new ArrayList<>();

        for (UserDTO User : users) {
            if (User.getCollectives() != null) {
                boolean match = tags.stream().anyMatch(tag -> {
                    return User.getCollectives().get(0).getCollective().getTags().stream().anyMatch(item -> item.contains(tag));
                });
                if (match) {
                    filteredUsers.add(User);
                }
            }
        }
        return filteredUsers;
    }

    public List<UserDTO> filterUsersByLocation(List<UserDTO> users, List<String> locations) {
        List<UserDTO> filteredUsers = new ArrayList<>();
        for (UserDTO User : users) {
            if (User.getLocation() != null) {
                boolean match = locations.stream().anyMatch(location -> User.getLocation().toLowerCase().contains(location.toLowerCase()));
                if (match) {
                    filteredUsers.add(User);
                }
            }
        }

        return filteredUsers;
    }

    public void filterUsersByAnswerCount(List<UserDTO> users, int answerCount) {
        users.removeIf(User -> User.getQuestion_count() < 1);
    }
    public User convertUserDTOToUser (UserDTO userDTO){
        return new User(userDTO.getAnswer_count(), userDTO.getQuestion_count(), userDTO.getReputation(), userDTO.getLocation(), userDTO.getLink(), userDTO.getProfile_image(), userDTO.getDisplay_name(), userDTO.getCollectives());

    }
}
