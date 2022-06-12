package bg.softuni.weatherproject.bindingModel;

import lombok.*;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserLoginDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}