package org.edu.ifmg.client.utility;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ApiResponseCode {
    SUCCESS(200,"Succcessfully finished"),
    CREATED(201,"Succcessfully Created"),
    BAD_REQUEST(400,"Bad Request"),
    NOT_FOUND(404,"Not Found"),
    NO_CONTENT(204,"No content");
    private Integer id;
    private String description;
}
