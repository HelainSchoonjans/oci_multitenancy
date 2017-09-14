package multitenancy

import grails.gorm.multitenancy.Tenants
import groovy.transform.CompileStatic

@CompileStatic
class BootStrap {

    VehicleService vehicleService

    def init = { servletContext ->
        Tenants.withId('audi') {
            vehicleService.saveVehicle([name: 'Audi A3', year: 1996])
            vehicleService.saveVehicle([name: 'Audi A4', year: 1994])
        }
        Tenants.withId('ford') {
            vehicleService.saveVehicle([name: 'Ford KA', year: 1996])
        }
    }

    def destroy = {
    }
}
