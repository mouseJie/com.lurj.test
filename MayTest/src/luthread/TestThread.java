package luthread;

/**
 * 线程是一个程序的多个执行路径，执行调度的单位，依托于进程存在。 
 * 线程不仅可以共享进程的内存，而且还拥有一个属于自己的内存空间，这段内存空间也叫做线程栈，
 * 是在建立线程时由系统分配的，主要用来保存线程内部所使用的数据，如线程执行函数中所定义的变量。
 * 注意：Java中的多线程是一种抢占机制而不是分时机制。抢占机制指的是有多个线程处于可运行状态，但是只允许一个线程在运行，他们通过竞争的方式抢占CPU。
 * @author Administrator
 *
 */
public class TestThread{
	
	public static int sign = 0;
	
	public static void main(String []args) {
		LuThread thread = new LuThread();
		thread.start();
		
		RuiThread thread1 = new RuiThread();
		Thread t = new Thread(thread1);
		t.start();
	}
}

/**
 * 继承Thread，扩展性小，无法继承其他类
 * @author Administrator
 *
 */
class LuThread extends Thread{
	@Override
    public void run() {
        System.out.println("继承Thread线程启动");
    }
}

/**
 * 直接实现Runnable接口，Thread也是通过实现该接口的
 */
class RuiThread implements Runnable{
	@Override
	public void run() {
		System.out.println("实现Runnable接口线程开启");
	}
}

















