package datastructures.stack;

public interface Stack<Item> {

    void push(Item item);

    Item pop();

    Item peak();

    int size();

    int capacity();

    boolean isEmpty();

}
