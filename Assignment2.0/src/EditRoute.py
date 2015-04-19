__author__ = 'MyPrecious'

from src import QueryData, GraphLibrary


def editnetwork():
    while(True):
        isValid = False
        cityList = QueryData.citylist()
        while(not isValid):

            user_city = raw_input("Type a valid city to edit, or type 0 or exit to quit")
            isValid = user_city in cityList
            if user_city == "exit" or user_city == "quit" or user_city == "q" or user_city == "0":
                return

        while(True):

            s = "Type the number for corresponding options:\n" \
                "1. Edit current city's code\n" \
                "2. Edit current city's country\n" \
                "3. Edit current city's continent\n" \
                "4. Edit current city's timezone\n" \
                "5. Edit current city's region\n" \
                "6. Edit current city's population\n" \
                "0. Quit"

            print s

            i = raw_input("Enter the number.")
            i = int(i)

            if i == 1:
                newcode = raw_input("Type the new code of the city.")
                editcode(user_city, newcode)

            elif i == 2:
                newcountry = raw_input("Type the new country of the city.")
                editcountry(user_city, newcountry)

            elif i == 3:
                newcont = raw_input("Type the new continent of the city.")
                editcontinent(user_city, newcont)

            elif i == 4:
                newzone = raw_input("Type the new timezone of the city.")
                edittimezone(user_city, newzone)

            elif i == 5:
                newreg = raw_input("Type the new region of the city.")
                editregion(user_city, newreg)

            elif i == 6:
                newpop = raw_input("Type the new population of the city.")
                editpop(user_city, newpop)

            elif i == 0:
                break

            else:
                print "Invalid Number!"


def removecity(city):

    del GraphLibrary.city_dictionary[city]

    # since the city is removed, we have to remove any route
    # which has the city as starting point
    code = QueryData.nametocode(city)
    for route in GraphLibrary.route_list:

        if code in route.startportcode:
            del route


def removeroute(city, city2):

    code = QueryData.nametocode(city)
    code2 = QueryData.nametocode(city2)
    isValid = False

    for route in GraphLibrary.route_list:
        if code in route.startportcode and code2 in route.endportcode:
            isValid = True
            del route
        elif code2 in route.startportcode and code in route.startportcode:
            isValid = True
            del route

    if isValid:
        print "Remove of route between " + city + " and " + city2 + " is successful."
    else:
        print "Remove unsuccessful."


def editcode(city, newcode):


    for city_name, city_info in GraphLibrary.city_dictionary.iteritems():

        if city_name == city:
            oldcode = city_info.code
            city_info.code = newcode

    print "Code change from " + oldcode + " to " + newcode + " is successful."


def editcountry(city, newcountry):

    for city_name, city_info in GraphLibrary.city_dictionary.iteritems():

        if city_name == city:
            oldcon = city_info.country
            city_info.country = newcountry

    print "Country change from " + oldcon + " to " + newcountry + " is successful."

def editcontinent(city, newcont):

    # check if the new city meets the requirement
    if newcont == "North America" or newcont == "South America" \
        or newcont == "Europe" or newcont == "Africa" \
            or newcont == "Asia" or newcont == "Australia":

        for city_name, city_info in GraphLibrary.city_dictionary.iteritems():

            if city_name == city:
                if city_info.continent == "North America":
                    GraphLibrary.NA.remove(city_info.name)
                elif city_info.continent == "South America":
                    GraphLibrary.SA.remove(city_info.name)
                elif city_info.continent == "Europe":
                    GraphLibrary.EU.remove(city_info.name)
                elif city_info.continent == "Africa":
                    GraphLibrary.Africa.remove(city_info.name)
                elif city_info.continent == "Asia":
                    GraphLibrary.Asia.remove(city_info.name)
                elif city_info.continent == "Australia":
                    GraphLibrary.Aust.remove(city_info.name)

                # Apply new continent
                if newcont == "North America":
                    city_info.continent == newcont
                    GraphLibrary.NA.append(city_info.name)
                elif newcont == "South America":
                    city_info.continent == newcont
                    GraphLibrary.SA.append(city_info.name)
                elif newcont == "Europe":
                    city_info.continent == newcont
                    GraphLibrary.EU.append(city_info.name)
                elif newcont == "Africa":
                    city_info.continent == newcont
                    GraphLibrary.Africa.append(city_info.name)
                elif newcont == "Asia":
                    city_info.continent == newcont
                    GraphLibrary.Asia.append(city_info.name)
                elif newcont == "Australia":
                    city_info.continent == newcont
                    GraphLibrary.Aust.append(city_info.name)
                print "Continent change from is successful."
    else:
        print "Invalid continent input."

