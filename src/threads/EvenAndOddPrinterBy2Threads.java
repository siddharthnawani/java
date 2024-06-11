package threads;

public class EvenAndOddPrinterBy2Threads implements Runnable {

    static int count = 1;
    Object object;

    public EvenAndOddPrinterBy2Threads(Object object) {
        this.object = object;
    }

    @Override
    public void run() {

        while (count <= 100) {

            if (count % 2 == 0 && Thread.currentThread().getName().equalsIgnoreCase("even")) {
                System.out.println(Thread.currentThread().getName() + " waiting for lock even");
                synchronized (object) {
                    System.out.println("Thread Name : " + Thread.currentThread().getName() + " value :" + count);
                    count++;
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Thread : " + Thread.currentThread().getName() +" came out of synchonized even");

            }
            if (count % 2 != 0 && Thread.currentThread().getName().equalsIgnoreCase("odd")) {
                System.out.println(Thread.currentThread().getName() + " waiting for lock odd");
                synchronized (object) {
                    System.out.println("Thread Name : " + Thread.currentThread().getName() + " value :" + count);
                    count++;
                    object.notify();
                }
                System.out.println("Thread : " + Thread.currentThread().getName() +" came out of synchonized odd");

            }
        }


    }

    public static void main(String[] args) {
        Object obj=new Object();

        Runnable r1=new EvenAndOddPrinterBy2Threads(obj);
        Runnable r2=new EvenAndOddPrinterBy2Threads(obj);

        new Thread(r1,"even").start();
        new Thread(r2,"odd").start();
    }
}
