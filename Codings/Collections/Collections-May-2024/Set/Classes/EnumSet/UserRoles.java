import java.util.*;

public class UserRoles {
    public enum Role {
        ADMINISTRATOR, MODERATOR, USER
    }

    public static void main(String[] args) {
        EnumSet<Role> roles = EnumSet.of(Role.ADMINISTRATOR, Role.MODERATOR);
        System.out.println(roles);
    }
}