def edittimezone(city, newzone):

    for city_name, city_info in GraphLibrary.city_dictionary.iteritems():

        if city_name == city:
            oldtime = city_info.timezone
            city_info.timezone = newzone

    print "Timezone change from " + str(oldtime) + " to " + str(newzone) + " is successful."


def editregion(city, newregion):

    for city_name, city_info in GraphLibrary.city_dictionary.iteritems():

        if city_name == city:
            oldregion = city_info.region
            city_info.region = newregion

    print "Region change from " + str(oldregion) + " to " + str(newregion) + " is successful."

def editpop(city, newpop):

    for city_name, city_info in GraphLibrary.city_dictionary.iteritems():

        if city_name == city:
            oldpop = city_info.population
            city_info.population = newpop

    print "Population change from " + str(oldpop) + " to " + str(newpop) + " is successful."

def addnetwork():

    while(True):

        cityList = QueryData.citylist()
        s = "Type the number for corresponding options:\n" \
            "1. Remove a city\n" \
            "2. Remove a route\n" \
            "3. Add a city\n" \
            "4. Add a route\n" \
            "0. Quit"

        print s

        i = raw_input("Enter the number.")
        i = int(i)

        if i == 1:

            isValid = False
            while(not isValid):
                print "Type a valid city to remove, or type 0 or exit to quit"
                user_city = raw_input()
                isValid = user_city in cityList
                if user_city == "exit" or user_city == "quit" or user_city == "q" or user_city == "0":
                    return

            removecity(user_city)

        elif i == 2:

            isValid = False
            while(not isValid):
                print "Type the first valid city of route."
                user_city = raw_input()
                isValid = user_city in cityList
                if user_city == "exit" or user_city == "quit" or user_city == "q" or user_city == "0":
                    return
            isValid = False
            while(not isValid):
                city2 = raw_input("Type the second valid city of route.")
                isValid = city2 in cityList


            removeroute(user_city, city2)

        elif i == 3:
            newcode = raw_input("Type the new code of city.")
            newname = raw_input("Type the new name of city.")
            newcountry = raw_input("Type the new country of city.")
            newcont = raw_input("Type the new continent of city.")
            newzone = raw_input("Type the new timezone of city.")
            newcoord1 = raw_input("Type the Latitude of city.")
            newcoord2 = raw_input("Type the longitude of city.")
            newpop = raw_input("Type the population of city.")
            newdist = raw_input("Type the distance of city.")
            newreg = raw_input("Type the region of city.")

            newpop = int(newpop)
            newdist = int(newdist)
            newreg = int(newreg)
            if newpop > 0 and newdist > 0 and newreg > 0:
                addcity(newcode, newname, newcountry, newcont, newzone, newcoord1, newcoord2, newpop, newreg)
            else:
                print "Invalid info on population/distance/region."

        elif i == 4:
            isValid = False
            while not isValid:
                print "Type the first valid city of new route, or type exit to quit."
                city1 = raw_input()
                isValid = city1 in cityList
                if city1 == "exit" or city1 == "quit" or city1 == "q" or city1 == "0":
                    return

            isValid = False
            while not isValid:
                city2 = raw_input("Type the second valid city of route.")
                isValid = city2 in cityList
                if city2 == "q" or city2 == "exit":
                    return


            newdist = raw_input("Type the distance of city.")
            newdist = int(newdist)
            newstart = QueryData.nametocode(city1)
            newend = QueryData.codetoname(city2)

            if newdist > 0:
                addroute(newstart, newend, newdist)
            else:
                print "Invalid distance."

        elif i == 0:
            break

        else:
            print "Invalid Number!"

def addcity(code, name, country, cont, zone, coord1, coord2, pop, reg):

    if cont == "North America":
        GraphLibrary.NA.append(name)
    elif cont == "South America":
        GraphLibrary.SA.append(name)
    elif cont == "Europe":
        GraphLibrary.EU.append(name)
    elif cont == "Africa":
        GraphLibrary.Africa.append(name)
    elif cont == "Asia":
        GraphLibrary.Asia.append(name)
    elif cont == "Australia":
        GraphLibrary.Aust.append(name)
    else:
        print("Wrong continent.")
        return

    coord = {"N": coord1, "E": coord2}

    city_info = GraphLibrary.City(code, name, country, cont, zone, coord, pop, reg)

    GraphLibrary.city_dictionary[name] = city_info

    print  name + " has been added successfully."

def addroute(start, end, dist):

        source_to_dest = GraphLibrary.Route(start, end, dist)
        dest_to_source = GraphLibrary.Route(end, start, dist)

        GraphLibrary.route_list.append(source_to_dest)
        GraphLibrary.route_list.append(dest_to_source)

        QueryData.addhubcity(start)
        QueryData.addhubcity(end)