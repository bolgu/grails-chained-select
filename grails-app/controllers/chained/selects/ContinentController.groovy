package chained.selects

import grails.converters.JSON
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ContinentController {


    def index(Continent continentInstance) {
        render continentInstance?.countries?.sort { it.country }?.collect { [id: it.id, country: it.country] } as JSON
    }


}
