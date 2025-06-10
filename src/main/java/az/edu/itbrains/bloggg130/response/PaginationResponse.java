package az.edu.itbrains.bloggg130.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginationResponse <TEntity>{
    private TEntity data;
    private long pageSize;
}
