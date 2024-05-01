package com.jd.graphql.Repository;

import com.jd.graphql.Model.Order;
import com.jd.graphql.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
}
