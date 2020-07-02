public class ThreadPe {
    int count = 0;

    public class ThreadPeInner extends Thread {
        private String tname;
        public ThreadPeInner(String _tname) {
            this.tname = _tname;
        }



        public void run() {
            yield();

            System.out.println("This ran thread " + tname);
            count = count + 1;
        }
    }

    public ThreadPe() {
        ThreadPeInner tpi1 = new ThreadPeInner("Thread-1");
        ThreadPeInner tpi2 = new ThreadPeInner("Thread-2");
        tpi1.start();
        tpi2.start();
        try {
            tpi1.join();
            tpi2.join();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        System.out.println("Program finished,count=" + count);
    }

    public static void main(String args[]) {
        new ThreadPe();

    }
}