package myteststuff.classes.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.TypedQuery;
import myteststuff.classes.PharmacyEntity;
import myteststuff.classes.PharmacyNameProjection;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by aziring on 9/18/17.
 */
@Component
public class PharmacyRepoCustomImpl implements PharmacyRepoCustom {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  @Transactional(readOnly = true)
  public Map<Integer, String> getByName(String name) {
    String nameParm = "NAME_PARM";
    boolean hasName = false;
    StringBuilder queryStr = new StringBuilder().append("Select p.id, p.city from PharmacyEntity p ");
    if (name != null && !name.isEmpty()) {
      queryStr.append("where p.name like :").append(nameParm);
      hasName = true;
    }

    Session session = sessionFactory.getCurrentSession();
    Query query = sessionFactory.getCurrentSession().createQuery(queryStr.toString());
    if (hasName) {  query.setParameter(nameParm, "%" + name + "%"); }
    List<Object[]> rows = query.list();

    Map<Integer, String> names = new HashMap();
    for (Object[] row : rows) {
      names.put((Integer)row[0], (String)row[1]);
      }
    return names;
  }
}
