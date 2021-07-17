/**
 * <h1>AdminUserImpl</h1>
 * This class extends AbstractUser class and implements AdminUser interface.
 */

import javax.jws.soap.SOAPBinding;

public class AdminUserImpl extends AbstractUser implements AdminUser {

    private DataBase users = new DataBase(5);

    /**
     * This constructor created a admin user or ordinary user whit specified name. Which call constructor for admin user from AbstractUser class.
     * And get registration date of the user. Every admin user have database for users.
     * @param username name of the user.
     */
    public AdminUserImpl(String username) {
        super(username, true);
        registrationDateGet();
    }

    @Override
    public void deleteUser(String username) {
        User[] usersFromDB = users.getUsers();

        for (int i = 0; i < usersFromDB.length; i++) {
            if (usersFromDB[i] != null) {
                if (usersFromDB[i].usernameGet().equals(username)) {
                    usersFromDB[i] = null;
                    return;
                }
            }
        }
        System.out.println("DataBase is empty!");
    }

    @Override
    public User createUser(String username, boolean isAdmin) {
        User[] usersFromDB = users.getUsers();

        if (isAdmin) {
            AdminUser adminUser = null;

            if (isNameTaken(username)) {
                System.out.println(username + " this username is already taken");
                return null;
            }

            for (int i = 0; i < usersFromDB.length; i++) {
                if (usersFromDB[i] == null) {
                    adminUser = new AdminUserImpl(username);
                    usersFromDB[i] = adminUser;
                    return adminUser;
                }
            }

            System.out.println("DataBase is full! No more space for " + username);
            return adminUser;
        } else {
            User normalUser = null;

            if (isNameTaken(username)) {
                System.out.println(username + " this username is already taken");
                return null;
            }

            for (int i = 0; i < usersFromDB.length; i++) {
                if (usersFromDB[i] == null) {
                    normalUser = new UserImpl(username);
                    usersFromDB[i] = normalUser;
                    return normalUser;
                }
            }

            System.out.println("DataBase is full! No more space for " + username);
            return normalUser;
        }
    }

    @Override
    public void printUserInfo() {
        User[] usersFromDB = users.getUsers();

        for (int i = 0; i < usersFromDB.length; i++) {
            if (usersFromDB[i] != null){
                if (usersFromDB[i] instanceof UserImpl) {
                    System.out.println(usersFromDB[i].usernameGet() + " registration date: " + ((UserImpl) usersFromDB[i]).registrationDateGet() +
                    " is user log in " + stateLogIn());
                    continue;
                }
                if (usersFromDB[i] instanceof AdminUserImpl) {
                    System.out.println(usersFromDB[i].usernameGet() + " registration date: " + ((AdminUserImpl) usersFromDB[i]).registrationDateGet() +
                    " is user log in " + stateLogIn());
                }
            }
        }
    }

    private boolean isNameTaken(String username) {
        User[] usersFromDB = users.getUsers();

        for (int i = 0; i < usersFromDB.length; i++) {
            if (usersFromDB[i] != null && usersFromDB[i].usernameGet().equals(username)) {
                return true;
            }
        }
        return false;
    }

}
