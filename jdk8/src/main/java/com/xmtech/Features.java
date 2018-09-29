package com.xmtech;

public class Features {

    private void testLambda() {

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
//        e.testStream();
    }


}
