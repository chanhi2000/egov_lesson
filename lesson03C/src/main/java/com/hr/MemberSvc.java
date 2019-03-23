package com.hr;

public interface MemberSvc {
    // should execute
    int do_save();
    // will not be executed because "do_" suffix is missing
    void insert();
}
