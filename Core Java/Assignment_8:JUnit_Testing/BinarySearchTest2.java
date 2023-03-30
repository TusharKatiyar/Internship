import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTest2 {

    private int[] arr;
    private int key;

    @Before
    public void setUp() {
        arr = new int[]{2,4,6,8,9,10,12,14,16,18,20};
        key=10;
    }

    @Test
    public void testBinarySearch() {
        int index = Main.binarySearch(arr, key);
        Assert.assertEquals(5, index);
    }

    @Test
    public void testBinarySearchNegative() {
        int index = Main.binarySearch(arr, 22);
        Assert.assertEquals(-1, index);
    }

    @Test
    public void testBinarySearchFail() {
        int index = Main.binarySearch(arr, key);
        Assert.assertEquals(7, index);
    }
}
