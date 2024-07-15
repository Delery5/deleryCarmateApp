package com.delerycarmate.dao.impl;

import com.delerycarmate.dao.AbstractDao;
import com.delerycarmate.dao.MaintenanceDao;
import com.delerycarmate.model.Maintenance;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("maintenanceDao")
public class MaintenanceDaoImpl extends AbstractDao implements MaintenanceDao {

    public void saveMaintenance(Maintenance maintenance) {
        persist(maintenance);
    }

    @SuppressWarnings("unchecked")
    public List<Maintenance> findAllMaintenances() {
        Criteria criteria = getSession().createCriteria(Maintenance.class);
        return (List<Maintenance>) criteria.list();
    }

    public void deleteMaintenanceById(int id) {
        Query query = getSession().createQuery("delete from Maintenance where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    public Maintenance findById(int id) {
        Criteria criteria = getSession().createCriteria(Maintenance.class);
        criteria.add(Restrictions.eq("id", id));
        return (Maintenance) criteria.uniqueResult();
    }

    public void updateMaintenance(Maintenance maintenance) {
        getSession().update(maintenance);
    }
}

