package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 13548943514.
 * @date 2019/11/7.
 * @time 15:23.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {
    private boolean flag;
    private Integer code;
    private String message;
    private  T data;

}
