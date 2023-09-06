package com.example.labseq;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;


/**
 * LabSeqController handles HTTP requests related to the LabSeq sequence calculations.
 * This controller provides endpoints to fetch LabSeq values for given numbers.
 */

@RestController
@RequestMapping("/labseq")
@Tag(name = "Labseq", description = "Get Labseq for input n")
public class LabSeqController {

    @Autowired
    private LabSeqService labseqService;


    /**
     * Get the LabSeq value for the specified number.
     * @param n The number for which the LabSeq value is to be calculated.
     * @return A response containing the LabSeq value or an error if the number is negative.
     */
    @Operation(
            summary = "Calculate Labseq for given n",
            description = "Get a Response object. The response contains the original input and, if valid input, the computed labseq, otherwise, an error message ."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description  = "Successfully retrieved LabSeq value"),
            @ApiResponse(responseCode  = "400", description  = "Invalid input provided")
    })
    @GetMapping("/{n}")
    public ResponseEntity<LabSeqResponseDTO> getLabSeqValue(@Parameter(description = "Positive number")@PathVariable int n) {

        // Check if provided number is negative and return an error response
        if (n < 0) {
            return new ResponseEntity<>(LabSeqResponseDTO.response(n, "ERROR: Number must be non-negative"), HttpStatus.BAD_REQUEST);
        }

        // Calculate the LabSeq value using the service
        BigInteger result = labseqService.calculateLabSeq(n);

        // Return a success response with the LabSeq value
        return ResponseEntity.ok(LabSeqResponseDTO.response(n,result.toString()));
    }
}