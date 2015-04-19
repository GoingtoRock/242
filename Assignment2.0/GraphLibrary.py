__author__ = 'MyPrecious'

# specific information about a specific city in the CSAir route network
class City:

    def __init__(self, code, name, country, continent, timezone, coordinates, population, region):
        self.code = code
        self.name = name
        self.country = country
        self.continent = continent
        self.timezone = timezone
        self.coordinates = coordinates;
        self.population = population;
        self.region = region;
        self.flights = {}

class Route:

    def __init__(self, startportcode, endportcode, distance):
        self.startportcode = startportcode
        self.endportcode = endportcode
        self.distance = distance


# Statistical information about CSAir's route network

longestSingleFlight = 0
shortestSingleFlight = 0
averageDistance = 0
biggestCity = 0
smallestCity = 0
averageCitySize = 0
hubCity = {}

# Stat helpers

city_dictionary = {}
route_list = []
code_to_name = {}

NA = []
SA = []
EU = []
Asia = []
Africa = []
Aust = []

