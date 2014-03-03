package chained.selects

import grails.converters.JSON
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CountryController {


    def index(Country countryInstance) {
        render countryInstance?.cities?.sort { it.city }?.collect { [id: it.id, city: it.city] } as JSON
    }
}
