__author__ = 'MyPrecious'

import unittest
from unittest import TestCase

import QueryData, MapParser, GraphLibrary
import EditRoute

class Test(TestCase):

    MapParser.MapParser()

    def test_SeoulPop(self):
        key = 0
        info = None
        for cityname, cityinfo in GraphLibrary.city_dictionary.iteritems():
            if cityname == "Seoul":
                info = cityinfo
                break
        self.assertEqual(info.population, 24200000)

    def test_SeoulDis(self):
        key = 0
        for item in GraphLibrary.route_list:
            if item.startportcode == 'ICN' and item.endportcode == 'TYO':
                key = item.distance
        self.assertEqual(key, 1207)

    def test_SeoulCon(self):

        key = False
        for city in GraphLibrary.Asia:
            if city == "Seoul":
                key = True
        self.assertEqual(key, True)

    def test_LACountry(self):
        key = 0
        info = None
        for cityname, cityinfo in GraphLibrary.city_dictionary.iteritems():
            if cityname == "Los Angeles":
                info = cityinfo
                break
        self.assertEqual(info.country, "US")

    def test_LATimezone(self):
        key = 0
        info = None
        for cityname, cityinfo in GraphLibrary.city_dictionary.iteritems():
            if cityname == "Los Angeles":
                info = cityinfo
                break
        self.assertEqual(info.timezone, -8)

    def test_ParisRegion(self):
        key = 0
        info = None
        for cityname, cityinfo in GraphLibrary.city_dictionary.iteritems():
            if cityname == "Paris":
                info = cityinfo
                break
        self.assertEqual(info.region, 3)

    # def test_shortest_Length(self):
    #     key = QueryData.shortestflight()
    #     self.assertEqual(key, 198)
    #
    # def test_averagePop(self):
    #     key = QueryData.averagecitysize()
    #     self.assertEqual(key, 11796143)

# test for assignment 2.1

    def test_editCountry(self):

        info = None
        EditRoute.editcountry("Madrid", "America")
        isValid = True
        for cityname, cityinfo in GraphLibrary.city_dictionary.iteritems():
            if cityname == "Madrid":
                info = cityinfo
                break

        self.assertEqual(info.country, "America")


    def test_removeRoute(self):

        EditRoute.removeroute("Los Angeles", "San Francisco")
        isValid = False
        code = QueryData.nametocode("Los Angeles")
        code2 = QueryData.nametocode("San Francisco")

        for route in GraphLibrary.route_list:
            if route.startportcode == code and route.endportcode == code2:
                isValid = True
                break

        self.assertTrue(isValid)

    def test_addCity(self):

        EditRoute.addcity("LOR", "Minas Tirith", "Gondor", "Europe", "-3", "40", "50", "2034923", "5")

        isValid = False
        for cityname, cityinfo in GraphLibrary.city_dictionary.iteritems():
            if cityname == "Minas Tirith":
                isValid = True
                break

        self.assertTrue(isValid)

    def test_addRoute(self):

        code = QueryData.nametocode("Los Angeles")
        code2 = QueryData.nametocode("Seoul")
        EditRoute.addroute(code, code2, "12435")
        isValid = False

        for route in GraphLibrary.route_list:
            if route.startportcode == code and route.endportcode == code2:
                isValid = True
                break

        self.assertTrue(isValid)

    def test_Champaign(self):

        MapParser.newMapParser()

        isValid = False
        for cityname, cityinfo in GraphLibrary.city_dictionary.iteritems():
            if cityname == "Champaign":
                isValid = True
                break

        self.assertTrue(isValid)

if __name__ == '__main__':
    unittest.main()