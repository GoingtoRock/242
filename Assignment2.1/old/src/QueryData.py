__author__ = 'MyPrecious'

import webbrowser

import GraphLibrary


def citylist():
    cities = []
    for city in GraphLibrary.city_dictionary:
        cities.append(city)
    return cities

def longestflight():
    longest = 0
    for route in GraphLibrary.route_list:
        if route.distance > longest:
            longest = route.distance

    GraphLibrary.longestSingleFlight = longest
    return GraphLibrary.longestSingleFlight

def shortestflight():

    shortest = 0
    for route in GraphLibrary.route_list:

        if shortest == 0:
            shortest = route.distance

        elif route.distance < shortest:
            shortest = route.distance


    GraphLibrary.shortestSingleFlight = shortest
    return GraphLibrary.shortestSingleFlight

def averagedistance():
    dist = 0
    count = 0
    for route in GraphLibrary.route_list:
        dist += route.distance
        count += 1

    GraphLibrary.averageDistance = dist/count
    return GraphLibrary.averageDistance

def biggestcity():

    biggest = 0
    for city_name, city_info in GraphLibrary.city_dictionary.iteritems():
        if city_info.population > biggest:
            biggest = city_info.population

    GraphLibrary.biggestCity = biggest
    return GraphLibrary.biggestCity

def smallestcity():

    smallest = 0
    for city_name, city_info in GraphLibrary.city_dictionary.iteritems():

        if smallest == 0:
            smallest = city_info.population
        elif city_info.population < smallest:
            smallest = city_info.population

    GraphLibrary.smallestCity = smallest
    return GraphLibrary.smallestCity

def averagecitysize():

    size = 0
    count = 0
    for city_info in GraphLibrary.city_dictionary.itervalues():
        size += city_info.population
        count += 1
    GraphLibrary.averageCitySize = size/count
    return GraphLibrary.averageCitySize

def hubcitylist():

    hub_max = 0
    hub_list = []
    for route_count in GraphLibrary.hubCity.itervalues():
        if route_count > hub_max:
            hub_max = route_count

    for city_code, connections in GraphLibrary.hubCity.iteritems():
        if connections == hub_max:
            hub_list.append(codetoname(city_code))

    return hub_list

def codetoname(city_code):
    for code, name in GraphLibrary.code_to_name.iteritems():
        if code == city_code:
            return name

def nametocode(city_name):
    for code, name in GraphLibrary.code_to_name.iteritems():
        if name == city_name:
            return code

def continentlist(continent_list):
    continent = ""
    for item in continent_list:
        continent = continent + item + ', '
    return continent

def addhubcity(city_code):
    if city_code in GraphLibrary.hubCity:
        GraphLibrary.hubCity[city_code] += 1
    else:
        GraphLibrary.hubCity[city_code] = 0


def dest_city(source_city):
    source_code = nametocode(source_city)

    dest_list = {}
    for route in GraphLibrary.route_list:
        if route.startportcode == source_code:
            end_code = route.endportcode
            end_city = codetoname(end_code)
            dest_list[end_city] = route.distance

    return dest_list




def getroute(city_code):
    url = "http://www.gcmap.com/mapui?P="

    validUrl = False
    for item in GraphLibrary.route_list:
        if item.startportcode == city_code:
            url = url + city_code + '-' + item.endportcode + ','
            validUrl = True

    if validUrl == True:
        webbrowser.open_new_tab(url)
    return validUrl

def getstat():
    msg = "The longest flight length(miles): " + str(longestflight()) + "\n"
    msg += "The shortest flight length(miles): " + str(shortestflight())+ "\n"
    msg += "The average distance(miles): " + str(averagedistance())+ "\n"
    msg += "The city with biggest population: " + str(biggestcity())+ "\n"
    msg += "The city with smallest population : " + str(smallestcity())+ "\n"
    msg += "The average population of all cities: " + str(averagecitysize()) + "\n"

    msg += "Cities from North America:" + "\n"
    msg += continentlist(GraphLibrary.NA) + "\n"
    msg += "Cities from South America:" + "\n"
    msg += continentlist(GraphLibrary.SA) + "\n"
    msg += "Cities from Asia:" + "\n"
    msg += continentlist(GraphLibrary.Asia) + "\n"
    msg += "Cities from Europe:" + "\n"
    msg += continentlist(GraphLibrary.EU) + "\n"
    msg += "Cities from Africa:" + "\n"
    msg += continentlist(GraphLibrary.Africa) + "\n"
    msg += "Cities from Australia:" + "\n"
    msg += continentlist(GraphLibrary.Aust) + "\n"

    hub_list = hubcitylist()
    msg += "Hub city list" + "\n"
    for item in hub_list:
        msg += item + "\n"

    print msg




def getcitydata(city_name):
    for cityName in GraphLibrary.city_dictionary:
        if city_name == cityName:
            cityData = GraphLibrary.city_dictionary[cityName]
            msg = "The city's information\n"
            msg += "Name: " + cityData.name + "\n"
            msg += "Code: " + cityData.code + "\n"
            msg += "Country: " + cityData.country + "\n"
            msg += "Timezone: " + str(cityData.timezone)
            print msg

            coord_list = []
            for n, m in cityData.coordinates.iteritems():
                coord = str(n) + ': ' + str(m)
                coord_list.append("Coordinates: " + coord)
            print coord_list

            print "Population: " + str(cityData.population)
            print "Region: " + str(cityData.region)


            fly_list = dest_city(cityName)
            print "Destination and distance: "
            for destCity, distance in fly_list.iteritems():
                print  destCity + ': ' + str(distance) + " miles"
            return True

    # if there is nothing
    return False

