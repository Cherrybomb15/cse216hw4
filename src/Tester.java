public class Tester
{
    public static void main(String[] args)
    {
        BinaryTree<Integer> a = new BinaryTree<>(5);
        a.addLeftChild(new BinaryTree<Integer>(0));
        a.addRightChild(new BinaryTree<Integer>(10));
        a.right.addLeftChild(new BinaryTree<Integer>(7));

        for (int x : a)
        {
            System.out.println(x);
        }
    }
}
