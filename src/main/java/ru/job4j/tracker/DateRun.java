package ru.job4j.tracker;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class DateRun {
    public static void main(String[] args) {
        var registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try (var sf = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory()) {
            var session = sf
                    .withOptions()
                    .jdbcTimeZone(TimeZone.getTimeZone("UTC"))
                    .openSession();
            session.beginTransaction();
            var stored = session.createQuery(
                    "from Item", Item.class
            ).list();
            for (Item it : stored) {
                var time = it.getCreated().atZone(
                        ZoneId.of("UTC+3")
                ).format(DateTimeFormatter.ofPattern("HH:mm yyyy-MM-dd"));
                System.out.println(time);
            }
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}