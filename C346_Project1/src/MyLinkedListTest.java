import org.junit.Assert;

public class MyLinkedListTest {

    @org.junit.Test
    public void nextWithNullNext()
    {
        MyLinkedList<Integer> list = new MyLinkedList<>(5);
        Assert.assertEquals(null, list.next());
    }

    @org.junit.Test
    public void nextWithTrueNext()
    {
        MyLinkedList<Integer> list = new MyLinkedList<>(5);
        list.setNext(new MyLinkedList<Integer>(4));
        Integer temp = list.next().get();
        Assert.assertTrue(4 == temp);
    }

    @org.junit.Test
    public void lastWithOneEntry()
    {
        MyLinkedList<Integer> list = new MyLinkedList<>(5);
        Assert.assertTrue(list.last().get() == 5);
    }

    @org.junit.Test
    public void lastWithManyEntries()
    {
        MyLinkedList<Integer> list = new MyLinkedList<>(5);
        list.append(new MyLinkedList<Integer>(4));
        list.append(new MyLinkedList<Integer>(3));
        Assert.assertTrue(list.last().get() == 3);
    }

    @org.junit.Test
    public void afterWithinLegitRange0()
    {
        MyLinkedList<Integer> list = new MyLinkedList<>(5);
        list.append(new MyLinkedList<Integer>(4));
        list.append(new MyLinkedList<Integer>(3));
        list.append(new MyLinkedList<Integer>(2));
        list.append(new MyLinkedList<Integer>(1));

        Assert.assertTrue(list.after(0).get() == 5);

    }

    @org.junit.Test
    public void afterWithinLegitRange2()
    {
        MyLinkedList<Integer> list = new MyLinkedList<>(5);
        list.append(new MyLinkedList<Integer>(4));
        list.append(new MyLinkedList<Integer>(3));
        list.append(new MyLinkedList<Integer>(2));

        Assert.assertTrue(list.after(2).get() == 3);
    }


    @org.junit.Test
    public void detachWithNullNext()
    {
        MyLinkedList<Integer> list = new MyLinkedList<>(5);
        MyLinkedList<Integer> temp = list.detach();
        Assert.assertTrue(temp == null);
        Assert.assertTrue(list.next() == null);
    }

    @org.junit.Test
    public void detachWithTrueNext()
    {
        MyLinkedList<Integer> list = new MyLinkedList<>(5);
        list.append(new MyLinkedList<Integer>(4));
        MyLinkedList<Integer> temp = list.detach();
        Assert.assertTrue(temp.get() == 4);
        Assert.assertTrue(list.next() == null);
    }

    @org.junit.Test
    public void getWithNullValue()
    {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        Assert.assertTrue(list.get() == null);
    }

    @org.junit.Test
    public void getWithTrueValue()
    {
        MyLinkedList<Integer> list = new MyLinkedList<>(5);
        Assert.assertTrue(list.get() == 5);
    }

    @org.junit.Test
    public void setFromNull()
    {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.set(5);
        Assert.assertTrue(list.get() == 5);
    }

    @org.junit.Test
    public void setFromExisting()
    {
        MyLinkedList<Integer> list = new MyLinkedList<>(5);
        list.set(4);
        Assert.assertTrue(list.get() == 4);
    }

    @org.junit.Test
    public void setNextFromNullNext()
    {
        MyLinkedList<Integer> list = new MyLinkedList<>(5);
        list.setNext(new MyLinkedList<>(4));
        Assert.assertTrue(list.next().get() == 4);
    }

    @org.junit.Test
    public void setNextFromExistingNext()
    {
        MyLinkedList<Integer> list = new MyLinkedList<>(5);
        list.setNext(new MyLinkedList<>(4));
        list.setNext(new MyLinkedList<>(3));
        Assert.assertTrue(list.next().get() == 3);
    }

    @org.junit.Test
    public void appendWithNullNext()
    {
        MyLinkedList<Integer> list = new MyLinkedList<>(4);
        list.append(new MyLinkedList<Integer>(5));
        Assert.assertTrue(list.last().get() == 5);
    }

    @org.junit.Test
    public void appendWithExistingNext()
    {
        MyLinkedList<Integer> list = new MyLinkedList<>(4);
        list.setNext(new MyLinkedList<Integer>(5));
        list.append(new MyLinkedList<Integer>(3));
        Assert.assertTrue(list.last().get() == 3);
    }

    @org.junit.Test
    public void insertWithNullNext()
    {
        MyLinkedList<Integer> list = new MyLinkedList<>(5);
        list.insert(new MyLinkedList<>(4));
        Assert.assertTrue(list.get() == 4);
        Assert.assertTrue(list.next().get() == 5);
    }

    @org.junit.Test
    public void insertWithExistingNext()
    {
        MyLinkedList<Integer> list = new MyLinkedList<>(5);
        list.setNext(new MyLinkedList<>(3));
        list.insert(new MyLinkedList<>(4));
        Assert.assertTrue(list.get() == 4);
        Assert.assertTrue(list.next().get() == 5);
        Assert.assertTrue(list.last().get() == 3);
    }


}