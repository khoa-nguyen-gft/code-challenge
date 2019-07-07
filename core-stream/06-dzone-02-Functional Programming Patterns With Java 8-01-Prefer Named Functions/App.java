import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class AppBefore {
    public static void main(String[] arg) {
    }

    public List<UserDto> getAllUserV3() {
        List<User> users = new ArrayList<User>();
        return users.stream().map(this::toDto).collect(Collectors.toList());
    }

    private UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.setFullName(user.getFirstName() + " " + user.getLastName().toUpperCase());
        dto.setActive(user.getDeactionDate() == null);
        return dto;
    }

    public List<UserDto> getAllUserV02() {
        List<User> users = new ArrayList<User>();
        return users.stream().map(user -> {
            UserDto dto = new UserDto();
            dto.setFullName(user.getFirstName() + " " + user.getLastName().toUpperCase());
            dto.setActive(user.getDeactionDate() == null);
            return dto;
        }).collect(Collectors.toList());
    }

    public List<UserDto> getAllUsers() {
        List<User> users = new ArrayList<User>();
        List<UserDto> dtos = new ArrayList<>();
        for (User user : users) {
            UserDto dto = new UserDto();
            dto.setUserName(user.getUserName());
            dto.setFullName(user.getFirstName() + " " + user.getLastName().toUpperCase());
            dto.setActive(user.getDeactionDate() == null);
            dtos.add(dto);
        }
        return dtos;
    }
}

class UserDto {
    private String userName;
    private String fullName;
    private Boolean Active;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Boolean getActive() {
        return Active;
    }

    public void setActive(Boolean active) {
        Active = active;
    }

}

class User {
    private String userName;
    private String firstName;
    private String lastName;
    private Date deactionDate;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDeactionDate() {
        return deactionDate;
    }

    public void setDeactionDate(Date deactionDate) {
        this.deactionDate = deactionDate;
    }

}