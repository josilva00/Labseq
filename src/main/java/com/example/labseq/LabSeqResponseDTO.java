package com.example.labseq;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;

/**
 * Data Transfer Object (DTO) for sending LabSeq related responses.
 * Contains utility methods to easily construct error and success responses.
 */
@Schema(description = "Data Transfer Object for LabSeq responses.")
public class LabSeqResponseDTO {

    // Message indicating the success or failure of the response


    // The original input value for which LabSeq was computed
    @Schema(description = "Inputed Value")
    @Size(min = 0)
    private long value;

    // The computed LabSeq result, set as "-1" in case of an error
    @Schema(description = "Labseq result if valid input or error message if invalid input")
    private String result;

    // ... (getters, setters, constructors...)


    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    /**
     * Construct an response DTO.
     *
     * @param result Labseq for given input or error message.
     * @param value The original input that caused the error.
     * @return A configured LabSeqResponseDTO object for the error.
     */
    public static LabSeqResponseDTO response(long value, String result) {
        LabSeqResponseDTO response = new LabSeqResponseDTO();
        response.setValue(value);
        response.setResult(result);
        return response;
    }

}
