package thread.sync;

/**
 * Lock
 */
public class SaleTicket {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                ticket.sale();
            }
        }, "AA").start();

        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                ticket.sale();
            }
        }, "BB").start();

        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "CC").start();

    }



}

class Ticket {

    private int number = 30;

    public void sale() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() +
                    "卖出" + number-- + "剩下" + number);
        }
    }

}