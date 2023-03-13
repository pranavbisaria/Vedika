package com.Vedika.Service;

import java.time.LocalDate;
import java.util.Map;

public interface AdminService {

    void trackVisitor(String ipAddress);
    Map<LocalDate, Integer> getVisitorCount();
    int countTotalVisitors();
}
