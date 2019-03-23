package com.hr;

public interface CommonDao {
    /**
     * save data
     */
    void do_save();

    /**
     * modify data
     */
    void do_update();

    /**
     * remove data
     */
    void do_delete();

    /**
     * get data
     */
    void do_retrieve();
}
