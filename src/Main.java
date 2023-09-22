public class Main {
    public static void main(String[] args) throws InterruptedException {
        EggOrChicken egg = new EggOrChicken("Яйцо");
        EggOrChicken chicken = new EggOrChicken("Курица");

        chicken.start();
        egg.start();
        try {
            chicken.join();
            egg.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }


        System.out.println("Поток, завершившийся последним: " + EggOrChicken.getLastThreadName());
    }
}

class EggOrChicken extends Thread {
    private static String lastThreadName;

    public EggOrChicken(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int n = 0; n < 100; n++) {
            System.out.println(this.getName());
        }
        lastThreadName = getName();
    }

    public static String getLastThreadName() {
        return lastThreadName;
    }
}
