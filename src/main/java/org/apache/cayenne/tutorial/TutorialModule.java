package org.apache.cayenne.tutorial;

import org.apache.cayenne.configuration.server.DbAdapterFactory;
import org.apache.cayenne.dba.PkGenerator;
import org.apache.cayenne.di.Binder;
import org.apache.cayenne.di.Module;
import org.apache.cayenne.tutorial.factory.CustomAdapterFactory;

public class TutorialModule implements Module {

    @Override
    public void configure(Binder binder) {
        binder.bind(PkGenerator.class).to(PKGenerator.class);
        binder.bind(DbAdapterFactory.class).to(CustomAdapterFactory.class);
    }
}
