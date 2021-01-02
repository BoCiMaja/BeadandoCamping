package hu.uni.eku.tzs.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CellaDto
{
    private Integer cellaId;
    private boolean allapot;

}
