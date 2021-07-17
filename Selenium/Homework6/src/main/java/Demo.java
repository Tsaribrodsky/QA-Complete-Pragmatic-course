public class Demo {

    public static void main(String[] args) {

        AdminUser supermanAdmin = new AdminUserImpl("superman");

        supermanAdmin.createUser("dani", true);
        supermanAdmin.createUser("ani", false);
        supermanAdmin.createUser("monica", false);
        supermanAdmin.createUser("dani", false);
        supermanAdmin.createUser("niki", false);
//        supermanAdmin.createUser("asia", false);
//        supermanAdmin.createUser("zori", false);

        User superCat = supermanAdmin.createUser("cat", true);
        superCat.login();
        ((AdminUser) superCat).createUser("vladi", false);
        ((AdminUser) superCat).printUserInfo();

        supermanAdmin.printUserInfo();
        supermanAdmin.createUser("dani", false);
        supermanAdmin.login();
        supermanAdmin.logout();
        supermanAdmin.deleteUser("dani");

        supermanAdmin.printUserInfo();
    }
}
