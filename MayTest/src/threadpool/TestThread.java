package threadpool;

//1) 线程复用：通过线程复用减少反复创建线程的时间开销和内存开销；
//2) 线程资源管控：限制并发线程数，控制空闲线程的存活时间，可避免机器的线程消耗殆尽或创建了大量的线程引起内存溢出等问题。
//3) 任务调度：可通过改变线程池状态来管理线程池对正在执行的任务或请求队列中的任务以及新提交的任务的处理方式。
public class TestThread implements Runnable{
	
	@Override
	public void run() {
		System.out.println("线程启动！");
	}

}
