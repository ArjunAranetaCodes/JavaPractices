public class Exception2 {
    public static void main(String[] args) {
        try {
            validateUsername("asda");
        } catch (InvalidUsernameException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void validateUsername(String username) throws InvalidUsernameException{
        if(username.length() < 6){
            throw new InvalidUsernameException("Username must be at least 6 characters long.");
        }
    }
}