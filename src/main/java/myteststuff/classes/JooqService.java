package myteststuff.classes;

import static org.joox.JOOX.$;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * Created by aziring on 9/13/17.
 */
@Service
public class JooqService {

  private String xmlStr = "<note>\n"
      + "<header>\n"
      + "<to>Amy</to>\n"
      + "<from>Steve</from>\n"
      + "</header>\n"
      + "<heading>Grocery List</heading>\n"
      + "<body>Bananas, Bread, Coffee</body>\n"
      + "</note>";

  public void testJooqFind() {

    Document doc = $(xmlStr).document();
    NodeList nodeList = doc.getElementsByTagName("stop");
    String match = $(doc).find("header").find("stop").text();

    String newStr = match + "text";

    System.out.println(nodeList.getLength());
    System.out.println(match.toString());
    System.out.println(newStr);

    //$(doc).find("Error").find("Code").text() + " " + $(doc).find("Error").find("Description").text());
  }

}
