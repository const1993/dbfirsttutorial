package org.apache.cayenne.tutorial;

import org.apache.cayenne.access.DataNode;
import org.apache.cayenne.dba.PkGenerator;
import org.apache.cayenne.map.DbAttribute;
import org.apache.cayenne.map.DbEntity;

import java.util.Collections;
import java.util.List;

public class PKGenerator implements PkGenerator{


    @Override
    public void createAutoPk(DataNode node, List<DbEntity> dbEntities) throws Exception {

    }

    @Override
    public List<String> createAutoPkStatements(List<DbEntity> dbEntities) {
        return Collections.EMPTY_LIST;
    }

    @Override
    public void dropAutoPk(DataNode node, List<DbEntity> dbEntities) throws Exception {

    }

    @Override
    public List<String> dropAutoPkStatements(List<DbEntity> dbEntities) {
        return null;
    }

    @Override
    public Object generatePk(DataNode dataNode, DbAttribute pk) throws Exception {
        return 1111;
    }

    @Override
    public void reset() {

    }
}
