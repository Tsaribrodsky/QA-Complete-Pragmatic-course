public class Computer {
    int year;
    double price;
    boolean isNotebook;
    double hardDiskMemory;
    double freeMemory;
    String operationSystem;

    void changeOperationSystem(String newOperationSystem) {
        operationSystem = newOperationSystem;
    }

    void useMemory(double memmory) {  //My IntelliJ won't accept variable named memory
        freeMemory = hardDiskMemory - memmory;
        if (memmory > freeMemory) {
            System.out.println("Not enough free memory!");
        }
    }
}
