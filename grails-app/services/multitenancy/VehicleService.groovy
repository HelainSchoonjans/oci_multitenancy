package multitenancy

import grails.gorm.multitenancy.CurrentTenant
import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j

@Slf4j
@CompileStatic
@CurrentTenant
class VehicleService {

    @ReadOnly
    List<String> findAllVehicleNames() {
        Vehicle.where { }.projections {
            property('name')
        }.list() as List<String>
    }

    @Transactional
    protected Vehicle saveVehicle(Map m) {
        Vehicle vehicle = new Vehicle(m)
        if (!vehicle.save()) {
            log.error 'Unable to solve vehicle {}', vehicle.errors.toString()
        }
        vehicle
    }

}