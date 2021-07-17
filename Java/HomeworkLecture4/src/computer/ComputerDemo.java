package computer;

public class ComputerDemo {

    public static void main(String[] args) {
        Computer laptop = new Computer();
        laptop.year = 2015;
        laptop.price = 750;
        laptop.hardDiskMemory = 500;
        laptop.freeMemory = 200;
        laptop.operationSystem = "linux";
        laptop.isNotebook = true;

        Computer desktop = new Computer();
        desktop.year = 2009;
        desktop.price = 1300;
        desktop.hardDiskMemory = 250;
        desktop.freeMemory = 70;
        desktop.operationSystem = "windows";
        desktop.isNotebook = false;

        desktop.changeOperationSystem("linux");
        laptop.useMemory(100);

        System.out.println("desktop:" + desktop.operationSystem + " OS");
        System.out.println("desktop:" + desktop.year + "y");
        System.out.println("desktop:" + desktop.price + "lv");
        System.out.println("desktop:" + desktop.hardDiskMemory + "GB hard disk memory");
        System.out.println("desktop:" + desktop.freeMemory + "GB free memory");
        System.out.println("desktop" + " is notebook: " + desktop.isNotebook);
        System.out.println("laptop:" + laptop.freeMemory + "GB free memory");
        System.out.println("laptop:" + laptop.operationSystem + " OS");
        System.out.println("laptop:" + laptop.year + "y");
        System.out.println("laptop:" + laptop.price + "lv");
        System.out.println("laptop:" + laptop.hardDiskMemory + "GB hard disk memory");
        System.out.println("laptop" + " is notebook: " + laptop.isNotebook);


        Computer desktopHP = new Computer();
        desktopHP.price = 600;
        Computer desktopHP150 = new Computer();
        desktopHP150.price = 600;
        Computer desktopDELL = new Computer(2017, 2300, 900, 200);
        Computer desktopLenovo = new Computer(2012, 3400, false, 700, 100,"LinuxMint");
        desktopDELL.comparePrice(desktopLenovo);
        desktopLenovo.comparePrice(desktopHP);
        desktopHP.comparePrice(desktopHP150);
        desktopHP.glass = "glass";
        desktopHP.paperBox = "paperBox";
        desktopHP.plasticBottle = "plasticBottle";
        desktopHP.beer = "beer";
        desktopHP.milk = "milk";
        desktopHP.derbyCola = "derbyCola";
        desktopHP.production("glass","beer");
        desktopHP.production("shtaiga", "voda");

        if (desktopDELL.comparePrice(desktopLenovo) == 1) {
            System.out.println("desktopDELL is cheaper than desktopLenovo");
        } else if (desktopDELL.comparePrice(desktopLenovo) == -1) {
            System.out.println("desktopDELL is more expensive than desktopLenovo");
        } else if (desktopDELL.comparePrice(desktopLenovo) == 0) {
            System.out.println("desktopDELL price is equal with desktopLenovo");
        }

        if (desktopLenovo.comparePrice(desktopHP) == 1) {
            System.out.println("desktopLenovo is cheaper than desktopHP");
        } else if (desktopLenovo.comparePrice(desktopHP) == -1) {
            System.out.println("desktopLenovo is more expensive than desktopHP");
        } else if (desktopLenovo.comparePrice(desktopHP) == 0) {
            System.out.println("desktopLenovo price is equal with desktopHP");
        }

        if (desktopHP.comparePrice(desktopHP150) == 1) {
            System.out.println("desktopHP is cheaper than desktopHP150");
        } else if (desktopHP.comparePrice(desktopHP150) == -1) {
            System.out.println("desktopHP is more expensive than desktopHP150");
        } else if (desktopHP.comparePrice(desktopHP150) == 0) {
            System.out.println("desktopHP price is equal with desktopHP150");
        }
    }
}
