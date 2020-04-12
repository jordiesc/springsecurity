package org.jordi.springsecurity.persistence.dao;

import org.jordi.springsecurity.persistence.model.NewLocationToken;
import org.jordi.springsecurity.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewLocationTokenRepository extends JpaRepository<NewLocationToken, Long> {

    NewLocationToken findByToken(String token);

    NewLocationToken findByUserLocation(User userLocation);

}
