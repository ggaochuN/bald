package bald.base.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import bald.base.pojo.TbLabel;

/**
 * @author 13548943514.
 * @date 2019/11/8.
 * @time 10:33.
 */
public interface TbLabelDao extends JpaRepository<TbLabel,String>, JpaSpecificationExecutor<TbLabel> {
}
