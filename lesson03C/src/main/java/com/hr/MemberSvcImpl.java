package com.hr;

import org.apache.log4j.Logger;

public class MemberSvcImpl implements MemberSvc {
    private Logger LOG = Logger.getLogger(this.getClass());

    @Override public int do_save() {

        LOG.debug("==========================================");
        LOG.debug("do_save() = ");
        LOG.debug("==========================================");
        return 0;
    }

    @Override
    public void insert() {
        LOG.debug("==========================================");
        LOG.debug("insert() = ");
        LOG.debug("==========================================");
    }
}
