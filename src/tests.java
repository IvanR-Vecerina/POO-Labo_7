public class tests {

    public static void main(String[] args) {
        Integer i1 = 5;
        Integer i2 = 4;
        Integer i3 = 3;
        Integer i4 = 2;
        Integer i5 = 1;

        Stack<Integer> stack = new Stack<Integer>(i1);
        System.out.println(stack);

        stack.push(i2);
        System.out.println(stack);

        stack.push(i3);
        System.out.println(stack);

        stack.push(i4);
        System.out.println(stack);

        stack.push(i5);
        System.out.println(stack);


    }


}
