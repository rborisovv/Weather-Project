package bg.softuni.weatherproject.session;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserSession {
    private boolean isLoggedIn;

    private String username;

    String fullName;

    private String email;
}