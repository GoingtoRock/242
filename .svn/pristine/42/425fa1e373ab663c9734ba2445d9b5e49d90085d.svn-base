__author__ = 'MyPrecious'

import math

import QueryData, GraphLibrary


def routeinfo():

    cityList = QueryData.citylist()
    isValid = False
    while not isValid:
        print "Type the first valid city of new route."
        startcity = raw_input()
        isValid = startcity in cityList
        if startcity == "exit" or startcity == "quit" or startcity == "q" or startcity == "0":
            return

    legs = []
    stops = []

    # Gather dest city
    while(True):
        isValid = False
        while not isValid:
            endcity = raw_input("Type the next valid city of route, or type exit to end")
            isValid = endcity in cityList or endcity == "exit" or endcity == "q"
            if not isValid:
                print "Wrong city. Not counted."

        if endcity == "exit" or endcity == "q":
            break

        stops.append(endcity)
        startcode = QueryData.nametocode(startcity)
        endcode = QueryData.nametocode(endcity)
        for route in GraphLibrary.route_list:

            if route.startportcode == startcode and \
            route.endportcode == endcode:

                dist = route.distance
                legs.append(dist)
                stops.append(endcode)
                break

        startcity = endcity

    # after getting all the list
    print "Total Distance = " + str(totaldistance(legs)) + " km"
    print "Total Cost = $" + str(totalcost(legs))
    print "Total Time = " + str(totaltime(legs, stops)) + " hrs"

def totaldistance(legs):

    sum = 0
    for leg in legs:
        sum += leg
    return sum

def totalcost(legs):

    cost = legs[0] * .35
    for i in range(1, len(legs)):
        cost -= legs[i] * .05
    if cost <= 0:
        cost = 0
    return cost

def totaltime(legs, stops):

    time = 0
    # from |v|^2 = |v0|^2 + 2as,
    # a = (|v|^2 - |v0|^2) / 2s = 750^2 / 2*200 = 1406.25
    a = 1406.25 #km/hr^2

    for i in range(len(legs)):

        # when the total distance is below 400
        if legs[i] < 400:
            d = legs[i]/2
            time = math.sqrt((2 * d) / a)
            time += time * 2

        else:
            time += math.sqrt((2 * 400) / a)
            d = legs[i] - 400
            time += d / 750

        # layover
        outboundFlights = 0
        if i + 2 < len(stops):
            for route in GraphLibrary.route_list:
                if route.startportcode == stops[i]:
                    outboundFlights += 1

            # 10 min = 1 hour / 6
            time += 2 - outboundFlights/6

    return time


def mindist(self, source, dest):
    path = self.graph.minDistance((self.graph.findNode(source)),
                                          (self.graph.findNode(dest)))
    print path[0].name + " , " + path[1].name


def shortestroute():

    start = ""
    finish = ""

    cityList = QueryData.citylist()
    isValid = False
    while not isValid:
        start = raw_input("Type a departing city or type exit to quit.")
        isValid = start in cityList
        if start == "q" or start == "exit":
            return

    isValid = False
    while not isValid:

        end = raw_input("Type an arriving city or type exit to quit.")
        isValid = start in cityList
        if start == "q" or start == "exit":
            return



