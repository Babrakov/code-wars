package test.java.kyu6.kata11;

import main.java.kyu6.kata11.PaginationHelper;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaginationHelperTest {

    @Test
    void testInteger() {
        PaginationHelper<Integer> helper = new PaginationHelper(Arrays.asList(1,2,3,4,5), 2);
        assertEquals(3, helper.pageCount());
    }

    @Test
    void testPageCount() {
        PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
        assertEquals(2, helper.pageCount());
    }

    @Test
    void testItemsCount() {
        PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
        assertEquals(6, helper.itemCount());
    }

    @Test
    void testNoPageItemCount() {
        PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
        assertEquals(-1, helper.pageItemCount(2));
    }

    @Test
    void testPageItemCount() {
        PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
        assertEquals(2, helper.pageItemCount(1));
    }

    @Test
    void testBiggerPageItemCount() {
        PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f','g','h'), 4);
        assertEquals(4, helper.pageItemCount(0));
    }

    @Test
    void testNoPageIndex() {
        PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
        assertEquals(-1, helper.pageIndex(20));
    }

    @Test
    void testPageIndex() {
        PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
        assertEquals(0, helper.pageIndex(2));
    }

}
