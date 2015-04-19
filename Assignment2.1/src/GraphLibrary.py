__author__ = 'MyPrecious'

from Edge import Edge
from Node import Node
import json

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

class Graph(object):

    def __init__(self):
        self.nodes = []
        self.edges = []
        self.sources = []
        self.routes = []

    def doubleEdge(self, e):
        e2 = Edge(e.second, e.first, e.distance)
        self.edges.append(e)
        self.edges.append(e2)

        e.first.setEdge(e)
        e.first.setEdge(e2)
        e.second.setEdge(e)
        e.second.setEdge(e2)

    def getNode(self, code):
        for node in self.nodes:
            if code == node.code:
                return node

    def findNode(self, city):
        for node in self.nodes:
            if node.name == city:
                return node


    def minDistance(self, source, dest):

        unvisited = []
        unvisited.append(source)
        for node in self.nodes:
            if node != source:
                node.distance = float("inf")
                node.previous = None
                unvisited.append(node)

        source.distance = 0

        while len(unvisited) != 0:
            unvisited = sorted(unvisited, key=lambda vertex: vertex.distance)

            node1 = unvisited.pop(0)
            for edge in node1.edges:
                u = edge.second
                a = node1.distance + edge.getDist()
                if a < u.distance:
                    u.distance = a
                    u.previous = node1

        path = []
        path.append(dest)
        prev = dest.previous
        while prev is not source:
            path.append(prev)
            prev = prev.previous

        path.append(source)
        return path

    def parse_graph(self):

        path = open("/Users/MyPrecious/Desktop/cs242/park155/Assignment2.0/src/citylist.text")
        self.data = json.load(path)
        path.close()

        for city in self.data["metros"]:
            self.nodes.append(Node(city))
            city_list.append(city["name"])

        for route in self.data["routes"]:
            v1 = self.getNode(route["ports"][0])
            v2 = self.getNode(route["ports"][1])
            self.routes.append(route["ports"][0])
            self.routes.append(route["ports"][1])
            edge = Edge(v1, v2, route["distance"])
            self.doubleEdge(edge)

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
route_graph = {}
city_list = []

NA = []
SA = []
EU = []
Asia = []
Africa = []
Aust = []

