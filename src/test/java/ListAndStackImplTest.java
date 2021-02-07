import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class ListAndStackImplTest {

    private ListAndStackImpl listAndStackImp;

    @BeforeEach
    public void init() {
        listAndStackImp = new ListAndStackImpl();
    }

    @Test
    public void hasEmpty() {

        int actualSize = listAndStackImp.size();
        int expectedSize = 0;
        Assertions.assertEquals(actualSize, expectedSize);
    }

    @Test
    public void isIndexCorrect() {

        listAndStackImp.add(1);
        int actualIndex = listAndStackImp.getIndexByValue(1);
        int expectedIndex = 0;
        Assertions.assertEquals(actualIndex, expectedIndex);
    }

    @Test
    public void isIndexCorrectAfterDelete() {

        for (int i = 1; i <= 5; i++) {
            listAndStackImp.add(i);
        }
        listAndStackImp.removeValue(3);
        int actualIndex = listAndStackImp.getIndexByValue(4);
        int expectedIndex = 3;
        Assertions.assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void ArrayIndexOutOfBoundException() throws ArrayIndexOutOfBoundsException {

        boolean actualResult = false;
        try {
            listAndStackImp.getByIndex(15);
        } catch (ArrayIndexOutOfBoundsException e) {
            actualResult = true;
        }
        Assertions.assertTrue(actualResult);
    }

    @Test
    public void isReturnSubList() {

        for (int i = 5; i >= 0; i--) {
            listAndStackImp.add(i);
        }
        IntList list = listAndStackImp.subList(0, 2);
        int[] actualList = list.toArray();
        System.out.println(Arrays.toString(actualList));
        int[] expectedList = {5, 4, 0, 0, 0, 0, 0, 0, 0, 0};
        Assertions.assertTrue(Arrays.equals(expectedList, actualList));
    }

    @Test
    public void DeleteAtLastIndex() {

        for (int i = 5; i >= 0; i--) {
            listAndStackImp.add(i);
        }
        int actualResult = listAndStackImp.pop();
        int expectedResult = 0;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void AddInTheEnd() {

        for (int i = 5; i >= 0; i--) {
            listAndStackImp.add(i);
        }
        listAndStackImp.push(5);
        int expectedResult = 5;
        int actualResult = listAndStackImp.getByIndex(listAndStackImp.size() - 1);
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
