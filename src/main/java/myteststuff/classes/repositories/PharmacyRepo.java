package myteststuff.classes.repositories;

import java.util.ArrayList;
import java.util.List;
import myteststuff.classes.PharmacyEntity;
import myteststuff.classes.PharmacyNameProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by aziring on 9/18/17.
 */
@Repository
public interface PharmacyRepo extends JpaRepository<PharmacyEntity, Integer> {

  List<PharmacyEntity> findAllByOrderByName();

  List<PharmacyNameProjection> findAllProjectedBy();

}
