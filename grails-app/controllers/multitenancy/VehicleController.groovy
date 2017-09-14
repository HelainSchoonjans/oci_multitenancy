package multitenancy

import groovy.transform.CompileStatic
import org.grails.datastore.mapping.multitenancy.web.SessionTenantResolver

@CompileStatic
class VehicleController {

    VehicleService vehicleService

    def index() {
        [vehicleList: vehicleService.findAllVehicleNames()]
    }

    def manufacturer(String name) {
        session.setAttribute(SessionTenantResolver.ATTRIBUTE, name.toLowerCase())
        redirect action: 'index'
    }
}