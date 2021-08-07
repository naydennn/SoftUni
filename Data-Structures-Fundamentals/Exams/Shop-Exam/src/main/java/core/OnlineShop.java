package core;

import model.Order;
import shared.Shop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OnlineShop implements Shop {

    static class Node {
        Order order;
        Node next;

        public Node(Order order) {
            this.order = order;
        }
    }

    Node root;
    Node tail;
    int size;

    @Override
    public void add(Order order) {
        Node newNode = new Node(order);

        if (this.root == null) {
            this.root = this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        size++;
    }

    @Override
    public Order get(int index) {
        List<Order> orders = this.toList();

        if (!validateIndex(index)) {
            throw new IndexOutOfBoundsException();
        }

        return orders.get(index);
    }

    private Boolean validateIndex(int index) {
        return index >= 0 && index <= this.size();
    }

    @Override
    public int indexOf(Order order) {
        NodeAndPrevious nodeAndPrevious = findOrderById(order.getId());

        if (nodeAndPrevious == null) {
            return -1;
        }
        return nodeAndPrevious.index;
    }

    @Override
    public Boolean contains(Order order) {
        return findOrderById(order.getId()) != null;
    }

    @Override
    public Boolean remove(Order order) {
        return this.remove(order.getId());
    }

    @Override
    public Boolean remove(int id) {
        NodeAndPrevious nodeAndPrevious = findOrderById(id);

        if (nodeAndPrevious == null) {
            return false;
        }

        if (nodeAndPrevious.node == root) {
            root = nodeAndPrevious.node.next;
        } else {
            nodeAndPrevious.previous.next = nodeAndPrevious.node.next;
            if (nodeAndPrevious.node == tail) {
                this.tail = nodeAndPrevious.previous;
            }
        }

        size--;

        return true;
    }

    static class NodeAndPrevious {
        Node node;
        Node previous;
        int index;

        public NodeAndPrevious(Node node, Node previous, int index) {
            this.node = node;
            this.previous = previous;
            this.index = index;
        }
    }

    private NodeAndPrevious findOrderById(int id) {

        Node previous = null;
        int index = -1;
        for (Node node = this.root; node != null; node = node.next) {
            index++;
            if (node.order.getId() == id) {
                return new NodeAndPrevious(node, previous, index);
            }
            previous = node;
        }


        return null;
    }

    @Override
    public void set(int index, Order order) {

        List<Order> orders = toList();
        if (!validateIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
        Order order1 = orders.get(index);

        NodeAndPrevious orderById = this.findOrderById(order.getId());

        orderById.node.order = order;
    }

    @Override
    public void set(Order oldOrder, Order newOrder) {
        NodeAndPrevious nodeAndPrevious = findOrderById(oldOrder.getId());

        if (nodeAndPrevious.node == null) {
            throw new IndexOutOfBoundsException();
        }
        nodeAndPrevious.node.order = newOrder;
    }

    @Override
    public void clear() {
        this.size = 0;
        this.tail = null;
        this.root = null;
    }

    @Override
    public Order[] toArray() {

        Order[] orders = new Order[size()];

        List<Order> ordersList = this.toList();

        for (int i = 0; i < ordersList.size(); i++) {
            orders[i] = ordersList.get(i);
        }
        return orders;
    }

    @Override
    public void swap(Order first, Order second) {
        NodeAndPrevious firstNode = findOrderById(first.getId());
        NodeAndPrevious secondNode = findOrderById(second.getId());

        if (firstNode.node == null || secondNode.node == null) {
            throw new IllegalArgumentException();
        }

        firstNode.node.order = second;
        secondNode.node.order = first;
    }

    @Override
    public List<Order> toList() {

        List<Order> orders = new ArrayList<>();

        for (Node node = this.root; node != null; node = node.next) {
            orders.add(node.order);
        }
        return orders;
    }

    @Override
    public void reverse() {
        List<Order> orders = toList();
        clear();

        for (int i = orders.size() - 1; i >= 0 ; i--) {
            add(orders.get(i));
        }
    }

    @Override
    public void insert(int index, Order order) {

        if (!validateIndex(index) || size == 0) {
            throw new IndexOutOfBoundsException();
        }
        List<Order> orders = toList();
        NodeAndPrevious nodeAndPrevious = findOrderById(orders.get(index).getId());

        Node newNode = new Node(order);

        if (nodeAndPrevious.node == root) {
            newNode.next = nodeAndPrevious.node;
            this.root = newNode;
        } else {
            newNode.next = nodeAndPrevious.node;
            nodeAndPrevious.previous.next = newNode;
        }
    }

    @Override
    public Boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
