package idv.mission.example.JAXB_Example;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Test {
    public static void main(String[] args) {
        // write();
        read();
    }

    public static void read() {
        File xmlFile = new File("input_article.xml");
        JAXBContext context;
        try {
            context = JAXBContext.newInstance(Article.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Article article = (Article) unmarshaller.unmarshal(xmlFile);
            System.out.println(article.getTitle());
            System.out.println(article.getAuthor());
            System.out.println(article.getEmail());
            System.out.println(article.getDate());
        }
        catch (Exception ex) {
            System.out.println(ex.toString());
        }
        System.out.println("Done!");
    }

    public static void write() {
        File xmlFile = new File("output_article.xml");
        JAXBContext context;
        try {
            context = JAXBContext.newInstance(Article.class);
            Marshaller marshaller = context.createMarshaller();

            Article article = new Article();
            article.setAuthor("Janet");
            article.setDate("20080801");
            article.setEmail("test@yahoo.com.tw");
            article.setTitle("A test article");

            marshaller.marshal(article, xmlFile);
        }
        catch (Exception ex) {
            System.out.println(ex.toString());
        }
        System.out.println("Done!");
    }
}
