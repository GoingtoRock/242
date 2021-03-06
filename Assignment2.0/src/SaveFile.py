__author__ = 'MyPrecious'

import json

from src import GraphLibrary


def saveFile():

    root = {}
    metros = []
    routes = []

    for city in GraphLibrary.city_dictionary.itervalues():

            cities = {}
            cities["code"] = city.code
            cities["name"] = city.name
            cities["country"] = city.country
            cities["continent"] = city.continent
            cities["timezone"] = city.timezone
            cities["coordinates"] = city.coordinates
            cities["population"] = city.population
            cities["region"] = city.region

            metros.append(cities)

    for route in GraphLibrary.route_list:

            routelist = {}
            routelist["ports"[0]] = route.startportcode
            routelist["ports"[1]] = route.endportcode
            routelist["distance"] = route.distance

            routes.append(routelist)

    root["metros"] = metros
    root["routes"] = routes

    newFile = open("newFile.txt", "w")
    newFile.write(json.dumps(root))