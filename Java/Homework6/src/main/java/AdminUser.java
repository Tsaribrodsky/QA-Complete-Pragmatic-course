/**
 * <h1>AdminUser</h1>
 * This interface has the following methods void deleteUser(String username), User createUser(String username, boolean isAdmin),
 * void printUserInfo(). Which are used to delete user, create user and show user information.
 * @see #deleteUser(String)
 * @see #createUser(String, boolean)
 * @see #printUserInfo()
 * @author Dani Tsaribrodski
 * @since 03.06.2018
 */

public interface AdminUser extends User {

    /**
     * Method which delete user from DataBase.
     * @param username the user which you want delete from DataBase.
     */
    void deleteUser(String username);

    /**
     * Method which create user in DataBase.
     * @param username the user which you want create in DataBase.
     * @param isAdmin accept true for admin user and false for ordinary user.
     * @return created user.
     */
    User createUser(String username, boolean isAdmin);

    /**
     * Method which show information for all users.
     */
    void printUserInfo();
}
