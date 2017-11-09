package myteststuff.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by aziring on 9/19/17.
 */
@Component
public class StartMyProcessing implements CommandLineRunner {

  @Autowired
  private SearchService searchService;
  
  public void run(String... var) {
    System.out.println("Application has started");
    searchService.startFuzzySearch();

    searchService.startHibernateSearch();
  }

}
