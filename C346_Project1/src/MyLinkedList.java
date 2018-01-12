/*
@author Ben Heil
@since 1/12/2018
*** This class is an implementation of the ILinkedList interface given in C346 ***
*/
public class MyLinkedList<T> implements ILinkedList<T>
{
    private MyLinkedList<T> next;
    private T value;

    public MyLinkedList() {}

    public MyLinkedList(T value)
    {
        this.value = value;
    }

    @Override
    /*
    @return ILinkedList<T> - the next element in the list
    @requires - #next != null
    @ensures - a reference to the next element in the list is returned
     */
    public MyLinkedList<T> next()
    {
        return next;
    }

    @Override
    /*
    @return ILinkedList<T> - the last element in the list
    @ensures - a reference to the last element in the list will be returned
     */
    public MyLinkedList<T> last()
    {
        MyLinkedList<T> temp = this;
        while(temp.next != null)
            temp = temp.next;
        return temp;
    }

    @Override
    /*
    @param n : int - the index of the desired element
    @return ILinkedList - the nth element down the list
    @requires - 0 <= n < |list|
    @ensures - the nth element of the list will be returned
     */
    public MyLinkedList<T> after(int n)
    {
        MyLinkedList<T> temp = this;
        for(int i = 0; i < n; i++)
        {
            temp = temp.next;
        }
        return temp;
    }

    @Override
    /*
    @return ILinkedList - the next element in the list, after its removal
    @requires - next != null
    @ensures - the next element will be removed and returned
     */
    public MyLinkedList<T> detach()
    {
        MyLinkedList<T> temp = next;
        next = null;
        return temp;
    }

    @Override
    /*
    @return T - the value held by this instance of MyLinkedList
    @requires - value != null
    @ensures - the value will be returned
     */
    public T get()
    {
        return value;
    }

    @Override
    /*
    @param value : T - the new value
    @requires - incoming value != null and of type T
    @ensures - this instance of MyLinkedList will store value such that #value = value
     */
    public void set(T value)
    {
        this.value = value;
    }

    @Override
    /*
    @param next : ILinkedList - the list to add to ours
    @requires - next != null
    @ensures - the list will be added such that |list| = 1 + |next|
     */
    public void setNext(ILinkedList<T> next)
    {
        this.next = (MyLinkedList<T>) next;
    }

    @Override
    /*
    @param next : ILinkedList - the list to append to ours
    @requires - next != null
    @ensures - the list will be added such that list = #list * next
     */
    public void append(ILinkedList<T> next)
    {
        this.last().setNext(next);
    }

    @Override
    /*
    @param newFirst : ILinkedList - the element to become the head of the list
    @requires - newFirst != null
    @ensures - newFirst will be the head of the list such that list = newFirst * #list
     */
    public void insert(ILinkedList<T> newFirst)
    {
        MyLinkedList<T> temp = new MyLinkedList<>(this.value);
        temp.setNext(this.next);
        this.value = newFirst.get();
        this.next = temp;
    }
}
