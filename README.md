# DistributedLock-Zk


## 如何模拟锁资源
Zookeeper一个节点下的第一个子节点，我们认为其获得了锁资源。由于Zookeeper节点被全局共享，所以该锁资源是支持分布式的。

## 如何排队等待
通过监听前一个相邻节点，使得所有的线程排列成一个虚拟队列，类似AQS的虚拟双向队列。

## 如何实现线程阻塞和唤醒？
本案例使用JDK提供的LockSupport工具类实现线程的阻塞和唤醒。LockSupport被大量使用在JUC包中，
除了LockSupport，还可以使用像 CountDownLatch 类似的锁工具类。

