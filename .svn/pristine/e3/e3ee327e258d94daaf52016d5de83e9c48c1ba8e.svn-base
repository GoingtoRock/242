__author__ = 'MyPrecious'

import json

import QueryData, GraphLibrary


def parse_city(data):
    for city in data["metros"]:
        city_info = GraphLibrary.City(city["code"], city["name"], city["country"],
                                     city["continent"], city["timezone"], city["coordinates"],
                                     city["population"], city["region"])

        GraphLibrary.city_dictionary[city["name"]] = city_info
        GraphLibrary.code_to_name[city["code"]] = city["name"]


        if city["continent"] == "North America":
            GraphLibrary.NA.append(city["name"])
        elif city["continent"] == "South America":
            GraphLibrary.SA.append(city["name"])
        elif city["continent"] == "Europe":
            GraphLibrary.EU.append(city["name"])
        elif city["continent"] == "Africa":
            GraphLibrary.Africa.append(city["name"])
        elif city["continent"] == "Asia":
            GraphLibrary.Asia.append(city["name"])
        elif city["continent"] == "Australia":
            GraphLibrary.Aust.append(city["name"])


def parse_route(data):
    for route in data["routes"]:
        source_to_dest = GraphLibrary.Route(route["ports"][0],
                                           route["ports"][1],
                                           route["distance"])

        dest_to_source = GraphLibrary.Route(route["ports"][1],
                                              route["ports"][0],
                                              route["distance"])

        GraphLibrary.route_list.append(source_to_dest)
        GraphLibrary.route_list.append(dest_to_source)

        QueryData.addhubcity(route["ports"][0])
        QueryData.addhubcity(route["ports"][1])


class MapParser:

    path = '/Users/MyPrecious/Desktop/cs242/park155/Assignment2.0/src/citylist.text'
    requested_data = json.load(open(path))
    parse_city(requested_data)
    parse_route(requested_data)


class newMapParser:

    path = '/Users/MyPrecious/Desktop/cs242/park155/Assignment2.0/src/cmi_hub.txt'
    new_data = json.load(open(path))
    parse_city(new_data)
    parse_route(new_data)

