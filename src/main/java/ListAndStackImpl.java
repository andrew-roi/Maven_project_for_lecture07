import java.util.Arrays;

public class ListAndStackImpl implements IntStack, IntList {
    private final int[] values = new int[10]; // default array with capacity 10 for Stack and List implementation
    int nextIndex = 0; // increments while add or remove element

    @Override
    public void add(int i) {
        values[nextIndex] = i;
        nextIndex++;
    }

    @Override
    public void insert(int index, int value) {
        nextIndex = index;
        values[nextIndex] = value;
    }

    @Override
    public void set(int index, int value) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        try {
            nextIndex = index;
            values[nextIndex] = value;
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            System.out.println("Not such index in the array");
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("Something is wrong");
        }
    }

    @Override
    public int size() {
        return nextIndex;
    }

    @Override
    public int capacity() {
        return values.length;
    }

    @Override
    public int getByIndex(int index) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        try {
            if (index<=10){
            return values[index];
            }
        } catch (ArrayIndexOutOfBoundsException boundsException) {
            System.out.print("No such index in array: ");
            return -1;
        } catch (IllegalArgumentException illegalException) {
            System.out.println("Not a number: ");
            return -1;
        }
        return  values[index];
    }

    @Override
    public Integer getIndexByValue(int value) {
        for (int i = 0; i < values.length; i++) {
            if (value == values[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(int value) {
        for (int j : values) {
            if (j == value) {
                return true;
            }

        }
        return false;
    }

    @Override
    public void removeValue(int value) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] == value) {

                int[] newArray = new int[values.length - 1];
                int[] newArray2 = new int[values.length - 1];
                int[] newArray3 = new int[values.length - 1];


                System.arraycopy(values, 0, newArray, 0, i);
                System.arraycopy(values, ++i, newArray2, i, i);
                System.arraycopy(newArray, 0, newArray3, 0, i);
                System.arraycopy(newArray2, i, newArray3, i, i);


                System.out.println(Arrays.toString(newArray3));
                break;
            }
        }
    }

    @Override
    public void removeByIndex(int index) {
        for (int i = 0; i < values.length; i++) {
            if (i == index) {

                int[] newArray = new int[values.length - 1];
                int[] newArray2 = new int[values.length - 1];
                int[] newArray3 = new int[values.length - 1];


                System.arraycopy(values, 0, newArray, 0, i);
                System.arraycopy(values, ++i, newArray2, i, i);
                System.arraycopy(newArray, 0, newArray3, 0, i);
                System.arraycopy(newArray2, i, newArray3, i, i);

                System.out.println(Arrays.toString(newArray3));
                break;
            }

        }
    }

    @Override
    public IntList subList(int fromIndex, int toIndex) {
        IntList intList = new ListAndStackImpl();
        for (int i = fromIndex; i < toIndex; i++) {
            intList.add(values[i]);
        }
        return intList;
    }

    @Override
    public int[] toArray() {
        int[] arr = new int[10];
        System.arraycopy(values, 0, arr, 0, values.length);
        return arr;
    }

    @Override
    public boolean isEmpty() {
        return nextIndex == 0;
    }


    @Override
    public void push(int value) {
        add(value);
    }

    @Override
    public int pop() throws ArrayIndexOutOfBoundsException {
        try {
            nextIndex--;
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        }
        return values[nextIndex];
    }

    @Override
    public int peek() {
        return values[nextIndex];
    }

}
