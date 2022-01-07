#并发编程

###共享变量
####volatile
> 为了提高处理速度，处理器不直接和内存进行通信，而是先将系统内存的数据读到内部缓存（L1，L2或其他）后再进行操作，但操作完不知道何时会写到内存。如果对声明了volatile的变量进行写操作，JVM就会向处理器发送一条Lock前缀的指令，将这个变量所在缓存行的数据写回到系统内存。
> 
> 但是，就算写回到内存，如果其他处理器缓存的值还是旧的，再执行计算操作就会有问题。所以，在多处理器下，为了保证各个处理器的缓存是一致的，就会实现缓存一致性协议，每个处理器通过嗅探在总线上传播的数据来检查自己缓存的值是不是过期了，当处理器发现自己缓存行对应的内存地址被修改，就会将当前处理器的缓存行设置成无效状态，当处理器对这个数据进行修改操作的时候，会重新从系统内存中把数据读到处理器缓存里。

####synchronized
>synchronized用的锁是存在Java对象头里的。

> ·对于普通同步方法，锁是当前实例对象。 
> 
> ·对于静态同步方法，锁是当前类的Class对象。 
> 
> ·对于同步方法块，锁是Synchonized括号里配置的对象。

####死锁
> 死锁描述了两个或多个线程被永远阻塞、互相等待的情况。

>避免死锁的方法：
> - 避免一个线程同时获取多个锁。
>
> - 避免一个线程在锁内同时占用多个资源，尽量保证每个锁只占用一个资源。 
> 
> - 尝试使用定时锁，使用lock.tryLock（timeout）来替代使用内部锁机制。
>
> - 对于数据库锁，加锁和解锁必须在一个数据库连接里，否则会出现解锁失败的情况。



###不共享变量