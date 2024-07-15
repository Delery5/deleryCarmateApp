package com.delerycarmate.dao.impl;

import com.delerycarmate.dao.AbstractDao;
import com.delerycarmate.dao.VehicleDao;
import com.delerycarmate.model.Vehicle;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("vehicleDao")
public class VehicleDaoImpl extends AbstractDao implements VehicleDao {

    public void saveVehicle(Vehicle vehicle) {
        persist(vehicle);
    }

    @SuppressWarnings("unchecked")
    public List<Vehicle> findAllVehicles() {
        Criteria criteria = getSession().createCriteria(Vehicle.class);
        return (List<Vehicle>) criteria.list();
    }

    public void deleteVehicleById(int id) {
        Query query = getSession().createQuery("delete from Vehicle where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    public Vehicle findById(int id) {
        Criteria criteria = getSession().createCriteria(Vehicle.class);
        criteria.add(Restrictions.eq("id", id));
        return (Vehicle) criteria.uniqueResult();
    }

    public void updateVehicle(Vehicle vehicle) {
        getSession().update(vehicle);
    }
}

