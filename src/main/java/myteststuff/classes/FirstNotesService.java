package myteststuff.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by aziring on 9/6/17.
 */
@Service
public class FirstNotesService {

  @Autowired
  private NotesService ns;

  public int createNote(String note) {
    return ns.createNote(note);
  }

}
