import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTest1 {

    private int[] arr;
    private int key;
    

    @Before
    public void setUp() {
        arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        key = 5;
    }

    @Test
    public void testBinarySearch() {
        int index = Main.binarySearch(arr, key);
        Assert.assertEquals(4, index);
    }

    @Test
    public void testBinarySearchNegative() {
        int index = Main.binarySearch(arr, 11);
        Assert.assertEquals(-1, index);
    }

    @Test
    public void testBinarySearchFail() {
        int index = Main.binarySearch(arr, key);
        Assert.assertEquals(5, index);
    }
}
