package myteststuff.classes;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by aziring on 6/1/17.
 */
public class ControlProcessing {

    private ProcessorOne p1;

    private ProcessorTwo p2;

    @Autowired
    private NotesService notesService;

    public void startProcessing() {

        int newId = notesService.createNote("HELLO Amy");

        try {

            p1 = new ProcessorOne();
            p2 = new ProcessorTwo();

            p1.processing();

            p2.processing();

            System.out.println("*** startProcessing");


        } finally {
            System.out.println("*** finishProcessing");
        }
    }
}
