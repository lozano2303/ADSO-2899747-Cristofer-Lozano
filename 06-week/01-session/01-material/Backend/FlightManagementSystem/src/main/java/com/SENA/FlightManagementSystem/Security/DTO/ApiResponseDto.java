package com.SENA.FlightManagementSystem.Security.DTO;

/**
 * This class represents a generic API response.
 * @param <T> The type of entity data contained in the response.
 * @param <D> The type of DTO data contained in the response.
 */
public class ApiResponseDto<T, D> {

    private Boolean status;
    private T entityData;
    private D dtoData;
    private String message;

    /**
     * Default constructor.
     */
    public ApiResponseDto() {
    }

    /**
     * Constructs an ApiResponseDto with entity data.
     * @param message The message describing the response.
     * @param entityData The entity data contained in the response.
     * @param status The status of the response.
     */
    public ApiResponseDto(String message, T entityData, Boolean status) {
        this.message = message;
        this.entityData = entityData;
        this.status = status;
    }

    /**
     * Constructs an ApiResponseDto with DTO data.
     * @param message The message describing the response.
     * @param dtoData The DTO data contained in the response.
     * @param status The status of the response.
     * @param isDto Flag to indicate this is DTO data.
     */
    public ApiResponseDto(String message, D dtoData, Boolean status, boolean isDto) {
        this.message = message;
        this.dtoData = dtoData;
        this.status = status;
    }

    /**
     * Retrieves the status of the response.
     * @return The status of the response.
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * Sets the status of the response.
     * @param status The status of the response.
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * Retrieves the entity data contained in the response.
     * @return The entity data contained in the response.
     */
    public T getEntityData() {
        return entityData;
    }

    /**
     * Sets the entity data contained in the response.
     * @param entityData The entity data contained in the response.
     */
    public void setEntityData(T entityData) {
        this.entityData = entityData;
    }

    /**
     * Retrieves the DTO data contained in the response.
     * @return The DTO data contained in the response.
     */
    public D getDtoData() {
        return dtoData;
    }

    /**
     * Sets the DTO data contained in the response.
     * @param dtoData The DTO data contained in the response.
     */
    public void setDtoData(D dtoData) {
        this.dtoData = dtoData;
    }

    /**
     * Retrieves the message describing the response.
     * @return The message describing the response.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message describing the response.
     * @param message The message describing the response.
     */
    public void setMessage(String message) {
        this.message = message;
    }
}