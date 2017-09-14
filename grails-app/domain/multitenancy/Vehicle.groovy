package multitenancy

import grails.compiler.GrailsCompileStatic
import grails.gorm.MultiTenant

@GrailsCompileStatic
class Vehicle implements MultiTenant<Vehicle> {
    String name
    Integer year
    String manufacturerName

    static constraints = {
        name nullable: false, blank: false
        manufacturerName nullable: true
        year nullable: false
    }

    static mapping = {
        tenantId name: 'manufacturerName'
    }
}