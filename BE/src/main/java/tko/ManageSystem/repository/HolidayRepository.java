package tko.ManageSystem.repository;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import tko.ManageSystem.dto.HolidayDTO;

@Mapper
@Repository
public interface HolidayRepository {

    void insertHoliday(HolidayDTO holiday);
    List<HolidayDTO> findHoliday(Map<String, String> map);
    void removeHolidayTable();
}
