package dev.mhshahin.demosmallcompany.dto.rsponsedto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

import static dev.mhshahin.demosmallcompany.utils.Constants.DTO_DATE_TIME_FORMAT;

@Getter
@Setter
public class BaseResponseDTO {
    private UUID id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DTO_DATE_TIME_FORMAT)
    private LocalDateTime createTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DTO_DATE_TIME_FORMAT)
    private LocalDateTime updateTime;

    private String createdBy;

    private String updatedBy;

    private boolean active;
}
