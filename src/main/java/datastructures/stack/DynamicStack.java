package datastructures.stack;

import static java.lang.String.format;

public class DynamicStack<Item> implements Stack<Item> {

    /** Represents index of element at the top of the stack **/
    private int top;

    /** Represents maximum stack size. Initial capacity is 16 if not set**/
    private int size;

    /** Storage of all elements in the stack**/
    private Item[] container;

    public DynamicStack() {
        this(16);
    }

    public DynamicStack(int size) {
        this.size = size;
        this.container = (Item[]) new Object[size];
        this.top = -1;
    }

   @Override
    public void push(Item item) {
       if (isFull()) {
           resize(size * 2);
       }

       top++;
       container[top] = item;
    }

    @Override
    public Item pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        Item item = container[top];
        container[top] = null; //to avoid loitering
        top--;

        if (needsTrim()) {
            resize(size / 2);
        }

        return item;
    }

    @Override
    public Item peak() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return container[top];
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public int capacity() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;

    }

    private boolean isFull() {
        return top == (size - 1);

    }

    private boolean needsTrim() {
        return top < size / 4;
    }

    private void resize(int newSize) {
        Item[] tempContainer = (Item[]) new Object[newSize];

        for (int i = 0; i <= top; i++) {
            tempContainer[i] = container[i];
        }

        System.out.println(format("RESIZE array from %d to %d", size, newSize) );
        container = tempContainer;
        size = newSize;
    }
}
