import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BinaryTree<T> implements Iterable<T> {

    T data;
    BinaryTree<T> left;
    BinaryTree<T> right;

    @Override
    public Iterator<T> iterator() {
        return new TreeIterator(this);
    }

    private class TreeIterator implements Iterator<T> {

        private Stack<BinaryTree<T>> stack = new Stack<>();

        TreeIterator(BinaryTree<T> tree) {
            if (tree.data != null)
                stack.push(tree); // starts with the root node
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            BinaryTree<T> tree = stack.pop();
            if (tree.right != null)
                stack.push(tree.right);
            if (tree.left != null)
                stack.push(tree.left);
            return tree.data;
        }
    }

    public BinaryTree(T data)
    {
        this.data = data;
    }

    public BinaryTree() {}

    public void addLeftChild(BinaryTree<T> node)
    {
        left = node;
    }

    public void addRightChild(BinaryTree<T> node)
    {
        right = node;
    }
}
