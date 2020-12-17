package hu.uni.eku.tzs.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CellaDto
{
    private int cellaId;
    private boolean allapot;

}
