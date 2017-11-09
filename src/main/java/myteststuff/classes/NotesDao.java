package myteststuff.classes;

import java.util.Map;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by aziring on 9/5/17.
 */
@Component
public class NotesDao {

  @Autowired
  private SessionFactory sessionFactory;

  @Transactional
  public int save(NotesEntity notesEntity) {

    Session session= sessionFactory.getCurrentSession();
    Transaction tx = session.getTransaction();

    System.out.println("TX id: " + tx.hashCode());

    int pk = (Integer) session.save(notesEntity);

    return pk;
  }

}
