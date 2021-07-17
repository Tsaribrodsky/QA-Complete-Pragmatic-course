public class ComputerDemo {

    public static void main(String[] args) {
        Computer laptop = new Computer();
        laptop.year = 2015;
        laptop.price = 750;
        laptop.hardDiskMemory = 500;
//        laptop.freeMemory = 230;
        laptop.operationSystem = "linux";
        laptop.isNotebook = true;

        Computer desktop = new Computer();
        desktop.year = 2009;
        desktop.price = 1300;
        desktop.hardDiskMemory = 250;
//        desktop.freeMemory = 70;
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
    }
}
