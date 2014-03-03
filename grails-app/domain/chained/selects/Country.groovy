package chained.selects

class Country {

    static belongsTo = [continent: Continent]
    static hasMany = [cities: City]

    String country

    static constraints = {
        country blank: false, unique: true
    }

    String toString() {
        country
    }

    static mapping = {
        sort "country"
    }
}
