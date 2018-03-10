package datastructures.stack;

public class Client {

    public static void main(String[] args) {
        FixedSizeIntStack fixedSizeIntStack = new FixedSizeIntStack(5);
        fixedSizeIntStack.push(5);
        fixedSizeIntStack.push(7);
        fixedSizeIntStack.push(87);
        fixedSizeIntStack.push(32);
        fixedSizeIntStack.push(65);


        System.out.println("Print FixedSizeIntStack:");

        while (!fixedSizeIntStack.isEmpty()) {
            int element = fixedSizeIntStack.pop();
            System.out.println(element);
        }

        Stack stack = new DynamicStack<String>(4);
        stack.push("first");
        stack.push("second");
        stack.push("third");
        stack.push("forth");
        stack.push("fifth");
        stack.push("sixth");
        stack.push("seventh");
        stack.push("eighth");
        stack.push("ninth");
        stack.push("tenth");
        stack.push("eleventh");

        System.out.println("Print Dynamic Stack:");

        while (!stack.isEmpty()) {
            String element = (String)stack.pop();
            System.out.println("Element:" + element + "; Stack Size = " + stack.size() + "; Stack Capacity = " + stack.capacity());
        }

    }
}
