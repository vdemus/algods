package datastructures.stack;

public class FullStackException extends RuntimeException{

    public FullStackException() {
        super("Stack is full");
    }
}
