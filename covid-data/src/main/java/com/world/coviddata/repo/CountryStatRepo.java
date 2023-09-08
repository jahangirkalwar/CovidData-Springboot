package com.world.coviddata.repo;

import com.world.coviddata.entity.CountryStat;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CountryStatRepo extends JpaRepository<CountryStat, UUID> {

}
