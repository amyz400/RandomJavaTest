package myteststuff.classes;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by aziring on 9/5/17.
 */
@Service
public class NotesService {

  @Autowired
  private NotesDao notesDao;

  @Autowired
  private SessionFactory sessionFactory;

  public int createNote(String noteToCreate) {

    // calling the DAO to save the Notes data
    NotesEntity entity = new NotesEntity();
   // entity.setNotes(noteToCreate);

    return notesDao.save(entity);

  }


}
