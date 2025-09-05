package com.btsbooking.btsconcert.repository;

import com.btsbooking.btsconcert.model.VipPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VipPackageRepository extends JpaRepository<VipPackage, Long> {
}
