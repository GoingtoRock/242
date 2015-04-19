__author__ = 'MyPrecious'

import RouteInfo, EditRoute, SaveFile, QueryData, MapParser, GraphLibrary

MapParser.MapParser()

s = "Type the number for corresponding options:\n" \
    "1. Get all the cities from CSAir\n" \
    "2. Get a specific information about one city\n" \
    "3. Get all kinds of stats\n" \
    "4. Get a specific route\n" \
    "5. Edit the current city's information\n" \
    "6. Add/Remove cities and routes\n" \
    "7. Save the changed list to JSON File\n" \
    "8. Calculuate the total flight\n" \
    "9. Update CSAir with new Champaign hub town\n" \
    "10. Calculate the shortest route between to cities.\n" \
    "0. Exit the program"

while True:

    print s

    i = raw_input("Enter the number.")
    i = int(i)
    if i == 1:
        cityList = QueryData.citylist()
        print "Here are the lists!"
        for city in cityList:
            print city

    elif i == 2:
        city_name = raw_input("Enter the city name.")

        valid = QueryData.getcitydata(city_name)

        if valid == False :
            print "No such city."

    elif i == 3:
        QueryData.getstat()

    elif i == 4:
        city_code = raw_input("Enter the city code.")

        valid = QueryData.getroute(city_code)

        if valid == False :
            print "No such code."

    elif i == 5:
        EditRoute.editnetwork()

    elif i == 6:
        EditRoute.addnetwork()

    elif i == 7:
        SaveFile.saveFile()

    elif i == 8:
        RouteInfo.routeinfo()

    elif i == 9:
        MapParser.newMapParser()

    elif i == 10:
        RouteInfo.shortestroute()

    elif i == 0:
        print "See ya!"
        break

    else:
        print "Invalid Number!"

