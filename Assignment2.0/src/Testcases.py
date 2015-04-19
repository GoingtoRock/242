__author__ = 'MyPrecious'

import unittest
from unittest import TestCase

from src import QueryData, MapParser, GraphLibrary


class Test(TestCase):

    MapParser.MapParser()

    def TestSeoulPop(self):
        key = 0
        info = None
        for cityname, cityinfo in GraphLibrary.city_dictionary.iteritems():
            if cityname == "Seoul":
                info = cityinfo
                break
        self.assertEqual(info.population, 24200000)

    def TestSeoulDis(self):
        key = 0
        for item in GraphLibrary.route_list:
            if item.startportcode == 'ICN' and item.endportcode == 'TYO':
                key = item.distance
        self.assertEqual(key, 1207)

    def TestSeoulCon(self):

        key = False
        for city in GraphLibrary.Asia:
            if city == "Seoul":
                key = True
        self.assertEqual(key, True)

    def TestLACountry(self):
        key = 0
        info = None
        for cityname, cityinfo in GraphLibrary.city_dictionary.iteritems():
            if cityname == "Los Angeles":
                info = cityinfo
                break
        self.assertEqual(info.country, "US")

    def TestLATimezone(self):
        key = 0
        info = None
        for cityname, cityinfo in GraphLibrary.city_dictionary.iteritems():
            if cityname == "Los Angeles":
                info = cityinfo
                break
        self.assertEqual(info.timezone, -8)

    def TestParisRegion(self):
        key = 0
        info = None
        for cityname, cityinfo in GraphLibrary.city_dictionary.iteritems():
            if cityname == "Paris":
                info = cityinfo
                break
        self.assertEqual(info.region, 3)

    def TestshortestLength(self):
        key = QueryData.shortestflight()
        self.assertEqual(key, 334)

    def TestaveragePop(self):
        key = QueryData.averagecitysize()
        self.assertEqual(key, 11796143)



if __name__ == '__main__':
    unittest.main()