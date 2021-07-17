/**
 * <h1>AbstractUser</h1>
 * AbstractUser is abstract class which implements User interface. And has two constructors for ordinary user and
 * admin user.
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AbstractUser implements User {

    private String username;
    private String registrationDate;
    private boolean stateLogIn;
    private boolean isAdmin;

    public AbstractUser(String username) {
        this.username = username;
        this.isAdmin = false;
    }

    public AbstractUser(String username, boolean isAdmin) {
        this.username = username;
        this.isAdmin = isAdmin;
    }

    @Override
    public void login() {
        this.stateLogIn = true;
        System.out.println(usernameGet() + " is log in.");
    }

    @Override
    public void logout() {
        this.stateLogIn = false;
        System.out.println(usernameGet() + " is log out.");
    }

    @Override
    public String usernameGet() {
        return username;
    }

    @Override
    public String registrationDateGet() {
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        registrationDate = sdf.format(date);
        return registrationDate;
    }

    /**
     * Method which get user is admin or not
     * @return isAdmin
     */
    boolean isAdmin() {
        return isAdmin;
    }

    /**
     * Method which get state of user, log in or log out
     * @return stateLogIn
     */
    boolean stateLogIn() {
        return stateLogIn;
    }

}
