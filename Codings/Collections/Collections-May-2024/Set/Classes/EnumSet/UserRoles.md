## Problem: 
Implementing a User Roles Enumerator

## Description: 
Create a program that demonstrates the use of EnumSet to represent a set of user roles.

## Input:

Administrator

Moderator

User

## Output:
[ADMINISTRATOR, MODERATOR]

## Code Answer:
```Java
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

```

File Name: UserRoles.java

This program demonstrates the use of EnumSet to represent a set of user roles. The UserRoles class defines an enum Role representing the user roles. The main method creates an EnumSet containing two roles (Administrator and Moderator) and prints the set.
Note: EnumSet is a specialized Set implementation for enums. It is more efficient and provides additional methods for working with enums.
In this example, we can easily add or remove roles from the set, and check if a user has a specific role. For example:

```Java
EnumSet<Role> roles = EnumSet.of(Role.ADMINISTRATOR, Role.MODERATOR);
roles.add(Role.USER); // add the USER role
roles.remove(Role.MODERATOR); // remove the MODERATOR role
if (roles.contains(Role.ADMINISTRATOR)) { // check if the user has the ADMINISTRATOR role
System.out.println("User is an administrator");
}
```