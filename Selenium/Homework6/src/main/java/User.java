/**
 *<h1>User</h1>
 * This interface has the following methods void login(), void logout(), String usernameGet(), String registrationDateGet().
 * Which are used to show if the user is log in, log out, his name and registration date.
 * @see #login()
 * @see #logout()
 * @see #usernameGet()
 * @see #registrationDateGet()
 * @author Dani Tsaribrodski
 * @since 03.06.2018
 */
public interface User {

    /**
     * Method which change user state in "Log in".
     */
    void login();

    /**
     * Method which change user state in "Log out".
     */
    void logout();

    /**
     * Method which get user name.
     * @return usernameGet Name of the user.
     */
    String usernameGet();

    /**
     * Method which return user registration date.
     * @return registrationDateGet the date of user registration.
     */
    String registrationDateGet();

}
