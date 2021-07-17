/**
 * <h1>DataBase</h1>
 * This class contain user database.
 */

public class DataBase {

    User[] users;

    /**
     * Constructor which create database. Array of User.
     * @param n number of elements.
     */
    public DataBase(int n){
        this.users = new User[n];
    }

    /**
     * Method which get all users in array.
     * @return users
     */
    public User[] getUsers() {
        return users;
    }
}
