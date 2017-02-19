package ru.skrser.ctci4dot2;

import java.util.HashSet;
import java.util.Set;

public class Node {

    public int value;
    public Set<Node> linkedNodes = new HashSet<Node>();
}
