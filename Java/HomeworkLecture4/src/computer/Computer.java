package computer;

public class Computer {
    int year;
    double price;
    boolean isNotebook;
    double hardDiskMemory;
    double freeMemory;
    String operationSystem;
    String beer;
    String glass;
    String paperBox;
    String milk;
    String plasticBottle;
    String derbyCola;

    Computer() {
        this.isNotebook = false;
        this.operationSystem = "Win XP";
    }

    Computer(int year, double price, double hardDiskMemory, double freeMemory) {
        this();
        this.year = year;
        this.price = price;
        this.hardDiskMemory = hardDiskMemory;
        this.freeMemory = freeMemory;
    }

    Computer(int year, double price, boolean isNotebook, double hardDiskMemory, double freeMemory, String operationSystem) {
        this.year = year;
        this.price = price;
        this.isNotebook = isNotebook;
        this.hardDiskMemory = hardDiskMemory;
        this.freeMemory = freeMemory;
        this.operationSystem = operationSystem;
    }

    void changeOperationSystem(String newOperationSystem) {
        operationSystem = newOperationSystem;
    }

    void useMemory(double memmory) {  //My IntelliJ won't accept variable named memory
        if (memmory > freeMemory) {
            System.out.println("Not enough free memory!");
        } else {
            freeMemory -= memmory;
        }
    }

    void production(String material, String liquid) {
        if(material.equals(glass) && liquid.equals(beer)) {
            System.out.println("The beer is produced");
        }
        else if (material.equals(paperBox) && liquid.equals(milk)) {
            System.out.println("The milk is produced");
        }
        else if (material.equals(plasticBottle) && liquid.equals(derbyCola)) {
            System.out.println("The Derby Cola is produced");
        }
        else {
            System.out.println("Impossible combination!");
        }
    }

    int comparePrice(Computer c) {
        if (this.price > c.price) {
            return -1;
        } else if (this.price < c.price) {
            return 1;
        } else {
            return 0;
        }
    }
}
