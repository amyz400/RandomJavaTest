package myteststuff.classes;

/**
 * Created by aziring on 6/1/17.
 */
public class ProcessorTwo implements Processor {

    @Override
    public void processing() {

        try {
            String myString = null;
            System.out.println(myString.length());
            System.out.println("*****ProcessTwo - processing");
        } catch (NullPointerException e) {
            System.out.println("caught NPE");
        }
    }
}
