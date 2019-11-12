package bald.base.service;

import bald.base.dao.TbLabelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import bald.base.pojo.TbLabel;
import util.IdWorker;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 13548943514.
 * @date 2019/11/8.
 * @time 10:35.
 */
@Service
@Transactional
public class TbLabelService {
    @Autowired
    private TbLabelDao daoTbLabel;
    @Autowired
    private IdWorker idWorker;

    public List<TbLabel> findAll(){
        return daoTbLabel.findAll();
    }
    public TbLabel findById(String id){
        return daoTbLabel.findById(id).get();
    }
    public void save(TbLabel tbLabel){
        tbLabel.setId(idWorker.nextId()+"");
        daoTbLabel.save(tbLabel);
    }
    public void update(TbLabel tbLabel){
        daoTbLabel.save(tbLabel);
    }
    public void deleteById(String id){
        daoTbLabel.deleteById(id);
    }

    public List<TbLabel> findSearch(TbLabel tblabel) {
           return daoTbLabel.findAll(new Specification<TbLabel>() {
            @Override
            public Predicate toPredicate(Root<TbLabel> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                if(tblabel.getLabelname() != null && tblabel.getLabelname() !="") {
                    Predicate predicate=criteriaBuilder.like(root.get("labelname").as(String.class), "%" + tblabel.getLabelname() + "%");
                    list.add(predicate);
                }
                if(tblabel.getState() != null && tblabel.getState() != "") {
                    Predicate predicate=criteriaBuilder.like(root.get("state").as(String.class),tblabel.getLabelname());
                    list.add(predicate);
                }
                Predicate[] predicates = new Predicate[list.size()];
                list.toArray(predicates);
                return criteriaBuilder.and(predicates);
            }
        });
    }


    public Page<TbLabel> pageQuery(TbLabel tblabel, int page, int size) {
        Pageable pageble = PageRequest.of(page-1,size);
        return daoTbLabel.findAll(new Specification<TbLabel>() {
            @Override
            public Predicate toPredicate(Root<TbLabel> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                if(tblabel.getLabelname() != null && tblabel.getLabelname() !="") {
                    Predicate predicate=criteriaBuilder.like(root.get("labelname").as(String.class), "%" + tblabel.getLabelname() + "%");
                    list.add(predicate);
                }
                if(tblabel.getState() != null && tblabel.getState() != "") {
                    Predicate predicate=criteriaBuilder.like(root.get("state").as(String.class),tblabel.getLabelname());
                    list.add(predicate);
                }
                Predicate[] predicates = new Predicate[list.size()];
                list.toArray(predicates);
                return criteriaBuilder.and(predicates);
            }
        },pageble);
    }
}
