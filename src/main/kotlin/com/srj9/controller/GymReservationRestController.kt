package com.srj9.controller

import com.srj9.service.GymReservationService
import com.srj9.model.GymReservation
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
@Api(value = "gym_reservations", description = "Reservation system for Gym")
class GymReservationRestController {

    @Autowired
    lateinit var gymReservationService: GymReservationService

    @ApiOperation(value = "Retreive all gym reservations", notes = "Retrieves all gym reservations", responseContainer = "List")
    @ApiResponse(code = 200, message = "Successfully retrieved list of gym reservations")
    @CrossOrigin(origins = arrayOf("http://localhost:4200"))
    @GetMapping("/gym_reservation")
    fun getAllGymReservations(): List<GymReservation> {
        return gymReservationService.getAllGymReservations()
    }

    @ApiOperation(value = "Retrieve single gym reservation", notes = "Retrieves single gym reservation based on reservation ID")
    @ApiResponses(
        ApiResponse(code = 200, message = "Successfully retrieved single gym reservation"),
        ApiResponse(code = 404, message = "Reservation is not found"),
        ApiResponse(code = 500, message = "Internal Server Error")
    )
    @CrossOrigin(origins = arrayOf("http://localhost:4200"))
    @GetMapping("/gym_reservation/{reservationId}")
    fun getSingleGymReservation(@PathVariable reservationId: Long): GymReservation {
        return gymReservationService.getSingleGymReservation(reservationId)
    }

    @ApiOperation(value = "Create a new gym reservation", notes = "The newly created reservation object will be sent as the response")
    @ApiResponses(
            ApiResponse(code = 201, message = "Reservation successfully created"),
            ApiResponse(code = 400, message = "Input validation failed"),
            ApiResponse(code = 500, message = "Internat Server Error")
    )
    @CrossOrigin(origins = arrayOf("http://localhost:4200"))
    @PostMapping("/gym_reservation")
    fun createGymReservation(@Valid @RequestBody gymReservation: GymReservation) : GymReservation {
        return gymReservationService.createGymReservation(gymReservation)
    }

    @ApiOperation(value = "Update gym reservation", notes = "Updates gym reservation specified by reservationId with content in request body")
    @ApiResponses(
            ApiResponse(code = 200, message = "Reservation successfully updated"),
            ApiResponse(code = 404, message = "Reseration not found"),
            ApiResponse(code = 500, message = "Internal Server Error")
    )
    @CrossOrigin(origins = arrayOf("http://localhost:4200"))
    @PutMapping("/gym_reservation/{reservationId}")
    fun updateExistingGymReservation(@RequestBody gymReservation: GymReservation, @PathVariable reservationId: Long): ResponseEntity<GymReservation> {
        return gymReservationService.updateExistingGymReservation(gymReservation,reservationId)
    }

    @ApiOperation(value = "Delete gym reservation", notes = "Delete gym reservation specified by reservationId")
    @ApiResponses(
            ApiResponse(code = 200, message = "Reservation successfully deleted"),
            ApiResponse(code = 404, message = "Reservation not found"),
            ApiResponse(code = 500, message = "Internal Server Error")
    )
    @CrossOrigin(origins = arrayOf("http://localhost:4200"))
    @DeleteMapping("/gym_reservation/{reservationId}")
    fun deleteExistingGymReservation(@PathVariable reservationId: Long): ResponseEntity<Void> {
        return gymReservationService.deleteGymReservation(reservationId)
    }
}