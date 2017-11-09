package myteststuff.classes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by aziring on 9/5/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NotesServiceTest {

  @Autowired
  private FirstNotesService firstNotesService;

  @Autowired
  public NotesService notesService;

  @Test
  public void createNoteTest() {
    int id = firstNotesService.createNote("Hello Amy");
  }

}
