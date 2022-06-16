package com.github.jjjzzzqqq.distributedlock.zk.test;


import com.github.jjjzzzqqq.distributedLock.zk.DistributedLock;
import org.apache.zookeeper.KeeperException;

import java.io.IOException;
import java.util.Date;

public class DistributedLockTest {
    public static void main(String[] args) throws InterruptedException, IOException, KeeperException {
        // 创建分布式锁 1 模拟服务A
        final DistributedLock lock1 = new DistributedLock();
        // 创建分布式锁 2 模拟服务B
        final DistributedLock lock2 = new DistributedLock();

        new Thread(new Runnable() {
            @Override
            public void run() {
                // 获取锁对象
                try {
                    lock1.lock();
                    System.out.println("线程 1 获取锁" + new Date());
                    Thread.sleep(5 * 1000);
                    lock1.unlock();
                    System.out.println("线程 1 释放锁" + new Date());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                // 获取锁对象
                try {
                    lock2.lock();
                    System.out.println("线程 2 获取锁" + new Date());
                    Thread.sleep(5 * 1000);
                    lock2.unlock();
                    System.out.println("线程 2 释放锁" + new Date());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
