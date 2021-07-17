/**
 * <h1>UserImpl</h1>
 * This class is User and extends AbstractUser.
 */

public class UserImpl extends AbstractUser {

    /**
     * This constructor created a ordinary user whit specified name. Which call constructor for ordinary user from AbstractUser class.
     * And get registration date of the user.
     * @param username name of the user.
     */
    public UserImpl(String username) {
        super(username);
        registrationDateGet();
    }
}
