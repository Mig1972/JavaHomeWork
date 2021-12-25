package com.pb.mospan.hw13;

import java.util.PriorityQueue;
import java.util.Queue;

public class MyMain {

    public static void main(String[] args) {
        Object block = new Object();
        Queue<Integer> Buffer = new PriorityQueue<>();
        Producer producer = new Producer(block, Buffer);
        Consumer consumer = new Consumer(block, Buffer);

        producer.start();
        consumer.start();

        while (true) {
            if (!producer.isAlive() && Buffer.isEmpty()) {
                System.exit(0);
            }
        }
    }

    public static class Producer extends Thread {
        private final Object block;
        private final Queue<Integer> Buffer;

        public Producer(Object block, Queue<Integer> Buffer) {
            this.block = block;
            this.Buffer = Buffer;
        }

        @Override
        public void run() {
            int number = 0;
            for (int i = 0; i < 100; i++) {

                if (Buffer.size()<5) {
                    number += 1;
                    synchronized (block) {
                        System.out.println("Добавляем новое число в буфер number: "+ number);
                        Buffer.add(number);
                        System.out.println("Сейчас в буфере находятся следующие числа: " + Buffer);
                        block.notify();

                        if (Buffer.size() >= 5) {
                            try {
                                System.out.println("Буфер заполнен полностью!");
                                block.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                           }
                        }
                    }
                }
            }
        }
    }

    public static class Consumer extends Thread {
        private final Object block;
        private final Queue<Integer> Buffer;

        public Consumer(Object block, Queue<Integer> Buffer) {
            this.block = block;
            this.Buffer = Buffer;
        }

        @Override
        public void run() {
            int number = 0;

            while (true) {

                if (!Buffer.isEmpty()) {
                    synchronized (block) {
                        number = Buffer.remove();
                        System.out.println("Забираем из буфера number: " + number);
                        block.notify();

                        if (Buffer.isEmpty()) {
                            try {
                                block.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                 }
            }
        }
    }
}
