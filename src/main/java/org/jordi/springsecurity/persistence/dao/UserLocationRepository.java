package org.jordi.springsecurity.persistence.dao;

import org.jordi.springsecurity.persistence.model.User;
import org.jordi.springsecurity.persistence.model.UserLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLocationRepository extends JpaRepository<UserLocation, Long> {
    UserLocation findByCountryAndUser(String country, User user);

}
