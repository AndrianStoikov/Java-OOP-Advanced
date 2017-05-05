package tests;

import main.Interfaces.SimpleOrderedBag;
import main.dataStructures.SimpleSortedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimpleOrderedBagTests {

    private SimpleOrderedBag<String> names;

    @Before
    public void setUp() {
        this.names = new SimpleSortedList<String>(String.class);
    }

    @Test
    public void testEmptyCtor() {
        this.names = new SimpleSortedList<String>(String.class);
        Assert.assertEquals(16, this.names.capacity());
        Assert.assertEquals(0, this.names.size());
    }

    @Test
    public void testCtorWithInitialCapacity() {
        this.names = new SimpleSortedList<String>(String.class, 20);
        Assert.assertEquals(20, this.names.capacity());
        Assert.assertEquals(0, this.names.size());
    }


    @Test
    public void testCtorWithInitalComparer() {
        this.names = new SimpleSortedList<String>(String.class, String.CASE_INSENSITIVE_ORDER);
        Assert.assertEquals(16, this.names.capacity());
        Assert.assertEquals(0, this.names.size());
    }

    @Test
    public void testCtorWithAllParms() {
        this.names = new SimpleSortedList<String>(String.class, String.CASE_INSENSITIVE_ORDER, 30);
        Assert.assertEquals(30, this.names.capacity());
        Assert.assertEquals(0, this.names.size());
    }

    @Test
    public void testAddIncreaseSize() {
        this.names.add("Asen");
        Assert.assertEquals(1, this.names.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullFunctionality() {
        this.names.add(null);
    }

    @Test
    public void testAddUnsortedDataIsHeldSorted() {
        this.names.add("Rosen");
        this.names.add("Georgi");
        this.names.add("Balkan");
        String[] result = this.names.joinWith(" ").split(" ");
        String[] expectedResult = new String[]{"Balkan", "Georgi", "Rosen"};
        Assert.assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testAddingAllFromCollectionIncreasesSize() {
        List<String> list = new ArrayList<>();
        list.add("Gosheto");
        list.add("Shepo");
        this.names.addAll(list);
        Assert.assertEquals(2, this.names.size());
    }

    @Test
    public void testAddingMoreThanInitialCapacity() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "Balkan", "Georgi", "Rosen", "Balkan1", "Georgi1", "Rosen1", "Balkan",
                "Georgi", "Rosen", "Balkan1", "Georgi1", "Rosen1", "Balkan", "Georgi", "Rosen", "Balkan1", "Georgi1");
        this.names.addAll(list);
        Assert.assertEquals(17, this.names.size());
        Assert.assertNotEquals(16, this.names.capacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddingAllFromNullThrowsException() {
        List<String> list = new ArrayList<>();
        list.add("Gosheto");
        list.add("Shepo");
        list.add(null);
        this.names.addAll(list);
    }

    @Test
    public void testAddAllKeepsSorted() {
        List<String> list = new ArrayList<>();
        list.add("Rosen");
        list.add("Georgi");
        list.add("Balkan");
        this.names.addAll(list);
        String[] result = this.names.joinWith(" ").split(" ");
        String[] expectedResult = new String[]{"Balkan", "Georgi", "Rosen"};
        Assert.assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testRemoveValidElementDecreasesSize() {
        String element = "Gosho";
        this.names.add(element);
        this.names.remove(element);
        Assert.assertEquals(0, this.names.size());
    }

    @Test
    public void testRemoveValidElementRemovesSelectedOne() {
        this.names.add("Ivan");
        this.names.add("Nasko");
        this.names.remove("Ivan");
        String result = this.names.joinWith("");
        Assert.assertEquals("Nasko", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemovingNullThrowsException() {
        this.names.remove(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testJoinWithNull() {
        this.names.add("Nasko");
        this.names.add("Ivan");
        String result = this.names.joinWith(null);
    }

    @Test()
    public void testJoinWorksFine () {
        this.names.add("Nasko");
        this.names.add("Ivan");
        String result = this.names.joinWith(", ");
        Assert.assertEquals("Ivan, Nasko", result);
    }
}
