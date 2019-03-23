package com.hr;

import org.apache.log4j.Logger;

public class MemberDao implements CommonDao {
    private Logger LOG = Logger.getLogger(this.getClass());

    @Override public void do_save() {
        LOG.debug("------------------------------------------");
        LOG.debug("do_save()");
        LOG.debug("------------------------------------------");
    }

    @Override public void do_update() {
        LOG.debug("------------------------------------------");
        LOG.debug("do_update()");
        LOG.debug("------------------------------------------");
    }

    @Override public void do_delete() {
        LOG.debug("------------------------------------------");
        LOG.debug("do_delete()");
        LOG.debug("------------------------------------------");
    }

    @Override public void do_retrieve() {
        LOG.debug("------------------------------------------");
        LOG.debug("do_retrieve()");
        LOG.debug("------------------------------------------");
    }
}
