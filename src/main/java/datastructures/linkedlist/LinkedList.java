package datastructures.linkedlist;

import static java.util.Objects.isNull;

public class LinkedList<T> {

    /** represents first element in list **/
    private Node<T> first;
    /** represents last element in list **/
    private Node<T> last;
    /** represents size of the list **/
    private int size;

    public LinkedList() {
    }

    /** add element to the end of the list **/
    public void add(T item) {
        addLast(item);
    }

    /** add element by index **/
    public void add(T item, int index) {
        checkIndex(index);
        Node<T> newNode = new Node<>(item);

        if (index < size / 2) {
            int i = 0;
            for (Node<T> x = first; x != null; x = x.next) {
                if (i == index) {
                    placeBefore(newNode, x);
                } else {
                    i++;
                }
            }
        } else {
            int i = size-1;
            for (Node<T> x = last; x != null; x = x.previous) {
                if (i == index) {
                    placeBefore(newNode, x);
                } else {
                    i--;
                }
            }
        }
    }

    private void placeBefore(Node<T> newNode, Node<T> x) {
        Node<T> oldPrev = x.previous;
        newNode.previous = oldPrev;
        x.previous = newNode;
        newNode.next = x;
        if (isNull(oldPrev)) {
            first = newNode;
        } else {
            oldPrev.next = newNode;
        }

        size++;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    /** add element at the beginning of the list **/
    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item);
        Node<T> oldFirst = first;
        if (isNull(oldFirst)) {
            last = newNode;
        } else {
            oldFirst.previous = newNode;
            newNode.next = oldFirst;
        }
        first = newNode;
        size++;
    }

    /** add element to the end of the list **/
    public void addLast(T item) {
        Node<T> newNode = new Node<>(item);
        Node<T> oldLast = last;
        if (isNull(oldLast)) {
            first = newNode;
        } else {
            oldLast.next = newNode;
            newNode.previous = oldLast;
        }
        last = newNode;
        size++;
    }

    /** checks if list contains given element **/
    public boolean contains(T item) {
        if (isEmpty()) {
            return false;
        }

        if (isNull(item)) {
            for (Node<T> x = first; x != null; x = x.next) {
                if (isNull(x.item)) {
                    return true;
                }
            }
        } else {
            for (Node<T> x = first; x != null; x = x.next) {
                if (item.equals(x.item)) {
                    return true;
                }
            }
        }

        return false;
    }

    /** returns the size of the list **/
    public int size() {
        return size;
    }

    /** checks is list empty**/
    public boolean isEmpty() {
        return size == 0;
    }

    /** returns element from the list by index. doesn't remove it **/
    public T get(int index) {
        checkIndex(index);

        if (index < size / 2) {
            int i = 0;
            for (Node<T> x = first; x != null; x = x.next) {
                if (i == index) {
                    return x.item;
                } else {
                    i++;
                }
            }
        } else {
            int i = size-1;
            for (Node<T> x = last; x != null; x = x.previous) {
                if (i == index) {
                    return x.item;
                } else {
                    i--;
                }
            }
        }

        return null;
    }

    /** returns first element from the list. doesn't remove it **/
    public T getFirst() {
        return isNull(first) ? null : first.item;
    }

    /** returns last element from the list. doesn't remove it **/
    public T getLast() {
        return isNull(last) ? null : last.item;
    }

    private class Node<T> {
        Node<T> previous;
        Node<T> next;
        T item;

        Node(T item) {
            this.item = item;
        }
    }
}

