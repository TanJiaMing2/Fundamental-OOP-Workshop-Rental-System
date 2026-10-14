import java.util.Scanner;

public class equipments {
    private String[] equipmentList;
    private int currentIndex;
    private Scanner scanner;

    public equipments() {
        equipmentList = new String[1];
        currentIndex = 0;
        scanner = new Scanner(System.in);
    }

    public void equipmentlist() {
        boolean continueAdding = true;

        while (continueAdding) {
            System.out.print("Enter the equipment and write 'finish' when there are no more equipment: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("finish")) {
                continueAdding = false;
            } else {
                if (currentIndex < equipmentList.length) {
                    equipmentList[currentIndex] = input;
                    currentIndex++;
                } else {
                    resizeArray();
                    equipmentList[currentIndex] = input;
                    currentIndex++;
                }
            }
        }
    }

    private void resizeArray() {
        int newCapacity = equipmentList.length + 1;
        String[] resizedArray = new String[newCapacity];
        System.arraycopy(equipmentList, 0, resizedArray, 0, equipmentList.length);
        equipmentList = resizedArray;
    }

    public String[] getEquipmentList() {
        return equipmentList;
    }
}
