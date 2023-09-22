public class LastThread {
    public static void main(String[] args) {
        int numThreads = 5; // Количество потоков
        Thread[] threads = new Thread[numThreads];

        // Создание и запуск потоков
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new MyThread("Поток " + i);
            threads[i].start();
        }

        // Ожидание завершения всех потоков
        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Поток, который завершился последним
        System.out.println("Поток, завершившийся последним: " + MyThread.getLastThreadName());
    }
}

class MyThread extends Thread {
    private static String lastThreadName;

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        // Делаем какую-то работу в потоке
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Записываем имя потока, который завершился
        lastThreadName = getName();
    }

    public static String getLastThreadName() {
        return lastThreadName;
    }
}


