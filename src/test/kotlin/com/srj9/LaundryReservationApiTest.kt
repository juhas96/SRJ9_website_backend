package com.srj9

import com.srj9.enums.Status
import com.srj9.model.LaundryReservation
import com.srj9.service.LaundryReservationService
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.sql.Timestamp
import java.util.*
import kotlin.test.assertNotNull


@SpringBootTest
@RunWith(SpringRunner::class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class LaundryReservationApiTest {

    @Autowired lateinit var laundryReservationService: LaundryReservationService

    @Test
    fun createNewLaundryReservation() {
        val newLaundryReservation = laundryReservationService.createLaundryReservation(LaundryReservation(0L,"3123131", Date(), null,null, Status.RESERVED))
        println(newLaundryReservation)
        assertNotNull(newLaundryReservation)
    }

    @Test
    fun getAllLaundryReservations() {
        laundryReservationService.createLaundryReservation(LaundryReservation(0L,"3123131", Date(), null,null, Status.RESERVED))
        val reservations = laundryReservationService.getAllLaundryReservations()
        println(reservations.size)
        assertNotNull(reservations)
    }

    @Test
    fun getSingleLaundryReservation() {
        laundryReservationService.createLaundryReservation(LaundryReservation(0L,"3123131", Date(), null,null, Status.RESERVED))
        val singleReservation = laundryReservationService.getSingleLaundryReservation(1L)
        println(singleReservation)
        assertNotNull(singleReservation)
    }

    @Test
    fun updateExistingReservation() {
        laundryReservationService.createLaundryReservation(LaundryReservation(0L,"3123131", Date(), null,null, Status.RESERVED))
        val updatedReservation = laundryReservationService.updateExistingLaundryReservation(LaundryReservation(0L,"555555", Date(), null,null, Status.RESERVED),1L)
        println(updatedReservation)
        assertNotNull(updatedReservation)
    }

    @Test
    fun deleteExistingReservation() {
        laundryReservationService.createLaundryReservation(LaundryReservation(0L,"3123131", Date(), null,null, Status.RESERVED))
        val deletedReservation = laundryReservationService.deleteLaundryReservation(1L)
        println(deletedReservation)
        assert(deletedReservation.statusCode.is2xxSuccessful)
    }

    @Test
    fun getAllReservationsBetweenDates() {
        laundryReservationService.createLaundryReservation(LaundryReservation(
                0,null,Date(), Timestamp.valueOf("2019-11-15 15:30:00"), Timestamp.valueOf("2019-11-15 16:30:00"),Status.RESERVED, null, null
        ))
        val reservations = laundryReservationService.getAllReservationsForCurrentWeek()
        println(reservations)
        assertNotNull(reservations)
    }
}
