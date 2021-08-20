public class Main {
    public static void main(String[] args) {
        //Creator.showStudents();
        int taskNumber = GetInfo.getInt("Please, enter the number of the task from 1 to 4: ");
        switch (taskNumber){
            case 1:
                Tasks.task1();
                break;
            case 2:
                //
                break;
            default:
                System.out.println("Incorrect task number!");
        }

    }
}
