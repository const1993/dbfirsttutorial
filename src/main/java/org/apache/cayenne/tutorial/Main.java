package org.apache.cayenne.tutorial;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.datasource.DataSourceBuilder;
import org.apache.cayenne.query.ObjectSelect;
import org.apache.cayenne.tutorial.persistent.Artist;
import org.apache.cayenne.tutorial.persistent.DbEntity;
import org.apache.cayenne.tutorial.persistent.Gallery;
import org.apache.cayenne.tutorial.persistent.Painting;

import java.util.List;

public class Main  {

    public static void main(String[] args) {
        ServerRuntime cayenneRuntime = ServerRuntime.builder()
                .addModule(new TutorialModule())
                .dataSource(DataSourceBuilder
                        .url("jdbc:stub://127.0.0.1:3306/cayenne_demo")
                        .driver("io.bootique.jdbc.driver.stub.Driver")
                        .userName("user")
                        .password("password").build())
                .addConfig("cayenne-project.xml")
                .build();
        ObjectContext context = cayenneRuntime.newContext();

        Artist artist = context.newObject(Artist.class);
        artist.setName("Picasso");
        context.commitChanges();

        List<DbEntity> entities = ObjectSelect.query(DbEntity.class).select(context);
        entities.forEach(a -> System.out.println(a.toString()));

        List<Artist> artists = ObjectSelect.query(Artist.class).select(context);
        artists.forEach(a -> System.out.println(a.toString()));

        List<Painting> paintings = ObjectSelect.query(Painting.class).select(context);
        paintings.forEach(p -> System.out.println(p.toString()));

        List<Gallery> gallery = ObjectSelect.query(Gallery.class).select(context);
        gallery.forEach(g -> {
            System.out.println(g.toString());
            g.getPaintings().forEach(painting -> System.out.println(painting.toString()));
        });
    }

}