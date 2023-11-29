package com.GreenCodeSolution.CollectionOfData.dto.response.paginated;

import com.GreenCodeSolution.CollectionOfData.dto.response.RespomseClientDto;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedClientResponseDto {

    private long count;
    private List<RespomseClientDto> dataList;
}
