package bald.base.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tb_label")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbLabel implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;
  private String labelname;
  private String state;
  private long count;
  private String recommend;
  private long fans;

}
