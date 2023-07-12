package net.endeffect.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.endeffect.enums.Gender;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {

    private String firstName;
    private String lastName;
    private String userName;
    private String passWord;
    private boolean enabled;
    private String phone;
    private RoleDTO role;
    private Gender gender;

}
