package chained.selects

class City {

    static belongsTo = [country: Country]

    String city

    static constraints = {
        city blank: false
    }

    String toString() {
        city
    }

    static mapping = {
        sort "city"
    }
}
