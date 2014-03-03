import chained.selects.City
import chained.selects.Continent
import chained.selects.Country

class BootStrap {

    def init = { servletContext ->
        def asia = Continent.findOrCreateByContinent('Asia');
        asia.addToCountries(new Country(country: 'China'))
        asia.addToCountries(new Country(country: 'India'))
        asia.save()

        def china = Country.findByCountry('China')
        china?.addToCities(new City(city: 'Beijing'))
        china?.addToCities(new City(city: 'Shanghai'))
        china?.addToCities(new City(city: 'Hong Kong'))
        china.save()

        def india = Country.findByCountry('India')
        india?.addToCities(new City(city: 'Mumbai'))
        india?.addToCities(new City(city: 'Delhi'))
        india?.addToCities(new City(city: 'Bangalore'))
        india.save()

        def southAmerica = Continent.findOrCreateByContinent('South America');
        southAmerica.addToCountries(new Country(country: 'Argentina'))
        southAmerica.addToCountries(new Country(country: 'Brazil'))
        southAmerica.save()

        def northAmerica = Continent.findOrCreateByContinent('North America');
        northAmerica.addToCountries(new Country(country: 'Belize'))
        northAmerica.addToCountries(new Country(country: 'United States'))
        northAmerica.save()

        def belize = Country.findByCountry('Belize')
        belize.addToCities(new City(city: 'Belize City'))
        belize.addToCities(new City(city: 'Belmopan City'))
        belize.save()

        def usa = Country.findByCountry('United States')
        usa.addToCities(new City(city: 'New York'))
        usa.addToCities(new City(city: 'Chicago'))
        usa.addToCities(new City(city: 'Dallas'))
        usa.addToCities(new City(city: 'Miami'))
        usa.addToCities(new City(city: 'Denver'))
        usa.addToCities(new City(city: 'Los Angeles'))
        usa.save()
    }
    def destroy = {
    }
}
