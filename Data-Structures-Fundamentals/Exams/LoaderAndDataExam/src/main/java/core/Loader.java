package core;

import interfaces.Buffer;
import interfaces.Entity;
import model.BaseEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Loader implements Buffer {

    static class Node {
        Entity entity;
        Node next;

        public Node(Entity entity) {
            this.entity = entity;
        }
    }


    Node root;
    Node tail;
    int size;

    @Override
    public void add(Entity entity) {

        Node newNode = new Node(entity);

        if (this.root == null) {
            this.root = this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        size++;
    }

    @Override
    public Entity extract(int id) {
        NodeAndPrevious nodeAndPrevious = findNodeWIthEntityId(id);
        Node result = nodeAndPrevious.node;

        if (result == root) {
            root = nodeAndPrevious.node.next;
        } else {
            nodeAndPrevious.previous.next = nodeAndPrevious.node.next;
            if (tail == nodeAndPrevious.node) {
                tail = nodeAndPrevious.previous;
            }
        }

        if (result != null) {
            size--;
            return result.entity;
        }

        return null;
    }

    @Override
    public Entity find(Entity entity) {
        NodeAndPrevious nodeWIthEntityId = findNodeWIthEntityId(entity.getId());

        if (nodeWIthEntityId != null) {
            return nodeWIthEntityId.node.entity;
        }
        return null;
    }

    private NodeAndPrevious findNodeWIthEntityId(int id) {

        Node previous = null;

        for (Node node = root; node != null; node = node.next) {
            if (node.entity.getId() == id) {
                return new NodeAndPrevious(node, previous);
            }
            previous = node;
        }
        return null;
    }

    static class NodeAndPrevious {
        Node node;
        Node previous;

        public NodeAndPrevious(Node node, Node previous) {
            this.node = node;
            this.previous = previous;
        }
    }

    @Override
    public boolean contains(Entity entity) {
        return this.findNodeWIthEntityId(entity.getId()) != null;
    }

    @Override
    public int entitiesCount() {
        return this.size;
    }

    @Override
    public void replace(Entity oldEntity, Entity newEntity) {

        Node node = findNodeWIthEntityId(oldEntity.getId()).node;

        if (node == null) {
            throw new IllegalStateException("Entity not found");
        }
        node.entity = newEntity;

    }

    @Override
    public void swap(Entity first, Entity second) {
        Node firstNode = findNodeWIthEntityId(first.getId()).node;
        Node secondNode = findNodeWIthEntityId(second.getId()).node;

        if (firstNode == null || secondNode == null) {
            throw new IllegalStateException("Entity not found");
        }
        Entity oldEntity = firstNode.entity;
        firstNode.entity = secondNode.entity;
        secondNode.entity = oldEntity;
    }

    @Override
    public void clear() {
        this.root = null;
        this.tail = null;
        size = 0;
    }

    @Override
    public Entity[] toArray() {
        List<Entity> entities = this.getAll();

        Entity[] result = new Entity[this.size];

        for (int i = 0; i < entities.size(); i++) {
            result[i] = entities.get(i);
        }

        return result;
    }

    @Override
    public List<Entity> retainAllFromTo(BaseEntity.Status lowerBound, BaseEntity.Status upperBound) {
        return getAll().stream()
                .filter(e -> isBetweenBounds(e, lowerBound, upperBound))
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public List<Entity> getAll() {

        List<Entity> entities = new ArrayList<>();
        for (Node node = root; node != null; node = node.next) {
            entities.add(node.entity);
        }


        return entities;
    }

    @Override
    public void updateAll(BaseEntity.Status oldStatus, BaseEntity.Status newStatus) {
        for (Node node = root; node != null; node = node.next) {
            if (node.entity.getStatus() == oldStatus) {
                node.entity.setStatus(newStatus);
            }
        }
    }

    @Override
    public void removeSold() {

        for (Node node = root; node != null; node = node.next) {
            if (node.entity.getStatus() == BaseEntity.Status.SOLD) {
                this.extract(node.entity.getId());
            }
        }
    }

    @Override
    public Iterator<Entity> iterator() {
        return getAll().listIterator();
    }
    private boolean isBetweenBounds(Entity entity, BaseEntity.Status lowerBound, BaseEntity.Status upperBound) {
        return lowerBound.ordinal() <= entity.getStatus().ordinal() && entity.getStatus().ordinal() <= upperBound.ordinal();
    }
}
