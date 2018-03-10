package datastructures.stack;

public class FixedSizeIntStack {
    /** Represents index of element at the top of the stack **/
    private int top;

    /** Represents maximum stack size **/
    private int size;

    /** Storage of all elements in the stack**/
    private int[] container;

    public FixedSizeIntStack(int size) {
        this.size = size;
        this.container = new int[size];
        top = -1;
    }

    public void push(int element) {
        if (this.isFull()) {
            throw new FullStackException();
        }

        top++;
        container[top] = element;
    }

    public int pop() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }

        int element = container[top];
        top--;
        return element;
    }

    public int peak() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        return container[top];
    }

    public boolean isEmpty() {
        return top == -1;

    }

    public boolean isFull() {
        return top == (size - 1);

    }
}
