package com.xmtech;

import java.util.List;

public class Features {

    public void testLambda() {
        var nums = List.of(1, 2, 3);
        out(nums);
        nums.forEach(e -> {
            out(e);
        });
        // UnsupportedOperation
        // nums.add(4);
    }

    public void testStream() {
        var nums = List.of(1, 2, 3, 5, 8);
        nums.stream().filter(e -> e > 1).forEach(e -> {
            System.out.println(e);
        });

        Node<String> node = new Node<>("xm");
        Node<String> node1 = new Node<>("xx");
        Node<String> node2 = new Node<>("xd");
        var nodes = List.of(node, node1, node2);
        nodes.stream().forEach(e -> {
            System.out.println(e.item);
        });
    }


    public void out(Object obj) {
        System.out.println(obj);
    }

    static class Node<E> {
        E item;

        Node(E e) {
            item = e;
        }
    }

    public static void main(String[] args) {
        Features e = new Features();
        e.testLambda();
        e.testStream();
    }
}
