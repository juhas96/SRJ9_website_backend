package com.srj9.repository

import com.srj9.model.SportOfficer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SportOfficerRepository: JpaRepository<SportOfficer, Long> {
}