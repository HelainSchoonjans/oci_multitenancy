package multitenancy

import geb.spock.GebSpec
import grails.testing.mixin.integration.Integration

@Integration
class VehicleControllerSpec extends GebSpec {

    def "if you change tenant, a different vehicle list is returned"() {
        when: 'Set tenant to audi and retrieve names displayed in the page'
        browser.go "http://localhost:$serverPort/vehicle/manufacturer?name=audi"
        List<String> names = browser.$('#vehicleList li').collect { it.text() }

        then:
        names == ['Audi A3', 'Audi A4']

        when: 'Set tenant to ford and retrieve names displayed in the page'
        browser.go "http://localhost:$serverPort/vehicle/manufacturer?name=ford"
        names = browser.$('#vehicleList li').collect { it.text() }

        then:
        names == ['Ford KA']
    }
}
