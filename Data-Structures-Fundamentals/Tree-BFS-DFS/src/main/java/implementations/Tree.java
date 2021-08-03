package implementations;

import interfaces.AbstractTree;

import java.util.*;

public class Tree<E> implements AbstractTree<E> {

    private E value;
    private Tree<E> parent;
    private List<Tree<E>> children;

    public Tree(E value, Tree<E>... children) {
        this.value = value;
        this.children = new ArrayList<>();
        for (Tree<E> child : children) {
            this.children.add(child);
            child.parent = this;
        }
    }

    public Tree() {

    }

    @Override
    public List<E> orderBfs() {
        List<E> result = new ArrayList<>();
        Deque<Tree<E>> queue = new ArrayDeque<>();

        queue.offer(this);

        while (queue.size() > 0) {
            Tree<E> current = queue.poll();
            result.add(current.value);

            for (Tree<E> child : current.children) {
                queue.offer(child);
            }
        }

        return result;
    }

    @Override
    public List<E> orderDfs() {

        List<E> result = new ArrayList<>();
        Stack<Tree<E>> stack = new Stack<>();

        stack.push(this);

        while (stack.size() > 0) {
            Tree<E> current = stack.pop();
            result.add(current.value);

            getChild(stack, current);
        }

        Collections.reverse(result);
        return result;
    }

    @Override
    public void addChild(E parentKey, Tree<E> child) {
        Stack<Tree<E>> stack = new Stack<>();

        stack.push(this);

        while (stack.size() > 0) {
            Tree<E> parent = stack.pop();
            if (parent.value == parentKey) {
                parent.children.add(child);
                return;
            }

            getChild(stack, parent);
        }
    }

    @Override
    public void removeNode(E nodeKey) {

        Stack<Tree<E>> stack = new Stack<>();

        stack.push(this);

        while (!stack.isEmpty()) {
            Tree<E> parent = stack.pop();

            if (parent.value == nodeKey) {
                parent.parent.children.remove(parent);
            }
            getChild((Stack<Tree<E>>) stack, parent);
        }
    }

    private void getChild(Stack<Tree<E>> stack, Tree<E> parent) {
        for (Tree<E> child : parent.children) {
            stack.push(child);
        }
    }

    @Override
    public void swap(E firstKey, E secondKey) {

        Tree<E> firstNode = new Tree<E>();
        Tree<E> secondNode = new Tree<E>();

        Queue<Tree<E>> queue = new ArrayDeque<>();

        queue.offer(this);

        while (!queue.isEmpty()) {
            Tree<E> currentNode = queue.poll();
            if (currentNode.value == firstKey) {
                firstNode = currentNode;
            }
            if (currentNode.value == secondKey) {
                secondNode = currentNode;
            }

            for (Tree<E> child : currentNode.children) {
                queue.offer(child);
            }
        }
        swapElements(this, firstNode, secondNode);
    }

    private void swapElements(Tree<E> tree, Tree<E> firstNode, Tree<E> secondNode) {
        List<Tree<E>> result = new ArrayList<>();
        Deque<Tree<E>> queue = new ArrayDeque<>();

        queue.offer(this);

        while (queue.size() > 0) {
            Tree<E> current = queue.poll();
            if (current.value == firstNode.value) {
                current = secondNode;
            } else if(current.value == secondNode.value) {
                current = firstNode;
            }
            result.add(current);

            for (Tree<E> child : current.children) {
                queue.offer(child);
            }
        }

        Tree<Integer> newTree = new Tree<>();
    }
}



