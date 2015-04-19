__author__ = 'MyPrecious'

class Node:

    def __init__(self, data):
        self.code = data["code"]
        self.name = data["name"]
        self.edges = []
        self.distance = 0
        self.previous = None

    def edit(self, data):
        self.code = data["code"]
        self.name = data["name"]
        self.edges = []
        self.distance = 0
        self.previous = None

    def setEdge(self, e):
        self.edges.append(e)