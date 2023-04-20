package tko.ManageSystem.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface CalendarRepository {
    List<Integer> getUserAnnualData(int month);
}
