public class Main {
    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<Integer, String>();

        bst.insert(5, "Value1");
        bst.insert(3, "Value2");
        bst.insert(6, "Value3");
        bst.insert(9, "Value4");
        bst.insert(7, "Value5");
        System.out.println(bst.contains(10));
    }
}