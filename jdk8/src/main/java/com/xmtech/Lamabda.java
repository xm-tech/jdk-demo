package com.xmtech;

public class Lamabda {

    private void test() {
        final Runnable task = () -> {
            out("exec task ");
        };

        new Thread(task).start();
    }

    public void out(Object obj) {
        System.out.println(obj);
    }

    public static void main(String[] args) {
        Lamabda e = new Lamabda();
        e.test();
    }


}
