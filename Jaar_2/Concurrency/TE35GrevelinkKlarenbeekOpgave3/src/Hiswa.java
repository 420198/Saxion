import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sklar on 10/4/2016.
 */
public class Hiswa {
    private Lock lock = new ReentrantLock();
    private Condition kijkersWachtBuiten = lock.newCondition(),
            buyerCanGoInside = lock.newCondition(),
            kijkerWachtTotAlleKijkersHiswaHebbenBetreden = lock.newCondition();
    private int kijkerWachtBuitenC = 0,
            wachtendeKopersC = 0,
            koperRijC = 0,
            kijkersBinnenC = 0,
            hiswaCapaciteitC = 10;
    private boolean isEenKoperBinnen = false,
            alleKijkersMogenNaarBinnen = false;

    /**
     * Constructor for the hiswa
     */
    public Hiswa() {
    }

    /**
     * Enter the hiswa
     *
     * @param person Person
     */
    public void enter(Person person) {
        //Lock the entering of the hiswa, critical condition
        lock.lock();
        assert person != null : "person is null";
        try {
            if (person instanceof Buyer) {
                //The entering of a buyer, let them wait when needed and else let them enter
                System.out.println(person.toString() + " heeft zich gemeld.");
                wachtendeKopersC++;
                //laat wachten wanneer 1 van deze condities waar is
                while (koperRijC >= 4 || isEenKoperBinnen || alleKijkersMogenNaarBinnen || kijkersBinnenC > 0) {
                    buyerCanGoInside.await();
                }
                wachtendeKopersC--;
                //koper gaat naar binnen
                assert !isEenKoperBinnen : "Er is al een koper binnen";
                isEenKoperBinnen = true;
            }
            if (person instanceof Visitor) {
                //wacht hier als "alle kijkers naar binnen zijn, nieuwe mensen moeten hier dan wachten"
                while (alleKijkersMogenNaarBinnen) {
                    System.out.println(person.toString() + " moet wachten tot alle voorgaande wachtende kijkers binnen zijn geweest");
                    kijkerWachtTotAlleKijkersHiswaHebbenBetreden.await();
                }
                //als 1 van deze condities klopt, ga while loop binnen en als de condities daar kloppen, dan wacht
                while ((!alleKijkersMogenNaarBinnen && wachtendeKopersC > 0 && koperRijC < 4) || isEenKoperBinnen ||
                        (kijkersBinnenC >= hiswaCapaciteitC)) {
                    kijkerWachtBuitenC++;
                    System.out.println(person.toString() + " wacht buiten");
                    kijkersWachtBuiten.await();
                    kijkerWachtBuitenC--;
                }
                kijkersBinnenC++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //Always unluck
            lock.unlock();
        }
    }

    /**
     * Leave the hiswa
     *
     * @param person
     */
    public void leave(Person person) {
        lock.lock();
        try {
            if (person instanceof Buyer) {
                //hoog koperrij op
                koperRijC++;
                isEenKoperBinnen = false;
                //signalleer correcte rijen op correct moment
                if (koperRijC < 4 && wachtendeKopersC > 0) {
                    buyerCanGoInside.signal();
                } else if (koperRijC >= 4 && (wachtendeKopersC > 0 || kijkerWachtBuitenC > 0)) {
                    if (kijkerWachtBuitenC <= 0) {
                        buyerCanGoInside.signal();
                    } else {
                        alleKijkersMogenNaarBinnen = true;
                        kijkersWachtBuiten.signalAll();
                    }
                    koperRijC = 0;
                } else if (wachtendeKopersC <= 0 && kijkerWachtBuitenC >= 0) {
                    koperRijC = 0;
                    if (kijkerWachtBuitenC > 0) {
                        kijkersWachtBuiten.signal();
                    }
                }
            } else {
                //haal 1 kijker binnen af
                kijkersBinnenC--;
                //signaaleer correcte rijen.
                if (alleKijkersMogenNaarBinnen) {
                    if (kijkerWachtBuitenC > 0) {
                        kijkersWachtBuiten.signal();
                    } else {
                        if (wachtendeKopersC > 0) {
                            alleKijkersMogenNaarBinnen = false;
                            buyerCanGoInside.signal();
                        } else {
                            kijkersWachtBuiten.signal();
                        }
                        kijkerWachtTotAlleKijkersHiswaHebbenBetreden.signalAll();
                    }
                } else {
                    if (wachtendeKopersC > 0) {
                        buyerCanGoInside.signal();
                    } else if (kijkerWachtBuitenC > 0) {
                        kijkersWachtBuiten.signal();
                    }
                }
            }
        } finally {
            lock.unlock();
        }
    }
}