package myteststuff.classes.repositories;

import java.util.List;
import java.util.Map;
import myteststuff.classes.PharmacyNameProjection;

/**
 * Created by aziring on 9/18/17.
 */
public interface PharmacyRepoCustom {

  Map<Integer, String> getByName(String name);
}
