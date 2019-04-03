public class Main {
    public static void main(String[] args) {
        final String string1 = "Mads";
        final String string2 = "Martin";

        Thread t1 = new Thread() {
            public void run() {
                synchronized (string1) {
                    System.out.println("Thread 1: locked string 1");

                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }

                    synchronized (string2) {
                        System.out.println("Thread 1: locked string 2");
                    }
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                synchronized (string2) {
                    System.out.println("Thread 2: locked string 2");

                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }

                    synchronized (string1) {
                        System.out.println("Thread 2: locked string 1");
                    }
                }
            }
        };

        t1.start();
        t2.start();

    }
}
