package com.astra_life.testing.backend.repositories;

import com.astra_life.testing.backend.models.UserModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends PagingAndSortingRepository<UserModel, Long> {

}
