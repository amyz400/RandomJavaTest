package myteststuff.classes;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import myteststuff.classes.repositories.PharmacyRepo;
import myteststuff.classes.repositories.PharmacyRepoCustom;
import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.search.Query;
import org.hibernate.CacheMode;
import org.hibernate.FlushMode;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.BooleanJunction;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by aziring on 9/18/17.
 */
@Service
public class SearchService {

  @Autowired
  private SessionFactory sessionFactory;

  @Autowired
  private PharmacyRepo pharmacyRepo;

  @Autowired
  private PharmacyRepoCustom pharmacyRepoCustom;

  @Transactional
  public void startFuzzySearch() {
    queryForEverything();
    // get data and kick off fuzzy search for first criteria

    long startTime = System.currentTimeMillis();
    // get initial list
    //List<PharmacyEntity> nameList = pharmacyRepo.findAll();
    //List<PharmacyNameProjection> nameList = pharmacyRepo.findAllProjectedBy();
    String nameSearchStr = "CVS";
    String citySearchStr = "LANSDALE";
    String zipSearchStr = "19446";
    Map<Integer, String> nameMap = pharmacyRepoCustom.getByName(nameSearchStr);
    System.out.println("nameMap count: " + nameMap.size());

    // not we have a huge list of data, see which data items are relevant
    Map<Integer, Integer> fuzzyResult = new HashMap<Integer, Integer>();
    //for (PharmacyEntity p : nameList) {
    for (Entry<Integer,String> mapEntry : nameMap.entrySet()) {
      int nameFuzzy = StringUtils.getLevenshteinDistance(mapEntry.getValue().toUpperCase(), citySearchStr);
  //      int nameFuzzy = StringUtils.getLevenshteinDistance(p.getName().toUpperCase(), nameSearchStr);
  //      int cityFuzzy = StringUtils.getLevenshteinDistance(p.getCity().toUpperCase(), citySearchStr);
  //      int zipFuzzy = StringUtils.getLevenshteinDistance(p.getZipCode().toUpperCase(), zipSearchStr);
      int fuzzy = nameFuzzy;// + cityFuzzy + zipFuzzy;
      if (fuzzy <= 2) {
        //fuzzyResult.put(p.getId(), fuzzy);
        fuzzyResult.put(mapEntry.getKey(), fuzzy);
      }
    }

    long endTime = System.currentTimeMillis();
    System.out.println("startFuzzySearch - Time for query: " + (endTime-startTime));
    System.out.println("startFuzzySearch - count of fuzzies " + fuzzyResult.size());
  }

  public void startLuceneSearch() {

  }

  @Transactional
  public void startHibernateSearch() {

  //  indexDatabase(PharmacyEntity.class);

    long startTime = System.currentTimeMillis();
    Session session = sessionFactory.getCurrentSession();
    FullTextSession fullTextSession = Search.getFullTextSession(session);

    QueryBuilder qb = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(PharmacyEntity.class).get();
    BooleanJunction<BooleanJunction> junction = qb.bool();
    junction.should(qb.keyword().fuzzy().onField("name").matching("CVS").createQuery());
    junction.should(qb.keyword().fuzzy().onField("city").matching("lansdale").createQuery());
    Query query = junction.createQuery();

    FullTextQuery fullTextQuery = fullTextSession.createFullTextQuery(query, PharmacyEntity.class);
    List<PharmacyEntity> results = fullTextQuery.list();

    long endTime = System.currentTimeMillis();
    System.out.println("startHibernateSearch - Time for query: " + (endTime-startTime));
    System.out.println("startHibernateSearch - count of fuzzies " + results.size());
  }

  private void indexDatabase(Class clazz) {
    // overriding the MassIndexer automatic indexing and use the manual indexing.
    Session indexingSession = sessionFactory.openSession();
    FullTextSession fullTextSession = Search.getFullTextSession(indexingSession);
    fullTextSession.setFlushMode(FlushMode.MANUAL);
    fullTextSession.setCacheMode(CacheMode.IGNORE);
    fullTextSession.beginTransaction();
    int batchSize = 10;
    ScrollableResults results = fullTextSession.createCriteria(clazz).setFetchSize(batchSize)
        .scroll(ScrollMode.SCROLL_INSENSITIVE);
    int index = 0;
    while (results.next()) {
      // Re-index entites in batches of 10, freeing up memory after each batch
      index++;
      fullTextSession.index(results.get(0));
      if (index % batchSize == 0) {
        fullTextSession.flushToIndexes();
        fullTextSession.clear();
      }
    }
    fullTextSession.getTransaction().commit();
  }

  private void queryForEverything() {
    long start = System.currentTimeMillis();

    List<PharmacyEntity> pharmacyEntityList = pharmacyRepo.findAllByOrderByName();

    String totalTime = new Long(System.currentTimeMillis() - start).toString();

    System.out.println("Total time querying for everything: " + totalTime);

  }

}
