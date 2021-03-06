package com.srj9.service

import com.srj9.model.SportOfficer
import com.srj9.repository.SportOfficerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class SportOfficerService {

    @Autowired
    lateinit var sportOfficerRepository: SportOfficerRepository

    fun getAllSportOfficers(): List<SportOfficer> {
        return sportOfficerRepository.findAll()
    }

    fun createSportOfficer(sportOfficer: SportOfficer): SportOfficer {
        return sportOfficerRepository.save(sportOfficer)
    }

    fun deleteSportOfficer(sportOfficerId: Long) {
        return sportOfficerRepository.deleteById(sportOfficerId)
    }

    fun updateSportOfficer(newSportOfficer: SportOfficer, sportOfficerId: Long): SportOfficer {
        assert(newSportOfficer.id == sportOfficerId)
        return sportOfficerRepository.save(newSportOfficer)
    }
}