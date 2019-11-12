package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 13548943514.
 * @date 2019/11/7.
 * @time 16:17.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> {
    private  long total;
    private List<T> rows;

}
