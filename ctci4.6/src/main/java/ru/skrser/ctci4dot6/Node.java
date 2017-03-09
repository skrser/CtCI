package ru.skrser.ctci4dot6;

public class Node {

    public int value;
    public Node parent;
    public Node left;
    public Node right;

    public Node(int value, Node parent) {
        this.value = value;
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
