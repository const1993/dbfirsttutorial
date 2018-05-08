package org.apache.cayenne.tutorial.persistent;

import org.apache.cayenne.di.Inject;
import org.apache.cayenne.tutorial.PKGenerator;
import org.apache.cayenne.tutorial.persistent.auto._Artist;

public class Artist extends _Artist {

    @Inject
    PKGenerator pkGenerator;


    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Artist{" +
                "name=" + name +
                " date_of_birh=" + dateOfBirth +
                '}';
    }
}
