package com.algorithm.multithreading;

/**
 * �����ṩ��һ���ࣺ
 *
 * public class Foo {
 * ? public void one() { print("one"); }
 * ? public void two() { print("two"); }
 * ? public void three() { print("three"); }
 * }
 * ������ͬ���߳̽��Ṳ��һ��?Foo?ʵ����
 *
 * �߳� A ������� one() ����
 * �߳� B �������?two() ����
 * �߳� C ������� three() ����
 * ������޸ĳ�����ȷ�� two() ������ one() ����֮��ִ�У�three() ������ two() ����֮��ִ�С�
 *
 * ?
 *
 * ʾ�� 1:
 *
 * ����: [1,2,3]
 * ���: "onetwothree"
 * ����:
 * �������̻߳ᱻ�첽������
 * ���� [1,2,3] ��ʾ�߳� A ������� one() �������߳� B ������� two() �������߳� C ������� three() ������
 * ��ȷ������� "onetwothree"��
 * ʾ�� 2:
 *
 * ����: [1,3,2]
 * ���: "onetwothree"
 * ����:
 * ���� [1,3,2] ��ʾ�߳� A ������� one() �������߳� B ������� three() �������߳� C ������� two() ������
 * ��ȷ������� "onetwothree"��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/print-in-order
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Question_1114 {


}

class Foo {

    private boolean firstFinished;
    private boolean secondFinished;
    private Object lock = new Object();

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        synchronized (lock) {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstFinished = true;
            lock.notifyAll();//�������У�������notifyֻ����һ�����ȴ��ص��е��̣߳�Ȼ����߳̾���ȥ�������������ʸ���
                            //Ҳ�����п���second��ʽ�Ǳ��̵߳�һ��ִ�еģ����ʱ��ͨ���жϻ���second��Ӧ���̵߳ȴ���������
                            //ִ������֮�󣬾Ϳ��Ի������е��߳���
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        synchronized (lock) {
            while (!firstFinished) {
                lock.wait();//���߳̾ʹ��ڵȴ��ص��У��ǲ������ȥ������������
            }

            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            secondFinished = true;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        synchronized (lock) {
            while (!secondFinished) {
                lock.wait();
            }

            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}

